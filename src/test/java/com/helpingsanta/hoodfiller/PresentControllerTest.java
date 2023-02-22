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

import com.helpingsanta.hoodfiller.controller.PresentsController;
import com.helpingsanta.hoodfiller.model.Presents;
import com.helpingsanta.hoodfiller.service.PresentsService;

@DataJpaTest
@RunWith(MockitoJUnitRunner.class)
public class PresentControllerTest {

	@InjectMocks
	PresentsController presentsController;

	@Mock
	private PresentsService presentsService;
	
	@Test
	public void testGetAllAvavilablePresents() {
		
		List<Presents> presentsList = new ArrayList<>();
        presentsList.add(new Presents(1, 10));
        presentsList.add(new Presents(2, 5));
        presentsList.add(new Presents(3, 2));
        
        Mockito.when(presentsService.getAllAvailablePresents()).thenReturn(presentsList);
        
        ResponseEntity<List<Presents>> responseEntity = presentsController.getAllAvailablePresentWeight();
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

		List<Presents> actualResponse = responseEntity.getBody();
		assertNotNull(actualResponse);
	}

}
