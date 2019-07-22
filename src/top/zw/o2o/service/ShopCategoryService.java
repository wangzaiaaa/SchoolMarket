package top.zw.o2o.service;

import org.apache.ibatis.annotations.Param;
import top.zw.o2o.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryService {
    List<ShopCategory> getShopCategory(ShopCategory shopCategoryCondition);
}
