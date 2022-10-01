package com.example.demo;

import com.example.demo.config.EnvProfileConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentConfigController {

    @Autowired
    private EnvProfileConfiguration envProfileConfiguration;

    @GetMapping(value = "env/profileInfo")
    public ResponseEntity<String> getProfileInfo() {
        return new ResponseEntity<>(envProfileConfiguration.getMessage(), HttpStatus.OK);
    }
}
