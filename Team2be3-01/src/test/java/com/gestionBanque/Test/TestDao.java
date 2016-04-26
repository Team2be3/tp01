package com.gestionBanque.Test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gestionBanque.DAO.InterDao;

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
		fail("Not yet implemented");
	}

	@Test
	public void testAddEmployer() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddGroupe() {
		fail("Not yet implemented");
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
