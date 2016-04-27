package com.gestionBanque.Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gestionBanque.DAO.InterDao;
import com.gestionBanque.entities.Client;
import com.gestionBanque.entities.Employer;
import com.gestionBanque.entities.Groupe;

public class TestDao {
	
	private static ClassPathXmlApplicationContext context;
	private static InterDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		dao=(InterDao) context.getBean("dao");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddClient() {
		Client c=new Client("Rengassamy","Alex",new Date(),"rue de figuig");
		dao.addClient(c);
		assertNotNull(c.getIdClient());
	}

	@Test
	public void testAddEmployer() {
		Employer e= new Employer("Dubuc");
		dao.addEmployer(e);
		assertNotNull(e.getIdEmployer());
	}

	@Test
	public void testAddGroupe() {
		Groupe g= new Groupe("Les boss");
		dao.addGroupe(g);
		assertNotNull(g.getIdGroupe());
	}

	@Test
	public void testAddEmpToGro() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCompte() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddOperation() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListCompte() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListComParCli() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListComCreEmp() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListEmployer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListEmpParGro() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListGroupe() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListCliParMc() {
		fail("Not yet implemented");
	}

}
