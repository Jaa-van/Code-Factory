package com.code.factory.runner;

import com.code.factory.domain.etc.service.EtcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    EtcService etcService;

    @Override
    public void run(ApplicationArguments arguments) throws Exception {
        etcService.getExhaustiveSearch();
        System.out.println("yes");
    }
}
