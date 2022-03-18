package com.pedrolsoares.itbootcampw5spring.sports.services;

import com.pedrolsoares.itbootcampw5spring.sports.model.Sport;
import com.pedrolsoares.itbootcampw5spring.sports.repository.SportsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SportService {

    private final SportsRepository sportsRepository;

    public boolean createSport(Sport sport){
        return sportsRepository.insertOne(sport);
    }

    public List<Sport> findAllSports(){
        return sportsRepository.findAll();
    }

    public Optional<Sport> findSportByName(String sportName) {
        return sportsRepository.findOne(sportName);

    }
}
