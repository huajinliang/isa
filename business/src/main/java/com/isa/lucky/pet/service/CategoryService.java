/**
 * Copyright (C) 2006-2019 Isa All rights reserved
 */
package com.isa.lucky.pet.service;

import java.util.List;

import com.isa.lucky.pet.domain.CategoryProductRsp;
import com.isa.lucky.pet.domain.CategoryRsp;

/**
 * category
 * Date: 2019-03-02
 *
 * @author huajinliang
 */
public interface CategoryService {

    List<CategoryRsp> getCategory();

    CategoryProductRsp getCategoryProducts(String url);
}
