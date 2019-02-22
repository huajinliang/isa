/**
 * Copyright (C) 2006-2019 Isa All rights reserved
 */
package com.isa.lucky.pet.dao.mapper;

import java.util.List;

import com.isa.lucky.pet.dao.domain.Category;

import io.lettuce.core.dynamic.annotation.Param;

/**
 * category
 * Date: 2019-02-19
 *
 * @author huajinliang
 */
public interface CategoryMapper {

    List<Category> getTopCategoryList();

    List<Category> getSecondCategoryList(@Param("parentId") int parentId);

    void insertCategory(Category category);

    void updateCategory(Category category);
}
