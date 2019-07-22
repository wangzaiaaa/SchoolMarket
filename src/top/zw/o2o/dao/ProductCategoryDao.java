package top.zw.o2o.dao;



import org.apache.ibatis.annotations.Param;
import top.zw.o2o.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {
    /**
     * 通过shop id 查询店铺商品类别
     * @param shopId
     * @return
     */

    List<ProductCategory> queryProductCategoryList(long shopId);

    /**
     * 批量新增商品类别
     * @param productCategoryList
     * @return
     */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

    /**
     * 删除指定商品类别
     * @param productCategory
     * @param shopId
     * @return
     */
    int deleteProductCategory(@Param("productCategoryId") long productCategory,@Param("shopId") long shopId);
}