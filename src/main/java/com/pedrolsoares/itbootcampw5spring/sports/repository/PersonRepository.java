package com.pedrolsoares.itbootcampw5spring.sports.repository;

import com.pedrolsoares.itbootcampw5spring.sports.model.Athlete;
import com.pedrolsoares.itbootcampw5spring.sports.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    private static final List<Person> personList = new ArrayList<>();

    public List<Person> findAll(){
        return personList;
    }

    public Person findOne(String name){
        return new Person();
    }

    public boolean insertOne(Person person){
        return personList.add(person);
    }

    public boolean insertMany(List<Person> data){
        return personList.addAll(data);
    }
}
