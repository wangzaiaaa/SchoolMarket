package top.zw.o2o.controller.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "shopadmin" ,method = RequestMethod.GET)
public class ShopController {


    @RequestMapping(value = "/shopoperate")
    public String shopOperation(){
        return "shop/shopoperation";
    }

    @RequestMapping(value = "/shoplist")
    public String shopList(){
        return "shop/shoplist";
    }


    @RequestMapping(value = "/shopmanagement")
    public String shopManagement() {
        // 转发至店铺管理页面
        return "shop/shopmanagement";
    }

    @RequestMapping(value = "/productcategorymanagement",method = RequestMethod.GET)
    private String productCategoryManage(){
        return "shop/productcategorymanagement";
    }


    @RequestMapping(value = "/productoperation")
    public String productOperation(){
        //转发商品添加/编辑页面
        return "shop/productoperation";
    }


}
