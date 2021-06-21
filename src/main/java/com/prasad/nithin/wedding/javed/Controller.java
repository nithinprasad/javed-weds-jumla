package com.prasad.nithin.wedding.javed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    Repository repository;

    @GetMapping("/all")
    public List<UserMessage> getAllMessages(){
       return repository.findAll();
    }

    @PostMapping("/add")
    public UserMessage addMessage(@RequestBody UserMessage msg){
        return repository.save(msg);
    }

}
