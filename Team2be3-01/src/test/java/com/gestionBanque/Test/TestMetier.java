package com.gestionBanque.Test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gestionBanque.Metier.InterMetier;

public class TestMetier {
	
	private static ClassPathXmlApplicationContext context;
	private static InterMetier metier;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		metier=(InterMetier) context.getBean("metier");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
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

	@Test
	public void testVersement() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrait() {
		fail("Not yet implemented");
	}

	@Test
	public void testVirement() {
		fail("Not yet implemented");
	}

}
