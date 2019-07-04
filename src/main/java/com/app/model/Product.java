package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name="producttab")
@Data
public class Product {
	
	@Id
	@Column(name="pid")
	@GeneratedValue
	private Integer id;
	
	@Column(name="pcode")
	private String code;
	@Column(name="pname")
	private String name;
	@Column(name="pcost")
	private Double cost;
	@Column(name="pgst")
	private Integer gst;
	@Transient
	private String email;
	@Column(name="pnote")
	private String note;
		
}
