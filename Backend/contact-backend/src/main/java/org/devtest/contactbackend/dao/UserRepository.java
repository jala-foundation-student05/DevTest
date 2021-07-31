package org.devtest.contactbackend.dao;

import org.devtest.contactbackend.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
