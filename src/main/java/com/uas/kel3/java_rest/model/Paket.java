package com.uas.kel3.java_rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paket")
public class Paket {

	private int id;
	private int id_user;
	private int id_product;
	private String alamat_pengirim;
	private String alamat_tujuan;
	private String nohp_tujuan;
	private String kurir;
	private int harga;
	private Date created_at; 
	private Date updated_at; 
	
	public Paket() {}

	public Paket(int id,int id_user, int id_product, String alamat_pengirim, String alamat_tujuan, String nohp_tujuan, String kurir,
			int harga, Date created_at, Date updated_at) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.id_product = id_product;
		this.alamat_pengirim = alamat_pengirim;
		this.alamat_tujuan = alamat_tujuan;
		this.nohp_tujuan = nohp_tujuan;
		this.kurir = kurir;
		this.harga = harga;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "Id")
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

	public int getId_product() {
		return id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}

	public String getAlamat_pengirim() {
		return alamat_pengirim;
	}

	public void setAlamat_pengirim(String alamat_pengirim) {
		this.alamat_pengirim = alamat_pengirim;
	}

	public String getAlamat_tujuan() {
		return alamat_tujuan;
	}

	public void setAlamat_tujuan(String alamat_tujuan) {
		this.alamat_tujuan = alamat_tujuan;
	}

	public String getNohp_tujuan() {
		return nohp_tujuan;
	}

	public void setNohp_tujuan(String nohp_tujuan) {
		this.nohp_tujuan = nohp_tujuan;
	}

	public String getKurir() {
		return kurir;
	}

	public void setKurir(String kurir) {
		this.kurir = kurir;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
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
