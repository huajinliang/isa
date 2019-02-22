/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.isa.lucky.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.lucky.pet.dao.domain.HomeBanner;
import com.isa.lucky.pet.dao.mapper.HomeBannerMapper;

/**
 * home service
 * Date: 2019-02-20
 *
 * @author huajinliang
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeBannerMapper homeBannerMapper;

    @Override
    public List<HomeBanner> getHomeBanner() {
        return homeBannerMapper.getBannerList();
    }
}
