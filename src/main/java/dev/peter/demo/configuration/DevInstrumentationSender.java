package dev.peter.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevInstrumentationSender {

    @Autowired
    private DevInstrumationSystemProperties config;


    public String sendStatistic() {
        return "Sending statistics with username" + config.getUsername();
    }

}