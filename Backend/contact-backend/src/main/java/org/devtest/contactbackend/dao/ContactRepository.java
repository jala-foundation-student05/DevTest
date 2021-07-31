package org.devtest.contactbackend.dao;

import org.devtest.contactbackend.dto.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
