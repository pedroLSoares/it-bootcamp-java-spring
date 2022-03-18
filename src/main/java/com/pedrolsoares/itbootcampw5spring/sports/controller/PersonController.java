package com.pedrolsoares.itbootcampw5spring.sports.controller;

import com.pedrolsoares.itbootcampw5spring.sports.model.Person;
import com.pedrolsoares.itbootcampw5spring.sports.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/sports/person")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> registerPerson(@RequestBody Person person){
        boolean created = personService.createPerson(person);
        if (!created) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível criar o usuário");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Criado");
    }
}
