package com.example.eurekaproducer2;

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
public class EurekaProducer2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProducer2Application.class, args);
    }


    @RequestMapping("/getUser")
    @ResponseBody
    public Map<String, Object> getUser(@RequestParam Integer id) {
        Map<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("userName", "admin");
        data.put("from", "provider-B");
        return data;

    }


}
