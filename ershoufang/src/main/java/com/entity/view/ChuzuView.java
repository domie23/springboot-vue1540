package com.entity.view;

import com.entity.ChuzuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 出租
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chuzu")
public class ChuzuView extends ChuzuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 出租方式的值
		*/
		private String chuzuValue;
		/**
		* 房屋类型的值
		*/
		private String fangxingValue;
		/**
		* 装修方式的值
		*/
		private String zhuangxiuValue;
		/**
		* 房屋朝向的值
		*/
		private String chaoxiangValue;
		/**
		* 所属区域的值
		*/
		private String quyuValue;
		/**
		* 是否出租的值
		*/
		private String yizuValue;



		//级联表 xiaoqu
			/**
			* 小区名
			*/
			private String xiaoquName;
			/**
			* 建筑年代
			*/
			private String xiaoquNiandai;
			/**
			* 建筑类型
			*/
			private Integer xiaoquTypes;
				/**
				* 建筑类型的值
				*/
				private String xiaoquValue;
			/**
			* 物业公司
			*/
			private Integer wuyeTypes;
				/**
				* 物业公司的值
				*/
				private String wuyeValue;
			/**
			* 每平米价格
			*/
			private Double wuyeMoney;
			/**
			* 所属商圈
			*/
			private Integer shangquanTypes;
				/**
				* 所属商圈的值
				*/
				private String shangquanValue;
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

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public ChuzuView() {

	}

	public ChuzuView(ChuzuEntity chuzuEntity) {
		try {
			BeanUtils.copyProperties(this, chuzuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 出租方式的值
			*/
			public String getChuzuValue() {
				return chuzuValue;
			}
			/**
			* 设置： 出租方式的值
			*/
			public void setChuzuValue(String chuzuValue) {
				this.chuzuValue = chuzuValue;
			}
			/**
			* 获取： 房屋类型的值
			*/
			public String getFangxingValue() {
				return fangxingValue;
			}
			/**
			* 设置： 房屋类型的值
			*/
			public void setFangxingValue(String fangxingValue) {
				this.fangxingValue = fangxingValue;
			}
			/**
			* 获取： 装修方式的值
			*/
			public String getZhuangxiuValue() {
				return zhuangxiuValue;
			}
			/**
			* 设置： 装修方式的值
			*/
			public void setZhuangxiuValue(String zhuangxiuValue) {
				this.zhuangxiuValue = zhuangxiuValue;
			}
			/**
			* 获取： 房屋朝向的值
			*/
			public String getChaoxiangValue() {
				return chaoxiangValue;
			}
			/**
			* 设置： 房屋朝向的值
			*/
			public void setChaoxiangValue(String chaoxiangValue) {
				this.chaoxiangValue = chaoxiangValue;
			}
			/**
			* 获取： 所属区域的值
			*/
			public String getQuyuValue() {
				return quyuValue;
			}
			/**
			* 设置： 所属区域的值
			*/
			public void setQuyuValue(String quyuValue) {
				this.quyuValue = quyuValue;
			}
			/**
			* 获取： 是否出租的值
			*/
			public String getYizuValue() {
				return yizuValue;
			}
			/**
			* 设置： 是否出租的值
			*/
			public void setYizuValue(String yizuValue) {
				this.yizuValue = yizuValue;
			}
































				//级联表的get和set xiaoqu
					/**
					* 获取： 小区名
					*/
					public String getXiaoquName() {
						return xiaoquName;
					}
					/**
					* 设置： 小区名
					*/
					public void setXiaoquName(String xiaoquName) {
						this.xiaoquName = xiaoquName;
					}
					/**
					* 获取： 建筑年代
					*/
					public String getXiaoquNiandai() {
						return xiaoquNiandai;
					}
					/**
					* 设置： 建筑年代
					*/
					public void setXiaoquNiandai(String xiaoquNiandai) {
						this.xiaoquNiandai = xiaoquNiandai;
					}
					/**
					* 获取： 建筑类型
					*/
					public Integer getXiaoquTypes() {
						return xiaoquTypes;
					}
					/**
					* 设置： 建筑类型
					*/
					public void setXiaoquTypes(Integer xiaoquTypes) {
						this.xiaoquTypes = xiaoquTypes;
					}


						/**
						* 获取： 建筑类型的值
						*/
						public String getXiaoquValue() {
							return xiaoquValue;
						}
						/**
						* 设置： 建筑类型的值
						*/
						public void setXiaoquValue(String xiaoquValue) {
							this.xiaoquValue = xiaoquValue;
						}
					/**
					* 获取： 物业公司
					*/
					public Integer getWuyeTypes() {
						return wuyeTypes;
					}
					/**
					* 设置： 物业公司
					*/
					public void setWuyeTypes(Integer wuyeTypes) {
						this.wuyeTypes = wuyeTypes;
					}


						/**
						* 获取： 物业公司的值
						*/
						public String getWuyeValue() {
							return wuyeValue;
						}
						/**
						* 设置： 物业公司的值
						*/
						public void setWuyeValue(String wuyeValue) {
							this.wuyeValue = wuyeValue;
						}
					/**
					* 获取： 每平米价格
					*/
					public Double getWuyeMoney() {
						return wuyeMoney;
					}
					/**
					* 设置： 每平米价格
					*/
					public void setWuyeMoney(Double wuyeMoney) {
						this.wuyeMoney = wuyeMoney;
					}
					/**
					* 获取： 所属商圈
					*/
					public Integer getShangquanTypes() {
						return shangquanTypes;
					}
					/**
					* 设置： 所属商圈
					*/
					public void setShangquanTypes(Integer shangquanTypes) {
						this.shangquanTypes = shangquanTypes;
					}


						/**
						* 获取： 所属商圈的值
						*/
						public String getShangquanValue() {
							return shangquanValue;
						}
						/**
						* 设置： 所属商圈的值
						*/
						public void setShangquanValue(String shangquanValue) {
							this.shangquanValue = shangquanValue;
						}
					/**
					* 获取： 小区环境
					*/
					public String getHuanjing() {
						return huanjing;
					}
					/**
					* 设置： 小区环境
					*/
					public void setHuanjing(String huanjing) {
						this.huanjing = huanjing;
					}
					/**
					* 获取： 周边配置
					*/
					public String getZhoubian() {
						return zhoubian;
					}
					/**
					* 设置： 周边配置
					*/
					public void setZhoubian(String zhoubian) {
						this.zhoubian = zhoubian;
					}
					/**
					* 获取： 小区地址
					*/
					public String getXiaoquAddress() {
						return xiaoquAddress;
					}
					/**
					* 设置： 小区地址
					*/
					public void setXiaoquAddress(String xiaoquAddress) {
						this.xiaoquAddress = xiaoquAddress;
					}
					/**
					* 获取： 卖房套数
					*/
					public Integer getZaishouNumber() {
						return zaishouNumber;
					}
					/**
					* 设置： 卖房套数
					*/
					public void setZaishouNumber(Integer zaishouNumber) {
						this.zaishouNumber = zaishouNumber;
					}
					/**
					* 获取： 出租套数
					*/
					public Integer getChuzuNumber() {
						return chuzuNumber;
					}
					/**
					* 设置： 出租套数
					*/
					public void setChuzuNumber(Integer chuzuNumber) {
						this.chuzuNumber = chuzuNumber;
					}
					/**
					* 获取： 小区介绍
					*/
					public String getXiaoquContent() {
						return xiaoquContent;
					}
					/**
					* 设置： 小区介绍
					*/
					public void setXiaoquContent(String xiaoquContent) {
						this.xiaoquContent = xiaoquContent;
					}


				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}




}
