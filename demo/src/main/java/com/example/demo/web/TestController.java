package com.example.demo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.aop.MyAction;
import com.example.demo.component.DemoPublisher;
import com.example.demo.component.TestComponent;
import com.example.demo.domain.AppMsg;
import com.example.demo.domain.CardBanner;
import com.example.demo.domain.Democode;
import com.example.demo.domain.Fulltext;
import com.example.demo.domain.Product;
import com.example.demo.service.AppMsgService;
import com.example.demo.service.AsyncTaskService;
import com.example.demo.service.CardBannerService;
import com.example.demo.service.DemocodeService;
import com.example.demo.service.FulltextEsService;
import com.example.demo.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "测试controller")
@RestController
public class TestController {
	
	@Resource
	private CardBannerService cardBannerService;
	@Autowired
	private TestComponent test;
	@Resource
	private AsyncTaskService asyncTaskService;
	@Resource
	private DemoPublisher demoPublisher;
	@Resource
	private AppMsgService appMsgService;
	@Resource
	private DemocodeService democodeService;
	@Resource
	private FulltextEsService fulltextEsService;
	@Resource
	private ProductService productService;
	
	@MyAction(name = "yes")
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		test.yell();
		return "test";
	}
	
	@RequestMapping(value = "/banner/get/{id}", method = RequestMethod.GET)
	public CardBanner getBannerById(@PathVariable("id") Long id) {
		
		return cardBannerService.getById(id);
	}
	
	@RequestMapping(value = "/banner/list", method = RequestMethod.GET)
	public List<CardBanner> getBannerList() {
		return cardBannerService.queryBannerrList();
	}
	
	@RequestMapping(value = "/task", method = RequestMethod.GET)
	public void testTask() {
		
        for (int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
		
	}
	
	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public void eventTest() {
		demoPublisher.publish("hello application event");
	}
	
	@RequestMapping(value = "/appMsg/get/{id}", method = RequestMethod.GET)
	public void findAppMsgById(@PathVariable("id") Integer id) {
		AppMsg appMsg = appMsgService.findById(id);
		System.out.println("======:" + appMsg.getResume());
	}
	
	@ApiOperation(value = "搜索内容文本")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", required = true, dataType = "String", paramType = "query"),
    })
	@RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
	public Object searchContent(@PathVariable("name") String name) {
		return democodeService.findByName(name);
	}
	
	@ApiOperation(value = "搜索内容文本保存")
    @ApiImplicitParams({
    		@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "名称", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "description", value = "描述", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "popularity", value = "偏好值", required = true, dataType = "Integer", paramType = "query")
    })
	@RequestMapping(value = "/search/save", method = RequestMethod.GET)
	public Object searchSave(Democode democode) {
		return democodeService.save(democode);
	}
	
	@ApiOperation(value = "搜索全部")
    @ApiImplicitParams({
    })
	@RequestMapping(value = "/search/all", method = RequestMethod.GET)
	public Object searchContent() throws IOException {
//		return democodeService.findAll();
		return productService.searchAll("");
	}
	
	@ApiOperation(value = "搜索全部")
    @ApiImplicitParams({
    })
	@RequestMapping(value = "/search/in", method = RequestMethod.GET)
	public Object findNameIn(String name, @ApiIgnore Pageable page) {
		List<String> nameList = new ArrayList<>(1);
		nameList.add(name);
		return democodeService.findByNameIn(nameList, page);
	}
	
	@ApiOperation(value = "es搜索")
    @ApiImplicitParams({
    	 @ApiImplicitParam(name = "content", value = "内容文本", required = true, dataType = "String", paramType = "path"),
    })
	@RequestMapping(value = "/es/{content}", method = RequestMethod.GET)
	public Object esSearch(@PathVariable("content") String content) throws IOException {
		return fulltextEsService.searchFulltext(content);
	}
	
	@ApiOperation(value = "es保存")
    @ApiImplicitParams({
    	 @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long", paramType = "form"),
    	 @ApiImplicitParam(name = "content", value = "名称", required = true, dataType = "String", paramType = "form")
    })
	@RequestMapping(value = "/es/save", method = RequestMethod.POST)
	public Object esSave(@ApiIgnore Fulltext fulltext) {
		fulltextEsService.save(fulltext);
		return "success";
	}
	
//	searchFulltextByScroll
	@ApiOperation(value = "es分页搜索全部")
    @ApiImplicitParams({
    })
	@RequestMapping(value = "/es/scroll", method = RequestMethod.GET)
	public Object esScrollSearch() throws IOException {
		return fulltextEsService.searchFulltextByScroll();
	}
	
	@ApiOperation(value = "商品保存")
    @ApiImplicitParams({
    	 @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long", paramType = "form"),
    	 @ApiImplicitParam(name = "name", value = "名称", required = true, dataType = "String", paramType = "form"),
    	 @ApiImplicitParam(name = "intro", value = "简介", required = true, dataType = "String", paramType = "form"),
    	 @ApiImplicitParam(name = "thumb", value = "缩略图", required = true, dataType = "String", paramType = "form")
    })
	@RequestMapping(value = "/es/prod/save", method = RequestMethod.POST)
	public Object esSave(@ApiIgnore Product product) {
		productService.save(product);
//		Map<String, String> map = new HashMap<>();
		return "success";
	}
	
	
}
