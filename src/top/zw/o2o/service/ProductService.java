package top.zw.o2o.service;

import top.zw.o2o.dto.ImageHolder;
import top.zw.o2o.dto.ProductExecution;
import top.zw.o2o.entity.Product;
import top.zw.o2o.exceptions.ProductOperationException;

import java.io.InputStream;
import java.util.List;

public interface ProductService {
    /**
     * 添加商品信息以及图片处理
     *
     */
    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
            throws ProductOperationException;
}
