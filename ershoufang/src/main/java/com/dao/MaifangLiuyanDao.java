package com.dao;

import com.entity.MaifangLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MaifangLiuyanView;

/**
 * 卖房留言 Dao 接口
 *
 * @author 
 */
public interface MaifangLiuyanDao extends BaseMapper<MaifangLiuyanEntity> {

   List<MaifangLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
