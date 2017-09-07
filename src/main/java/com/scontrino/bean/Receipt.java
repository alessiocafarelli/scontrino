package com.scontrino.bean;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Receipt {

//	private Logger logger;
	private static final Logger logger = LogManager.getLogger(Receipt.class);
	
	private ArrayList<Product> productsList;
	private double totalCost;

	public Receipt(ArrayList<Product> productsList, double totalCost) {
		super();
		this.productsList = productsList;
		this.totalCost = totalCost;
	}
	
	public Receipt() {
		super();
	}

	public ArrayList<Product> getProductsList() {
		return productsList;
	}
	
	public void setProductsList(ArrayList<Product> productsList) {
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
