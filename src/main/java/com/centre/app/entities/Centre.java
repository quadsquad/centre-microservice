package com.centre.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="centre")
public class Centre {
	
	@Id
	private String id_c;
	
	private String nom_centre_f;
	
	private String website_centre_f;
	
	private String num_centre_f;
	
	private String desc_centre_f;
	
	private String logo_centre_f;
	
	private String address_f;
	
	private String region_f;

	public String getId_c() {
		return id_c;
	}

	public void setId_c(String id_c) {
		this.id_c = id_c;
	}

	public String getNom_centre_f() {
		return nom_centre_f;
	}

	public void setNom_centre_f(String nom_centre_f) {
		this.nom_centre_f = nom_centre_f;
	}

	public String getWebsite_centre_f() {
		return website_centre_f;
	}

	public void setWebsite_centre_f(String website_centre_f) {
		this.website_centre_f = website_centre_f;
	}

	public String getNum_centre_f() {
		return num_centre_f;
	}

	public void setNum_centre_f(String num_centre_f) {
		this.num_centre_f = num_centre_f;
	}

	public String getDesc_centre_f() {
		return desc_centre_f;
	}

	public void setDesc_centre_f(String desc_centre_f) {
		this.desc_centre_f = desc_centre_f;
	}

	public String getLogo_centre_f() {
		return logo_centre_f;
	}

	public void setLogo_centre_f(String logo_centre_f) {
		this.logo_centre_f = logo_centre_f;
	}

	public String getAddress_f() {
		return address_f;
	}

	public void setAddress_f(String address_f) {
		this.address_f = address_f;
	}

	public String getRegion_f() {
		return region_f;
	}

	public void setRegion_f(String region_f) {
		this.region_f = region_f;
	}

}