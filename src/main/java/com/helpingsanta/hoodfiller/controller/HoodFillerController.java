package com.helpingsanta.hoodfiller.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpingsanta.hoodfiller.entity.HoodFillerRequest;
import com.helpingsanta.hoodfiller.entity.HoodFillerResponse;
import com.helpingsanta.hoodfiller.exception.ResourceNotFoundException;
import com.helpingsanta.hoodfiller.service.HoodFillerService;
import com.helpingsanta.hoodfiller.service.PresentsService;

@RestController
@RequestMapping("/helpingsanta")
public class HoodFillerController {

	@Autowired
	private HoodFillerService hoodFillerService;

	@Autowired
	private PresentsService presentsService;

	/**
	 * @param request
	 * @return list of present weights hooded
	 * @throws ResourceNotFoundException
	 */
	@PostMapping("/hoodfiller")
	public ResponseEntity<HoodFillerResponse> getHoodFiller(@RequestBody HoodFillerRequest request) throws ResourceNotFoundException {
		if (Optional.ofNullable(request.getHoodCapacity()).orElse(0) == 0) {
			return new ResponseEntity<HoodFillerResponse>(HttpStatus.BAD_REQUEST);
		}
		if (CollectionUtils.isEmpty(request.getPresents())) {
			request.setPresents(presentsService.getAllAvailablePresents());
		}
		HoodFillerResponse response = hoodFillerService.getHoodFiller(request);
		return new ResponseEntity<HoodFillerResponse>(response, HttpStatus.OK);
	}

}
