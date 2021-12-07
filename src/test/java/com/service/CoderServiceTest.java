package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Coder;
import com.repository.CoderRepository;

@SpringBootTest
class CoderServiceTest {

	@Autowired
	CoderService coderService;
	
	@MockBean
	CoderRepository repo;
	
	@Test
	void testAddCoder() {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("sree");
		c1.setTech("JavaFS");
		Mockito.when(repo.save(c1)).thenReturn(c1);
		
		assertThat(coderService.addCoder(c1)).isEqualTo(c1);
	}

	@Test
	void testGetCoders() {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("sree");
		c1.setTech("JavaFS");
		
		Coder c2=new Coder();
		c2.setCid(2);
		c2.setCname("varsha");
		c2.setTech("Java");
		
		 List<Coder> coderList=new ArrayList<>();
		 coderList.add(c1);
		 coderList.add(c2);
		 
		 Mockito.when(repo.findAll()).thenReturn(coderList);
		 
		 assertThat(coderService.getCoders()).isEqualTo(coderList);
	}

	@Test
	
	void testGetCoderById() throws Throwable {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("Sree");
		c1.setTech("JavaFS");
		Optional<Coder> c2=Optional.of(c1);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		assertThat(coderService.getCoderById(1)).isEqualTo(c1);
	}


	@Test
	void testDeleteCoder() {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("sree");
		c1.setTech("JavaFS");
		Optional<Coder> c2=Optional.of(c1);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		Mockito.when(repo.existsById(c1.getCid())).thenReturn(false);
		assertFalse(repo.existsById(c1.getCid()));
	}
	@Test
	void testUpdateCoder() throws Throwable {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("sree");
		c1.setTech("JavaFS");
		Optional<Coder> c2=Optional.of(c1);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		Mockito.when(repo.save(c1)).thenReturn(c1);
		c1.setCname("Sreelakshmi");
		c1.setTech("Java Developer");
		
		assertThat(coderService.updateCoder(c1)).isEqualTo(c1);
	}
//	@Test
//	void testGetCoderByCname() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindByTechSorted() {
//		fail("Not yet implemented");
//	}
//	@Test
//	void testDeleteCoderById() {
//		fail("Not yet implemented");
//	}

}
