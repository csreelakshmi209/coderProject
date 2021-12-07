package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Coder;
import com.service.CoderService;

@RestController
//@RequestMapping(path="/api")
public class CoderController {

	@Autowired
	CoderService coderService;
	
	@RequestMapping("/Hello")
	public String HelloCoder()
	{
		String msg="Welcome to spring Data Jpa";
		return msg;
	}
	
	@PostMapping("/coder/add")
	public ResponseEntity<Coder> addCoder (@RequestBody Coder c)
	{
		Coder c1=coderService.addCoder(c);
		ResponseEntity re=new ResponseEntity<Coder>(c,HttpStatus.CREATED);
		return re;
	}
	@GetMapping("/coder/get")
	public ResponseEntity<List<Coder>> getCoders()
	{
		List<Coder> lcl=coderService.getCoders();
	 ResponseEntity re=new ResponseEntity<List<Coder>>(lcl,HttpStatus.OK);
	return re;
	}
	
	@GetMapping(path="/coder/get/{cid}")
	public ResponseEntity<Coder> getEmpById(@PathVariable int cid) throws Throwable
	{
		Coder c1=coderService.getCoderById(cid);
		
		ResponseEntity re=new ResponseEntity<Coder>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addCoders")
	public ResponseEntity<List<Coder>> addCoders(@RequestBody List<Coder> ls)
	{
		List<Coder> le=coderService.addCoders(ls);
		
		ResponseEntity re=new ResponseEntity<List<Coder>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateCoder")
	public ResponseEntity<Coder> updateCoder(@RequestBody Coder e) throws Throwable
	{
		Coder e1=coderService.updateCoder(e);
		
		ResponseEntity re=new ResponseEntity<Coder>(e1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteCoder")
	public ResponseEntity<String> deleteCoder(@RequestBody Coder e)
	{
		coderService.deleteCoder(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteCoder/{eid}")
	public ResponseEntity<String> deleteCoderById(@PathVariable int eid)
	{
		coderService.deleteCoderById(eid);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getCodername/{cname}")
	public ResponseEntity<Coder> getCoderByCname(@PathVariable String cname) 
	{
		Coder c=coderService.getCoderByCname(cname);
		ResponseEntity re=new ResponseEntity<Coder>(c,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getCoderstech/{tech}")
	public ResponseEntity<List<Coder>> findByTechSorted(@PathVariable String tech) 
	{
		List<Coder> lc=coderService.findByTechSorted(tech);
		ResponseEntity re=new ResponseEntity<List<Coder>>(lc,HttpStatus.OK);
		return re;
	}
//	@GetMapping("/getCodersId/{cid}")
//	public ResponseEntity<List<Coder>> findByIdSorted(@PathVariable int cid) 
//	{
//		List<Coder> lc=coderService.findByIdSorted(cid);
//		ResponseEntity re=new ResponseEntity<List<Coder>>(lc,HttpStatus.OK);
//		return re;
//	}

	
}
