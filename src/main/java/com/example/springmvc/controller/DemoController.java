package com.example.springmvc.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.FilterRegistration;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/index")
    public String index(){
        return "hello";
    }
    @PostMapping("/login")
    public String login(HttpServletRequest request){
        String name = request.getParameter("name");
        System.out.println("name " + name);
        request.getSession().setAttribute("name" , name);
        return name;
    }
    @PostMapping("/check")
    public String check(HttpServletRequest request){
       String name = (String) request.getSession().getAttribute("name");
        return name;
    }
    @GetMapping("/filter")
    public void filter(HttpServletRequest request){
        Map<String, ? extends FilterRegistration> map = request.getServletContext().getFilterRegistrations();
        for(Map.Entry<String, ? extends FilterRegistration> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : :  " + entry.getValue().getClass().getName() );

        }
    }


}
