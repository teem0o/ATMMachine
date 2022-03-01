package com.finances.ATMMachine.entity;


import lombok.Data;

@Data
public class Result {

    private Integer code;

    private String message;

    private Result(Integer code, String messgae) {
        this.code = code;
        this.message = messgae;
    }

    public static Result success(String message) {
        return new Result(200, message);
    }

    public static Result result(Integer code, String messgae) {
        return new Result(code, messgae);
    }
}
