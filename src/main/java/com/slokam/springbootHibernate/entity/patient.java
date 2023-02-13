package com.slokam.springbootHibernate.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class patient {
	@Id
	@GeneratedValue
	private Integer pid;
	private String pname;
	private String pcondition;
	private Double pbill;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	
	
	@Override
	public String toString() {
		return "patient [pid=" + pid + ", pname=" + pname + ", pcondition=" + pcondition + ", pbill=" + pbill + "]";
	}
	
}
