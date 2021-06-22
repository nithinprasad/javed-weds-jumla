package com.prasad.nithin.wedding.javed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class Controller {

    @Autowired
    Repository repository;

    @GetMapping("/all")
    public List<UserMessage> getAllMessages(){
       return repository.findAll();
    }

    @PostMapping(path = "/add")
    public UserMessage addMessage(@RequestBody UserMessage msg){
        return repository.save(msg);
    }

    @PostMapping(path = "/addform")
    public UserMessage addMessage(@RequestBody String name){
        //author=Nithin&company=TCS&message=Welcome
        List<String> each=Optional.ofNullable(name).map(a->a.split("&")).map(Arrays::asList).orElse(Collections.emptyList());
        Map<String, String> collect = each.stream().map(values -> values.split("=")).collect(Collectors.toMap(a -> a[0], a -> a[1]));
        UserMessage userMessage=new UserMessage();
        userMessage.setUserName(collect.get("userName"));
        userMessage.setCompany(collect.get("company"));
        userMessage.setMessage(collect.get("message"));

        return repository.save(userMessage);
    }

}
