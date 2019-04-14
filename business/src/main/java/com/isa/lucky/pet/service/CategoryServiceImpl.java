/**
 * Copyright (C) 2006-2019 Isa All rights reserved
 */
package com.isa.lucky.pet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.isa.lucky.pet.dao.domain.Category;
import com.isa.lucky.pet.dao.domain.Product;
import com.isa.lucky.pet.dao.mapper.CategoryMapper;
import com.isa.lucky.pet.domain.CategoryProductRsp;
import com.isa.lucky.pet.domain.CategoryRsp;

/**
 * 分类
 * Date: 2019-03-02
 *
 * @author huajinliang
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductService productService;

    @Override
    public List<CategoryRsp> getCategory() {
        List<CategoryRsp> categoryRsp = new ArrayList<>();
        List<Category> topCategories = categoryMapper.getTopCategoryList();

        if (!CollectionUtils.isEmpty(topCategories)) {
            topCategories.forEach(category -> {
                CategoryRsp csp = new CategoryRsp();
                BeanUtils.copyProperties(category, csp);
                List<Category> secondC = categoryMapper.getSecondCategoryList(category.getId());
                csp.setCategories(secondC);
                categoryRsp.add(csp);
            });
        }
        return categoryRsp;
    }

    @Override
    public CategoryProductRsp getCategoryProducts(String url) {

        Category category = categoryMapper.getCategoryByUrl(url);
        if (category != null) {
            CategoryProductRsp cpr = new CategoryProductRsp();
            cpr.setCategory(category);
            cpr.setProducts(new ArrayList<>());
            if (category.getParentId() > 0) {
                cpr.setTopCategory(categoryMapper.getCategory(category.getParentId()));
                cpr.setProducts(productService.getCategoryProducts(category.getParentId()));
            } else {
                List<Category> subCategories = categoryMapper.getSecondCategoryList(category.getId());
                if (!CollectionUtils.isEmpty(subCategories)) {
                    subCategories.forEach(category1 -> {
                        List<Product> products = productService.getCategoryProducts(category1.getId());
                        cpr.getProducts().addAll(products);
                    });
                }
            }
            return cpr;
        }
        return null;
    }
}
