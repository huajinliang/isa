/**
 * Copyright (C) 2006-2019 Isa All rights reserved
 */
package com.isa.lucky.pet.controller.product;

import com.isa.lucky.pet.domain.CategoryRsp;
import com.isa.lucky.pet.service.CategoryService;
import com.isa.lucky.pet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 产品信息
 */

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/detail/{productId}")
    public ModelAndView productDetail(@PathVariable("productId") int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product");
        mv.addObject("product", productService.getProductDetail(id));
        mv.addObject("title", "Product Detail");
        List<CategoryRsp> crsp = categoryService.getCategory();
        mv.addObject("category", crsp);
        return mv;
    }
}
