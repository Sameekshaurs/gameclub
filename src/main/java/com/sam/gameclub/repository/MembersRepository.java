package com.sam.gameclub.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sam.gameclub.model.Members;

@Repository
public interface MembersRepository extends MongoRepository<Members, String> {
    
}
