package com.gamza.nyangflix.domain.testFlight.endpoint;

import com.gamza.nyangflix.domain.testFlight.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    final TestService testService;

    @GetMapping("/")
    public String getOne() {
        return "아 제발 나오셈";
    }
}
