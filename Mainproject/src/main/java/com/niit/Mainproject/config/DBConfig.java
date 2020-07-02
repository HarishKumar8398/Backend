package com.niit.Mainproject.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages=("com.niit"))
public class DBConfig{
	
	@Bean(name="data")
	public DataSource dataSource()
	{
	DriverManagerDataSource data=new DriverManagerDataSource();
	data.setDriverClassName("org.h2.Driver");
	data.setUrl("jdbc:h2:tcp://localhost/~/test");
	data.setUsername("sa");
	data.setPassword("");
	
	return data;
	}
	
	public Properties getHibernateProperties() {
		Properties hp=new Properties();
		hp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hp.setProperty("hibernate.hbm2ddl.auto", "update");
		hp.setProperty("hibernate.show_sql", "true");
		
		return hp;
	}
	
	
	@Bean(name="sessionFactory")
	@Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource data)
	{
		LocalSessionFactoryBean sessionFactory= new LocalSessionFactoryBean ();
		sessionFactory.setDataSource (data);
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setPackagesToScan("com.niit");
		
		return sessionFactory;
	}
	
	
	@Bean(name="transactionManager")
	@Autowired
	public HibernateTransactionManager getTransactionManager (SessionFactory sessionFactory )
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
	
}

