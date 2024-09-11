package com.TravelEntity;

public class SupportDocumentEntity extends StatusEntity{

	private String tono;
	private String description;
	private String file;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTono() {
		return tono;
	}
	public void setTono(String tono) {
		this.tono = tono;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}

}
