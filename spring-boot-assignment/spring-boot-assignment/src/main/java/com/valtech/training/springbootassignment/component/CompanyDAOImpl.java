package com.valtech.training.springbootassignment.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CompanyDAOImpl implements CompanyDAO {

	public class CompanyRowMapper implements RowMapper<Company>{

		@Override
		public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
			Company c = new Company();
			c.setCompanyID(rs.getInt(1));
			c.setCompanyName(rs.getString(2));
			c.setCompanyAddr(rs.getString(3));
			return c;
		}
		

	}

	@Autowired
	private DataSource datasource;

	@Override
	public void deleteCompany(int companyID) {
		
		String deleteQry = "DELETE FROM COMPANY WHERE companyID=?";
		new JdbcTemplate(datasource).update(deleteQry, companyID);
	}
	
	@Override
	public void updateCompany(Company company) {
		String updateQry = "UPDATE COMPANY SET COMPANYNAME = ?, COMPANYADDR = ? WHERE COMPANYID = ?";
		new JdbcTemplate(datasource).update(updateQry, company.getCompanyName(), company.getCompanyAddr(), company.getCompanyID());

	}

	@Override
	public void createCompany(Company company) {

		String createQry = "INSERT INTO COMPANY (COMPANYNAME,COMPANYADDR) VALUES (?,?)";
		new JdbcTemplate(datasource).update(createQry, company.getCompanyName(),company.getCompanyAddr());
	}

	@Override
	public List<Company> getAllCompanies() {

		String selectAllQry = "SELECT COMPANYID,COMPANYNAME,COMPANYADDR FROM COMPANY";
		return new JdbcTemplate(datasource).query(selectAllQry, new CompanyRowMapper());

	}

	@Override
	public Company getCompany(int companyID) {

		String selectQry = "SELECT COMPANYID,COMPANYNAME,COMPANYADDR FROM COMPANY WHERE COMPANYID = ?";
		return new JdbcTemplate(datasource).queryForObject(selectQry, new CompanyRowMapper());

	}

	@Override
	public long countCompanies() {

		String countQry = "SELECT COUNT(COMPANYID) FROM COMPANY";
		return new JdbcTemplate(datasource).queryForObject(countQry, Long.class);

	}
}
