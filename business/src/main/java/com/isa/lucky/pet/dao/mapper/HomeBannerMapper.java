/**
 * Copyright (C) 2006-2019 Isa All rights reserved
 */
package com.isa.lucky.pet.dao.mapper;

import java.util.List;

import com.isa.lucky.pet.dao.domain.HomeBanner;

/**
 * home banner
 * Date: 2019-02-19
 *
 * @author huajinliang
 */
public interface HomeBannerMapper {

    List<HomeBanner> getBannerList();

    void insertBanner(HomeBanner homeBanner);

    void updateBanner(HomeBanner homeBanner);
}
