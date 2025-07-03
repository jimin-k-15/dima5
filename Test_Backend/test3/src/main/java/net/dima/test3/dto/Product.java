package net.dima.test3.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Product {
	private LocalDate creadtionDate;
	private String productName;
	private boolean status;
	private int unitPrice;
	private int count;
	private String details;
}



	
		

