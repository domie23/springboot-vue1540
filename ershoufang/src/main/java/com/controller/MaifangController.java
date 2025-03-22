












package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 卖房
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/maifang")
public class MaifangController {
    private static final Logger logger = LoggerFactory.getLogger(MaifangController.class);

    @Autowired
    private MaifangService maifangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private XiaoquService xiaoquService;
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = maifangService.queryPage(params);

        //字典表数据转换
        List<MaifangView> list =(List<MaifangView>)page.getList();
        for(MaifangView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MaifangEntity maifang = maifangService.selectById(id);
        if(maifang !=null){
            //entity转view
            MaifangView view = new MaifangView();
            BeanUtils.copyProperties( maifang , view );//把实体数据重构到view中

                //级联表
                XiaoquEntity xiaoqu = xiaoquService.selectById(maifang.getXiaoquId());
                if(xiaoqu != null){
                    BeanUtils.copyProperties( xiaoqu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXiaoquId(xiaoqu.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(maifang.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody MaifangEntity maifang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,maifang:{}",this.getClass().getName(),maifang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            maifang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<MaifangEntity> queryWrapper = new EntityWrapper<MaifangEntity>()
            .eq("yonghu_id", maifang.getYonghuId())
            .eq("xiaoqu_id", maifang.getXiaoquId())
            .eq("maifang_name", maifang.getMaifangName())
            .eq("fangxing_types", maifang.getFangxingTypes())
            .eq("zhuangxiu_types", maifang.getZhuangxiuTypes())
            .eq("chaoxiang_types", maifang.getChaoxiangTypes())
            .eq("louceng", maifang.getLouceng())
            .eq("quyu_types", maifang.getQuyuTypes())
            .eq("maifang_types", maifang.getMaifangTypes())
            .eq("tese", maifang.getTese())
            .eq("xiangxi", maifang.getXiangxi())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MaifangEntity maifangEntity = maifangService.selectOne(queryWrapper);
        if(maifangEntity==null){
            maifang.setInsertTime(new Date());
            maifang.setCreateTime(new Date());
            maifangService.insert(maifang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MaifangEntity maifang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,maifang:{}",this.getClass().getName(),maifang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("用户".equals(role))
//            maifang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<MaifangEntity> queryWrapper = new EntityWrapper<MaifangEntity>()
            .notIn("id",maifang.getId())
            .andNew()
            .eq("yonghu_id", maifang.getYonghuId())
            .eq("xiaoqu_id", maifang.getXiaoquId())
            .eq("maifang_name", maifang.getMaifangName())
            .eq("fangxing_types", maifang.getFangxingTypes())
            .eq("zhuangxiu_types", maifang.getZhuangxiuTypes())
            .eq("chaoxiang_types", maifang.getChaoxiangTypes())
            .eq("louceng", maifang.getLouceng())
            .eq("quyu_types", maifang.getQuyuTypes())
            .eq("maifang_types", maifang.getMaifangTypes())
            .eq("tese", maifang.getTese())
            .eq("xiangxi", maifang.getXiangxi())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MaifangEntity maifangEntity = maifangService.selectOne(queryWrapper);
        if("".equals(maifang.getMaifangPhoto()) || "null".equals(maifang.getMaifangPhoto())){
                maifang.setMaifangPhoto(null);
        }
        if(maifangEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      maifang.set
            //  }
            maifangService.updateById(maifang);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        maifangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<MaifangEntity> maifangList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            MaifangEntity maifangEntity = new MaifangEntity();
//                            maifangEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            maifangEntity.setXiaoquId(Integer.valueOf(data.get(0)));   //小区 要改的
//                            maifangEntity.setMaifangName(data.get(0));                    //房间 要改的
//                            maifangEntity.setMaifangPhoto("");//照片
//                            maifangEntity.setFangxingTypes(Integer.valueOf(data.get(0)));   //房屋类型 要改的
//                            maifangEntity.setPingfang(data.get(0));                    //房屋平方 要改的
//                            maifangEntity.setMaifangMoney(data.get(0));                    //每平米/价格 要改的
//                            maifangEntity.setZhuangxiuTypes(Integer.valueOf(data.get(0)));   //装修方式 要改的
//                            maifangEntity.setChaoxiangTypes(Integer.valueOf(data.get(0)));   //房屋朝向 要改的
//                            maifangEntity.setLouceng(Integer.valueOf(data.get(0)));   //楼层 要改的
//                            maifangEntity.setQuyuTypes(Integer.valueOf(data.get(0)));   //所属区域 要改的
//                            maifangEntity.setMaifangTypes(Integer.valueOf(data.get(0)));   //是否卖出 要改的
//                            maifangEntity.setTese(data.get(0));                    //房屋特色 要改的
//                            maifangEntity.setXiangxi(data.get(0));                    //详细地址 要改的
//                            maifangEntity.setMaifangContent("");//照片
//                            maifangEntity.setInsertTime(date);//时间
//                            maifangEntity.setCreateTime(date);//时间
                            maifangList.add(maifangEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        maifangService.insertBatch(maifangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = maifangService.queryPage(params);

        //字典表数据转换
        List<MaifangView> list =(List<MaifangView>)page.getList();
        for(MaifangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MaifangEntity maifang = maifangService.selectById(id);
            if(maifang !=null){


                //entity转view
                MaifangView view = new MaifangView();
                BeanUtils.copyProperties( maifang , view );//把实体数据重构到view中

                //级联表
                    XiaoquEntity xiaoqu = xiaoquService.selectById(maifang.getXiaoquId());
                if(xiaoqu != null){
                    BeanUtils.copyProperties( xiaoqu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXiaoquId(xiaoqu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(maifang.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody MaifangEntity maifang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,maifang:{}",this.getClass().getName(),maifang.toString());
        Wrapper<MaifangEntity> queryWrapper = new EntityWrapper<MaifangEntity>()
            .eq("yonghu_id", maifang.getYonghuId())
            .eq("xiaoqu_id", maifang.getXiaoquId())
            .eq("maifang_name", maifang.getMaifangName())
            .eq("fangxing_types", maifang.getFangxingTypes())
            .eq("zhuangxiu_types", maifang.getZhuangxiuTypes())
            .eq("chaoxiang_types", maifang.getChaoxiangTypes())
            .eq("louceng", maifang.getLouceng())
            .eq("quyu_types", maifang.getQuyuTypes())
            .eq("maifang_types", maifang.getMaifangTypes())
            .eq("tese", maifang.getTese())
            .eq("xiangxi", maifang.getXiangxi())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MaifangEntity maifangEntity = maifangService.selectOne(queryWrapper);
        if(maifangEntity==null){
            maifang.setInsertTime(new Date());
            maifang.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      maifang.set
        //  }
        maifangService.insert(maifang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
