package com.checker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/restTest")
public class RESTController {

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String getBook(@PathVariable("id") int id) {
        System.out.println("getBook..."+id);
        return "success";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.POST)
    public String postBook(@PathVariable("id") int id) {
        System.out.println("postBook..."+id);
        return "success";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("id") int id) {
        System.out.println("deleteBook..."+id);
        return "success";
    }

    @RequestMapping(value = "/book",method = RequestMethod.PUT)
    public String putBook(){
        System.out.println("putBook...");
        return "success";
    }
}
