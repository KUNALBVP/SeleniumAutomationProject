package com.store.dataproviders;

import org.testng.annotations.DataProvider;

import com.store.utlity.ExcelLibraryFile;

public class DataProviders {
	
    ExcelLibraryFile obj = new ExcelLibraryFile();
	
    @DataProvider(name = "loginCredentials")
	public Object[][] getLoginCredentials() {
		// Totals rows count
		int rows = obj.getRowCount("Login_Credentials");
		// Total Columns
		int column = obj.getColumnCount("Login_Credentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Login_Credentials", j, i + 2);
			}
		}
		return data;
	}
    
    
    @DataProvider(name = "cardCredentials")
	public Object[][] getCardCredentials() {
		// Totals rows count
		int rows = obj.getRowCount("Card_Credentials");
		// Total Columns
		int column = obj.getColumnCount("Card_Credentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Card_Credentials", j, i + 2);
			}
		}
		return data;
}

}   
