package com.varun;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.varun.application.controller.cli.ChgReqCliController;

@SpringBootApplication
public class ApplicationRunner implements CommandLineRunner {

    public final ChgReqCliController chgReqCliController;

    public ApplicationRunner(ChgReqCliController chgReqCliController) {
        this.chgReqCliController = chgReqCliController;
    }

    public static void main(final String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        chgReqCliController.createChangeRequest();
    }
}
