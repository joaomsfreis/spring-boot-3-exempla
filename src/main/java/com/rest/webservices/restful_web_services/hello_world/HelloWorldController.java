package com.rest.webservices.restful_web_services.hello_world;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloWorldController {
    private MessageSource messageSource;

    HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/hello-world-i18n")
    public String helloWorldI18n() {
        var locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning", null, "Default Message", locale);
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World!");
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        var sb = new StringBuffer();
        sb.append("Hello World, ").append(name).append("!");
        return new HelloWorldBean(sb.toString());
    }

}
