package com.scontrino.utility;

import java.math.BigDecimal;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.scontrino.bean.Product;
import com.scontrino.bean.Receipt;

public class Utility {
	
	private static final Logger logger = LogManager.getLogger(Utility.class);
	
	public Product calculateTax(Product product){

		BigDecimal taxes = BigDecimal.ZERO;
		BigDecimal taxedPrice = BigDecimal.ZERO;
		BigDecimal taxPercent = BigDecimal.ZERO;
		
		Product result = product;
		
		try {
			if(null != product && null != product.getPrice() && product.getPrice().compareTo(BigDecimal.ZERO) > 0){
				
				taxedPrice = product.getPrice();
				
				if(StringUtils.isNotEmpty(product.getTypeOfProduct()) &&  Arrays.asList(Constants.BASIC_TAX).contains(product.getTypeOfProduct())){
					taxPercent = taxPercent.add(Constants.TAX);
				}
				if(StringUtils.isNotEmpty(product.getFlagImported()) && product.getFlagImported().equalsIgnoreCase(Constants.FLAG_IMPORTED_Y)){
					taxPercent = taxPercent.add(Constants.IMPORT_TAX);
				}
				
				taxes = (product.getPrice().multiply(taxPercent)).divide(Constants.BIG_D_100);
				taxes = taxes.setScale(2, BigDecimal.ROUND_UP);
				taxes = (new BigDecimal(Math.ceil(taxes.doubleValue() * 20) / 20)).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				taxedPrice = product.getPrice().add(taxes);
				
				result.setTaxes(taxes);
				result.setTaxedPrice(taxedPrice.setScale(2, BigDecimal.ROUND_UP));
				
			}
			
		} catch (Exception e) {
			logger.error("Errore in calculateTax = "+e);
		}
		
		return result;
	}
	
	public void printReceipt(Receipt receipt){

		try {
			if(null != receipt && null != receipt.getProductsList() && receipt.getProductsList().size() > 0){
				
				String imported = StringUtils.EMPTY;
				
				for (int i = 0; i < receipt.getProductsList().size(); i++) {
					imported = StringUtils.EMPTY;
					if(receipt.getProductsList().get(i).getFlagImported().equalsIgnoreCase(Constants.FLAG_IMPORTED_Y)){
						imported = Constants.IMPORTED_DESC + " ";
					}
					
					logger.debug(imported + receipt.getProductsList().get(i).getDescription() + Constants.DOUBLE_DOT + " " + calculateTax(receipt.getProductsList().get(i)).getTaxedPrice());
				}
				
				logger.debug(Constants.SALES_TAXES + Constants.DOUBLE_DOT + " " + receipt.getTotalTax());
		        logger.debug(Constants.TOTAL + Constants.DOUBLE_DOT + " " + receipt.getTotalCost());
				
		        logger.debug("===========================================");
				
			}
			
		} catch (Exception e) {
			logger.error("Errore in printReceipt = "+e);
		}
		
	}
	
	
}
