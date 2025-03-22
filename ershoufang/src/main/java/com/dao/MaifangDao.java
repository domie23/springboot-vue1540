package com.dao;

import com.entity.MaifangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MaifangView;

/**
 * 卖房 Dao 接口
 *
 * @author 
 */
public interface MaifangDao extends BaseMapper<MaifangEntity> {

   List<MaifangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
