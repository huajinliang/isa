/**
 * Copyright (C) 2006-2019 Isa All rights reserved
 */
package com.isa.lucky.pet.dao.mapper;

import java.util.List;

import com.isa.lucky.pet.dao.domain.ProductDetail;

import io.lettuce.core.dynamic.annotation.Param;

/**
 * product detail
 * Date: 2019-02-19
 *
 * @author huajinliang
 */
public interface ProductDetailMapper {

    List<ProductDetail> getProductDetailList(@Param("productId") int productId);

    void insertProductDetail(ProductDetail productDetail);

    void changeProduct(ProductDetail productDetail);
}
