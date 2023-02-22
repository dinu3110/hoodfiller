package com.helpingsanta.hoodfiller.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpingsanta.hoodfiller.model.Presents;
import com.helpingsanta.hoodfiller.service.PresentsService;

@RestController
@RequestMapping("/helpingsanta/presents")
public class PresentsController {

	@Autowired
	private PresentsService presentsService;

	/**
	 * @return all available presents in get request
	 */
	@GetMapping
	public ResponseEntity<List<Presents>> getAllAvailablePresentWeight() {
		List<Presents> response = new ArrayList<>();
		response = presentsService.getAllAvailablePresents();
		return new ResponseEntity<List<Presents>>(response, HttpStatus.OK);
	}

}
