package com.sales.util;

import java.util.ResourceBundle;

public final class ResourceGetter {
	private static ResourceBundle application = ResourceBundle
			.getBundle("applicationResources");
	private static ResourceBundle sql = ResourceBundle.getBundle("sql");
	private static ResourceGetter theInstance;
	
	private ResourceGetter(){
		
	}

	static {
		try {
			theInstance = new ResourceGetter();
		} catch (Exception se) {
			se.printStackTrace();
		}
	}

	static public ResourceGetter getInstance() {
		return theInstance;
	}

	public String getSqlPropertyText(String key) {
		return sql.getString(key);
	}

	public String getApplicationPropertyText(String key) {
		return application.getString(key);
	}

}
