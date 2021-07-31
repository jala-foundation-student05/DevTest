package org.devtest.contactbackend.service;

import org.devtest.contactbackend.dao.ContactRepository;
import org.devtest.contactbackend.dao.UserRepository;
import org.devtest.contactbackend.dto.Contact;
import org.devtest.contactbackend.dto.Relations;
import org.devtest.contactbackend.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    //Create - Update
    public Contact save(Contact contact){
        return contactRepository.save(contact);
    }

    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    public Set<Contact> getContactsByUserId(String userId){
        return contactRepository.findByRelationsUserId(userId);
    }

    public List<Contact> getAllContactsComplete(String seed){
        return contactRepository.findBySeed(seed);
    }
}
