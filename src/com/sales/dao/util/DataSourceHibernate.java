package com.sales.dao.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sales.util.ApplicationConstants;

public final class DataSourceHibernate {

	private Map<String, SessionFactory> cache = null;
	private static DataSourceHibernate hibernatDS = null;
	static {
		hibernatDS = new DataSourceHibernate();
	}

	private DataSourceHibernate() {
		cache = new HashMap<String, SessionFactory>();
		intiHibernate();
	}

	private synchronized SessionFactory intiHibernate() {
		SessionFactory sf = null;
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sf = configuration.buildSessionFactory();
		} catch (HibernateException he) {
			he.printStackTrace();
			System.out.println("Initializing Hibernate: " + he);
		}
		cache.put(ApplicationConstants.CONFIGURATION_FILE_APP, sf);
		return sf;
	}

	public SessionFactory getHibernateSession() {
		SessionFactory sfInstance = (SessionFactory) cache
				.get(ApplicationConstants.CONFIGURATION_FILE_APP);
		return sfInstance;
	}

	public static DataSourceHibernate getInstance() {
		return hibernatDS;
	}

	public static void main(String[] args) {
		new DataSourceHibernate().intiHibernate();
	}

}
