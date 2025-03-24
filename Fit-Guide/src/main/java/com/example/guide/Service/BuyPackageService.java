package com.example.guide.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.guide.Data.BuyPackage;
import com.example.guide.Repository.BuyPackageRepository;

@Service
public class BuyPackageService {
	
	@Autowired
	private BuyPackageRepository buyPackageRepository;
	
	public BuyPackage buyPolicy(BuyPackage buyPackage) {
		return buyPackageRepository.save(buyPackage);
}
}
