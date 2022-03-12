package com.example.demo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("v1/person") //versioning using basic approach
    public PersonV1 personV1(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping("v2/person") //versioning using basic approach
    public PersonV2 personV2(){
        return new PersonV2(new Name("Bobby", "Charlie"));
    }


    @GetMapping(value="/person/param",params="version=1") //versioning using request param
    public PersonV1 paramV1(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value="/person/param",params="version=2") //versioning using request param
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Bobby", "Charlie"));
    }


    @GetMapping(value="/person/header",headers="X-API-version=1") //versioning using header param
    public PersonV1 headerV1(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value="/person/header",headers="X-API-version=2") //versioning using header param
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Bobby", "Charlie"));
    }


    @GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json") //versioning using produces(also known as content_negotiation or accept_versioning)
    public PersonV1 producesV1(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value="/person/produces",produces="application/vnd.company.app-v2+json") //versioning using produces(also known as content_negotiation or accept_versioning)
    public PersonV2 prodcesV2(){
        return new PersonV2(new Name("Bobby", "Charlie"));
    }
}
