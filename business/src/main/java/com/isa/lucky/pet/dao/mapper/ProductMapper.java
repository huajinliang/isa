/**
 * Copyright (C) 2006-2019 Isa All rights reserved
 */
package com.isa.lucky.pet.dao.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Param;

import com.isa.lucky.pet.dao.domain.Product;

/**
 * product
 * Date: 2019-02-19
 *
 * @author huajinliang
 */
public interface ProductMapper {

    List<Product> getProductList(@Param("online") int online, @Param("categoryId") int categoryId);

    List<Product> getFeaturedProductList();

    Product getProductDetail(@Param("id") int id);

    void insertProduct(Product product);

    void changeProduct(Product product);
}
