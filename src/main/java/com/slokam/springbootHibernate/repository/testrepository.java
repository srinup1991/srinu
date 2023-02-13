package com.slokam.springbootHibernate.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slokam.springbootHibernate.entity.patient;

@Repository
public interface testrepository extends JpaRepository<patient, Integer> {

	public abstract List<patient> findBypname(String pname);
	public abstract List<patient> findBypnameLike(String pname);
	public abstract List<patient> findBydateBefore(Date date);
	
	@Query("from patient p where p.pname=?1")
	public abstract List<patient> getpatientsbyname(String pname);
	
}
