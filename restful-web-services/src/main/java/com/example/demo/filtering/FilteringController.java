package com.example.demo.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import javassist.Loader;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

//    @GetMapping("/filtering")
//    public SomeBean retrieveSomeBean_staticFiltering(){
//        return new SomeBean("val1", "val2", "val3");
//    }

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean_dynamicFiltering(){
    SomeBean someBean = new SomeBean("val1", "val2", "val3");

    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
    FilterProvider filters =  new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);
        return mapping;
    }

//    @GetMapping("/filtering-list")
//    public List<SomeBean> retrieveListofSomeBean_staticFiltering(){
//        return Arrays.asList(new SomeBean("val1", "val2", "val3"),new SomeBean("val12", "val22", "val32"));
//    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListofSomeBean_dynamicFiltering(){
        List<SomeBean> list = Arrays.asList(new SomeBean("val1", "val2", "val3")
                ,new SomeBean("val12", "val22", "val32"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filters =  new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);
        return mapping;
    }
}
