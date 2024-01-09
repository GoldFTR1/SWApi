package dev.peter.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.peter.demo.configuration.DevInstrumentationSender;



@RestController
@Profile("dev")
public class InstrumentationSenderController {

    @Autowired
    private DevInstrumentationSender sender;


    @GetMapping("/senddevstatistics")
    public String sendStatistics() {
        return sender.sendStatistic();
    }


}