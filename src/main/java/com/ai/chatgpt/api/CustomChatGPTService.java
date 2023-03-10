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

    private static final int MAX_RETRIES = 10;

    public ChatGptRes getChatResponse(String prompt) throws Exception {
        String responseMessage = "";
        for (int i=0; i<MAX_RETRIES; i++) {
            try {
                // ChatGPT 에게 질문을 던집니다.
                responseMessage = chatgptService.sendMessage(prompt);
                break;
            } catch (Exception e) {
                Thread.sleep(3000);

                if(i == MAX_RETRIES-1){
                    throw e;
                }
            }
        }

        return new ChatGptRes(responseMessage);
    }
}
