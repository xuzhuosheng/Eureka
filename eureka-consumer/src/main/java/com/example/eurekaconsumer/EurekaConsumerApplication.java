package com.example.eurekaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaConsumerApplication {


    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }


    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    @RequestMapping("/getUser")
    @ResponseBody
    public Map<String, Object> getUser(@RequestParam int id) {

        Map<String, Object> data = new HashMap<>();
        data = restTemplate.getForObject("http://service-producer/getUser?id=" + id, Map.class);
        return data;


    }

}
