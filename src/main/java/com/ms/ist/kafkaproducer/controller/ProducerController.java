package com.ms.ist.kafkaproducer.controller;

import com.ms.ist.kafkaproducer.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;


    private final String TOPC = "ist-pod";

    @GetMapping("/check")
    public String produceere(){


        return "i am alive";
    }

    @PostMapping("/produce")
    public String produce(@RequestBody Employee employee){
       kafkaTemplate.send(TOPC,employee);

       return "Message sent to "+TOPC+" topic";
    }
}
