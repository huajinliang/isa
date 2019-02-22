/**
 * Copyright (C) 2006-2019 Isa All rights reserved
 */
package com.isa.lucky.pet.controller.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.lucky.pet.dao.domain.HomeBanner;
import com.isa.lucky.pet.service.HomeService;

/**
 * home banner
 * Date: 2019-02-22
 *
 * @author huajinliang
 */
@RestController
@RequestMapping("/home/banner")
public class HomeBannerController {

    @Autowired
    private HomeService homeService;

    @RequestMapping("/list")
    public List<HomeBanner> getBanner() {
        return homeService.getHomeBanner();
    }
}
