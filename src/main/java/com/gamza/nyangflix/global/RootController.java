package com.gamza.nyangflix.global;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RootController {
    @GetMapping("")
    public ResponseEntity<Response> root() {
        return ping();
    }

    @GetMapping("/ping")
    public ResponseEntity<Response> ping() {
        Map<String, Object> main = new HashMap<>();
        main.put("result", "OK");
        return Response.success(main);
    }
}
