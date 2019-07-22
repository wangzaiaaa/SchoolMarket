package top.zw.o2o.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.zw.o2o.BaseTest;
import top.zw.o2o.entity.Area;
import top.zw.o2o.entity.PersonInfo;
import top.zw.o2o.entity.Shop;
import top.zw.o2o.entity.ShopCategory;
import org.junit.Assert;

import java.util.Date;
import java.util.List;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

   @Test
   public void testQueryShopListAndCount(){
       Shop shopCondition = new Shop();
       PersonInfo owner = new PersonInfo();
       owner.setUserId(1L);
       shopCondition.setOwner(owner);

       ShopCategory sc = new ShopCategory();
       sc.setShopCategoryId(3L);
       shopCondition.setShopCategory(sc);
       List<Shop> shopList = shopDao.queryShopList(shopCondition,0,5);
       int count = shopDao.queryShopCount(shopCondition);
       System.out.println("店铺总数: " + count);
       System.out.println("店铺列表的大小: " + shopList.size());
   }

    @Test
   @Ignore
   public void testQueryByShopId(){
       long shopId = 1;
       Shop shop = shopDao.queryByShopId(shopId);
       System.out.println("araeName:" +shop.getArea().getAreaName());
       System.out.println("areaId :" + shop.getArea().getAreaId());
   }

    @Test
    @Ignore
    public void testInsertShop(){
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
        Assert.assertEquals(1,effectedNum);
    }


    @Test
    @Ignore
    public void testUpdateShop(){
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopDesc("测试描述");
        shop.setShopAddr("测试地址");
        shop.setLastEditTime(new Date());
        int effectedNum = shopDao.updateShop(shop);
        Assert.assertEquals(1,effectedNum);


    }
}
