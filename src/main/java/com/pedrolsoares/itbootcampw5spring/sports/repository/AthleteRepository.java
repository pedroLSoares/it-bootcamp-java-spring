package com.pedrolsoares.itbootcampw5spring.sports.repository;

import com.pedrolsoares.itbootcampw5spring.sports.model.Athlete;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AthleteRepository {
    private static final List<Athlete> athletes = new ArrayList<>();

    public List<Athlete> findAll(){
        return athletes;
    }

    public Optional<Athlete> findOne(String personName){
        return athletes.stream().filter(a -> a.getPerson().getName().equals(personName)).findFirst();
    }

    public boolean insertOne(Athlete athlete){
        return athletes.add(athlete);
    }

    public boolean insertMany(List<Athlete> athleteList){
        return athletes.addAll(athleteList);
    }

}
