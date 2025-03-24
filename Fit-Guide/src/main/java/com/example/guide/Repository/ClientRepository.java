package com.example.guide.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.guide.Data.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

}
