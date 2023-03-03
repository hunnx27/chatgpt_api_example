package com.ai.chatgpt.api;

import lombok.Getter;

@Getter
public class BaseResponse<T> {
    String message;
    T result;

    public BaseResponse(T result) {
        this.result = result;
    }
}
