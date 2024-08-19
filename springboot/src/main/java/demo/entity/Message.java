package demo.entity;

import lombok.Data;

@Data
public class Message {
    private String code;

    private String status;

    private String message;

    public Message(String code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
