package org.techhub.DBConfig;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configurable
@ComponentScan(basePackages= {" org.techhub.Service","org.techhub.repository"})
public class JdbcConfig 
{
  @Bean(name="datasource")
  public DriverManagerDataSource getDataSource()
  {
	  DriverManagerDataSource datasource=new DriverManagerDataSource();
	  datasource.setUrl("jdbc:mysql://localhost:3306/march");
	  datasource.setUsername("root");
	  datasource.setPassword("root");
	  datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	return  datasource;
	  
  }
  
  @Bean(name="template")
  public JdbcTemplate gettemplate()
  {
	  JdbcTemplate template=new JdbcTemplate();
	  template.setDataSource(getDataSource());
	  
	return template;
	  
  }
}
