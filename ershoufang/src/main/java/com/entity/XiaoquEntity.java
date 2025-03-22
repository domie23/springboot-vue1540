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
 * 小区
 *
 * @author 
 * @email
 */
@TableName("xiaoqu")
public class XiaoquEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiaoquEntity() {

	}

	public XiaoquEntity(T t) {
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
     * 小区名
     */
    @TableField(value = "xiaoqu_name")

    private String xiaoquName;


    /**
     * 建筑年代
     */
    @TableField(value = "xiaoqu_niandai")

    private String xiaoquNiandai;


    /**
     * 小区图片
     */
    @TableField(value = "xiaoqu_photo")

    private String xiaoquPhoto;


    /**
     * 建筑类型
     */
    @TableField(value = "xiaoqu_types")

    private Integer xiaoquTypes;


    /**
     * 物业公司
     */
    @TableField(value = "wuye_types")

    private Integer wuyeTypes;


    /**
     * 每平米价格
     */
    @TableField(value = "wuye_money")

    private Double wuyeMoney;


    /**
     * 所属商圈
     */
    @TableField(value = "shangquan_types")

    private Integer shangquanTypes;


    /**
     * 小区环境
     */
    @TableField(value = "huanjing")

    private String huanjing;


    /**
     * 周边配置
     */
    @TableField(value = "zhoubian")

    private String zhoubian;


    /**
     * 小区地址
     */
    @TableField(value = "xiaoqu_address")

    private String xiaoquAddress;


    /**
     * 卖房套数
     */
    @TableField(value = "zaishou_number")

    private Integer zaishouNumber;


    /**
     * 出租套数
     */
    @TableField(value = "chuzu_number")

    private Integer chuzuNumber;


    /**
     * 小区介绍
     */
    @TableField(value = "xiaoqu_content")

    private String xiaoquContent;


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
	 * 设置：小区名
	 */
    public String getXiaoquName() {
        return xiaoquName;
    }


    /**
	 * 获取：小区名
	 */

    public void setXiaoquName(String xiaoquName) {
        this.xiaoquName = xiaoquName;
    }
    /**
	 * 设置：建筑年代
	 */
    public String getXiaoquNiandai() {
        return xiaoquNiandai;
    }


    /**
	 * 获取：建筑年代
	 */

    public void setXiaoquNiandai(String xiaoquNiandai) {
        this.xiaoquNiandai = xiaoquNiandai;
    }
    /**
	 * 设置：小区图片
	 */
    public String getXiaoquPhoto() {
        return xiaoquPhoto;
    }


    /**
	 * 获取：小区图片
	 */

    public void setXiaoquPhoto(String xiaoquPhoto) {
        this.xiaoquPhoto = xiaoquPhoto;
    }
    /**
	 * 设置：建筑类型
	 */
    public Integer getXiaoquTypes() {
        return xiaoquTypes;
    }


    /**
	 * 获取：建筑类型
	 */

    public void setXiaoquTypes(Integer xiaoquTypes) {
        this.xiaoquTypes = xiaoquTypes;
    }
    /**
	 * 设置：物业公司
	 */
    public Integer getWuyeTypes() {
        return wuyeTypes;
    }


    /**
	 * 获取：物业公司
	 */

    public void setWuyeTypes(Integer wuyeTypes) {
        this.wuyeTypes = wuyeTypes;
    }
    /**
	 * 设置：每平米价格
	 */
    public Double getWuyeMoney() {
        return wuyeMoney;
    }


    /**
	 * 获取：每平米价格
	 */

    public void setWuyeMoney(Double wuyeMoney) {
        this.wuyeMoney = wuyeMoney;
    }
    /**
	 * 设置：所属商圈
	 */
    public Integer getShangquanTypes() {
        return shangquanTypes;
    }


    /**
	 * 获取：所属商圈
	 */

    public void setShangquanTypes(Integer shangquanTypes) {
        this.shangquanTypes = shangquanTypes;
    }
    /**
	 * 设置：小区环境
	 */
    public String getHuanjing() {
        return huanjing;
    }


    /**
	 * 获取：小区环境
	 */

    public void setHuanjing(String huanjing) {
        this.huanjing = huanjing;
    }
    /**
	 * 设置：周边配置
	 */
    public String getZhoubian() {
        return zhoubian;
    }


    /**
	 * 获取：周边配置
	 */

    public void setZhoubian(String zhoubian) {
        this.zhoubian = zhoubian;
    }
    /**
	 * 设置：小区地址
	 */
    public String getXiaoquAddress() {
        return xiaoquAddress;
    }


    /**
	 * 获取：小区地址
	 */

    public void setXiaoquAddress(String xiaoquAddress) {
        this.xiaoquAddress = xiaoquAddress;
    }
    /**
	 * 设置：卖房套数
	 */
    public Integer getZaishouNumber() {
        return zaishouNumber;
    }


    /**
	 * 获取：卖房套数
	 */

    public void setZaishouNumber(Integer zaishouNumber) {
        this.zaishouNumber = zaishouNumber;
    }
    /**
	 * 设置：出租套数
	 */
    public Integer getChuzuNumber() {
        return chuzuNumber;
    }


    /**
	 * 获取：出租套数
	 */

    public void setChuzuNumber(Integer chuzuNumber) {
        this.chuzuNumber = chuzuNumber;
    }
    /**
	 * 设置：小区介绍
	 */
    public String getXiaoquContent() {
        return xiaoquContent;
    }


    /**
	 * 获取：小区介绍
	 */

    public void setXiaoquContent(String xiaoquContent) {
        this.xiaoquContent = xiaoquContent;
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
        return "Xiaoqu{" +
            "id=" + id +
            ", xiaoquName=" + xiaoquName +
            ", xiaoquNiandai=" + xiaoquNiandai +
            ", xiaoquPhoto=" + xiaoquPhoto +
            ", xiaoquTypes=" + xiaoquTypes +
            ", wuyeTypes=" + wuyeTypes +
            ", wuyeMoney=" + wuyeMoney +
            ", shangquanTypes=" + shangquanTypes +
            ", huanjing=" + huanjing +
            ", zhoubian=" + zhoubian +
            ", xiaoquAddress=" + xiaoquAddress +
            ", zaishouNumber=" + zaishouNumber +
            ", chuzuNumber=" + chuzuNumber +
            ", xiaoquContent=" + xiaoquContent +
            ", createTime=" + createTime +
        "}";
    }
}
