package com.dhrumil.CarRental.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="t_car")
public class CarEntity {
	
	public final static byte STATUS_FREE = 0;
	public final static byte STATUS_RENT = 1;
	
	@Id
	@JsonProperty(value="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", unique = true, nullable = false, length=32)
	private Long id;
	
	
	@JsonProperty(value="name")
	@Column(name="name", nullable = false, length=128)
	private String name;
	
	
	@JsonProperty(value="price")
	@Column(name="price", nullable = false)
	private Double price;
	
	@JsonProperty(value="status")
	@Column(name="status", nullable = false)
	private Byte status;
	
	

	public CarEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarEntity(String name, Double price, Byte status) {
		super();
		this.name = name;
		this.price = price;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", price=" + price + ", status=" + status + "]";
	}

}
