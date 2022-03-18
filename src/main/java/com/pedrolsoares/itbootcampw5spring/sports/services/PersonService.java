package com.pedrolsoares.itbootcampw5spring.sports.services;

import com.pedrolsoares.itbootcampw5spring.sports.model.Person;
import com.pedrolsoares.itbootcampw5spring.sports.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public boolean createPerson(Person person){
        return personRepository.insertOne(person);
    }
}
