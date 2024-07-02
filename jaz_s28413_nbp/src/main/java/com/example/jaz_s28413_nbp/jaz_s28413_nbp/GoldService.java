package com.example.jaz_s28413_nbp.jaz_s28413_nbp;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class GoldService {
    private GoldRepository goldRepository;
    private final String url = "http://api.nbp.pl/api/cenyzlota/{startDate}/{endDate}";

    private final RestTemplate restTemplate;

    public GoldService(GoldRepository goldRepository, RestTemplate restTemplate) {
        this.goldRepository = goldRepository;
        this.restTemplate = restTemplate;
    }

    public AvgGold calculate(LocalDate startDate, LocalDate endDate){
        AvgGold avgGold = restTemplate.getForObject(url, AvgGold.class, startDate, endDate);
        Double sum = 0.0;
        System.out.println(avgGold.getAvgGold());
        for(GoldPrice cena : avgGold.getAvgGold()) {
            sum+= cena.getCena();
        }
        Double avgSum = sum/avgGold.getAvgGold().size();
        GoldData goldData = new GoldData(Gold.GOLD,startDate,endDate,LocalDateTime.now(), avgSum);


        goldRepository.save(goldData);
        return avgGold;
    }
}