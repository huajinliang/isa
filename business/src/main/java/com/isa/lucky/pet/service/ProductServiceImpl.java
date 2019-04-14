/**
 * Copyright (C) 2006-2019 Isa All rights reserved
 */
package com.isa.lucky.pet.service;

import java.util.List;

import com.isa.lucky.pet.dao.domain.ProductDetail;
import com.isa.lucky.pet.dao.domain.ProductForShow;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.lucky.pet.dao.domain.Product;
import com.isa.lucky.pet.dao.mapper.ProductDetailMapper;
import com.isa.lucky.pet.dao.mapper.ProductMapper;

/**
 * product 实现
 * Date: 2019-03-04
 *
 * @author huajinliang
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    public List<Product> getRecommendProducts() {
        return productMapper.getFeaturedProductList();
    }

    @Override
    public List<Product> getCategoryProducts(int categoryId) {
        return productMapper.getProductList(2, categoryId);
    }

    @Override
    public ProductForShow getProductDetail(int id) {
        ProductForShow show = new ProductForShow();
        Product product = productMapper.getProductDetail(id);
        if (product != null && product.getId() > 0) {
            BeanUtils.copyProperties(product, show);
            List<ProductDetail> details = productDetailMapper.getProductDetailList(id);
            show.setDetail(details);
        }
        return show;

    }
}
