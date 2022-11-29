package com.yunusbagriyanik.springrabbitmq.model;

import org.springframework.http.HttpStatus;

import java.util.Objects;

public class ProcessResult {
    private int code;
    private HttpStatus status;
    private String message;

    public static ProcessResult success(String message) {
        ProcessResult result = new ProcessResult();
        result.setStatus(HttpStatus.OK);
        result.setCode(200);
        result.setMessage(message);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessResult that = (ProcessResult) o;
        return code == that.code && status == that.status && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, status, message);
    }
}