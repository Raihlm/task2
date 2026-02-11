package com.ahihihuhu.controllers;

import com.ahihihuhu.entities.Application;
import com.ahihihuhu.entities.IPs;
import org.springframework.web.bind.annotation.*;
import com.ahihihuhu.services.IPsServices;

import java.util.List;

@RestController
@RequestMapping("/ips")
public class IPsController {
    private final IPsServices iPsServices;

    public IPsController(IPsServices iPsServices) {
        this.iPsServices = iPsServices;
    }

    @GetMapping
    public List<IPs> getAllIPs(){return iPsServices.getAllIp();}

    @GetMapping("/{id}")
    public IPs getIpByID(@PathVariable Integer id){return iPsServices.getIpByID(id);}

    @PostMapping
    public void insertIps(@RequestBody IPs iPs){ iPsServices.insertIPs(iPs);}

    @DeleteMapping("/{id}")
    public void deleteIps(@PathVariable Integer id){iPsServices.deleteIPS(id);}

    @GetMapping("/getApp/{ipId}")
    public Application getApp(@PathVariable Integer ipId){
        return iPsServices.getAppWithIp(ipId);
    }


}
