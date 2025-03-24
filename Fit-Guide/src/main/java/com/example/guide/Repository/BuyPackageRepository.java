package com.example.guide.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.guide.Data.BuyPackage;

@Repository
public interface BuyPackageRepository extends JpaRepository<BuyPackage,Long>{

}

