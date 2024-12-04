package com.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping("/some")
    public MappingJacksonValue getSomeBean() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        MappingJacksonValue mjv = new MappingJacksonValue(someBean);
        
        return FilteringSomeBean.mapping(mjv, "field1", "field3");
    }

    @GetMapping("/list")
    public MappingJacksonValue getList() {
        List<SomeBean> someBeanList = Arrays.asList(
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"));

        MappingJacksonValue mjv = new MappingJacksonValue(someBeanList);

        return FilteringSomeBean.mapping(mjv, "field3");
    }
}
