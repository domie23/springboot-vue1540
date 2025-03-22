package com.entity.view;

import com.entity.ChuzuCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 出租收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chuzu_collection")
public class ChuzuCollectionView extends ChuzuCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String chuzuCollectionValue;



		//级联表 chuzu
			/**
			* 房间
			*/
			private String chuzuName;
			/**
			* 房屋图片
			*/
			private String chuzuPhoto;
			/**
			* 出租方式
			*/
			private Integer chuzuTypes;
				/**
				* 出租方式的值
				*/
				private String chuzuValue;
			/**
			* 房租价格/月
			*/
			private Double chuzuMoney;
			/**
			* 水费/吨
			*/
			private Double shuiMoney;
			/**
			* 电费/度
			*/
			private Double dianMoney;
			/**
			* 保洁/月
			*/
			private Double baojieMoney;
			/**
			* 房屋类型
			*/
			private Integer fangxingTypes;
				/**
				* 房屋类型的值
				*/
				private String fangxingValue;
			/**
			* 房屋平方
			*/
			private Double pingfang;
			/**
			* 装修方式
			*/
			private Integer zhuangxiuTypes;
				/**
				* 装修方式的值
				*/
				private String zhuangxiuValue;
			/**
			* 房屋朝向
			*/
			private Integer chaoxiangTypes;
				/**
				* 房屋朝向的值
				*/
				private String chaoxiangValue;
			/**
			* 楼层
			*/
			private Integer louceng;
			/**
			* 所属区域
			*/
			private Integer quyuTypes;
				/**
				* 所属区域的值
				*/
				private String quyuValue;
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
			private String chuzuContent;
			/**
			* 是否出租
			*/
			private Integer yizuTypes;
				/**
				* 是否出租的值
				*/
				private String yizuValue;

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

	public ChuzuCollectionView() {

	}

	public ChuzuCollectionView(ChuzuCollectionEntity chuzuCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, chuzuCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getChuzuCollectionValue() {
				return chuzuCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setChuzuCollectionValue(String chuzuCollectionValue) {
				this.chuzuCollectionValue = chuzuCollectionValue;
			}




				//级联表的get和set chuzu
					/**
					* 获取： 房间
					*/
					public String getChuzuName() {
						return chuzuName;
					}
					/**
					* 设置： 房间
					*/
					public void setChuzuName(String chuzuName) {
						this.chuzuName = chuzuName;
					}
					/**
					* 获取： 房屋图片
					*/
					public String getChuzuPhoto() {
						return chuzuPhoto;
					}
					/**
					* 设置： 房屋图片
					*/
					public void setChuzuPhoto(String chuzuPhoto) {
						this.chuzuPhoto = chuzuPhoto;
					}
					/**
					* 获取： 出租方式
					*/
					public Integer getChuzuTypes() {
						return chuzuTypes;
					}
					/**
					* 设置： 出租方式
					*/
					public void setChuzuTypes(Integer chuzuTypes) {
						this.chuzuTypes = chuzuTypes;
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
					* 获取： 房租价格/月
					*/
					public Double getChuzuMoney() {
						return chuzuMoney;
					}
					/**
					* 设置： 房租价格/月
					*/
					public void setChuzuMoney(Double chuzuMoney) {
						this.chuzuMoney = chuzuMoney;
					}
					/**
					* 获取： 水费/吨
					*/
					public Double getShuiMoney() {
						return shuiMoney;
					}
					/**
					* 设置： 水费/吨
					*/
					public void setShuiMoney(Double shuiMoney) {
						this.shuiMoney = shuiMoney;
					}
					/**
					* 获取： 电费/度
					*/
					public Double getDianMoney() {
						return dianMoney;
					}
					/**
					* 设置： 电费/度
					*/
					public void setDianMoney(Double dianMoney) {
						this.dianMoney = dianMoney;
					}
					/**
					* 获取： 保洁/月
					*/
					public Double getBaojieMoney() {
						return baojieMoney;
					}
					/**
					* 设置： 保洁/月
					*/
					public void setBaojieMoney(Double baojieMoney) {
						this.baojieMoney = baojieMoney;
					}
					/**
					* 获取： 房屋类型
					*/
					public Integer getFangxingTypes() {
						return fangxingTypes;
					}
					/**
					* 设置： 房屋类型
					*/
					public void setFangxingTypes(Integer fangxingTypes) {
						this.fangxingTypes = fangxingTypes;
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
					* 获取： 房屋平方
					*/
					public Double getPingfang() {
						return pingfang;
					}
					/**
					* 设置： 房屋平方
					*/
					public void setPingfang(Double pingfang) {
						this.pingfang = pingfang;
					}
					/**
					* 获取： 装修方式
					*/
					public Integer getZhuangxiuTypes() {
						return zhuangxiuTypes;
					}
					/**
					* 设置： 装修方式
					*/
					public void setZhuangxiuTypes(Integer zhuangxiuTypes) {
						this.zhuangxiuTypes = zhuangxiuTypes;
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
					* 获取： 房屋朝向
					*/
					public Integer getChaoxiangTypes() {
						return chaoxiangTypes;
					}
					/**
					* 设置： 房屋朝向
					*/
					public void setChaoxiangTypes(Integer chaoxiangTypes) {
						this.chaoxiangTypes = chaoxiangTypes;
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
					* 获取： 楼层
					*/
					public Integer getLouceng() {
						return louceng;
					}
					/**
					* 设置： 楼层
					*/
					public void setLouceng(Integer louceng) {
						this.louceng = louceng;
					}
					/**
					* 获取： 所属区域
					*/
					public Integer getQuyuTypes() {
						return quyuTypes;
					}
					/**
					* 设置： 所属区域
					*/
					public void setQuyuTypes(Integer quyuTypes) {
						this.quyuTypes = quyuTypes;
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
					* 获取： 房屋特色
					*/
					public String getTese() {
						return tese;
					}
					/**
					* 设置： 房屋特色
					*/
					public void setTese(String tese) {
						this.tese = tese;
					}
					/**
					* 获取： 详细地址
					*/
					public String getXiangxi() {
						return xiangxi;
					}
					/**
					* 设置： 详细地址
					*/
					public void setXiangxi(String xiangxi) {
						this.xiangxi = xiangxi;
					}
					/**
					* 获取： 房屋详细介绍
					*/
					public String getChuzuContent() {
						return chuzuContent;
					}
					/**
					* 设置： 房屋详细介绍
					*/
					public void setChuzuContent(String chuzuContent) {
						this.chuzuContent = chuzuContent;
					}
					/**
					* 获取： 是否出租
					*/
					public Integer getYizuTypes() {
						return yizuTypes;
					}
					/**
					* 设置： 是否出租
					*/
					public void setYizuTypes(Integer yizuTypes) {
						this.yizuTypes = yizuTypes;
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
