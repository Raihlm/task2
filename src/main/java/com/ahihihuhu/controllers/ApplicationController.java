package com.ahihihuhu.controllers;

import com.ahihihuhu.entities.Application;
import com.ahihihuhu.entities.IPs;
import org.springframework.web.bind.annotation.*;
import com.ahihihuhu.services.ApplicationServices;

import java.util.List;

@RestController
@RequestMapping("/app")
public class ApplicationController {
    private final ApplicationServices applicationServices;


    public ApplicationController(ApplicationServices applicationServices) {
        this.applicationServices = applicationServices;
    }

    @GetMapping
    public List<Application> getApplication(){
        return applicationServices.getAllApplication();
    }

    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable Integer id){
        return  applicationServices.getApplicationByID(id);
    }

    @PostMapping
    public void insertNewApplication(@RequestBody Application application){
        if(application.getiPsList() != null){
            for(IPs iPs : application.getiPsList()){
                iPs.setAplikasi(application);
            }
        }
        applicationServices.insertApplication(application);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Integer id){
        applicationServices.deleteApplication(id);
    }

    @GetMapping("/getIp/{appId}")
    public List<IPs> getIp(@PathVariable Integer appId){
        return applicationServices.getIpWithAppId(appId);
    }
}
