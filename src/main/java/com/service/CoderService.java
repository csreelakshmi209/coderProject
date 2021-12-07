package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.model.Coder;
import com.repository.CoderRepository;

@Service
public class CoderService {
	@Autowired
	CoderRepository repo;
	
	public Coder addCoder(Coder c)
	{
		 repo.save(c);	
		 return c;
	}
	
	public List<Coder> getCoders()
	{
		List<Coder> lc1=repo.findAll();
		
		return lc1;
	}

	public Coder getCoderById(int cid) throws Throwable {
		Supplier s1= ()->new ResourceNotFoundException("Coder Does not exist in the database");
		Coder c=repo.findById(cid).orElseThrow(s1);
		return c;
	}

	public String deleteCoderById(int cid) {
		
		repo.deleteById(cid);
		
		return "Deleted";
	}

	public String deleteCoder(Coder c) {
		
		repo.delete(c);
		return "Deleted";
	}

	public Coder updateCoder(Coder c) throws Throwable {
		int id=c.getCid();
		
		Supplier s1= ()->new ResourceNotFoundException("Coder Does not exist in the database");
		Coder c1=repo.findById(id).orElseThrow(s1);
		
		c1.setCname(c.getCname());
			c1.setTech(c.getTech());
			repo.save(c1);
			return c1;	
	}

	public List<Coder> addCoders(List<Coder> ls) {
		repo.saveAll(ls);
		return ls;
	}
	
	public Coder getCoderByCname(String cname) {
		Coder c=repo.findByCname(cname);
		return c;
	}
	
	public List<Coder> findByTechSorted(String tech) 
	{
		List<Coder> lc=repo.findByTechSorted(tech);
	return lc;
	}

//	public List<Coder> findByIdSorted(int cid) {
//		List<Coder> lc=repo.findByIdSorted(cid);
//		return lc;
//	}

}
