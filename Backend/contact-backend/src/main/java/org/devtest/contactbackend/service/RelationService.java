package org.devtest.contactbackend.service;

import org.devtest.contactbackend.dao.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationService {
    @Autowired
    private RelationRepository relationRepository;
}
