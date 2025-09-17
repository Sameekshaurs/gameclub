package com.sam.gameclub.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.gameclub.exceptions.IdNotPresentException;
import com.sam.gameclub.model.game;
import com.sam.gameclub.repository.GameRepository;
import com.sam.gameclub.services.GameService;



@RestController
@RequestMapping(path="/games")
public class GameController {
    @Autowired
    private GameService service;
    @PostMapping 
    public ResponseEntity<game> create(@RequestBody game game){
        game savedGame =service.create(game);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGame);
    }
    @GetMapping 
    public ResponseEntity<List<game>>findAll(){
        List<game> games=service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(games);
    }
    @GetMapping(path="/{id}")
    public ResponseEntity<game>findById(@PathVariable String id)throws IdNotPresentException{
        game game =service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(game);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<game>update(@PathVariable String id, @RequestBody game game)throws IdNotPresentException{
        game updatedGame=service.update(id,game);
        return ResponseEntity.status(HttpStatus.OK).body(updatedGame);
    }
   
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id)throws IdNotPresentException{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    

    
}
