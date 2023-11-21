package com.valtech.training.springbootassignment.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.training.springbootassignment.component.ProductDAOImpl.ProductRowMapper;

@Component
public class CustomerOrdersImpl implements CustomerOrdersDAO {
	
	public class CustomerOrdersRowMapper implements RowMapper<CustomerOrders> {

		@Override
		public CustomerOrders mapRow(ResultSet rs, int rowNum) throws SQLException {
			CustomerOrders co = new CustomerOrders();
			co.setOrderID(rs.getLong(1));
			co.setCustomerID(rs.getLong(2));
			co.setOrderDate(rs.getDate(3));
			return co;
		}
		
	}

	@Autowired
	private DataSource datasource;

	@Override
	public void deleteCustomerOrders(int orderID) {
		
		String deleteQry = "DELETE FROM CUSTOMERORDERS WHERE orderID=?";
		new JdbcTemplate(datasource).update(deleteQry, orderID);
	}
	
	@Override
	public void updateCustomerOrders(CustomerOrders customerOrders) {
		String updateQry = "UPDATE CUSTOMERORDERS SET CUSTOMERID = ?, ORDERDATE = ? WHERE ORDERID = ?";
		new JdbcTemplate(datasource).update(updateQry, customerOrders.getCustomerID(),customerOrders.getOrderDate(),customerOrders.getOrderID());

	}

	@Override
	public void createCustomerOrders(CustomerOrders customerOrders) {

		String createQry = "INSERT INTO CUSTOMERORDERS (CUSTOMERID,ORDERDATE) VALUES (?,?)";
		new JdbcTemplate(datasource).update(createQry, customerOrders.getCustomerID(),customerOrders.getOrderDate());
	}

	@Override
	public List<CustomerOrders> getAllCustomerOrders() {

		String selectAllQry = "SELECT CUSTOMERID,ORDERDATE FROM CUSTOMERORDERS";
		return new JdbcTemplate(datasource).query(selectAllQry, new CustomerOrdersRowMapper());

	}

	@Override
	public CustomerOrders getCustomerOrders(int orderID) {

		String selectQry = "SELECT ORDERID,CUSTOMERID,ORDERDATE FROM CUSTOMEORDERS WHERE ORDERID = ?";
		return new JdbcTemplate(datasource).queryForObject(selectQry, new CustomerOrdersRowMapper());

	}

	@Override
	public long countCustomerOrders() {

		String countQry = "SELECT COUNT(ORDERID) FROM CUSTOMERORDERS";
		return new JdbcTemplate(datasource).queryForObject(countQry, Long.class);

	}
	
}
