/**
 * Copyright (C) 2006-2019 Isa All rights reserved
 */
package com.isa.lucky.pet.dao.mapper;

import java.util.List;

import com.isa.lucky.pet.dao.domain.Category;
import com.isa.lucky.pet.dao.domain.Product;

import io.lettuce.core.dynamic.annotation.Param;

/**
 * product
 * Date: 2019-02-19
 *
 * @author huajinliang
 */
public interface ProductMapper {

    List<Product> getProductList(@Param("online") int online, @Param("name") String name, @Param("categoryId") int categoryId);

    Product getProductDetail(@Param("id") int id);

    void insertProduct(Product product);

    void changeProduct(Product product);
}
