package org.devtest.contactbackend.api;

import org.devtest.contactbackend.dto.Contact;
import org.devtest.contactbackend.dto.Relations;
import org.devtest.contactbackend.dto.User;
import org.devtest.contactbackend.service.ContactService;
import org.devtest.contactbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<?> createContact(@RequestBody Contact contact) {
        //Set Headers
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("User-Id",
                "2ff73690-5d12-4c2f-ba92-f447b8af75f3");
        Contact contactCreated = contactService.save(contact);

        User user = userService.findUserbyId("2ff73690-5d12-4c2f-ba92-f447b8af75f3");

        Set<Relations> relations = user.getRelations();

        Relations relation = new Relations();

        relation.setContactId(contactCreated.getId());
        relation.setUserId("2ff73690-5d12-4c2f-ba92-f447b8af75f3");

        relations.add(relation);

        user.setRelations(relations);

        userService.save(user);

        contactCreated.setRelations(relations);

        contactCreated = contactService.save(contactCreated);


        return ResponseEntity.status(201)
                .headers(responseHeaders)
                .body(contactCreated);
    }

    @GetMapping("")
    public ResponseEntity<?> getContacts() {
        //Set Headers
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("User-Id",
                "2ff73690-5d12-4c2f-ba92-f447b8af75f3");

        return ResponseEntity.status(200)
                .headers(responseHeaders)
                .body(contactService.getContactsByUserId("2ff73690-5d12-4c2f-ba92-f447b8af75f3"));
    }
}
