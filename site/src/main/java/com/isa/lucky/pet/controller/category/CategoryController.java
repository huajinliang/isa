/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.isa.lucky.pet.controller.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.isa.lucky.pet.domain.CategoryProductRsp;
import com.isa.lucky.pet.domain.CategoryRsp;
import com.isa.lucky.pet.service.CategoryService;
import com.isa.lucky.pet.service.ProductService;

/**
 * category detail
 * Date: 2019-03-05
 *
 * @author huajinliang
 */

@RestController
public class CategoryController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/product-category/{category}")
    public ModelAndView category(@PathVariable("category") String categoryUrl) {
        CategoryProductRsp cpr = categoryService.getCategoryProducts(categoryUrl);
        List<CategoryRsp> categories = categoryService.getCategory();

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("category");
        modelAndView.addObject("cpr", cpr);
        modelAndView.addObject("category", categories);
        modelAndView.addObject("title", "Products");
        return modelAndView;
    }
}
