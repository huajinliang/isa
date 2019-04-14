package com.isa.lucky.pet.controller.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.isa.lucky.pet.dao.domain.HomeBanner;
import com.isa.lucky.pet.dao.domain.Product;
import com.isa.lucky.pet.domain.CategoryRsp;
import com.isa.lucky.pet.service.CategoryService;
import com.isa.lucky.pet.service.HomeService;
import com.isa.lucky.pet.service.ProductService;

/**
 * home
 * Date: 2019-02-22
 *
 * @author huajinliang
 */
@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        List<HomeBanner> banners = homeService.getHomeBanner();
        List<CategoryRsp> crsp = categoryService.getCategory();
        List<Product> products = productService.getRecommendProducts();
        mv.setViewName("index");
        mv.addObject("banners", banners);
        mv.addObject("featured", products);

        mv.addObject("category", crsp);
        mv.addObject("title", "Welcome to Isa Lucky Pet Company");
        return mv;
    }
}
