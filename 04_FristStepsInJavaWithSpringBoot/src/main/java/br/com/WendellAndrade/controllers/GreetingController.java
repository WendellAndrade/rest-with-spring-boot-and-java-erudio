package br.com.WendellAndrade.controllers;

import br.com.WendellAndrade.model.Greeting;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
@RestController
public class GreetingController {

    private static final  String template = "Hello %s !";
    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam (value = "name", defaultValue = "Word")
            String name){

        return new Greeting(counter.incrementAndGet(),String.format(template,name));

    }
}
