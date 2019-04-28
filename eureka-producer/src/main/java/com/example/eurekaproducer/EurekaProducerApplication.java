package com.example.eurekaproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProducerApplication.class, args);
    }


//    @GetMapping(value = "/getUser")
//    @ResponseBody
//    public Map<String, Object> getUser(@RequestParam Integer id) {
//        Map<String, Object> data = new HashMap<>();
//        data.put("id", id);
//        data.put("userName", "admin");
//        data.put("from", "provider-A");
//        return data;
//    }

    @RequestMapping("/getUser")
    @ResponseBody
    public Map<String, Object> getUser(@RequestParam Integer id) {
        Map<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("userName", "admin");
        data.put("from", "provider-A");
        return data;

    }


}


