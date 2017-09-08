package com.scontrino.utility;

import java.math.BigDecimal;

public class Constants {

	public final static BigDecimal TAX = new BigDecimal(10);
	public final static BigDecimal IMPORT_TAX = new BigDecimal(5);
	
	public final static BigDecimal BIG_D_100 = new BigDecimal(100);
	
	public final static String FLAG_IMPORTED_Y = "Y";
	public final static String FLAG_IMPORTED_N = "N";
	
	public final static String BOOK = "1";
	public final static String MUSIC_CD = "2";
	public final static String CHOCOLATE_BAR = "3";
	public final static String BOX_OF_CHOCOLATE = "4";
	public final static String BOTTLE_OF_PERFUME = "5";
	public final static String POCKET_OF_HEADACHE = "6";
	public final static String CHOCOLATES = "7";
	
	public final static String BOOK_DESC = "book";
	public final static String MUSIC_CD_DESC = "music CD";
	public final static String CHOCOLATE_BAR_DESC = "chocolate bar";
	public final static String BOX_OF_CHOCOLATE_DESC = "box of chocolate";
	public final static String BOTTLE_OF_PERFUME_DESC = "bottle of perfume";
	public final static String POCKET_OF_HEADACHE_DESC = "pocket of headache";
	public final static String CHOCOLATES_DESC = "box of chocolates";
	
	public final static String SALES_TAXES = "Sales Taxes";
	public final static String TOTAL = "Total";
	public final static String IMPORTED_DESC = "imported";
	
	public final static String DOUBLE_DOT = ":";
	
	public final static String[] BASIC_TAX = {"2","5"};
	public final static String[] TAX_EXEMPT = {"1","3","4","6","7"};
}