package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 出租
 *
 * @author 
 * @email
 */
@TableName("chuzu")
public class ChuzuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChuzuEntity() {

	}

	public ChuzuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 小区
     */
    @TableField(value = "xiaoqu_id")

    private Integer xiaoquId;


    /**
     * 房间
     */
    @TableField(value = "chuzu_name")

    private String chuzuName;


    /**
     * 房屋图片
     */
    @TableField(value = "chuzu_photo")

    private String chuzuPhoto;


    /**
     * 出租方式
     */
    @TableField(value = "chuzu_types")

    private Integer chuzuTypes;


    /**
     * 房租价格/月
     */
    @TableField(value = "chuzu_money")

    private Double chuzuMoney;


    /**
     * 水费/吨
     */
    @TableField(value = "shui_money")

    private Double shuiMoney;


    /**
     * 电费/度
     */
    @TableField(value = "dian_money")

    private Double dianMoney;


    /**
     * 保洁/月
     */
    @TableField(value = "baojie_money")

    private Double baojieMoney;


    /**
     * 房屋类型
     */
    @TableField(value = "fangxing_types")

    private Integer fangxingTypes;


    /**
     * 房屋平方
     */
    @TableField(value = "pingfang")

    private Double pingfang;


    /**
     * 装修方式
     */
    @TableField(value = "zhuangxiu_types")

    private Integer zhuangxiuTypes;


    /**
     * 房屋朝向
     */
    @TableField(value = "chaoxiang_types")

    private Integer chaoxiangTypes;


    /**
     * 楼层
     */
    @TableField(value = "louceng")

    private Integer louceng;


    /**
     * 所属区域
     */
    @TableField(value = "quyu_types")

    private Integer quyuTypes;


    /**
     * 房屋特色
     */
    @TableField(value = "tese")

    private String tese;


    /**
     * 详细地址
     */
    @TableField(value = "xiangxi")

    private String xiangxi;


    /**
     * 房屋详细介绍
     */
    @TableField(value = "chuzu_content")

    private String chuzuContent;


    /**
     * 是否出租
     */
    @TableField(value = "yizu_types")

    private Integer yizuTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：小区
	 */
    public Integer getXiaoquId() {
        return xiaoquId;
    }


    /**
	 * 获取：小区
	 */

    public void setXiaoquId(Integer xiaoquId) {
        this.xiaoquId = xiaoquId;
    }
    /**
	 * 设置：房间
	 */
    public String getChuzuName() {
        return chuzuName;
    }


    /**
	 * 获取：房间
	 */

    public void setChuzuName(String chuzuName) {
        this.chuzuName = chuzuName;
    }
    /**
	 * 设置：房屋图片
	 */
    public String getChuzuPhoto() {
        return chuzuPhoto;
    }


    /**
	 * 获取：房屋图片
	 */

    public void setChuzuPhoto(String chuzuPhoto) {
        this.chuzuPhoto = chuzuPhoto;
    }
    /**
	 * 设置：出租方式
	 */
    public Integer getChuzuTypes() {
        return chuzuTypes;
    }


    /**
	 * 获取：出租方式
	 */

    public void setChuzuTypes(Integer chuzuTypes) {
        this.chuzuTypes = chuzuTypes;
    }
    /**
	 * 设置：房租价格/月
	 */
    public Double getChuzuMoney() {
        return chuzuMoney;
    }


    /**
	 * 获取：房租价格/月
	 */

    public void setChuzuMoney(Double chuzuMoney) {
        this.chuzuMoney = chuzuMoney;
    }
    /**
	 * 设置：水费/吨
	 */
    public Double getShuiMoney() {
        return shuiMoney;
    }


    /**
	 * 获取：水费/吨
	 */

    public void setShuiMoney(Double shuiMoney) {
        this.shuiMoney = shuiMoney;
    }
    /**
	 * 设置：电费/度
	 */
    public Double getDianMoney() {
        return dianMoney;
    }


    /**
	 * 获取：电费/度
	 */

    public void setDianMoney(Double dianMoney) {
        this.dianMoney = dianMoney;
    }
    /**
	 * 设置：保洁/月
	 */
    public Double getBaojieMoney() {
        return baojieMoney;
    }


    /**
	 * 获取：保洁/月
	 */

    public void setBaojieMoney(Double baojieMoney) {
        this.baojieMoney = baojieMoney;
    }
    /**
	 * 设置：房屋类型
	 */
    public Integer getFangxingTypes() {
        return fangxingTypes;
    }


    /**
	 * 获取：房屋类型
	 */

    public void setFangxingTypes(Integer fangxingTypes) {
        this.fangxingTypes = fangxingTypes;
    }
    /**
	 * 设置：房屋平方
	 */
    public Double getPingfang() {
        return pingfang;
    }


    /**
	 * 获取：房屋平方
	 */

    public void setPingfang(Double pingfang) {
        this.pingfang = pingfang;
    }
    /**
	 * 设置：装修方式
	 */
    public Integer getZhuangxiuTypes() {
        return zhuangxiuTypes;
    }


    /**
	 * 获取：装修方式
	 */

    public void setZhuangxiuTypes(Integer zhuangxiuTypes) {
        this.zhuangxiuTypes = zhuangxiuTypes;
    }
    /**
	 * 设置：房屋朝向
	 */
    public Integer getChaoxiangTypes() {
        return chaoxiangTypes;
    }


    /**
	 * 获取：房屋朝向
	 */

    public void setChaoxiangTypes(Integer chaoxiangTypes) {
        this.chaoxiangTypes = chaoxiangTypes;
    }
    /**
	 * 设置：楼层
	 */
    public Integer getLouceng() {
        return louceng;
    }


    /**
	 * 获取：楼层
	 */

    public void setLouceng(Integer louceng) {
        this.louceng = louceng;
    }
    /**
	 * 设置：所属区域
	 */
    public Integer getQuyuTypes() {
        return quyuTypes;
    }


    /**
	 * 获取：所属区域
	 */

    public void setQuyuTypes(Integer quyuTypes) {
        this.quyuTypes = quyuTypes;
    }
    /**
	 * 设置：房屋特色
	 */
    public String getTese() {
        return tese;
    }


    /**
	 * 获取：房屋特色
	 */

    public void setTese(String tese) {
        this.tese = tese;
    }
    /**
	 * 设置：详细地址
	 */
    public String getXiangxi() {
        return xiangxi;
    }


    /**
	 * 获取：详细地址
	 */

    public void setXiangxi(String xiangxi) {
        this.xiangxi = xiangxi;
    }
    /**
	 * 设置：房屋详细介绍
	 */
    public String getChuzuContent() {
        return chuzuContent;
    }


    /**
	 * 获取：房屋详细介绍
	 */

    public void setChuzuContent(String chuzuContent) {
        this.chuzuContent = chuzuContent;
    }
    /**
	 * 设置：是否出租
	 */
    public Integer getYizuTypes() {
        return yizuTypes;
    }


    /**
	 * 获取：是否出租
	 */

    public void setYizuTypes(Integer yizuTypes) {
        this.yizuTypes = yizuTypes;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Chuzu{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", xiaoquId=" + xiaoquId +
            ", chuzuName=" + chuzuName +
            ", chuzuPhoto=" + chuzuPhoto +
            ", chuzuTypes=" + chuzuTypes +
            ", chuzuMoney=" + chuzuMoney +
            ", shuiMoney=" + shuiMoney +
            ", dianMoney=" + dianMoney +
            ", baojieMoney=" + baojieMoney +
            ", fangxingTypes=" + fangxingTypes +
            ", pingfang=" + pingfang +
            ", zhuangxiuTypes=" + zhuangxiuTypes +
            ", chaoxiangTypes=" + chaoxiangTypes +
            ", louceng=" + louceng +
            ", quyuTypes=" + quyuTypes +
            ", tese=" + tese +
            ", xiangxi=" + xiangxi +
            ", chuzuContent=" + chuzuContent +
            ", yizuTypes=" + yizuTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
