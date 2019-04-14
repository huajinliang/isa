/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.isa.lucky.pet.domain;

import java.util.List;

import com.isa.lucky.pet.dao.domain.Category;

/**
 * category rsp
 * Date: 2019-03-02
 *
 * @author huajinliang
 */
public class CategoryRsp extends Category {

    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
