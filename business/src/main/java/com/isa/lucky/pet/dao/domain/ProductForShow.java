package com.isa.lucky.pet.dao.domain;

import java.util.List;

public class ProductForShow extends Product {

    private List<ProductDetail> detail;

    public List<ProductDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<ProductDetail> detail) {
        this.detail = detail;
    }
}
