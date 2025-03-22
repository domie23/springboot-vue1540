package com.entity.view;

import com.entity.XiaoquEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 小区
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xiaoqu")
public class XiaoquView extends XiaoquEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 建筑类型的值
		*/
		private String xiaoquValue;
		/**
		* 物业公司的值
		*/
		private String wuyeValue;
		/**
		* 所属商圈的值
		*/
		private String shangquanValue;



	public XiaoquView() {

	}

	public XiaoquView(XiaoquEntity xiaoquEntity) {
		try {
			BeanUtils.copyProperties(this, xiaoquEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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














}
