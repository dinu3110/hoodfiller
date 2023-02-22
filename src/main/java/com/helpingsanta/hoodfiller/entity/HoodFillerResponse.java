package com.helpingsanta.hoodfiller.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author dines
 *
 */
public class HoodFillerResponse implements Serializable {

	private static final long serialVersionUID = 1533785699853830636L;

	private List<Integer> presentWeights;

	public List<Integer> getPresentWeights() {
		return presentWeights;
	}

	public void setPresentWeights(List<Integer> presentWeights) {
		this.presentWeights = presentWeights;
	}

}
