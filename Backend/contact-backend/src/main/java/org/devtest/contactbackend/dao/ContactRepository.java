package org.devtest.contactbackend.dao;

import org.devtest.contactbackend.dto.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ContactRepository extends JpaRepository<Contact,Integer> {

    Set<Contact> findByRelationsUserId(String userId);

    List<Contact> findBySeed(String seed);

}
