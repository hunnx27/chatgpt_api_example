package com.ai.chatgpt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/chatGPT")
@RestController
public class ChatGPTApiContoller {

    String qreQuestion = "1. For the following commit message, please answer in one word which of the four types of software maintenance is fix, adapt, enhance, and prevent.\n\n\"%s\"";

    private final CustomChatGPTService chatGPTService;

    @Autowired
    public ChatGPTApiContoller(CustomChatGPTService chatGPTService){
        this.chatGPTService = chatGPTService;
    }

    @PostMapping("/askChatGPT")
    public BaseResponse<ChatGptRes> askToChatGPT(@RequestBody ChatGptReq chatGptReq){
        try {
            String resultQuestion = String.format(qreQuestion, chatGptReq.getQuestion());
            ChatGptRes chatGptRes = chatGPTService.getChatResponse(resultQuestion);

            return new BaseResponse(chatGptRes);
        } catch (Exception e){
            return new BaseResponse(e);
        }
    }

}
