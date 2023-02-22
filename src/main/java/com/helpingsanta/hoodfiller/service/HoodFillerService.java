package com.helpingsanta.hoodfiller.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpingsanta.hoodfiller.entity.HoodFillerRequest;
import com.helpingsanta.hoodfiller.entity.HoodFillerResponse;
import com.helpingsanta.hoodfiller.exception.ResourceNotFoundException;
import com.helpingsanta.hoodfiller.model.Presents;
import com.helpingsanta.hoodfiller.repository.PresentsRepository;

@Service
public class HoodFillerService {

	@Autowired
	private PresentsRepository presentsRepository;

	/**
	 * @param request
	 * @return WeightedPresnt list in the response
	 * @throws ResourceNotFoundException
	 * Calculation on minimum hooded present weight logic
	 */
	public HoodFillerResponse getHoodFiller(HoodFillerRequest request) throws ResourceNotFoundException {
		HoodFillerResponse response = new HoodFillerResponse();
		List<Integer> hoodedWeights = new ArrayList<>();
		List<Integer> hoodedIds = new ArrayList<>();

		Map<Integer, Integer> presentsMap = new HashMap<Integer, Integer>();
		for (Presents present : request.getPresents()) {
			presentsMap.put(present.getId(), present.getWeight());
		}

		List<Map.Entry<Integer, Integer>> sortedPresents = new ArrayList<>(presentsMap.entrySet());
		Collections.sort(sortedPresents, Comparator.comparingInt(Map.Entry::getValue));

		int remainingCapacity = request.getHoodCapacity();
		for (int i = sortedPresents.size() - 1; i >= 0; i--) {
			int presentId = sortedPresents.get(i).getKey();
			int presentWeight = sortedPresents.get(i).getValue();
			int presentCount = remainingCapacity / presentWeight;
			remainingCapacity -= presentCount * presentWeight;

			for (int j = 0; j < presentCount; j++) {
				hoodedWeights.add(presentWeight);
				hoodedIds.add(presentId);
			}
		}
		updateHoodedPresentFlag(hoodedIds);
		
		response.setPresentWeights(hoodedWeights);
		return response;
	}

	/**
	 * @param hoodedIds
	 * update h2 db with presentids as hooded
	 * @throws ResourceNotFoundException
	 */
	private void updateHoodedPresentFlag(List<Integer> hoodedIds) throws ResourceNotFoundException {
		try {
			hoodedIds.forEach(id -> {
				Optional<Presents> resultOptional = presentsRepository.findById(id);
				resultOptional.ifPresent((Presents result) -> {
					result.setHoodedFlag(true);
					presentsRepository.save(result);
				});
			});
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resource Not Found!!!!");
		}
	}

}
