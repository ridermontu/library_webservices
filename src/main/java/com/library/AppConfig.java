package com.library;

import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { WebAppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}

	@Configuration
	@EnableWebMvc
	@ComponentScan("com.library")
	@EnableTransactionManagement
	@PropertySource({"classpath:log4j.properties"})
	public static class WebAppConfig {
		
		
		
		@Bean(name = "dataSource")
		public DataSource getDataSource() {
			BasicDataSource basicDataSource = new BasicDataSource();
			basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
			basicDataSource.setUrl("jdbc:mysql://localhost:3306/library");
			basicDataSource.setUsername("root");
			basicDataSource.setPassword("root");
			return basicDataSource;

		}
		   @Bean
		    public MailSender getMailSender(){
		        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		         
		        //Using gmail
		        mailSender.setHost("smtp.mail.yahoo.com");
		        mailSender.setPort(587);
		        mailSender.setUsername("pradeep.rathore2629");
		        mailSender.setPassword("Anaysingh@");
		         
		        Properties javaMailProperties = new Properties();
		        javaMailProperties.put("mail.smtp.starttls.enable", "true");
		        javaMailProperties.put("mail.smtp.auth", "true");
		        javaMailProperties.put("mail.transport.protocol", "smtp");
		        javaMailProperties.put("mail.debug", "true");//Prints out everything on screen
		         
		        mailSender.setJavaMailProperties(javaMailProperties);
		        return mailSender;
		    }

		@Bean(name = "sessionFectory")
		public SessionFactory getSessionFectory(DataSource dataSource) {
			LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
			sessionFactoryBuilder.scanPackages("com.library.model");
			sessionFactoryBuilder.addProperties(getHibernateProperties());
			return sessionFactoryBuilder.buildSessionFactory();

		}

		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}

		private Properties getHibernateProperties() {
			Properties properties = new Properties();
			properties.put("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.format_sql", "true");
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			return properties;
		}

	

	}

}
