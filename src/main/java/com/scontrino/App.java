package com.scontrino;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import com.scontrino.bean.Product;
import com.scontrino.utility.Constants;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
/*        
Input 1:
1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85

Input 2:
1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50

Input 3:
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25

OUTPUT

Output 1:
1 book : 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83

Output 2:
1 imported box of chocolates: 10.50
1 imported bottle of perfume: 54.65
Sales Taxes: 7.65
Total: 65.15

Output 3:
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 imported box of chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68

*/        

/*
        Input 1:
        	1 book at 12.49
        	1 music CD at 14.99
        	1 chocolate bar at 0.85
        	
		Output 1:
			1 book : 12.49
			1 music CD: 16.49
			1 chocolate bar: 0.85
			Sales Taxes: 1.50
			Total: 29.83
			
1.setTaxedPrice price = 12.49
2.setTaxedPrice taxedPrice = 12.49
product_1 = 12.49

1.setTaxedPrice price = 14.99
2.setTaxedPrice taxedPrice = 14.99
3.setTaxedPrice taxedPrice = 16.489
product_2 = 16.489

1.setTaxedPrice price = 0.85
2.setTaxedPrice taxedPrice = 0.85
product_3 = 0.85			
			
*/
        
//        ArrayList<Prodotto> Ticket_1 = new ArrayList<Prodotto>();	
        
        Product product_1 = new Product(Constants.BOOK, StringUtils.EMPTY, Constants.FLAG_IMPORTED_N, 12.49);
        System.out.print("product_1 = "+product_1.getTaxedPrice());
        System.out.println();

        Product product_2 = new Product(Constants.MUSIC_CD, StringUtils.EMPTY, Constants.FLAG_IMPORTED_N, 14.99);
        System.out.print("product_2 = "+product_2.getTaxedPrice());
        System.out.println();
        
        Product product_3 = new Product(Constants.CHOCOLATE_BAR, StringUtils.EMPTY, Constants.FLAG_IMPORTED_N, 0.85);
        System.out.print("product_3 = "+product_3.getTaxedPrice());
        System.out.println();
        
        double tax = product_1.getTaxes() + product_2.getTaxes() + product_3.getTaxes();
        double roundOff = Math.round(tax * 100.00) / 100.00;
        System.out.print("tassa = "+roundOff);
        
        
//        Prodotto product_1 = new Prodotto();
//        product_1 = inizializeProduct(Constants.BOOK, StringUtils.EMPTY, Constants.FLAG_IMPORTED_N, 12.49);
//        if(null != product_1){
//        	Ticket_1.add(product_1);
//        }
        
//        Prodotto product_2 = new Prodotto();
//        product_2 = inizializeProduct(Constants.MUSIC_CD, StringUtils.EMPTY, Constants.FLAG_IMPORTED_N, 14.99);
//        if(null != product_2){
//        	Ticket_1.add(product_2);
//        }
//        
//        Prodotto product_3 = new Prodotto();
//        product_3 = inizializeProduct(Constants.CHOCOLATE_BAR, StringUtils.EMPTY, Constants.FLAG_IMPORTED_N, 0.85);
//        if(null != product_3){
//        	Ticket_1.add(product_3);
//        }
        
    }
    
    private static Product inizializeProduct(String typeOfProduct, String description, String flagImported, double price){
    	
    	Product result = new Product();
    	
    	Product result1 = new Product(typeOfProduct,description,flagImported,price);
    	
    	try {
			
    		if(StringUtils.isNotEmpty(typeOfProduct)){
    			result.setTypeOfProduct(typeOfProduct);
    		}
			if(StringUtils.isNotEmpty(description)){
			    result.setDescription(description);
			}
			if(StringUtils.isNotEmpty(flagImported)){
				result.setFlagImported(flagImported);
			}
			if(price > 0){
				result.setPrice(price);
			}
    		
		} catch (Exception e) {
			System.out.println("Errore in inizializeProduct, "+e);
			result = null;
		}
    	
    	return result;
    	
    }
    
}
