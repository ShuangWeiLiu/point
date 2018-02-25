package com.example.demo.domain;

import java.util.Date;

public class CardBanner {
    /**
     * 表id
     */
    private Long tid;

    /**
     * 名称
     */
    private String title;

    /**
     * 图片路径
     */
    private String image;

    /**
     * 所属模块:  
     *   1：首页banner广告位；
     *   2：首页活动精选广告位；
     *   3、发现卡盟banner图；
     *   4、发现超市banner图；
     *   5、发现商城banner图
     */
    private Byte module;

    /**
     * 类型：1：购物卡、2：活动专题、3：公告、4：大转盘、5：外链
     */
    private Byte type;

    /**
     * 业务id
     */
    private Integer bid;

    /**
     * 
     */
    private String bname;

    /**
     * 跳转链接
     */
    private String pageUrl;

    /**
     * 是否启用：0、不启用;1、启用
     */
    private Byte enable;

    /**
     * 状态：0：未启用  1：进行中  2：已过期
     */
    private Byte state;

    /**
     * 排序值
     */
    private Integer seqno;

    /**
     * 描述（description）
     */
    private String descp;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 
     */
    private Integer updateBy;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 表id
     * @return tid 表id
     */
    public Long getTid() {
        return tid;
    }

    /**
     * 表id
     * @param tid 表id
     */
    public void setTid(Long tid) {
        this.tid = tid;
    }

    /**
     * 名称
     * @return title 名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 名称
     * @param title 名称
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 图片路径
     * @return image 图片路径
     */
    public String getImage() {
        return image;
    }

    /**
     * 图片路径
     * @param image 图片路径
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * 所属模块:  
     *   1：首页banner广告位；
     *   2：首页活动精选广告位；
     *   3、发现卡盟banner图；
     *   4、发现超市banner图；
     *   5、发现商城banner图
     *   @return module 所属模块:
     *   1：首页banner广告位；
     *   2：首页活动精选广告位；
     *   3、发现卡盟banner图；
     *   4、发现超市banner图；
     *   5、发现商城banner图
     */
    public Byte getModule() {
        return module;
    }

    /**
     *   所属模块:
     *    1：首页banner广告位；
     *   2：首页活动精选广告位；
     *   3、发现卡盟banner图；
     *   4、发现超市banner图；
     *   5、发现商城banner图
     *       * @param module 所属模块:
     *   1：首页banner广告位；
     *   2：首页活动精选广告位；
     *   3、发现卡盟banner图；
     *   4、发现超市banner图；
     *  5、发现商城banner图
     */
    public void setModule(Byte module) {
        this.module = module;
    }

    /**
     * 类型：1：购物卡、2：活动专题、3：公告、4：大转盘、5：外链
     * @return type 类型：1：购物卡、2：活动专题、3：公告、4：大转盘、5：外链
     */
    public Byte getType() {
        return type;
    }

    /**
     * 类型：1：购物卡、2：活动专题、3：公告、4：大转盘、5：外链
     * @param type 类型：1：购物卡、2：活动专题、3：公告、4：大转盘、5：外链
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 业务id
     * @return bid 业务id
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * 业务id
     * @param bid 业务id
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * 
     * @return bname 
     */
    public String getBname() {
        return bname;
    }

    /**
     * 
     * @param bname 
     */
    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    /**
     * 跳转链接
     * @return page_url 跳转链接
     */
    public String getPageUrl() {
        return pageUrl;
    }

    /**
     * 跳转链接
     * @param pageUrl 跳转链接
     */
    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl == null ? null : pageUrl.trim();
    }

    /**
     * 是否启用：0、不启用;1、启用
     * @return enable 是否启用：0、不启用;1、启用
     */
    public Byte getEnable() {
        return enable;
    }

    /**
     * 是否启用：0、不启用;1、启用
     * @param enable 是否启用：0、不启用;1、启用
     */
    public void setEnable(Byte enable) {
        this.enable = enable;
    }

    /**
     * 状态：0：未启用  1：进行中  2：已过期
     * @return state 状态：0：未启用  1：进行中  2：已过期
     */
    public Byte getState() {
        return state;
    }

    /**
     * 状态：0：未启用  1：进行中  2：已过期
     * @param state 状态：0：未启用  1：进行中  2：已过期
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * 排序值
     * @return seqno 排序值
     */
    public Integer getSeqno() {
        return seqno;
    }

    /**
     * 排序值
     * @param seqno 排序值
     */
    public void setSeqno(Integer seqno) {
        this.seqno = seqno;
    }

    /**
     * 描述（description）
     * @return descp 描述（description）
     */
    public String getDescp() {
        return descp;
    }

    /**
     * 描述（description）
     * @param descp 描述（description）
     */
    public void setDescp(String descp) {
        this.descp = descp == null ? null : descp.trim();
    }

    /**
     * 开始时间
     * @return start_time 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 结束时间
     * @return end_time 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 结束时间
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 
     * @return update_by 
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * 
     * @param updateBy 
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 
     * @return update_time 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     * @param updateTime 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 创建人
     * @return create_by 创建人
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 创建人
     * @param createBy 创建人
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}