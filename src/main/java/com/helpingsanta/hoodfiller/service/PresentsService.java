package com.helpingsanta.hoodfiller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpingsanta.hoodfiller.model.Presents;
import com.helpingsanta.hoodfiller.repository.PresentsRepository;

@Service
public class PresentsService {

	@Autowired
	private PresentsRepository presentsRepository;

	/**
	 * @return all available presents from h2 db
	 * return available presents based on hooded flag
	 */
	public List<Presents> getAllAvailablePresents() {
		return presentsRepository.findAllByHoodedFlag(false);

	}

}
