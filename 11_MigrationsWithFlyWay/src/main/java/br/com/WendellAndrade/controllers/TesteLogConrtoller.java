package br.com.WendellAndrade.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteLogConrtoller {

    private Logger logger = LoggerFactory.getLogger(TesteLogConrtoller.class.getName());

    @GetMapping("/testeLog")
    public String testLog (){

        logger.debug("This is an DEBUG logger!");
        logger.info("This is an INFO logger!");
        logger.warn("This is an WARN logger!");
        logger.error("This is an ERROR logger!");
        return "Log generated successfully!";
    }

}
