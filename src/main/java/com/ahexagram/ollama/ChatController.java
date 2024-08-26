package com.ahexagram.ollama;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("")
    public String joke(){
        //String returnString = "G";
        String resultStr = chatClient.prompt() //ChatClientRequest.getSpec
            .user("tell me a dead joke aboud computer")
            .call()
            .content();
        //System.out.println(resultStr);
        //return returnString;
        return resultStr;
    }
    
}
