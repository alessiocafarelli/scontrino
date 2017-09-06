package com.scontrino.bean;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;

import com.scontrino.utility.Constants;

public class Product {

	private String typeOfProduct;
	private String description;
	private String flagImported;
	private double price;
	private double taxedPrice;
	private double taxes;
	
	public Product(String typeOfProduct, String description,
			String flagImported, double price, double taxedPrice,
			double taxes) {
		super();
		this.typeOfProduct = typeOfProduct;
		this.description = description;
		this.flagImported = flagImported;
		this.price = price;
		this.taxedPrice = taxedPrice;
		this.taxes = taxes;
	}

	public Product(String typeOfProduct, String description,
			String flagImported, double price) {
		super();
		this.typeOfProduct = typeOfProduct;
		this.description = description;
		this.flagImported = flagImported;
		this.price = price;
	}
	
	public Product() {
		super();
	}

	public String getTypeOfProduct() {
		return typeOfProduct;
	}

	public void setTypeOfProduct(String typeOfProduct) {
		this.typeOfProduct = typeOfProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFlagImported() {
		return flagImported;
	}

	public void setFlagImported(String flagImported) {
		this.flagImported = flagImported;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTaxedPrice() {
		taxedPrice = price + taxes;
		return taxedPrice;
	}

	public void setTaxedPrice(double taxedPrice) {
		this.taxedPrice = taxedPrice;
	}

	public double getTaxes() {
		
		if(price > 0){
//			System.out.print("\n1.setTaxedPrice price = "+price);
//			System.out.println();
			taxes = 0.00;
//			System.out.print("\n2.setTaxedPrice taxes = "+taxes);
//			System.out.println();
			if(StringUtils.isNotEmpty(typeOfProduct) &&  Arrays.asList(Constants.BASIC_TAX).contains(typeOfProduct)){
				taxes = price/100*Constants.TAX;
//				System.out.print("\n3.setTaxedPrice taxes = "+taxes);
//				System.out.println();
			}
			
			if(StringUtils.isNotEmpty(flagImported) && flagImported.equalsIgnoreCase(Constants.FLAG_IMPORTED_Y)){
				taxes = taxedPrice/100*Constants.IMPORT_TAX;
//				System.out.print("\n4.setTaxedPrice taxes = "+taxes);
//				System.out.println();
			}
		}
		
		return taxes;
	}

	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}
	
}
