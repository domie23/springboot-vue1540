package com.entity.model;

import com.entity.XiaoquEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 小区
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiaoquModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 小区名
     */
    private String xiaoquName;


    /**
     * 建筑年代
     */
    private String xiaoquNiandai;


    /**
     * 小区图片
     */
    private String xiaoquPhoto;


    /**
     * 建筑类型
     */
    private Integer xiaoquTypes;


    /**
     * 物业公司
     */
    private Integer wuyeTypes;


    /**
     * 每平米价格
     */
    private Double wuyeMoney;


    /**
     * 所属商圈
     */
    private Integer shangquanTypes;


    /**
     * 小区环境
     */
    private String huanjing;


    /**
     * 周边配置
     */
    private String zhoubian;


    /**
     * 小区地址
     */
    private String xiaoquAddress;


    /**
     * 卖房套数
     */
    private Integer zaishouNumber;


    /**
     * 出租套数
     */
    private Integer chuzuNumber;


    /**
     * 小区介绍
     */
    private String xiaoquContent;


    /**
     * 创建时间 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：小区名
	 */
    public String getXiaoquName() {
        return xiaoquName;
    }


    /**
	 * 设置：小区名
	 */
    public void setXiaoquName(String xiaoquName) {
        this.xiaoquName = xiaoquName;
    }
    /**
	 * 获取：建筑年代
	 */
    public String getXiaoquNiandai() {
        return xiaoquNiandai;
    }


    /**
	 * 设置：建筑年代
	 */
    public void setXiaoquNiandai(String xiaoquNiandai) {
        this.xiaoquNiandai = xiaoquNiandai;
    }
    /**
	 * 获取：小区图片
	 */
    public String getXiaoquPhoto() {
        return xiaoquPhoto;
    }


    /**
	 * 设置：小区图片
	 */
    public void setXiaoquPhoto(String xiaoquPhoto) {
        this.xiaoquPhoto = xiaoquPhoto;
    }
    /**
	 * 获取：建筑类型
	 */
    public Integer getXiaoquTypes() {
        return xiaoquTypes;
    }


    /**
	 * 设置：建筑类型
	 */
    public void setXiaoquTypes(Integer xiaoquTypes) {
        this.xiaoquTypes = xiaoquTypes;
    }
    /**
	 * 获取：物业公司
	 */
    public Integer getWuyeTypes() {
        return wuyeTypes;
    }


    /**
	 * 设置：物业公司
	 */
    public void setWuyeTypes(Integer wuyeTypes) {
        this.wuyeTypes = wuyeTypes;
    }
    /**
	 * 获取：每平米价格
	 */
    public Double getWuyeMoney() {
        return wuyeMoney;
    }


    /**
	 * 设置：每平米价格
	 */
    public void setWuyeMoney(Double wuyeMoney) {
        this.wuyeMoney = wuyeMoney;
    }
    /**
	 * 获取：所属商圈
	 */
    public Integer getShangquanTypes() {
        return shangquanTypes;
    }


    /**
	 * 设置：所属商圈
	 */
    public void setShangquanTypes(Integer shangquanTypes) {
        this.shangquanTypes = shangquanTypes;
    }
    /**
	 * 获取：小区环境
	 */
    public String getHuanjing() {
        return huanjing;
    }


    /**
	 * 设置：小区环境
	 */
    public void setHuanjing(String huanjing) {
        this.huanjing = huanjing;
    }
    /**
	 * 获取：周边配置
	 */
    public String getZhoubian() {
        return zhoubian;
    }


    /**
	 * 设置：周边配置
	 */
    public void setZhoubian(String zhoubian) {
        this.zhoubian = zhoubian;
    }
    /**
	 * 获取：小区地址
	 */
    public String getXiaoquAddress() {
        return xiaoquAddress;
    }


    /**
	 * 设置：小区地址
	 */
    public void setXiaoquAddress(String xiaoquAddress) {
        this.xiaoquAddress = xiaoquAddress;
    }
    /**
	 * 获取：卖房套数
	 */
    public Integer getZaishouNumber() {
        return zaishouNumber;
    }


    /**
	 * 设置：卖房套数
	 */
    public void setZaishouNumber(Integer zaishouNumber) {
        this.zaishouNumber = zaishouNumber;
    }
    /**
	 * 获取：出租套数
	 */
    public Integer getChuzuNumber() {
        return chuzuNumber;
    }


    /**
	 * 设置：出租套数
	 */
    public void setChuzuNumber(Integer chuzuNumber) {
        this.chuzuNumber = chuzuNumber;
    }
    /**
	 * 获取：小区介绍
	 */
    public String getXiaoquContent() {
        return xiaoquContent;
    }


    /**
	 * 设置：小区介绍
	 */
    public void setXiaoquContent(String xiaoquContent) {
        this.xiaoquContent = xiaoquContent;
    }
    /**
	 * 获取：创建时间 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
