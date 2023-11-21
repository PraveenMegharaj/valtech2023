package com.valtech.training.springbootassignment.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.training.springbootassignment.component.CompanyDAOImpl.CompanyRowMapper;

@Component
public class ProductDAOImpl implements ProductDAO{
	
	public class ProductRowMapper implements RowMapper<Product>{

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product p = new Product();
			p.setProductID(rs.getInt(1));
			p.setProductName(rs.getString(2));
			p.setProductAmount(rs.getInt(3));
			p.setManufacturerID(rs.getInt(4));
			return p;
		}
		
	}
	
	@Autowired
	private DataSource datasource;

	@Override
	public void deleteProduct(int productID) {
		
		String deleteQry = "DELETE FROM PRODUCT WHERE productID=?";
		new JdbcTemplate(datasource).update(deleteQry, productID);
	}
	
	@Override
	public void updateProduct(Product product) {
		String updateQry = "UPDATE PRODUCT SET PRODUCTNAME = ?, PRODUCTAMOUNT = ? MANUFACTURERID = ? WHERE PRODUCTID = ?";
		new JdbcTemplate(datasource).update(updateQry, product.getProductName(),product.getProductAmount(),product.getManufacturerID(),product.getProductID());

	}

	@Override
	public void createProduct(Product product) {

		String createQry = "INSERT INTO PRODUCT (PRODUCTNAME,PRODUCTAMOUNT,MANUFACTURERID) VALUES (?,?,?)";
		new JdbcTemplate(datasource).update(createQry, product.getProductName(),product.getProductAmount(),product.getManufacturerID());
	}

	@Override
	public List<Product> getAllProducts() {

		String selectAllQry = "SELECT PRODUCTNAME,PRODUCTAMOUNT,MANUFACTURERID FROM PRODUCT";
		return new JdbcTemplate(datasource).query(selectAllQry, new ProductRowMapper());

	}

	@Override
	public Product getProduct(int productID) {

		String selectQry = "SELECT PRODUCTID,PRODUCTNAME,PRODUCTAMOUNT,MANUFACTURERID FROM PRODUCT WHERE PRODUCTID = ?";
		return new JdbcTemplate(datasource).queryForObject(selectQry, new ProductRowMapper());

	}

	@Override
	public long countProducts() {

		String countQry = "SELECT COUNT(PRODUCTID) FROM PRODUCT";
		return new JdbcTemplate(datasource).queryForObject(countQry, Long.class);

	}

}
