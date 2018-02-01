package com.yspaper;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.yspaper.delivery.model.Item;
import com.yspaper.delivery.model.Order;

public class AppTest {

	private static final String PERSISTENCE_UNIT_NAME = "yspaper-jpa";
	private static EntityManagerFactory factory;

	@Test
	public void testApp() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		// read the existing entries and write to console
		Query q = em.createQuery("select o from Order o");
		List<Object> orderList = q.getResultList();
		for (Object order : orderList) {
			System.out.println(order);
		}
		System.out.println("Size: " + orderList.size());

		// create new order
		em.getTransaction().begin();
		Order order = new Order();
		order.setCustomer("FengWo");
		order.setDocumentDate(new java.util.Date().getTime());
		em.persist(order);
		em.getTransaction().commit();

		// read the existing entries and write to console
		Query itemQ = em.createQuery("select i from Item i");
		List<Object> itemList = itemQ.getResultList();
		for (Object item : itemList) {
			System.out.println(item);
		}
		System.out.println("Size: " + itemList.size());

		// create new order
		em.getTransaction().begin();
		Item item = new Item();
		item.setProduct("1200");
		item.setQuantity(new BigDecimal(1));
		em.persist(item);
		em.getTransaction().commit();

		em.close();
	}
}
