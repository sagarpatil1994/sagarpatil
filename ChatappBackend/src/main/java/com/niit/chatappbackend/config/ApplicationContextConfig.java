package com.niit.chatappbackend.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.ConnectionProperties;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.niit.chatappbackend.model.Blog;
import com.niit.chatappbackend.model.Chat;
import com.niit.chatappbackend.model.Event;
import com.niit.chatappbackend.model.Forum;
import com.niit.chatappbackend.model.Job;
import com.niit.chatappbackend.model.User;

@Configuration
@EnableWebMvc
@ComponentScan("com.niit.chatappbackend")
@EnableTransactionManagement

public class ApplicationContextConfig 
{
	@Bean(name = "dataSource")
	public DataSource getOracleDatasource() 
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");

		//datasource.setUsername("scott");
		//datasource.setPassword("scott");
		Properties connectionProperties = new Properties(); 
	
		connectionProperties.setProperty("hibernate.hbm2ddl.auto","create");
		connectionProperties.setProperty("hibernate.show_sql","true");
		connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		connectionProperties.setProperty("hibernate.format_sql","true");
		datasource.setConnectionProperties(connectionProperties);
		return datasource;
	}
	
@Autowired
@Bean(name="sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource)
{
	
	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addProperties((Properties) getOracleDatasource());
	sessionBuilder.addAnnotatedClass(User.class);
	sessionBuilder.addAnnotatedClass(Blog.class);
	sessionBuilder.addAnnotatedClass(Forum.class);
	sessionBuilder.addAnnotatedClass(Chat.class);
	sessionBuilder.addAnnotatedClass(Job.class);
	sessionBuilder.addAnnotatedClass(Event.class);
	return sessionBuilder.buildSessionFactory();
}


@Autowired
@Bean(name = "transactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{

	HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	return transactionManager;
}



	



}
