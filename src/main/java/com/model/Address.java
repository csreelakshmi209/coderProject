package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Address {

	public Coder getCoder() {
		return coder;
	}
	public void setCoder(Coder coder) {
		this.coder = coder;
	}
	@Id
	@GeneratedValue
	private int aid;
	private String city;
	
	@ManyToOne
	@JoinColumn(name="coder_aid")
	Coder coder;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", city=" + city + ", coder=" + coder + "]";
	}
	
}
