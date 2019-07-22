package top.zw.o2o.dao;

import org.apache.ibatis.annotations.Param;
import top.zw.o2o.entity.Shop;

import java.util.List;

public interface ShopDao {


    int queryShopCount(@Param("shopCondition") Shop shopCondition);

    /**
     *
     * @param shopCondition
     * @param rowIndex 第几行开始
     * @param pageSize 行数
     * @return
     */

    List<Shop> queryShopList(@Param("shopCondition")Shop shopCondition,
                             @Param("rowIndex") int rowIndex,
                             @Param("pageSize") int pageSize);

    /**
     * 通过shop id查询店铺
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);

}
