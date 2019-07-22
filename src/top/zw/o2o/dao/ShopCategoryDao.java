package top.zw.o2o.dao;

import org.apache.ibatis.annotations.Param;
import top.zw.o2o.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryDao {
    /**
     * @return
     */
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
