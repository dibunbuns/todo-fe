package dmuller.todo_fe.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class test {
    @GetMapping("/test")
    public String testField() {
        return "OK";
    }
}
