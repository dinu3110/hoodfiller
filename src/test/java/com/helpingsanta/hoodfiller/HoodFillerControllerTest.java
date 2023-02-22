package com.helpingsanta.hoodfiller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.helpingsanta.hoodfiller.controller.HoodFillerController;
import com.helpingsanta.hoodfiller.entity.HoodFillerRequest;
import com.helpingsanta.hoodfiller.entity.HoodFillerResponse;
import com.helpingsanta.hoodfiller.exception.ResourceNotFoundException;
import com.helpingsanta.hoodfiller.model.Presents;
import com.helpingsanta.hoodfiller.service.HoodFillerService;
import com.helpingsanta.hoodfiller.service.PresentsService;

@DataJpaTest
@RunWith(MockitoJUnitRunner.class)
class HoodFillerControllerTest {

	@InjectMocks
	HoodFillerController hoodFillerController;

	@Mock
	HoodFillerService hoodFillerService;
	
	@Mock
	private PresentsService presentsService;

	@Test
	public void testGetHoodFiller() throws ResourceNotFoundException {
		HoodFillerRequest request = new HoodFillerRequest();
		int hoodCapacity = 20;
		request.setHoodCapacity(hoodCapacity);

		List<Integer> presentWeights = new ArrayList<>();
		presentWeights.add(10);
		presentWeights.add(15);
		presentWeights.add(2);

		HoodFillerResponse expectedResponse = new HoodFillerResponse();
		expectedResponse.setPresentWeights(presentWeights);
		
		List<Presents> presentsList = new ArrayList<>();
        presentsList.add(new Presents(1, 10));
        presentsList.add(new Presents(2, 5));
        presentsList.add(new Presents(3, 2));
		
		Mockito.when(presentsService.getAllAvailablePresents()).thenReturn(presentsList);

		Mockito.when(hoodFillerService.getHoodFiller(request)).thenReturn(expectedResponse);

		ResponseEntity<HoodFillerResponse> responseEntity = hoodFillerController.getHoodFiller(request);
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

		HoodFillerResponse actualResponse = responseEntity.getBody();
		assertNotNull(actualResponse);
	}

	@Test
	public void testGetHoodFillerEmptyInputs() throws ResourceNotFoundException {
		HoodFillerController controller = new HoodFillerController();
		int hoodCapacity = 0;

		HoodFillerRequest request = new HoodFillerRequest();
		request.setHoodCapacity(hoodCapacity);

		ResponseEntity<HoodFillerResponse> responseEntity = controller.getHoodFiller(request);
		assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
	}

}
