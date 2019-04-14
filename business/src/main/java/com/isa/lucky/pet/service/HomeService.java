/**
 * Copyright (C) 2006-2019 Isa All rights reserved
 */
package com.isa.lucky.pet.service;

import java.util.List;

import com.isa.lucky.pet.dao.domain.HomeBanner;

/**
 * home service interface
 * Date: 2019-02-20
 *
 * @author huajinliang
 */
public interface HomeService {

    List<HomeBanner> getHomeBanner();
}
