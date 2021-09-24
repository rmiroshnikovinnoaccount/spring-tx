package com.example.springtx.controller;

import com.example.springtx.service.DsMigrationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DsMigrationController {

    final DsMigrationService dsMigrationService;

    public DsMigrationController(DsMigrationService dsMigrationService) {
        this.dsMigrationService = dsMigrationService;
    }

    @GetMapping("/with_error")
    public void testWithError() {
        dsMigrationService.testWithError();
    }

    @GetMapping("/without_error")
    public void testWithoutError() {
        dsMigrationService.testWithoutError();
    }
}
