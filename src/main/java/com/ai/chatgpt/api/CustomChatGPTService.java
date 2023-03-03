package com.ai.chatgpt.api;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomChatGPTService {
    private ChatgptService chatgptService;

    @Autowired
    public CustomChatGPTService(ChatgptService chatgptService){
        this.chatgptService = chatgptService;
    }

    public ChatGptRes getChatResponse(String prompt) throws Exception {
        try {
            // ChatGPT 에게 질문을 던집니다.
            String responseMessage = chatgptService.sendMessage(prompt);
            return new ChatGptRes(responseMessage);
        } catch (Exception e){
            throw new Exception(e);
        }
    }
}
