package com.example.backendskyteck.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.backendskyteck.entities.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response,Integer> {

}