package com.ahexagram.ollama.functions;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class C2Controller {

    private final ChatClient chatClient;
        
    public C2Controller(ChatClient.Builder builder) {
        this.chatClient = builder
            .defaultSystem("You are a helpful AI Assistant answering questions about cities around the world.")
            .defaultFunctions("currentWeatherFunction1")
            .build();

    }

   /*  ChatOptions chatOptions =  ChatOptions.builder()
        .withFunction( functionNames : "currentWeatherFunction")
        .build();
    */
    @GetMapping("/c2")
    public String city2() {


        UserMessage userMessage = new UserMessage("What's the weather like in San Francisco, Tokyo, and Paris?");
        return chatClient.prompt()
        //.user("tell me a dead joke aboud ai")
        .user(userMessage.getContent())
        .call()
        .content();

    }
}