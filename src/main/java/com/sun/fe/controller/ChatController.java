package com.sun.fe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class ChatController {
 
    @GetMapping("/chatting")
    public String chat(){
        return "chat";
    }
}