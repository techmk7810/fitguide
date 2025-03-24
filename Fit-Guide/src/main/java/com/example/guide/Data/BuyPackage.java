package com.example.guide.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BuyPackage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BuyId")
	private Long buyId;
	
	@Column(name = "RollTag", unique = true, nullable = true)
	private Long rollTag;
	
	@Column(name="TrainerName")
	private String trainerName;
	
	@Column(name="Membership")
	private String membership;
	
	@Column(name="Amount")
	private String amount;


	public Long getBuyId() {
		return buyId;
	}

	public void setBuyId(Long buyId) {
		this.buyId = buyId;
	}

	public Long getRollTag() {
		return rollTag;
	}

	public void setRollTag(Long rollTag) {
		this.rollTag = rollTag;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	

}
