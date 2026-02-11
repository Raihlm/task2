package com.ahihihuhu.services;

import com.ahihihuhu.entities.Application;
import com.ahihihuhu.entities.IPs;
import com.ahihihuhu.repo.ApplicationRepository;
import org.springframework.stereotype.Service;
import com.ahihihuhu.repo.IPsRepository;

import java.util.List;

@Service
public class IPsServices {
    private final IPsRepository iPsRepository;
    private final ApplicationRepository applicationRepository;


    public IPsServices(IPsRepository iPsRepository, ApplicationRepository applicationRepository) {
        this.iPsRepository = iPsRepository;
        this.applicationRepository = applicationRepository;
    }

    public List<IPs> getAllIp(){
        return iPsRepository.findAll();
    }

    public IPs getIpByID(Integer id){
        return iPsRepository.findById(id)
                .orElseThrow(()->new IllegalStateException(
                        "ip: " + id + " not found"
                ));
    }

    public void insertIPs(IPs iPs){
        iPsRepository.save(iPs);
    }

    public void deleteIPS(Integer id){
        iPsRepository.deleteById(id);
    }

 //   public IPs assignIpToApp(Integer ipId, Integer appId){
 //       IPs ip = iPsRepository.findById(ipId).orElseThrow();
 //       Application app = applicationRepository.findById(appId).orElseThrow();
//
 //       ip.setAplikasi(app);
 //       return iPsRepository.save(ip);
//
 //   }

    public Application getAppWithIp(Integer ipId){
        IPs ip = iPsRepository.findById(ipId)
                .orElseThrow(()->new IllegalStateException(
                        "Ip with id: " + ipId + "Not found"
                ));

        return ip.getAplikasi();
    }


}
