package com.example.eventplanner.repository;

import com.example.eventplanner.model.enquirySubmit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface enquiryRepository extends JpaRepository<enquirySubmit,Long> {
}
