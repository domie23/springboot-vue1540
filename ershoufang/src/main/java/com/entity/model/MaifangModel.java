package com.entity.model;

import com.entity.MaifangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 卖房
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MaifangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 小区
     */
    private Integer xiaoquId;


    /**
     * 房间
     */
    private String maifangName;


    /**
     * 房屋图片
     */
    private String maifangPhoto;


    /**
     * 房屋类型
     */
    private Integer fangxingTypes;


    /**
     * 房屋平方
     */
    private Double pingfang;


    /**
     * 每平米/价格
     */
    private Double maifangMoney;


    /**
     * 装修方式
     */
    private Integer zhuangxiuTypes;


    /**
     * 房屋朝向
     */
    private Integer chaoxiangTypes;


    /**
     * 楼层
     */
    private Integer louceng;


    /**
     * 所属区域
     */
    private Integer quyuTypes;


    /**
     * 是否卖出
     */
    private Integer maifangTypes;


    /**
     * 房屋特色
     */
    private String tese;


    /**
     * 详细地址
     */
    private String xiangxi;


    /**
     * 房屋详细介绍
     */
    private String maifangContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：小区
	 */
    public Integer getXiaoquId() {
        return xiaoquId;
    }


    /**
	 * 设置：小区
	 */
    public void setXiaoquId(Integer xiaoquId) {
        this.xiaoquId = xiaoquId;
    }
    /**
	 * 获取：房间
	 */
    public String getMaifangName() {
        return maifangName;
    }


    /**
	 * 设置：房间
	 */
    public void setMaifangName(String maifangName) {
        this.maifangName = maifangName;
    }
    /**
	 * 获取：房屋图片
	 */
    public String getMaifangPhoto() {
        return maifangPhoto;
    }


    /**
	 * 设置：房屋图片
	 */
    public void setMaifangPhoto(String maifangPhoto) {
        this.maifangPhoto = maifangPhoto;
    }
    /**
	 * 获取：房屋类型
	 */
    public Integer getFangxingTypes() {
        return fangxingTypes;
    }


    /**
	 * 设置：房屋类型
	 */
    public void setFangxingTypes(Integer fangxingTypes) {
        this.fangxingTypes = fangxingTypes;
    }
    /**
	 * 获取：房屋平方
	 */
    public Double getPingfang() {
        return pingfang;
    }


    /**
	 * 设置：房屋平方
	 */
    public void setPingfang(Double pingfang) {
        this.pingfang = pingfang;
    }
    /**
	 * 获取：每平米/价格
	 */
    public Double getMaifangMoney() {
        return maifangMoney;
    }


    /**
	 * 设置：每平米/价格
	 */
    public void setMaifangMoney(Double maifangMoney) {
        this.maifangMoney = maifangMoney;
    }
    /**
	 * 获取：装修方式
	 */
    public Integer getZhuangxiuTypes() {
        return zhuangxiuTypes;
    }


    /**
	 * 设置：装修方式
	 */
    public void setZhuangxiuTypes(Integer zhuangxiuTypes) {
        this.zhuangxiuTypes = zhuangxiuTypes;
    }
    /**
	 * 获取：房屋朝向
	 */
    public Integer getChaoxiangTypes() {
        return chaoxiangTypes;
    }


    /**
	 * 设置：房屋朝向
	 */
    public void setChaoxiangTypes(Integer chaoxiangTypes) {
        this.chaoxiangTypes = chaoxiangTypes;
    }
    /**
	 * 获取：楼层
	 */
    public Integer getLouceng() {
        return louceng;
    }


    /**
	 * 设置：楼层
	 */
    public void setLouceng(Integer louceng) {
        this.louceng = louceng;
    }
    /**
	 * 获取：所属区域
	 */
    public Integer getQuyuTypes() {
        return quyuTypes;
    }


    /**
	 * 设置：所属区域
	 */
    public void setQuyuTypes(Integer quyuTypes) {
        this.quyuTypes = quyuTypes;
    }
    /**
	 * 获取：是否卖出
	 */
    public Integer getMaifangTypes() {
        return maifangTypes;
    }


    /**
	 * 设置：是否卖出
	 */
    public void setMaifangTypes(Integer maifangTypes) {
        this.maifangTypes = maifangTypes;
    }
    /**
	 * 获取：房屋特色
	 */
    public String getTese() {
        return tese;
    }


    /**
	 * 设置：房屋特色
	 */
    public void setTese(String tese) {
        this.tese = tese;
    }
    /**
	 * 获取：详细地址
	 */
    public String getXiangxi() {
        return xiangxi;
    }


    /**
	 * 设置：详细地址
	 */
    public void setXiangxi(String xiangxi) {
        this.xiangxi = xiangxi;
    }
    /**
	 * 获取：房屋详细介绍
	 */
    public String getMaifangContent() {
        return maifangContent;
    }


    /**
	 * 设置：房屋详细介绍
	 */
    public void setMaifangContent(String maifangContent) {
        this.maifangContent = maifangContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
