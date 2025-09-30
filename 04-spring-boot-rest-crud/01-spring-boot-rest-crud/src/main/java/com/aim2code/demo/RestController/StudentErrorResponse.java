package com.aim2code.demo.RestController;

public class StudentErrorResponse {

    private int Status;
    private String Message;
    private long timestamp;

    public StudentErrorResponse(){

    }

    public StudentErrorResponse(int status, String message, long timestamp) {
        Status = status;
        Message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
