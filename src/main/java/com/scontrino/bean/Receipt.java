package com.scontrino.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Receipt {

	private Logger logger;
	
	private List<Product> productsList;
	private double totalCost;

	public Receipt(List<Product> productsList, double totalCost) {
		super();
		this.productsList = productsList;
		this.totalCost = totalCost;
	}
	
	public Receipt() {
		super();
	}

	public List<Product> getProductsList() {
		return productsList;
	}
	
	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}
	
	public double getTotalCost() {
		
		try {
			for (int i = 0; i < productsList.size(); i++) {
				logger.error("suca");
			}
		} catch (Exception e) {
			
		}
		
		return totalCost;
	}
	
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
}
