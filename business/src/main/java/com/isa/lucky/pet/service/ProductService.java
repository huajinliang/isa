/**
 * Copyright (C) 2006-2019 Isa All rights reserved
 */
package com.isa.lucky.pet.service;

import java.util.List;

import com.isa.lucky.pet.dao.domain.Product;
import com.isa.lucky.pet.dao.domain.ProductForShow;

/**
 * product service
 * Date: 2019-03-04
 *
 * @author huajinliang
 */
public interface ProductService {
    List<Product> getRecommendProducts();

    List<Product> getCategoryProducts(int categoryId);

    ProductForShow getProductDetail(int id);
}
