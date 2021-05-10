package com.anji.provider2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

//    @Autowired
    RestTemplate restTemplate;


    @GetMapping("ribbon")
    String hellRibbon(){
        return restTemplate.getForEntity("http:/localh/hello",String.class).getBody();
    }


}
