package org.devtest.contactbackend.dao;

import org.devtest.contactbackend.dto.Relations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationRepository extends JpaRepository<Relations,Integer> {
}
