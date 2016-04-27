package com.gestionBanque.Test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gestionBanque.Metier.InterMetier;
import com.gestionBanque.entities.Client;
import com.gestionBanque.entities.Compte;
import com.gestionBanque.entities.Employer;
import com.gestionBanque.entities.Groupe;

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
		context.close();
	}

	@Test
	public void testAddClient() {
		Client c=new Client("dubuc", "jeremy", new Date(), "ici");
		metier.addClient(c);
		assertNotNull(c.getIdClient());
	}

	@Test
	public void testAddEmployer() {
		Employer e=new Employer("MisterA");
		metier.addEmployer(e);
		assertNotNull(e.getIdEmployer());
	}

	@Test
	public void testAddGroupe() {
		Groupe g=new Groupe("test");
		metier.addGroupe(g);
		assertNotNull(g.getIdGroupe());
	}

	@Test
	public void testAddEmpToGro() {
		List<Employer> tab1=metier.getListEmpParGro(1L);
		metier.addEmpToGro(1L, 1L);
		List<Employer> tab2=metier.getListEmpParGro(1L);
		assertTrue(tab2.size()>tab1.size());
	}

	@Test
	public void testAddCompte() {
		Compte c=new Compte(10, new Date());
		metier.addCompte(c, 1L, 1L);
		assertNotNull(c.getIdCompte());
	}

	@Test
	public void testGetListCompte() {
		List<Compte> tab=metier.getListCompte();
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetListComParCli() {
		List<Compte> tab=metier.getListComParCli(1L);
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetListComCreEmp() {
		List<Compte> tab=metier.getListComCreEmp(1L);
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetListEmployer() {
		List<Employer> tab=metier.getListEmployer();
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetListEmpParGro() {
		List<Employer> tab=metier.getListEmpParGro(1L);
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetListGroupe() {
		List<Groupe> tab=metier.getListGroupe();
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetListCliParMc() {
		List<Client> tab=metier.getListCliParMc("d");
		assertTrue(tab.size()>0);
	}

	@Test
	public void testVersement() {
		double solde1=metier.getCompte(1L).getSolde();
		metier.versement(20, new Date(), 1L, 1L);
		double solde2=metier.getCompte(1L).getSolde();
		assertTrue(solde2-solde1==20);
	}

	@Test
	public void testRetrait() throws Exception {
		double solde1=metier.getCompte(1L).getSolde();
		metier.retrait(20, new Date(), 1L, 1L);
		double solde2=metier.getCompte(1L).getSolde();
		assertTrue(solde1-solde2==20);
	}

	@Test
	public void testVirement() throws Exception {
		double solde1a=metier.getCompte(1L).getSolde();
		double solde1b=metier.getCompte(2L).getSolde();
		metier.virement(5, new Date(), 1L, 2L, 1L);
		double solde2a=metier.getCompte(1L).getSolde();
		double solde2b=metier.getCompte(2L).getSolde();
		assertTrue((solde2b-solde1b==5)&&(solde1a-solde2a==5));
	}

}
