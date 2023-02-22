package com.helpingsanta.hoodfiller.entity;

import java.io.Serializable;
import java.util.List;

import com.helpingsanta.hoodfiller.model.Presents;

/**
 * @author dines
 *
 */
public class HoodFillerRequest implements Serializable {

	private static final long serialVersionUID = 4103065527803098054L;

	private Integer hoodCapacity;
	private List<Presents> presents;

	public Integer getHoodCapacity() {
		return hoodCapacity;
	}

	public void setHoodCapacity(Integer hoodCapacity) {
		this.hoodCapacity = hoodCapacity;
	}

	public List<Presents> getPresents() {
		return presents;
	}

	public void setPresents(List<Presents> presents) {
		this.presents = presents;
	}

}
