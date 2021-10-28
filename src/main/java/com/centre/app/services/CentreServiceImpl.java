package com.centre.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.centre.app.entities.Centre;
import com.centre.app.repositories.CentreRepository;

@Service
public class CentreServiceImpl implements CentreService {
	@Autowired
	private CentreRepository centre_rep;
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	public ResponseEntity<?> getAllCentres() {
		List<Centre> centres = centre_rep.findAll();
		if (centres.size() > 0) {
			return new ResponseEntity<List<Centre>>(centres, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Centres not available!", HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<?> getSingleCentre(String id_centre) {
		try {
			Centre centre = centre_rep.findById(id_centre).get();
			if (centre_rep.findById(id_centre).isPresent()) {
				return new ResponseEntity<Centre>(centre, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Unable to find centre", HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> allIdCentres() {
		List<Centre> centres = centre_rep.findAll();
		List<String> id_centres = new ArrayList<String>();
		for (int i = 0; i<centres.size(); i++) {
			id_centres.add(centres.get(i).getId_c());
		}
		return new ResponseEntity<List<String>>(id_centres, HttpStatus.OK);
	}
	
	public ResponseEntity<?> addCentre(Centre centre) {
		try {
			centre_rep.save(centre);
			return new ResponseEntity<Centre>(centre, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> updateCentre(Centre centre, String id_centre) {
		try {
			if (centre_rep.findById(id_centre).isPresent()) {
				Centre existedCentre = centre_rep.findById(id_centre).get();
				if (centre.getNom_centre_f() == null) {
					existedCentre.setNom_centre_f(existedCentre.getNom_centre_f());
				} else {
					existedCentre.setNom_centre_f(centre.getNom_centre_f());
				}
				if (centre.getWebsite_centre_f() == null) {
					existedCentre.setWebsite_centre_f(existedCentre.getWebsite_centre_f());
				} else {
					existedCentre.setWebsite_centre_f(centre.getWebsite_centre_f());
				}
				if (centre.getNum_centre_f() == null) {
					existedCentre.setNum_centre_f(existedCentre.getNum_centre_f());
				} else {
					existedCentre.setNum_centre_f(centre.getNum_centre_f());
				}
				if (centre.getDesc_centre_f() == null) {
					existedCentre.setDesc_centre_f(existedCentre.getDesc_centre_f());
				} else {
					existedCentre.setDesc_centre_f(centre.getDesc_centre_f());
				}
				if (centre.getLogo_centre_f() == null) {
					existedCentre.setLogo_centre_f(existedCentre.getLogo_centre_f());
				} else {
					existedCentre.setLogo_centre_f(centre.getLogo_centre_f());
				}
				if (centre.getAddress_f() == null) {
					existedCentre.setAddress_f(existedCentre.getAddress_f());
				} else {
					existedCentre.setAddress_f(centre.getAddress_f());
				}
				if (centre.getRegion_f() == null) {
					existedCentre.setRegion_f(existedCentre.getRegion_f());
				} else {
					existedCentre.setRegion_f(centre.getRegion_f());
				}
				centre_rep.save(existedCentre);
			} else {
				return new ResponseEntity<>("Centre not found!", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Centre>(centre_rep.findById(id_centre).get(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//delete centre as well as its formation
	public ResponseEntity<?> deleteCentre(String id_centre, String id_form) {
		try {
			if (centre_rep.findById(id_centre).isPresent()) {
				centre_rep.delete(centre_rep.findById(id_centre).get());
				/*if (form_rep.findById(id_form).isPresent()) {
					Formation formation = form_rep.findById(id_form).get();
					formation.getCentre().remove(0);
					form_rep.save(formation);
				}*/
				String formation = restTemplateBuilder.build().getForObject("https://formation-ms-qs.herokuapp.com/deleteCentreFromForm/"+id_form, String.class);
				return new ResponseEntity<>("Centre deleted successfully and associated: "+formation, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Centre not found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
