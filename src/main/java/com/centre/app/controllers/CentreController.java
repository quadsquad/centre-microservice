package com.centre.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.centre.app.entities.Centre;
import com.centre.app.services.CentreService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CentreController {
	
	@Autowired
	public CentreService cs;
	
	@GetMapping("/all-centres")
	public ResponseEntity<?> allCentre() {
		return cs.getAllCentres();
	}
	
	@GetMapping("/get-centre/{id_centre}")
	public ResponseEntity<?> getSingleCentre(@PathVariable String id_centre) {
		return cs.getSingleCentre(id_centre);
	}
	
	@GetMapping("/all_id_centers")
	public ResponseEntity<?> getAllIdsCentres() {
		return cs.allIdCentres();
	}
 	
	@PostMapping("/add-centre")
	public ResponseEntity<?> addNewCentre(@RequestBody Centre centre) {
		return cs.addCentre(centre);
	}
	
	@PutMapping("/update-centre/{id_centre}")
	public ResponseEntity<?> updateCentre(@RequestBody Centre centre, @PathVariable String id_centre) {
		return cs.updateCentre(centre, id_centre);
	}
	
	@DeleteMapping("/delete-centre/{id_centre}/{id_form}")
	public ResponseEntity<?> deleteCentre(@PathVariable String id_centre, @PathVariable String id_form) {
		return cs.deleteCentre(id_centre, id_form);
	}

}
