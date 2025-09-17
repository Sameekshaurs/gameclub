package com.sam.gameclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sam.gameclub.model.Members;
import com.sam.gameclub.repository.MembersRepository;

@RestController
@RequestMapping(path = "/members")
public class MembersController {
    @Autowired
    private MembersRepository repo;

    @PostMapping
    public Members create(@RequestBody Members member) {
        member.setId(null);
        Members savedMember = repo.save(member);
        return savedMember;
    }

    @GetMapping
    public List<Members> findAll() {
        return repo.findAll();
    }

    @GetMapping(path = "/{id}")
    public Members findById(@PathVariable String id) {
        return repo.findById(id).get();
    }

    @PutMapping(path = "/{id}")
    public Members update(@PathVariable String id, @RequestBody Members member) {
        Members oldMember = repo.findById(id).get();
        oldMember.setName(member.getName());
        oldMember.setPhone_number(member.getPhone_number());
        oldMember.setBalance(member.getBalance());

        return repo.save(oldMember);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
