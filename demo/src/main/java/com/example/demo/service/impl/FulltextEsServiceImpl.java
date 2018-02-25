package com.example.demo.service.impl;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Fulltext;
import com.example.demo.service.FulltextEsService;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.SearchResult.Hit;
import io.searchbox.core.SearchScroll;
import io.searchbox.params.Parameters;

@Service
public class FulltextEsServiceImpl implements FulltextEsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FulltextEsServiceImpl.class); 
    
	@Autowired
	private JestClient jestClient; 
	
	@Override
	public void save(Fulltext fulltext) {
		Index index = new Index.Builder(fulltext).index(Fulltext.INDEX_NAME).type(Fulltext.TYPE).build(); 
	    try { 
	      jestClient.execute(index); 
	      LOGGER.info("ES 插入完成"); 
	    } catch (IOException e) { 
	      e.printStackTrace(); 
	      LOGGER.error(e.getMessage()); 
	    } 
	}

	@Override
	public void saveFulltext(List<Fulltext> entityList) {
		Bulk.Builder bulk = new Bulk.Builder(); 
	    for(Fulltext entity : entityList) { 
	      Index index = new Index.Builder(entity).index(Fulltext.INDEX_NAME).type(Fulltext.TYPE).build(); 
	      bulk.addAction(index); 
	    }     
	    try { 
	      jestClient.execute(bulk.build()); 
	      LOGGER.info("ES 插入完成"); 
	    } catch (IOException e) { 
	      e.printStackTrace(); 
	      LOGGER.error(e.getMessage()); 
	    } 
	}
	
	

	@Override
	public List<Hit<Fulltext, Void>> searchFulltext(String searchContent) throws IOException {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.queryStringQuery(searchContent));
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("content"); //高亮field
        highlightBuilder.preTags("<em>").postTags("</em>");//高亮标签
        highlightBuilder.fragmentSize(200);//高亮内容长度
        searchSourceBuilder.highlight(highlightBuilder);
        Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex("index").addType(Fulltext.TYPE).build();
        SearchResult result = null ;
        List<?> hits = null ;
        try {
            result = jestClient.execute(search);
            System.out.println("本次查询共查到："+result.getTotal()+"个结果！");

            hits = result.getHits(Fulltext.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return (List<Hit<Fulltext, Void>>) hits;
	}
	
	@Override
	public List<Hit<Fulltext, Void>> searchAllFulltext() throws IOException {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
	    searchSourceBuilder.query(QueryBuilders.matchAllQuery()); 
	    Search search = new Search.Builder(searchSourceBuilder.toString())
	        .addIndex(Fulltext.INDEX_NAME)
	        .build();

	    SearchResult result = jestClient.execute(search);
	    System.out.println("json:" + result.getJsonString());
	    return result.getHits(Fulltext.class);
	}

	@Override
	public List<Hit<Fulltext, Void>> searchFulltextByScroll() throws IOException {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
	    searchSourceBuilder.query(QueryBuilders.matchAllQuery()); 
		Search search = new Search.Builder(searchSourceBuilder.toString())
				.addIndex(Fulltext.INDEX_NAME)
//				.addType("service")
				.setParameter(Parameters.SIZE, 4)
				.setParameter(Parameters.SCROLL, "1m") // 最大搜索时长
				.build();
		JestResult result = jestClient.execute(search);
		String scrollId = result.getJsonObject().get("_scroll_id").getAsString();
//		System.out.println("-----:" + scrollId);
		System.out.println(result.getJsonString()); // 这里是第一组数据了
		
		SearchScroll scroll = new SearchScroll.Builder(scrollId, "1m").build(); // 最大搜索时长
        result = jestClient.execute(scroll);
        System.out.println(result.getJsonString());
        
		/*for (int i = 0; i < 10; i++) {
			SearchScroll scroll = new SearchScroll.Builder(scrollId, "1m").build(); // 最大搜索时长
            result = jestClient.execute(scroll);
			List<Fulltext> fulltextList = result.getSourceAsObjectList(Fulltext.class);
			System.out.println("===============================================");
			if (fulltextList != null && !fulltextList.isEmpty()){
				fulltextList.forEach(m -> System.out.println(m.getContent()));
			}
		}*/
		
		return null;
	}
	
}
