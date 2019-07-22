package top.zw.o2o.dao;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import top.zw.o2o.BaseTest;
import top.zw.o2o.entity.ProductImg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductImgDaoTest extends BaseTest {
    @Autowired
    private ProductImageDao productImageDao;
    @Test
    public void testABatchInsertProductImg() throws Exception{
        ProductImg productImg1 = new ProductImg();
        productImg1.setImgAddr("图片1");
        productImg1.setImgDesc("测试图片1");
        productImg1.setPriority(1);
        productImg1.setCreateTime(new Date());
        productImg1.setProductId(1L);
        ProductImg productImg2 = new ProductImg();
        productImg2.setImgAddr("图片2");
        productImg2.setImgDesc("测试图片2");
        productImg2.setPriority(2);
        productImg2.setCreateTime(new Date());
        productImg2.setProductId(1L);
        List<ProductImg> productImgList = new ArrayList<>();
        productImgList.add(productImg1);
        productImgList.add(productImg2);
        int effectedNum = productImageDao.batchInsertProductImg(productImgList);
        Assert.assertEquals(2,effectedNum);


    }


    @Test
    public void testBQueryProductImgList(){

        //检查productId为1的商品是否有且仅有两张商品详细图片
        List<ProductImg> productImgList = productImageDao.queryProductImgList(1L);
        Assert.assertEquals(2,productImgList.size());
    }

    @Test
    public void testCDeleteProductImgByProductId() throws Exception{
         //删除新增的两条商品详情图片记录
        long productId = 1;
        int effectedNum = productImageDao.deleteProductImgByProductId(productId);
        Assert.assertEquals(2,effectedNum);
    }
}
