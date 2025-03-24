package com.example.guide.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.guide.Data.BuyPackage;
import com.example.guide.Service.BuyPackageService;

@RestController
@RequestMapping("/buy")
public class BuyPackageController {
	
	@Autowired
	private BuyPackageService buyPackageService;
	
	@PostMapping("")
    public ResponseEntity<?> buyPackage(@RequestBody BuyPackage buyPackage) {
        return ResponseEntity.ok(this.buyPackageService.buyPolicy(buyPackage));
    }

}
