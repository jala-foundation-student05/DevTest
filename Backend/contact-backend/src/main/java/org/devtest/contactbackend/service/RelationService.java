package org.devtest.contactbackend.service;

import org.devtest.contactbackend.dao.RelationRepository;
import org.devtest.contactbackend.dto.Relations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationService {
    @Autowired
    private RelationRepository relationRepository;

    public Relations save(Relations relations){
        return relationRepository.save(relations);
    }
}
