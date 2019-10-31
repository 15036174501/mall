package com.yzsunlei.xmall.admin.controller;

import com.yzsunlei.xmall.admin.dto.CommonResult;
import com.yzsunlei.xmall.admin.dto.PmsProductParam;
import com.yzsunlei.xmall.admin.dto.PmsProductQueryParam;
import com.yzsunlei.xmall.admin.dto.PmsProductResult;
import com.yzsunlei.xmall.admin.service.PmsProductCategoryService;
import com.yzsunlei.xmall.admin.service.PmsProductService;
import com.yzsunlei.xmall.db.model.PmsProduct;
import com.yzsunlei.xmall.db.model.PmsProductCategoryExpand;
import com.yzsunlei.xmall.db.model.PmsProductExpand;
import com.yzsunlei.xmall.db.model.PmsProductTitle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 商品管理Controller
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "PmsProductController", description = "商品管理")
@RequestMapping("/product")
public class PmsProductController {
    @Autowired
    private PmsProductService productService;
    @Autowired
    private PmsProductCategoryService pmsProductCategoryService;


    @ApiOperation("创建商品")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:create')")
    public Object create(@RequestBody PmsProductParam productParam, BindingResult bindingResult) {
        int count = productService.create(productParam);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("根据商品id获取商品编辑信息")
    @RequestMapping(value = "/updateInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:read')")
    public Object getUpdateInfo(@PathVariable Long id) {
        PmsProductResult productResult = productService.getUpdateInfo(id);
        return new CommonResult().success(productResult);
    }

    @ApiOperation("更新商品")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:update')")
    public Object update(@PathVariable Long id, @RequestBody PmsProductParam productParam, BindingResult bindingResult) {
        int count = productService.update(id, productParam);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("查询商品")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:read')")
    public Object getList(PmsProductQueryParam productQueryParam,
                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProduct> productList = productService.list(productQueryParam, pageSize, pageNum);
        return new CommonResult().pageSuccess(productList);
    }

    @ApiOperation("根据商品名称或货号模糊查询")
    @RequestMapping(value = "/simpleList", method = RequestMethod.GET)
    @ResponseBody
    public Object getList(String  keyword) {
        List<PmsProduct> productList = productService.list(keyword);
        return new CommonResult().success(productList);
    }

    @ApiOperation("批量修改审核状态")
    @RequestMapping(value = "/update/verifyStatus",method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:update')")
    public Object updateVerifyStatus(@RequestParam("ids") List<Long> ids,
                                     @RequestParam("verifyStatus") Integer verifyStatus,
                                     @RequestParam("detail") String detail) {
        int count = productService.updateVerifyStatus(ids, verifyStatus, detail);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("批量上下架")
    @RequestMapping(value = "/update/publishStatus",method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:update')")
    public Object updatePublishStatus(@RequestParam("ids") List<Long> ids,
                                     @RequestParam("publishStatus") Integer publishStatus) {
        int count = productService.updatePublishStatus(ids, publishStatus);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("批量推荐商品")
    @RequestMapping(value = "/update/recommendStatus",method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:update')")
    public Object updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                      @RequestParam("recommendStatus") Integer recommendStatus) {
        int count = productService.updateRecommendStatus(ids, recommendStatus);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("批量设为新品")
    @RequestMapping(value = "/update/newStatus",method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:update')")
    public Object updateNewStatus(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("newStatus") Integer newStatus) {
        int count = productService.updateNewStatus(ids, newStatus);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("批量修改删除状态")
    @RequestMapping(value = "/update/deleteStatus",method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:delete')")
    public Object updateDeleteStatus(@RequestParam("ids") List<Long> ids,
                                  @RequestParam("deleteStatus") Integer deleteStatus) {
        int count = productService.updateDeleteStatus(ids, deleteStatus);
        if (count > 0) {
            return new CommonResult().success(count);
        } else {
            return new CommonResult().failed();
        }
    }

    @ApiOperation("获得商品详情列表")
    @RequestMapping(value = "/goodsDetail", method = RequestMethod.POST)
    @ResponseBody
    public Object getGoodsList() {
        List<PmsProductExpand> productList = productService.getGoodsList();
        if(productList.size()>0){
            for(int i=0;i<productList.size();i++){
                PmsProductExpand model=productList.get(i);
                model.setStatusStr("上架");
            }
        }
        return new CommonResult().success(productList);
    }

    @ApiOperation("商品首页信息")
    @RequestMapping(value = "/value", method = RequestMethod.GET)
    @ResponseBody
    public Object getGoodsTitle() {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<PmsProductTitle> productList = new ArrayList<>();
        PmsProductTitle model =new PmsProductTitle();
        model.setDateUpdate(format.format(new Date()));
        model.setKey("mallName");
        model.setRemark("商城名称");
        model.setValue("向前进百货");
        productList.add(0,model);

        PmsProductTitle model1 =new PmsProductTitle();
        model1.setDateUpdate(format.format(new Date()));
        model1.setKey("ALLOW_SELF_COLLECTION");
        model1.setRemark("是否开启到店自提");
        model1.setValue("1");
        productList.add(1,model1);

        PmsProductTitle model2 =new PmsProductTitle();
        model2.setDateUpdate(format.format(new Date()));
        model2.setKey("RECHARGE_OPEN");
        model2.setRemark("方便审核，特设充值开关");
        model2.setValue("1");
        productList.add(2,model2);
        return new CommonResult().success(productList);
    }

    @ApiOperation("获得商品详情页面")
    @RequestMapping(value = "/goodsDetailAll", method = RequestMethod.GET)
    @ResponseBody
    public Object getGoodsDetailAll(@RequestParam(value = "id", required = false) Long id) {
        List<PmsProductExpand> productList = productService.getGoodsDetailAll(id);
        Map map = new HashMap();
        if(productList.size()>0){
            PmsProductExpand model = productList.get(0);
            model.setViews(0);
            model.setNumberFav(0);
            model.setNumberOrders(0);
            model.setNumberGoodReputation(0);
            map.put("basicInfo",model);
            //获得上级菜单信息
            long categoryId = model.getCategoryId();
            //获得画册值
            String album_pics=model.getAlbumPics();
            if(!"".equals(album_pics)&&null!=album_pics){
            String[] image=album_pics.split(",");

            ArrayList listImage = new ArrayList();
            for(int i=0;i<image.length;i++){
                Map mapImage=new HashMap();
                String pic=image[i];
                mapImage.put("pic",pic);
                mapImage.put("goodsId",model.getId());
                mapImage.put("userId",19341);
                mapImage.put("id",i+1);
                listImage.add(mapImage);
                }
                map.put("pics",listImage);
            }

            //根据Id获得集合
            List<PmsProductCategoryExpand> productCategoryList = pmsProductCategoryService.getCategoryDetail(categoryId);

            if (productCategoryList.size()>0){
                PmsProductCategoryExpand modelCategory = productCategoryList.get(0);
                map.put("category",modelCategory);
            }

            //logistics 赋值
            Map mapLogistics = new HashMap();
            mapLogistics.put("isFree",true);
            mapLogistics.put("feeType",0);
            mapLogistics.put("feeTypeStr","按件数");

            ArrayList listDetails = new ArrayList();
            Map mapDetails = new HashMap();
            mapDetails.put("addAmount",0);
            mapDetails.put("addNumber",1);
            mapDetails.put("firstAmount",8);
            mapDetails.put("firstNumber",100);
            mapDetails.put("type",0);
            mapDetails.put("userId",19341);
            listDetails.add(mapDetails);
            mapLogistics.put("details",listDetails);

            map.put("logistics",mapLogistics);

            map.put("content","<p><img class='img-ks-lazyload' src='https://img.alicdn.com/imgextra/i1/4134225718/O1CN011s6tA1vX4G8hLLA_!!4134225718.jpg' width='790' align='absmiddle' data-spm-anchor-id='a220o.1000855.0.i6.591c48abotbO5M' /><img class='img-ks-lazyload' src='https://img.alicdn.com/imgextra/i3/4134225718/O1CN011s6tA1vZ96eqZsr_!!4134225718.jpg' width='790' align='absmiddle' data-spm-anchor-id='a220o.1000855.0.i7.591c48abotbO5M' /><img class='img-ks-lazyload' src='https://img.alicdn.com/imgextra/i2/4134225718/O1CN011s6tA3DLclskqs6_!!4134225718.jpg' width='790' align='absmiddle' data-spm-anchor-id='a220o.1000855.0.i8.591c48abotbO5M' /><img class='img-ks-lazyload' src='https://img.alicdn.com/imgextra/i4/4134225718/O1CN011s6tA1DUHgPiE2d_!!4134225718.jpg' width='790' align='absmiddle' data-spm-anchor-id='a220o.1000855.0.i9.591c48abotbO5M' /><img class='img-ks-lazyload' src='https://img.alicdn.com/imgextra/i3/4134225718/O1CN011s6t9vkup0LRlCG_!!4134225718.jpg' width='790' align='absmiddle' data-spm-anchor-id='a220o.1000855.0.i10.591c48abotbO5M' /><img class='img-ks-lazyload' src='https://img.alicdn.com/imgextra/i3/4134225718/O1CN011s6tA2qDpJa9sr9_!!4134225718.jpg' width='790' align='absmiddle' data-spm-anchor-id='a220o.1000855.0.i0.591c48abotbO5M' /><img class='img-ks-lazyload' src='https://img.alicdn.com/imgextra/i4/4134225718/O1CN011s6tA1VUSl5L792_!!4134225718.jpg' width='790' align='absmiddle' /><img class='img-ks-lazyload' src='https://img.alicdn.com/imgextra/i2/4134225718/O1CN011s6t9vku1BsbKeo_!!4134225718.jpg' width='790' align='absmiddle' /><img class='img-ks-lazyload' src='https://img.alicdn.com/imgextra/i3/4134225718/O1CN011s6tA2JHiYfv0XK_!!4134225718.jpg' width='790' align='absmiddle' /><img class='img-ks-lazyload' src='https://img.alicdn.com/imgextra/i3/4134225718/O1CN011s6tA01t8vWMNub_!!4134225718.jpg' width='790' align='absmiddle' /><img class='img-ks-lazyload' src='https://img.alicdn.com/imgextra/i2/4134225718/O1CN011s6tA1vYseCmCxv_!!4134225718.jpg' width='790' align='absmiddle' /><img class='img-ks-lazyload' src='https://img.alicdn.com/imgextra/i2/4134225718/O1CN011s6tA2JHiaJAiNR_!!4134225718.jpg' width='790' align='absmiddle' /><img class='img-ks-lazyload' src='https://img.alicdn.com/imgextra/i2/4134225718/O1CN011s6tA01sL8d3mKD_!!4134225718.jpg' width='790' align='absmiddle' /><img class='img-ks-lazyload' src='https://img.alicdn.com/imgextra/i3/4134225718/O1CN011s6tA1VUrpntRXW_!!4134225718.jpg' width='790' align='absmiddle' /><img class='img-ks-lazyload' src='https://img.alicdn.com/imgextra/i4/4134225718/O1CN011s6tA2H1g9yk8i2_!!4134225718.jpg' width='790' align='absmiddle' data-spm-anchor-id='a220o.1000855.0.i2.591c48abotbO5M' /></p>");

        }
        return new CommonResult().success(map);
    }
}
