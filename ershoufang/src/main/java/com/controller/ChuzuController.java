












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
 * 出租
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chuzu")
public class ChuzuController {
    private static final Logger logger = LoggerFactory.getLogger(ChuzuController.class);

    @Autowired
    private ChuzuService chuzuService;


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
        PageUtils page = chuzuService.queryPage(params);

        //字典表数据转换
        List<ChuzuView> list =(List<ChuzuView>)page.getList();
        for(ChuzuView c:list){
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
        ChuzuEntity chuzu = chuzuService.selectById(id);
        if(chuzu !=null){
            //entity转view
            ChuzuView view = new ChuzuView();
            BeanUtils.copyProperties( chuzu , view );//把实体数据重构到view中

                //级联表
                XiaoquEntity xiaoqu = xiaoquService.selectById(chuzu.getXiaoquId());
                if(xiaoqu != null){
                    BeanUtils.copyProperties( xiaoqu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXiaoquId(xiaoqu.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(chuzu.getYonghuId());
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
    public R save(@RequestBody ChuzuEntity chuzu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chuzu:{}",this.getClass().getName(),chuzu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            chuzu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ChuzuEntity> queryWrapper = new EntityWrapper<ChuzuEntity>()
            .eq("yonghu_id", chuzu.getYonghuId())
            .eq("xiaoqu_id", chuzu.getXiaoquId())
            .eq("chuzu_name", chuzu.getChuzuName())
            .eq("chuzu_types", chuzu.getChuzuTypes())
            .eq("fangxing_types", chuzu.getFangxingTypes())
            .eq("zhuangxiu_types", chuzu.getZhuangxiuTypes())
            .eq("chaoxiang_types", chuzu.getChaoxiangTypes())
            .eq("louceng", chuzu.getLouceng())
            .eq("quyu_types", chuzu.getQuyuTypes())
            .eq("tese", chuzu.getTese())
            .eq("xiangxi", chuzu.getXiangxi())
            .eq("yizu_types", chuzu.getYizuTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuzuEntity chuzuEntity = chuzuService.selectOne(queryWrapper);
        if(chuzuEntity==null){
            chuzu.setInsertTime(new Date());
            chuzu.setCreateTime(new Date());
            chuzuService.insert(chuzu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChuzuEntity chuzu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chuzu:{}",this.getClass().getName(),chuzu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("用户".equals(role))
//            chuzu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ChuzuEntity> queryWrapper = new EntityWrapper<ChuzuEntity>()
            .notIn("id",chuzu.getId())
            .andNew()
            .eq("yonghu_id", chuzu.getYonghuId())
            .eq("xiaoqu_id", chuzu.getXiaoquId())
            .eq("chuzu_name", chuzu.getChuzuName())
            .eq("chuzu_types", chuzu.getChuzuTypes())
            .eq("fangxing_types", chuzu.getFangxingTypes())
            .eq("zhuangxiu_types", chuzu.getZhuangxiuTypes())
            .eq("chaoxiang_types", chuzu.getChaoxiangTypes())
            .eq("louceng", chuzu.getLouceng())
            .eq("quyu_types", chuzu.getQuyuTypes())
            .eq("tese", chuzu.getTese())
            .eq("xiangxi", chuzu.getXiangxi())
            .eq("yizu_types", chuzu.getYizuTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuzuEntity chuzuEntity = chuzuService.selectOne(queryWrapper);
        if("".equals(chuzu.getChuzuPhoto()) || "null".equals(chuzu.getChuzuPhoto())){
                chuzu.setChuzuPhoto(null);
        }
        if(chuzuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      chuzu.set
            //  }
            chuzuService.updateById(chuzu);//根据id更新
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
        chuzuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ChuzuEntity> chuzuList = new ArrayList<>();//上传的东西
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
                            ChuzuEntity chuzuEntity = new ChuzuEntity();
//                            chuzuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            chuzuEntity.setXiaoquId(Integer.valueOf(data.get(0)));   //小区 要改的
//                            chuzuEntity.setChuzuName(data.get(0));                    //房间 要改的
//                            chuzuEntity.setChuzuPhoto("");//照片
//                            chuzuEntity.setChuzuTypes(Integer.valueOf(data.get(0)));   //出租方式 要改的
//                            chuzuEntity.setChuzuMoney(data.get(0));                    //房租价格/月 要改的
//                            chuzuEntity.setShuiMoney(data.get(0));                    //水费/吨 要改的
//                            chuzuEntity.setDianMoney(data.get(0));                    //电费/度 要改的
//                            chuzuEntity.setBaojieMoney(data.get(0));                    //保洁/月 要改的
//                            chuzuEntity.setFangxingTypes(Integer.valueOf(data.get(0)));   //房屋类型 要改的
//                            chuzuEntity.setPingfang(data.get(0));                    //房屋平方 要改的
//                            chuzuEntity.setZhuangxiuTypes(Integer.valueOf(data.get(0)));   //装修方式 要改的
//                            chuzuEntity.setChaoxiangTypes(Integer.valueOf(data.get(0)));   //房屋朝向 要改的
//                            chuzuEntity.setLouceng(Integer.valueOf(data.get(0)));   //楼层 要改的
//                            chuzuEntity.setQuyuTypes(Integer.valueOf(data.get(0)));   //所属区域 要改的
//                            chuzuEntity.setTese(data.get(0));                    //房屋特色 要改的
//                            chuzuEntity.setXiangxi(data.get(0));                    //详细地址 要改的
//                            chuzuEntity.setChuzuContent("");//照片
//                            chuzuEntity.setYizuTypes(Integer.valueOf(data.get(0)));   //是否出租 要改的
//                            chuzuEntity.setInsertTime(date);//时间
//                            chuzuEntity.setCreateTime(date);//时间
                            chuzuList.add(chuzuEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        chuzuService.insertBatch(chuzuList);
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
        PageUtils page = chuzuService.queryPage(params);

        //字典表数据转换
        List<ChuzuView> list =(List<ChuzuView>)page.getList();
        for(ChuzuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChuzuEntity chuzu = chuzuService.selectById(id);
            if(chuzu !=null){


                //entity转view
                ChuzuView view = new ChuzuView();
                BeanUtils.copyProperties( chuzu , view );//把实体数据重构到view中

                //级联表
                    XiaoquEntity xiaoqu = xiaoquService.selectById(chuzu.getXiaoquId());
                if(xiaoqu != null){
                    BeanUtils.copyProperties( xiaoqu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXiaoquId(xiaoqu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(chuzu.getYonghuId());
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
    public R add(@RequestBody ChuzuEntity chuzu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chuzu:{}",this.getClass().getName(),chuzu.toString());
        Wrapper<ChuzuEntity> queryWrapper = new EntityWrapper<ChuzuEntity>()
            .eq("yonghu_id", chuzu.getYonghuId())
            .eq("xiaoqu_id", chuzu.getXiaoquId())
            .eq("chuzu_name", chuzu.getChuzuName())
            .eq("chuzu_types", chuzu.getChuzuTypes())
            .eq("fangxing_types", chuzu.getFangxingTypes())
            .eq("zhuangxiu_types", chuzu.getZhuangxiuTypes())
            .eq("chaoxiang_types", chuzu.getChaoxiangTypes())
            .eq("louceng", chuzu.getLouceng())
            .eq("quyu_types", chuzu.getQuyuTypes())
            .eq("tese", chuzu.getTese())
            .eq("xiangxi", chuzu.getXiangxi())
            .eq("yizu_types", chuzu.getYizuTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuzuEntity chuzuEntity = chuzuService.selectOne(queryWrapper);
        if(chuzuEntity==null){
            chuzu.setInsertTime(new Date());
            chuzu.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      chuzu.set
        //  }
        chuzuService.insert(chuzu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
