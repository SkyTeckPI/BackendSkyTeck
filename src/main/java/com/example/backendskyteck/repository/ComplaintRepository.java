package com.example.backendskyteck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.backendskyteck.entities.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {}