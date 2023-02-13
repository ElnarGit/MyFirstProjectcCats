package com.example.InfoCat.service;

import com.example.InfoCat.model.Cat;
import com.example.InfoCat.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@EnableScheduling
public class CatService {
    private final CatRepository catRepository;

    @Autowired
    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    private String URL = "https://catfact.ninja/fact";


    @Scheduled(fixedRate = 10000)
    public void infoCat(){
        RestTemplate restTemplate = new RestTemplate();

        Cat cat = restTemplate.getForObject(URL, Cat.class);

        catRepository.save(cat);

          /*  Map<Cat, Object> result = new ObjectMapper().readValue((DataInput) cat,  HashMap.class);
        System.out.println(result);*/
    }
}
