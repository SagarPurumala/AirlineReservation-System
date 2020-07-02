package com.jfsfeb.airlinereservationsystemspring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jfsfeb.airlinereservationsystemspring.bean.FlightDetails;
import com.jfsfeb.airlinereservationsystemspring.bean.User;
import com.jfsfeb.airlinereservationsystemspring.exception.ARSException;

@Repository
public class AirlineDAOJPAImpl implements AirlineDAO{
	@PersistenceUnit
	EntityManagerFactory factory;
	@Override
	public boolean register(User admin) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(admin);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new ARSException("User or Admin Already Exists Or User or Admin Can't Be added");
		} finally {
			manager.close();

		}
	}

	@Override
	public User authenticate(String email, String password) {
		EntityManager manager = null;
		
		manager = factory.createEntityManager();
		String jpql = "select u from  User u where u.emailId = :emailId and u.password =:password";
		TypedQuery<User> query = manager.createQuery(jpql, User.class);
		query.setParameter("emailId", email);
		query.setParameter("password", password);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			throw new ARSException("Invalid Login Credentials, Please Enter Correctly");
		} finally {
			manager.close();
			
		}
	}

	@Override
	public List<FlightDetails> getFlightDetails() {
		EntityManager manager = null;
		manager = factory.createEntityManager();
		String jpql = "select f from FlightDetails f";
		TypedQuery<FlightDetails> query = manager.createQuery(jpql, FlightDetails.class);
		List<FlightDetails> recordlist = query.getResultList();
		manager.close();
		return recordlist;
	}

	@Override
	public List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination) {
		EntityManager manager = null;
		try {

			manager = factory.createEntityManager();
			String jpql = "Select f from FlightDetails f where source=:source and destination=:destination";
			TypedQuery<FlightDetails> query = manager.createQuery(jpql, FlightDetails.class);
			 query.setParameter("source",source);
			  query.setParameter("destination",destination);
			List<FlightDetails> recordList = query.getResultList();
			for (int i = 0; i < recordList.size()-1; i++) {
				recordList.get(i);
			}
			manager.close();
			
			return recordList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
