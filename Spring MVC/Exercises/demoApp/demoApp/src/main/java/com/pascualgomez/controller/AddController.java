package com.pascualgomez.controller;

import com.pascualgomez.service.AddService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AddController {

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("t1") int a, @RequestParam("t2") int b,
                            HttpServletRequest request, HttpServletResponse response) {

        AddService as = new AddService();

        int c = as.add(a, b);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("display");
        mv.addObject("result", c);

        return mv;
    }

}
