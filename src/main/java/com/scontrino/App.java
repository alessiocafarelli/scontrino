package com.scontrino;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.scontrino.bean.Product;
import com.scontrino.bean.Receipt;
import com.scontrino.utility.Constants;
import com.scontrino.utility.Utility;

public class App 
{

	public static void main( String[] args )
    {
        
        Utility u = new Utility();
                
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
*/        
        Receipt scontrino_1 = new Receipt();
        ArrayList<Product> productsList_1 = new ArrayList<Product>();
        
        Product product_1 = new Product(Constants.BOOK, Constants.BOOK_DESC, Constants.FLAG_IMPORTED_N, new BigDecimal("12.49"));
        Product product_2 = new Product(Constants.MUSIC_CD, Constants.MUSIC_CD_DESC, Constants.FLAG_IMPORTED_N, new BigDecimal("14.99"));
        Product product_3 = new Product(Constants.CHOCOLATE_BAR, Constants.CHOCOLATE_BAR_DESC, Constants.FLAG_IMPORTED_N, new BigDecimal("0.85"));
        
        productsList_1.add(product_1);
        productsList_1.add(product_2);
        productsList_1.add(product_3);
       
        scontrino_1.setProductsList(productsList_1);

        u.printReceipt(scontrino_1);
        
/*        
		Input 2:
			1 imported box of chocolates at 10.00
			1 imported bottle of perfume at 47.50
        	
		Output 2:
			1 imported box of chocolates: 10.50
			1 imported bottle of perfume: 54.65
			Sales Taxes: 7.65
			Total: 65.15
*/         
        
        Receipt scontrino_2 = new Receipt();
        ArrayList<Product> productsList_2 = new ArrayList<Product>();
        
        Product product_4 = new Product(Constants.BOX_OF_CHOCOLATE, Constants.BOX_OF_CHOCOLATE_DESC, Constants.FLAG_IMPORTED_Y, new BigDecimal("10.00"));
        Product product_5 = new Product(Constants.BOTTLE_OF_PERFUME, Constants.BOTTLE_OF_PERFUME_DESC, Constants.FLAG_IMPORTED_Y, new BigDecimal("47.50"));
        
        productsList_2.add(product_4);
        productsList_2.add(product_5);
        
        scontrino_2.setProductsList(productsList_2);
        
        u.printReceipt(scontrino_2);
        
/*        
		Input 3:
			1 imported bottle of perfume at 27.99
			1 bottle of perfume at 18.99
			1 packet of headache pills at 9.75
			1 box of imported chocolates at 11.25
        	
		Output 3:
			1 imported bottle of perfume: 32.19
			1 bottle of perfume: 20.89
			1 packet of headache pills: 9.75
			1 imported box of chocolates: 11.85
			Sales Taxes: 6.70
			Total: 74.68
*/           
        
        
        Receipt scontrino_3 = new Receipt();
        ArrayList<Product> productsList_3 = new ArrayList<Product>();
        
        Product product_6 = new Product(Constants.BOTTLE_OF_PERFUME, Constants.BOTTLE_OF_PERFUME_DESC, Constants.FLAG_IMPORTED_Y, new BigDecimal("27.99"));
        Product product_7 = new Product(Constants.BOTTLE_OF_PERFUME, Constants.BOTTLE_OF_PERFUME_DESC, Constants.FLAG_IMPORTED_N, new BigDecimal("18.99"));
        Product product_8 = new Product(Constants.POCKET_OF_HEADACHE, Constants.POCKET_OF_HEADACHE_DESC, Constants.FLAG_IMPORTED_N, new BigDecimal("9.75"));
        Product product_9 = new Product(Constants.CHOCOLATES, Constants.CHOCOLATES_DESC, Constants.FLAG_IMPORTED_Y, new BigDecimal("11.25"));
        
        productsList_3.add(product_6);
        productsList_3.add(product_7);
        productsList_3.add(product_8);
        productsList_3.add(product_9);
        
        scontrino_3.setProductsList(productsList_3);

        u.printReceipt(scontrino_3);
        
    }
    
}
