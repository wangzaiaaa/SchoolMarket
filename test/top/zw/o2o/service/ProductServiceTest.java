package top.zw.o2o.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.zw.o2o.BaseTest;
import top.zw.o2o.dto.ImageHolder;
import top.zw.o2o.dto.ProductExecution;
import top.zw.o2o.entity.Product;
import top.zw.o2o.entity.ProductCategory;
import top.zw.o2o.entity.Shop;
import top.zw.o2o.enums.ProductStateEnum;
import top.zw.o2o.exceptions.ShopOperationException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductServiceTest extends BaseTest {
    @Autowired
    private ProductService productService;
    @Test
    public void testAddProduct() throws ShopOperationException, FileNotFoundException{
        //创建shopId为1且productCategoryId为1的商品实例并给其成员变量赋值
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(1L);
        ProductCategory pc = new ProductCategory();
        pc.setProductCategoryId(1L);
        product.setShop(shop );
        product.setProductCategory(pc);
        product.setProductName("测试商品1");
        product.setProductDesc("测试商品2");
        product.setPriority(20);
        product.setCreateTime(new Date());
        product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
        //创建缩略图文件流
        File thummbnailFile = new File("C:\\Users\\bonsoirzw\\Pictures\\Camera Roll\\qie.jpg");
        InputStream is = new FileInputStream(thummbnailFile);
        ImageHolder thumbnail = new ImageHolder(thummbnailFile.getName(),is);
        //创建两个商品详细图文件流并将他们添加到详细图列表中
        File productImg1 = new File("D:\\projectdev\\image\\upload\\images\\item\\shop\\1\\2019071621332990182.jpg");
        InputStream is1 = new FileInputStream(productImg1);

        File productImg2 = new File("D:\\projectdev\\image\\upload\\images\\item\\shop\\1\\2019071821353240028.jpg");
        InputStream is2 = new FileInputStream(productImg1);

        List<ImageHolder> productImgList = new ArrayList<>();
        productImgList.add(new ImageHolder(productImg1.getName(),is1));
        productImgList.add(new ImageHolder(productImg2.getName(),is2));
        //添加商品验证
        ProductExecution pe = productService.addProduct(product,thumbnail,productImgList);
        Assert.assertEquals(ProductStateEnum.SUCCESS.getState(),pe.getState());



    }
}
