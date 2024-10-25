package ca.mcgill.ecse321.eventregistration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/greetings/hello")
    public String hello() {
        return "Hello there!";
    }

    @GetMapping("/greetings/hello/{name}")
    public String helloPathVariable(@PathVariable String name) {
        return String.format("Hello, %s!", name);
    }

    @GetMapping("/greetings/hello-query")
    public String helloQueryParam(@RequestParam String name) {
        return String.format("Hello, %s!", name);
    }
}
