package com.valtech.training.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.hibernate.Employee;

@Transactional
@Repository // All DAO Classes will be defined using the Respository
//@Service for all classes that are service class.. they will need Tx support
//@Controller for all classes when we want them to be used for Presentation logic
//@Component They are general classses which have to be registered with the BeanFactory
public class EmployeeDAOImpl implements EmployeeDAO {

	private SessionFactory sessionFactory;
	
	@Override
	public void deleteEmployee(Employee emp) {
		Session ses = sessionFactory.getCurrentSession();
		ses.delete(emp);
	}
	
	@Override
	public Employee saveEmployee(Employee emp) {
		Session ses = sessionFactory.getCurrentSession();
		ses.persist(emp);
		return emp;
	}
	
	@Override
	public Employee loadEmployee(int empId) {
		Session ses = sessionFactory.getCurrentSession();
		Employee emp = (Employee) ses.load(Employee.class, empId);
		return emp;
	}
	
	@Override
	public Employee updateEmployee(Employee emp) {
		Session ses = sessionFactory.getCurrentSession();
		emp = (Employee)ses.merge(emp);
		return emp;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		Session ses = sessionFactory.getCurrentSession();
		List<Employee> emps = ses.createQuery("from Employee e").list();
		return emps;
	}
 	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
