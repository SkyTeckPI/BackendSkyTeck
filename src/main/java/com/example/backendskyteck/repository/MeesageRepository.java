package com.example.backendskyteck.repository;

import com.example.backendskyteck.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeesageRepository extends JpaRepository<Message, String> {}