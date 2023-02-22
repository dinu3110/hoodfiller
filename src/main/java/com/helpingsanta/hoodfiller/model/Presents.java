package com.helpingsanta.hoodfiller.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dines
 *
 */
@Entity
@Table(name = "PRESENTS")
public class Presents {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "TITLE")
	private String name;

	@Column(name = "WEIGHT")
	private Integer weight;

	@Column(name = "CREATED_BY")
	private String cretaedBy;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "HOODED_FLAG")
	private Boolean hoodedFlag;

	public Presents() {
	}

	public Presents(int id, int weight) {
		this.id = id;
		this.weight = weight;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getCretaedBy() {
		return cretaedBy;
	}

	public void setCretaedBy(String cretaedBy) {
		this.cretaedBy = cretaedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getHoodedFlag() {
		return hoodedFlag;
	}

	public void setHoodedFlag(Boolean hoodedFlag) {
		this.hoodedFlag = hoodedFlag;
	}

}
