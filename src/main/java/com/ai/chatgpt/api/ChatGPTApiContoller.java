package com.ai.chatgpt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/chatGPT")
@RestController
public class ChatGPTApiContoller {

    String qreQuestion = "안녕, ChatGPT! 나 질문이 있어.";
    private final CustomChatGPTService chatGPTService;

    @Autowired
    public ChatGPTApiContoller(CustomChatGPTService chatGPTService){
        this.chatGPTService = chatGPTService;
    }

    @PostMapping("/askChatGPT")
    public BaseResponse<ChatGptRes> askToChatGPT(@RequestBody ChatGptReq chatGptReq){
        try {
            String resultQuestion = qreQuestion + chatGptReq.getQuestion();
            ChatGptRes chatGptRes = chatGPTService.getChatResponse(resultQuestion);

            return new BaseResponse(chatGptRes);
        } catch (Exception e){
            return new BaseResponse(e);
        }
    }

}
