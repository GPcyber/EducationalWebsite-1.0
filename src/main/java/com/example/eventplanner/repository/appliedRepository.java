package com.example.eventplanner.repository;

import com.example.eventplanner.model.appliedcourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.transform.Transformer;
import java.util.List;

@Repository
public interface appliedRepository  extends JpaRepository<appliedcourse,Integer> {

    @PersistenceContext
    EntityManager entityManager = null;
}
