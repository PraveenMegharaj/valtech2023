package com.valtech.training.springbootassignment.component;

import java.util.List;

public interface CompanyDAO {

	void deleteCompany(int companyID);

	void updateCompany(Company company);

	void createCompany(Company company);

	List<Company> getAllCompanies();

	Company getCompany(int companyID);

	long countCompanies();

}