package com.ahihihuhu.services;

import com.ahihihuhu.entities.Application;
import org.springframework.stereotype.Service;
import com.ahihihuhu.repo.ApplicationRepository;

import java.util.List;

@Service
public class ApplicationServices {

    private final ApplicationRepository applicationRepository;

    public ApplicationServices(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Application> getAllApplication(){
        return applicationRepository.findAll();
    }

    public Application getApplicationByID(Integer ID){
        return applicationRepository.findById(ID)
                .orElseThrow(() -> new IllegalStateException(
                        ID + "Not found"
                ));
    }

    public void insertApplication(Application application){

        applicationRepository.save(application);
    }

    public void deleteApplication(Integer id){

        applicationRepository.deleteById(id);
    }

}
