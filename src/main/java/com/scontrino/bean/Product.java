package com.scontrino.bean;

import java.math.BigDecimal;
import com.scontrino.utility.Constants;

public class Product {

	
	private String typeOfProduct;
	private String description;
	private String flagImported;
	private BigDecimal price;
	private BigDecimal taxedPrice;
	private BigDecimal taxes;
	
	public Product(String typeOfProduct, String description,
			String flagImported, BigDecimal price, BigDecimal taxedPrice,
			BigDecimal taxes) {
		super();
		this.typeOfProduct = typeOfProduct;
		this.description = description;
		this.flagImported = flagImported;
		this.price = price;
		this.taxedPrice = taxedPrice;
		this.taxes = taxes;
	}

	public Product(String typeOfProduct, String description,
			String flagImported, BigDecimal price) {
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
		if(flagImported.equalsIgnoreCase(Constants.FLAG_IMPORTED_Y)){
			description = Constants.IMPORTED_DESC + " " + description;
		}
		this.description = description;
	}

	public String getFlagImported() {
		return flagImported;
	}

	public void setFlagImported(String flagImported) {
		this.flagImported = flagImported;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTaxedPrice() {
		return taxedPrice;
	}

	public void setTaxedPrice(BigDecimal taxedPrice) {
		this.taxedPrice = taxedPrice;
	}

	public BigDecimal getTaxes() {
		return taxes;
	}

	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
	}

//	public BigDecimal getTaxedPrice() {
//		taxedPrice = price;
//		if((null != taxes && taxes.compareTo(BigDecimal.ZERO) > 0)){
//			taxedPrice = price.add(taxes);
//		}
//		return taxedPrice;
//	}

//	public void setTaxedPrice(BigDecimal taxedPrice) {
//		this.taxedPrice = taxedPrice;
//	}

//	public BigDecimal getTaxes() {
//		
//		taxes = BigDecimal.ZERO;
//		
//		if((null != price && price.compareTo(BigDecimal.ZERO) > 0)){
//			if(StringUtils.isNotEmpty(typeOfProduct) &&  Arrays.asList(Constants.BASIC_TAX).contains(typeOfProduct)){
//				logger.error("1.");
////				taxes = price/100*Constants.TAX;
////				logger.error("1.price = "+price);
////				logger.error("1.price.divide(new BigDecimal(100)) = "+price.divide(new BigDecimal(100)));
//				taxes = (price.divide(new BigDecimal(100))).multiply(Constants.TAX);
//				taxedPrice = price.add(taxes);
////				logger.error("1.taxes = "+taxes);
//			}
//			
//			if(StringUtils.isNotEmpty(flagImported) && flagImported.equalsIgnoreCase(Constants.FLAG_IMPORTED_Y)){
//				logger.error("2."+taxedPrice);
////				taxes = taxedPrice/100*Constants.IMPORT_TAX;
//				taxes = taxes.add((taxedPrice.divide(new BigDecimal(100))).multiply(Constants.IMPORT_TAX));
//			}
//			logger.error("taxes = "+taxes);
//		}
//		
//		return taxes;
//	}

//	public void setTaxes(BigDecimal taxes) {
//		this.taxes = taxes;
//	}
	
}
