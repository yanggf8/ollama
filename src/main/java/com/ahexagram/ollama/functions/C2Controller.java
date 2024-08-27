package com.ahexagram.ollama.functions;
import org.springframework.ai.chat.client.ChatClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
public class C2Controller {

    private static final Logger log = LoggerFactory.getLogger(C2Controller.class);
    private final ChatClient chatClient;
        
    public C2Controller(ChatClient.Builder builder) {
        this.chatClient = builder
            .defaultSystem("You are a helpful AI Assistant answering questions about cities around the world.")
            .defaultFunctions("weatherFunction1")
            .build();
        log.info("C2 Controller constructed");
    }

   /*  ChatOptions chatOptions =  ChatOptions.builder()
        .withFunction( functionNames : "currentWeatherFunction")
        .build();
    */
    @GetMapping("/c2")
    public String city2() {
        log.info("c2 Entered");
        //UserMessage userMessage = new UserMessage("What's the weather like in San Francisco, Tokyo, and Paris?");
        

        //OllamaChatModel chatModel = context.getBean(OllamaChatModel.class);
     

        //String userMessage = "What's the weather like in San Francisco, Tokyo, and Paris? You can call the following functions 'WeatherInfo'";
        String userMessage = "What's the weather like in San Francisco, Tokyo, and Paris? You can call the following functions 'weatherFunction1'";
        log.info("c2 userMessage: {}",userMessage);

        String resultStr = chatClient.prompt()
            .user(userMessage)
            .functions("weatherFunction1")
            .call()
            .content();

        //var chatClient = chatClientBuilder.build();
                       	
        log.info("c2 response: {}",resultStr);
        return resultStr;

    }
}