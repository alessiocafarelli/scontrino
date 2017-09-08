package com.scontrino.bean;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.scontrino.utility.Utility;

public class Receipt {

	private static final Logger logger = LogManager.getLogger(Receipt.class);
	
	private ArrayList<Product> productsList;
	private BigDecimal totalCost;
	private BigDecimal totalTax;
	private ArrayList<String> countProductType;
	

	Utility u = new Utility();
	
	public Receipt(ArrayList<Product> productsList, BigDecimal totalCost) {
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
	
	public BigDecimal getTotalCost() {
		
		totalCost = BigDecimal.ZERO;
		try {
			for (int i = 0; i < productsList.size(); i++) {
				totalCost = totalCost.add(u.calculateTax(productsList.get(i)).getTaxedPrice());
			}
		} catch (Exception e) {
			logger.error("ERRORE = "+e);
		}
		
		return totalCost;
	}
	
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public BigDecimal getTotalTax() {
		
		totalTax = BigDecimal.ZERO;
		
		try {
			if(null != productsList && productsList.size() > 0){
				for (int i = 0; i < productsList.size(); i++) {
					totalTax = totalTax.add(u.calculateTax(productsList.get(i)).getTaxes());
				}
			}
		} catch (Exception e) {
			logger.error("ERRORE = "+e);
		}
		
		return totalTax;
	}

	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

	public ArrayList<String> getCountProductType() {
		return countProductType;
	}

	public void setCountProductType(ArrayList<String> countProductType) {
		this.countProductType = countProductType;
	}
	
}
