package com.restdemo.restapplication.controllers;

public class StudentErrorResponse {
    private int status;
    private String response;
    private long timestamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int status, String response, long timestamp){
        this.status=status;
        this.response=response;
        this.timestamp=timestamp;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}