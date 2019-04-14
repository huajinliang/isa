package com.isa.lucky.pet.controller.contact;

import com.isa.lucky.pet.domain.CategoryRsp;
import com.isa.lucky.pet.service.CategoryService;
import com.isa.lucky.pet.util.MailSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 联系
 * Date: 2019-03-09
 *
 * @author huajinliang
 */
@Controller
public class ContactController {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @GetMapping("/contact")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        List<CategoryRsp> crsp = categoryService.getCategory();
        mv.setViewName("contact");
        mv.addObject("category", crsp);
        mv.addObject("result", null);
        mv.addObject("title", "Contact us");
        return mv;
    }

    @PostMapping(value = "/contact/confirm")
    public ModelAndView confirm(HttpServletRequest request) {
        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("contact");
        mv.addObject("title", "Contact us");
        List<CategoryRsp> crsp = categoryService.getCategory();
        mv.addObject("category", crsp);
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(mail)) {
            mv.addObject("result", "name or email cannot be null");
            return mv;
        }

        String info = "User Name: " + name +
                "<br/>User Mail: " + mail +
                "<br/>User Subject: " + subject +
                "<br/>User Message: " + message;

        MailSend mailSend = new MailSend(subject, info);
        mailSend.doSend();

        mv.addObject("result", "send email success");
        return mv;
    }
}
