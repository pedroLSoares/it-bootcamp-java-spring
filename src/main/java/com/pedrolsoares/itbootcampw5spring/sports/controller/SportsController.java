package com.pedrolsoares.itbootcampw5spring.sports.controller;

import com.pedrolsoares.itbootcampw5spring.sports.dto.AthleteDTO;
import com.pedrolsoares.itbootcampw5spring.sports.model.Athlete;
import com.pedrolsoares.itbootcampw5spring.sports.model.Sport;
import com.pedrolsoares.itbootcampw5spring.sports.repository.AthleteRepository;
import com.pedrolsoares.itbootcampw5spring.sports.services.AthleteService;
import com.pedrolsoares.itbootcampw5spring.sports.services.SportService;
import jdk.javadoc.doclet.Reporter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/sports")
public class SportsController {

    private final SportService sportService;
    private final AthleteService athleteService;

    @PostMapping
    public ResponseEntity<?> createSport(@RequestBody Sport sport, UriComponentsBuilder uriComponentsBuilder){
        boolean created = sportService.createSport(sport);
        if (!created) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível criar o usuário");
        }

        URI uri = uriComponentsBuilder
                .path("/api/v1/sports/findSports/{sportName}")
                .buildAndExpand(sport.getName())
                .toUri();

        return ResponseEntity.created(uri).body(sport);
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> findAllSports(){
        List<Sport> sports = sportService.findAllSports();

        return new ResponseEntity<>(sports, HttpStatus.OK);
    }

    @GetMapping("/findSports/{sportName}")
    public ResponseEntity<?> findSport(@PathVariable String sportName){
        Optional<Sport> sport =  sportService.findSportByName(sportName);
        if(sport.isEmpty()){
            return new ResponseEntity<>("Não encontrado",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(sport, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<AthleteDTO>> findAllSportsPersons(){
        List<Athlete> athleteList = athleteService.findAllAthletes();

        return new ResponseEntity<>(AthleteDTO.modelToDTO(athleteList), HttpStatus.OK);


    }
}
