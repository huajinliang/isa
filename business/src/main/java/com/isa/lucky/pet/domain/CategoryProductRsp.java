/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.isa.lucky.pet.domain;

import java.util.List;

import com.isa.lucky.pet.dao.domain.Category;
import com.isa.lucky.pet.dao.domain.Product;

/**
 * category product detail
 * Date: 2019-03-05
 *
 * @author huajinliang
 */
public class CategoryProductRsp {

    private Category category;

    private Category topCategory;

    private List<Product> products;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getTopCategory() {
        return topCategory;
    }

    public void setTopCategory(Category topCategory) {
        this.topCategory = topCategory;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
