package com.rest.webservices.restful_web_services.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class FilteringSomeBean {

    public static MappingJacksonValue mapping(MappingJacksonValue mjv, String... fields) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
        FilterProvider sfp = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        mjv.setFilters(sfp);

        return mjv;
    }

}
