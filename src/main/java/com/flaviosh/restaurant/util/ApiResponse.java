package com.flaviosh.restaurant.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private boolean success;
    private T data;
    private Map<String, String> error;

    public ApiResponse(boolean success, T data, Map<String, String> error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }
}
