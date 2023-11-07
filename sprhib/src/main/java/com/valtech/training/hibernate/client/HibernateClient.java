package com.valtech.training.hibernate.client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.Query;
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;
import com.valtech.training.hibernate.Account;
import com.valtech.training.hibernate.Address;
import com.valtech.training.hibernate.AtmTx;
import com.valtech.training.hibernate.ChequeTx;
import com.valtech.training.hibernate.Customer;
import com.valtech.training.hibernate.Employee;
import com.valtech.training.hibernate.Registration;
import com.valtech.training.hibernate.TellerTx;
import com.valtech.training.hibernate.Tx;

public class HibernateClient {

	public static void main(String[] args) throws HibernateException, ParseException {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(ChequeTx.class).addAnnotatedClass(TellerTx.class).addAnnotatedClass(AtmTx.class);
		cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class).addAnnotatedClass(Account.class);
		cfg.addAnnotatedClass(Registration.class);
		
		org.hibernate.SessionFactory sesFac = cfg.buildSessionFactory();
		org.hibernate.Session ses = sesFac.openSession();
		org.hibernate.Transaction tx = ses.beginTransaction();
		
//		Customer cus = new Customer("Abc",23);
//		ses.save(cus);
//		Address add = new Address("JP nager","Blr",560070);
//		add.setCustomer(cus);
//		ses.save(add);
//		
//		Account acc = new Account(10000,"Savings");
//		Tx tx1 = new Tx(1000);
//		Tx tx2 = new ChequeTx(2000,123123,34435);
//		Tx tx3 = new TellerTx(3000,132345,13456);
//		Tx tx4 = new AtmTx(4000,45767);
//		
//		Account acc1 = new Account(20000,"CA");
//		Tx tx5 = new ChequeTx(2000,456233,468454);
//		
//		Customer cus1 = new Customer("Def",26);
//		Address add1 = new Address("Jayanagar","Blr",560070);
//		Customer cus2 = new Customer("jkk",27);
//		Address add2 = new Address("gandhinagar","hyd",560055);
//		
//		
//		ses.persist(acc);
//		ses.persist(tx1);
//		ses.persist(tx2);
//		ses.persist(tx3);
//		ses.persist(tx4);
//		
//		ses.persist(acc1);
//		ses.persist(tx5);
//		ses.persist(cus1);
//		ses.persist(cus2);
//		ses.persist(add1);
//		ses.persist(add2);
//		
//		cus1.setAddress(add1);
//		add1.setCustomer(cus1);
//		cus2.setAddress(add2);
//		add2.setCustomer(cus2);
//		
//		acc.addTx(tx1);acc.addTx(tx2);acc.addTx(tx3);acc.addTx(tx4);
//		acc1.addTx(tx5);
//		acc1.addCustomer(cus2);acc1.addCustomer(cus);acc1.addCustomer(cus);acc1.addCustomer(cus);acc1.addCustomer(cus);
//		acc.addCustomer(cus1);acc.addCustomer(cus2);acc.addCustomer(cus);
		
//		ses.save();
//		ses.save();
//		ses.save();
//		ses.save();
		
//		ses.createQuery("Select distinct tx.account from Tx tx ").list().forEach(t-> System.out.println(t));
		
//		org.hibernate.Query query = ses.createQuery("SELECT DISTINCT c FROM Customer c join c.accounts a join a.txs t where t.amount >?");
//		query.setFloat(0, 3000);
//		query.list().forEach(t-> System.out.println(t));
		
		org.hibernate.Query query = ses.getNamedQuery("Tx.findAllByCityAndAmountGreaterThan");
//		org.hibernate.Query query = ses.createQuery("SELECT tx from Tx tx JOIN tx.account.customers c WHERE c.address.city = ? AND tx.amount > ?");
		((org.hibernate.Query) query).setString(0,"Blr");
		((org.hibernate.Query) query).setFloat(1,3000);
		((org.hibernate.Query) query).list().forEach(t->System.out.println(t));
		
		
//		ses.persist(new Employee("Abc",df.parse("15-09-1947"),20000,'M',false));
		
		tx.commit();
		ses.close();
		sesFac.close();

	}

}
