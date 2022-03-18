package com.pedrolsoares.itbootcampw5spring.sports.repository;

import com.pedrolsoares.itbootcampw5spring.sports.model.Sport;
import org.springframework.stereotype.Repository;

import javax.management.relation.RelationNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SportsRepository {
    private static final List<Sport> sports = new ArrayList<>();

    public List<Sport> findAll(){
        return sports;
    }

    public Optional<Sport> findOne(String name) {
        return sports.stream().filter(s -> s.getName().equalsIgnoreCase(name)).findFirst();
    }

    public boolean insertOne(Sport sport){
        return sports.add(sport);
    }

    public boolean insertMany(List<Sport> sportList){
        return sports.addAll(sportList);
    }
}
