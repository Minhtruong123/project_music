package com.example.music.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public class AbstractController {
    public <T> ResponseEntity<T> ok(T data){
        return ResponseEntity.ok(data);
    }
    public ResponseEntity<Void> noContent(){
        return ResponseEntity.noContent().build();
    }
}
