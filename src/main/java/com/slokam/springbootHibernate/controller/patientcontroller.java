package com.slokam.springbootHibernate.controller;

import java.io.IOException;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.springbootHibernate.entity.patient;
import com.slokam.springbootHibernate.repository.testrepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class patientcontroller {
	@Autowired
	private testrepository testrep;
	
	private final static Logger LOGGER = LoggerFactory.getLogger(patientcontroller.class);
	
	
	@PostMapping("savepatientdata")
	@Operation(description = "this is save patient" ,
	requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
	required = true,description = "requires id name and bill ,joindate"))
	public ResponseEntity<patient>  savedata (@RequestBody patient patient) throws Exception
	{
		//patient.setDate(new Date());
		System.out.println(patient);
		LOGGER.trace("save");
		LOGGER.debug("getbyid");
		LOGGER.info("getbyid");
		LOGGER.warn("getbyid");
		LOGGER.error("getbyid");
		testrep.save(patient);
		ResponseEntity<patient> re = new ResponseEntity<>(patient,HttpStatus.CREATED);
		if(false)
		{
			throw new IOException();
		}
		return re;
	}

	@PostMapping("saveall")
	public ResponseEntity<List<patient>>  saveall(@RequestBody List<patient> patient)
	{
		System.out.println(patient);
		testrep.saveAll(patient);
		ResponseEntity<List<patient>> re = new ResponseEntity<>(patient,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("getbyid/{id}")
	public ResponseEntity<patient> getbyid(@PathVariable(name="id") Integer id)
	{	
		
		LOGGER.trace("getbyid");
		LOGGER.debug("getbyid");
		LOGGER.info("getbyid");
		LOGGER.warn("getbyid");
		LOGGER.error("getbyid");
		ResponseEntity<patient> re ;
		 Optional<patient> pat= testrep.findById(id);
		
		  if(pat.isPresent())
		  {
			  System.out.println(pat);
			 re = new ResponseEntity<patient>(HttpStatus.OK);
				return re;
		  }
		  else 
		  {
			  System.out.println("no data found");
			  re = new ResponseEntity<patient>(HttpStatus.NOT_FOUND);
			  return re;
		  }
	}
	
	@GetMapping("getall")
	public ResponseEntity<List<patient>>  getall()
	{
		 List<patient> pat= testrep.findAll();
		System.out.println(pat);
		 ResponseEntity<List<patient>> re;
		 if(pat== null || pat.isEmpty())
		 {
			 re = new ResponseEntity<>(pat,HttpStatus.NOT_FOUND);
			 return re;
		 }
		 else {
			 re = new ResponseEntity<>(pat,HttpStatus.OK);
			 return re;
		 }
		
	}
	@GetMapping("deletedata/{id}")
	public ResponseEntity<patient> deletedata(@PathVariable(name="id") Integer id)
	{
		  testrep.deleteById(id);
		  //ResponseEntity<patient> re = new ResponseEntity<>(patient,HttpStatus.OK);
		 return null ;
	}
	@GetMapping("findbyname/{pname}")
	public List<patient> findByname(@PathVariable(name="pname") String pname)
	{
		 List<patient> pat= testrep.findBypname(pname);
		System.out.println(pat);
		return pat;
	}
	@GetMapping("findbynamelike/{partialpname}")
	public ResponseEntity<List<patient>> findBynameLike(@PathVariable(name="partialpname") String pname)
	{
		 List<patient> pat= testrep.findBypnameLike(pname+"%");
		System.out.println(pat);
		ResponseEntity<List<patient>> re = new ResponseEntity<>(pat,HttpStatus.OK);
		return re;
	}
	/*
	 * @GetMapping("findbybeforedate/{date}") public List<patient>
	 * findBybeforerdate(@PathVariable(name="date") String datestr) throws Exception
	 * { SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd"); Date
	 * date=format.parse(datestr); List<patient> pat=
	 * testrep.findBydateBefore(date); System.out.println(pat); return pat; }
	 */
	@GetMapping("getpaientsbyname/{pname}")
	public ResponseEntity<List<patient>>  getpatientsbyname(@PathVariable(name="pname") String pname)
	{
		 List<patient> pat= testrep.getpatientsbyname(pname);
		System.out.println(pat);
		ResponseEntity<List<patient>> re = new ResponseEntity<>(pat,HttpStatus.OK);
		return re;
	}
	
}
