package com.sam.gameclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.gameclub.exceptions.BuisnessException;
import com.sam.gameclub.exceptions.IdNotPresentException;
import com.sam.gameclub.model.game;
import com.sam.gameclub.repository.GameRepository;

@Service
public class GameService {
    @Autowired
    private GameRepository repo;

    public game create(game game){
        game.setId(null);
        game savedGame = repo.save(game);
        return savedGame;
    }
    public List<game>findAll(){
        List<game> games=repo.findAll();
        return games;
    }
    public game findById(String id) throws IdNotPresentException{
        Optional<game>optionalGame = repo.findById(id);
        if(optionalGame.isEmpty()){
            throw new IdNotPresentException("game not found "+id);
        }
        return optionalGame.get();
    }
    public game update(String id, game game) throws IdNotPresentException{
        Optional<game>optionalGame = repo.findById(id);
        if(optionalGame.isEmpty()){
            throw new IdNotPresentException("game not found "+id);
        }
        game oldgame = optionalGame.get();
        oldgame.setName(game.getName());
        oldgame.setDescription(game.getDescription());
        oldgame.setPrice(game.getPrice());

        game updatGame = repo.save(oldgame);
        return updatGame;
    }
    public boolean delete(String id)throws IdNotPresentException{
        Optional<game>optionalGame=repo.findById(id);
        if(optionalGame.isEmpty()){
            throw new IdNotPresentException("Game not found "+id);
        }
        repo.deleteById(id);
        return true;
    }

}
