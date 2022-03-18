package com.example.demo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
//URI VERSIONING
        @GetMapping("v1/person")
        public PersonV1 personV1(){
            return new PersonV1("Bob Charlie");
        }
        @GetMapping("v2/person")
        public PersonV2 personV2(){
            return new PersonV2(new Name("Bobby", "Charlie"));
        }

//Request Parameter versioning
        @GetMapping(value="/person/param",params="version=1")
        public PersonV1 paramV1(){
            return new PersonV1("Bob Charlie");
        }
        @GetMapping(value="/person/param",params="version=2")
        public PersonV2 paramV2(){
            return new PersonV2(new Name("Bobby", "Charlie"));
        }

//Custom Header Versioning
        @GetMapping(value="/person/header",headers="X-API-version=1")
        public PersonV1 headerV1(){
            return new PersonV1("Bob Charlie");
        }
        @GetMapping(value="/person/header",headers="X-API-version=2")
        public PersonV2 headerV2(){
            return new PersonV2(new Name("Bobby", "Charlie"));
        }

//Media Type Versioning
        @GetMapping(value="/person/produces",produces="application/app-v1+json")
        public PersonV1 producesV1(){
            return new PersonV1("Bob Charlie");
        }
        @GetMapping(value="/person/produces",produces="application/app-v2+json")
        public PersonV2 prodcesV2(){
            return new PersonV2(new Name("Bobby", "Charlie"));
        }
    }


