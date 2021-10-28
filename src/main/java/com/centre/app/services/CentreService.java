package com.centre.app.services;

import org.springframework.http.ResponseEntity;

import com.centre.app.entities.Centre;

public interface CentreService {
	
	public ResponseEntity<?> getAllCentres();
	public ResponseEntity<?> getSingleCentre(String id_centre);
	public ResponseEntity<?> allIdCentres();
	public ResponseEntity<?> addCentre(Centre centre);
	public ResponseEntity<?> updateCentre(Centre centre, String id_centre);
	public ResponseEntity<?> deleteCentre(String id_centre, String id_form);

}
