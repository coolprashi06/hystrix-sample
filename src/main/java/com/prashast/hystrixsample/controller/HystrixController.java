package com.prashast.hystrixsample.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @RequestMapping(value = "/getContent/{contentKey}", method = RequestMethod.GET)
    @HystrixCommand(commandKey = "getContent", fallbackMethod = "getContentFallback")
    public String getContent(@PathVariable("contentKey") String contentKey) throws Exception{
        if(contentKey.equalsIgnoreCase("fallback")){
            throw new Exception("need fallback content");
        }
        return "General Content";
    }

    public String getContentFallback(String contentKey){
        System.out.println("going to fallback as the content key is "+ contentKey);
        return "Fallback Content";
    }
}
