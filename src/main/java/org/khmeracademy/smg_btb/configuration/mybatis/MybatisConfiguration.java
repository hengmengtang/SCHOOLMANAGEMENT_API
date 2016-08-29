package org.khmeracademy.smg_btb.configuration.mybatis;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@MapperScan("org.khmeracademy.smg_btb.repository")
public class MybatisConfiguration {

	@Bean 
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://120.136.24.174:5432/SCHOOL_MGT_BTB");
		dataSource.setUsername("SCHOOL_MGT_BTB");
		dataSource.setPassword("SCHOOL_MGT_BTB");
		return dataSource;
	}
	
	/*@Bean 
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/SCHOOL_MGT_BTB");
		dataSource.setUsername("postgres");
		dataSource.setPassword("1234");
		return dataSource;
	}*/
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(getDataSource());
	}
 
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		return sessionFactory;
	}
}
