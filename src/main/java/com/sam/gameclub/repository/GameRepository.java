package com.sam.gameclub.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sam.gameclub.model.game;

@Repository
public interface GameRepository extends MongoRepository<game, String> {
    
}
