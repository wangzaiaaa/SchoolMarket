package top.zw.o2o.service;

import top.zw.o2o.dto.ImageHolder;
import top.zw.o2o.dto.ShopExecution;
import top.zw.o2o.entity.Shop;
import top.zw.o2o.exceptions.ShopOperationException;

import java.io.InputStream;

public interface ShopService {
    /**
     * 根据shopCondition分页返回
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);
    /**
     * 添加店铺
     * @param shop
     * @return
     */
    ShopExecution addShop(Shop shop, ImageHolder thumbnail);

    /**
     * 获取店铺
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId);

    /**
     *
     * @param shop
     * @return
     * @throws ShopOperationException
     */
    ShopExecution modifyShop(Shop shop,ImageHolder thumbnail) throws ShopOperationException;
}
