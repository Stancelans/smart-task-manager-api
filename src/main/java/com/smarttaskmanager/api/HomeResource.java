package com.smarttaskmanager.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
    @GetMapping("/")
    public String index() {
        return "\"Welcome Smart Task Manager API. Access API Docs to Continue!\"";
    }

}
