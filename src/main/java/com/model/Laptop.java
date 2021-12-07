package com.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	@Id
	@GeneratedValue
	private int lid;
	private String laptopName;
	private String company;
	
	@ManyToOne
	@JoinColumn(name="coder_id")
	Coder coder;
	
	//select * from coder_laptops-------> it will give separate mapping tab
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLaptopName() {
		return laptopName;
	}
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public Coder getCoder() {
		return coder;
	}
	public void setCoder(Coder coder) {
		this.coder = coder;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", laptopName=" + laptopName + ", company=" + company + ", coder=" + coder + "]";
	}
	
		
}
