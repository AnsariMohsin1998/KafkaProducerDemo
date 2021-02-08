package com.meesho.kafka.springbootkafkaproucerexample.resource;

import com.meesho.kafka.springbootkafkaproucerexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {


    @Autowired
    KafkaTemplate<String, User>  kafkaTemplate;

    public static final String TOPIC = "Kafka_Example";


    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name){
        kafkaTemplate.send(TOPIC,new User("Peter","Tech",2600000L));
        return "Published Successfully";
    }



}
