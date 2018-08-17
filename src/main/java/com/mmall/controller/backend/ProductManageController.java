package com.mmall.controller.backend;

import com.google.common.collect.Maps;
import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.pojo.User;
import com.mmall.service.IFileService;
import com.mmall.service.IProductService;
import com.mmall.service.IUserService;
import com.mmall.util.CookieUtil;
import com.mmall.util.JsonUtil;
import com.mmall.util.PropertiesUtil;
import com.mmall.util.RedisPoolUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 商品管理模块开发
 * Created by wangfei
 */
@Controller
@RequestMapping("/manage/product")
public class ProductManageController {

    //接口注入
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IFileService iFileService;

    //保存产品
    @RequestMapping("save.do")
    @ResponseBody
    public ServerResponse productSave(HttpServletRequest httpServletRequest, Product product){
        //用户登录
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        if(StringUtils.isEmpty(loginToken)){
            return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户的信息");
        }
        String userJsonStr = RedisPoolUtil.get(loginToken);
        User currentUser = JsonUtil.string2Obj(userJsonStr, User.class);

        if(currentUser == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录管理员");
        }
        //判断管理员权限
        if(iUserService.checkAdminRole(currentUser).isSuccess()){
            //填充我们增加产品的业务逻辑
            return iProductService.saveOrUpdateProduct(product);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    //修改产品的销售状态
    @RequestMapping("set_sale_status.do")
    @ResponseBody
    public ServerResponse setSaleStatus(HttpServletRequest httpServletRequest, Integer productId, Integer status){
        //用户登录
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        if(StringUtils.isEmpty(loginToken)){
            return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户的信息");
        }
        String userJsonStr = RedisPoolUtil.get(loginToken);
        User currentUser = JsonUtil.string2Obj(userJsonStr, User.class);

        if(currentUser == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录管理员");
        }
        //判断管理员权限
        if(iUserService.checkAdminRole(currentUser).isSuccess()){
            return iProductService.setSaleStatus(productId, status);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    //获取产品详情
    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse getDetail(HttpServletRequest httpServletRequest, Integer productId){
        //用户登录
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        if(StringUtils.isEmpty(loginToken)){
            return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户的信息");
        }
        String userJsonStr = RedisPoolUtil.get(loginToken);
        User currentUser = JsonUtil.string2Obj(userJsonStr, User.class);

        if(currentUser == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录管理员");
        }
        //判断管理员权限
        if(iUserService.checkAdminRole(currentUser).isSuccess()){
            //填充业务
            return iProductService.manageProductDetail(productId);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    //后台商品列表查询
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse getList(HttpServletRequest httpServletRequest, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        //用户登录
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        if(StringUtils.isEmpty(loginToken)){
            return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户的信息");
        }
        String userJsonStr = RedisPoolUtil.get(loginToken);
        User currentUser = JsonUtil.string2Obj(userJsonStr, User.class);

        if(currentUser == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录管理员");
        }
        //判断管理员权限
        if(iUserService.checkAdminRole(currentUser).isSuccess()){
            //填充业务
            return iProductService.getProductList(pageNum, pageSize);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    //后台商品搜索
    @RequestMapping("search.do")
    @ResponseBody
    public ServerResponse productSearch(HttpServletRequest httpServletRequest, String productName, Integer productId, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        //用户登录
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        if(StringUtils.isEmpty(loginToken)){
            return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户的信息");
        }
        String userJsonStr = RedisPoolUtil.get(loginToken);
        User currentUser = JsonUtil.string2Obj(userJsonStr, User.class);

        if(currentUser == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录管理员");
        }
        //判断管理员权限
        if(iUserService.checkAdminRole(currentUser).isSuccess()){
            //填充业务
            return iProductService.searchProduct(productName, productId, pageNum, pageSize);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    //文件上传
    @RequestMapping("upload.do")
    @ResponseBody
    public ServerResponse upload(HttpServletRequest httpServletRequest, @RequestParam(value = "upload_file", required = false) MultipartFile file, HttpServletRequest request){
        //用户登录
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        if(StringUtils.isEmpty(loginToken)){
            return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户的信息");
        }
        String userJsonStr = RedisPoolUtil.get(loginToken);
        User currentUser = JsonUtil.string2Obj(userJsonStr, User.class);

        if(currentUser == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录管理员");
        }
        //判断管理员权限
        if(iUserService.checkAdminRole(currentUser).isSuccess()){
            //填充业务
            String path = request.getSession().getServletContext().getRealPath("upload");
            String targetFileName = iFileService.upload(file, path);
            String url = PropertiesUtil.getProperty("ftp.server.http.prefix")+targetFileName;

            Map fileMap = Maps.newHashMap();
            fileMap.put("uri", targetFileName);
            fileMap.put("url", url);
            return  ServerResponse.createBySuccess(fileMap);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    //富文本图片上传
    @RequestMapping("richtext_img_upload.do")
    @ResponseBody
    public Map richtextIimgUpload(HttpServletRequest httpServletRequest, @RequestParam(value = "upload_file", required = false) MultipartFile file,
                                  HttpServletRequest request, HttpServletResponse response){
        Map resultMap = Maps.newHashMap();
        //用户登录
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        if(StringUtils.isEmpty(loginToken)){
            resultMap.put("success", false);
            resultMap.put("msg", "请登录管理员");
            return resultMap;
        }
        String userJsonStr = RedisPoolUtil.get(loginToken);
        User currentUser = JsonUtil.string2Obj(userJsonStr, User.class);

        if(currentUser == null){
            resultMap.put("success", false);
            resultMap.put("msg", "请登录管理员");
            return resultMap;
        }
        //副文本中对于返回值有自己的要求，我们使用的是simditor,所以按照simditor的要求进行返回
        //判断管理员权限
        if(iUserService.checkAdminRole(currentUser).isSuccess()){
            //填充业务
            String path = request.getSession().getServletContext().getRealPath("upload");
            String targetFileName = iFileService.upload(file, path);
            if(StringUtils.isBlank(targetFileName)){
                resultMap.put("success", false);
                resultMap.put("msg", "上传失败");
                return resultMap;
            }
            String url = PropertiesUtil.getProperty("ftp.server.http.prefix")+targetFileName;
            resultMap.put("success", true);
            resultMap.put("msg", "上传成功");
            resultMap.put("file_path", path);
            response.addHeader("Access-Control-Allow-Headers","X-File-Name"); //跟前端的约定
            return resultMap;
        }else {
            resultMap.put("success", false);
            resultMap.put("msg", "无权限操作");
            return resultMap;
        }
    }
}
