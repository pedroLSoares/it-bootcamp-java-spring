package com.pedrolsoares.itbootcampw5spring.sports.services;

import com.pedrolsoares.itbootcampw5spring.sports.model.Athlete;
import com.pedrolsoares.itbootcampw5spring.sports.repository.AthleteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AthleteService {

    private final AthleteRepository athleteRepository;

    public List<Athlete> findAllAthletes(){
        return athleteRepository.findAll();
    }

}
