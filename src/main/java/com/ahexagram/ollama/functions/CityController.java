package com.ahexagram.ollama.functions;

import org.springframework.ai.chat.client.ChatClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CityController {

    private static final Logger log = LoggerFactory.getLogger(CityController.class);
    private final ChatClient chatClient;
    
    public CityController(ChatClient.Builder builder) {
        
        this.chatClient = builder
                .defaultSystem("You are a helpful AI Assistant answering questions about cities around the world.")
                .defaultFunctions("currentWeatherFunction")
                .build();
        log.info("city client: {}",chatClient);
    }

   /*  ChatOptions chatOptions =  ChatOptions.builder()
        .withFunction( functionNames : "currentWeatherFunction")
        .build();
    */
    @GetMapping("/cities")
    public String cityFaq(@RequestParam String message) {
        log.info("city message: {}",message);
        log.info("city chatClient: {}",chatClient);
        return chatClient.prompt()
                //.user("tell me a dead joke aboud ai")
                .user(message)
                .call()
                .content();
    }

}