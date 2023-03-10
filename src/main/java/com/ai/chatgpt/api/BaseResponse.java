package com.ai.chatgpt.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    private String message;
    private T result;

    public BaseResponse(T result) {
        this.message = "성공";
        this.result = result;
    }
}
