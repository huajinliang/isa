/**
 * Copyright (C) 2006-2019 Isa All rights reserved
 */
package com.isa.lucky.pet.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.isa.lucky.pet.dao.domain.Category;


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

    Category getCategoryByUrl(@Param("url") String url);

    Category getCategory(@Param("id") int id);
}
