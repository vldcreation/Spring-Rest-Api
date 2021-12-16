package com.uas.kel3.java_rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "booking_room")
public class Booking {
	private int id;
	private int id_user;
	private int id_room;
	private Date start_at;
	private Date end_at;
	private String keperluan;
	private String deskripsi;
	private Date created_at;
	private Date updated_at;
	public Booking() {}

	public Booking(int id,int id_user, int id_room, Date start_at, Date end_at, String keperluan, String deskripsi
			,Date created_at, Date updated_at) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.id_room = id_room;
		this.start_at = start_at;
		this.end_at = end_at;
		this.keperluan = keperluan;
		this.deskripsi = deskripsi;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_room() {
		return id_room;
	}

	public void setId_room(int id_room) {
		this.id_room = id_room;
	}

	public Date getStart_at() {
		return start_at;
	}

	public void setStart_at(Date start_at) {
		this.start_at = start_at;
	}

	public Date getEnd_at() {
		return end_at;
	}

	public void setEnd_at(Date end_at) {
		this.end_at = end_at;
	}

	public String getKeperluan() {
		return keperluan;
	}

	public void setKeperluan(String keperluan) {
		this.keperluan = keperluan;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	
	
}
