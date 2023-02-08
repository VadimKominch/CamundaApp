package org.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private CamundaRuntimeService service;

    @GetMapping
    public String runCamunda() {
        UUID key = UUID.randomUUID();
        service.startProcess(key.toString());
        return key.toString();
    }

    @GetMapping("/{businessKey}")
    public String correlate(@PathVariable String businessKey) {
        service.correlateOnCheckedFlag(businessKey);
        return "OK";
    }
}
