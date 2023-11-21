package com.valtech.training.springbootassignment.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Entity;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.training.springbootassignment.component.ProductDAOImpl.ProductRowMapper;

@Component
public class CustomerDAOImpl implements CustomerDAO {
	
	public class CustomerRowMapper implements RowMapper<Customer>{

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer cus = new Customer();
			cus.setCustomerID(rs.getInt(1));
			cus.setCustomerName(rs.getString(2));
			cus.setCustomerPhone(rs.getString(3));
			cus.setCustomerAddr(rs.getString(4));
			return cus;
		}
		
	}
	
	@Autowired
	private DataSource datasource;

	@Override
	public void deleteCustomer(int customerID) {
		
		String deleteQry = "DELETE FROM CUSTOMER WHERE customerID=?";
		new JdbcTemplate(datasource).update(deleteQry, customerID);
	}
	
	@Override
	public void updateCustomer(Customer customer) {
		String updateQry = "UPDATE CUSTOMER SET CUSTOMERNAME = ?, CUSTOMERPHONE = ? CUSTOMERADDR = ? WHERE CUSTOMERID = ?";
		new JdbcTemplate(datasource).update(updateQry, customer.getCustomerName(),customer.getCustomerPhone(),customer.getCustomerAddr(),customer.getCustomerID());

	}

	@Override
	public void createCustomer(Customer customer) {

		String createQry = "INSERT INTO CUSTOMER (CUSTOMERNAME,CUSTOMERPHONE,CUSTOMERADDR) VALUES (?,?,?)";
		new JdbcTemplate(datasource).update(createQry, customer.getCustomerName(),customer.getCustomerPhone(),customer.getCustomerAddr());
	}

	@Override
	public List<Customer> getAllCustomers(){

		String selectAllQry = "SELECT CUSTOMERNAME,CUSTOMERPHONE,CUSTOMERADDR FROM CUSTOMER";
		return new JdbcTemplate(datasource).query(selectAllQry, new CustomerRowMapper());

	}

	@Override
	public Customer getCustomer(int customerID) {

		String selectQry = "SELECT CUSTOMERID,CUSTOMERNAME,CUSTOMERPHONE,CUSTOMERADDR FROM CUSTOMER WHERE CUSTOMERID = ?";
		return new JdbcTemplate(datasource).queryForObject(selectQry, new CustomerRowMapper());

	}

	@Override
	public long countCustomer() {

		String countQry = "SELECT COUNT(CUSTOMERID) FROM CUSTOMER";
		return new JdbcTemplate(datasource).queryForObject(countQry, Long.class);

	}
	
}
