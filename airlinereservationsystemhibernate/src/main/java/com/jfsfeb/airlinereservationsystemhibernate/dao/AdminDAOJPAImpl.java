package com.jfsfeb.airlinereservationsystemhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jfsfeb.airlinereservationsystemhibernate.dto.BookingStatus;
import com.jfsfeb.airlinereservationsystemhibernate.dto.FlightDetails;
import com.jfsfeb.airlinereservationsystemhibernate.dto.User;
import com.jfsfeb.airlinereservationsystemhibernate.exception.ARSException;

public class AdminDAOJPAImpl implements AdminDAO{

	EntityManagerFactory factory = null;
	@Override
	public boolean registerAdmin(User admin) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(admin);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new ARSException("Admin Already Exists Or Admin Can't Be added");
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public User authenticateAdmin(String email, String password) {
		EntityManager manager = null;
		factory = Persistence.createEntityManagerFactory("TestPersistence");
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
			factory.close();
		}
	}

	@Override
	public boolean addFlights(FlightDetails flightDetails) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(flightDetails);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new ARSException("Flight Details already Exists ");
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public boolean removeFlight(int flightId) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			FlightDetails flightDetails = manager.find(FlightDetails.class, flightId);
			manager.remove(flightDetails);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new ARSException("Flight Can't Be Removed or Deleted from flight Details");
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public List<FlightDetails> searchFlightByName(String flightname) {
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "Select f from FlightDetails f where flightName=:name";
			TypedQuery<FlightDetails> query = manager.createQuery(jpql, FlightDetails.class);
			  query.setParameter("name",flightname);
			List<FlightDetails> recordList = query.getResultList();
			for (int i = 0; i < recordList.size()-1; i++) {
				recordList.get(i);
			}
			manager.close();
			factory.close();
			return recordList;
		}catch (Exception e) {
			e.printStackTrace();
			
		}

		return null;
	}

	@Override
	public List<FlightDetails> searchFlightBySource(String source) {
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "Select f from FlightDetails f where source=:source";
			TypedQuery<FlightDetails> query = manager.createQuery(jpql, FlightDetails.class);
			  query.setParameter("source",source);
			List<FlightDetails> recordList = query.getResultList();
			for (int i = 0; i < recordList.size()-1; i++) {
				recordList.get(i);
			}
			manager.close();
			factory.close();
			return recordList;
		}catch (Exception e) {
			e.printStackTrace();
			
		}

		return null;
	}

	@Override
	public List<FlightDetails> searchFlightByDestination(String destination) {
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "Select f from FlightDetails f where destination=:destination";
			TypedQuery<FlightDetails> query = manager.createQuery(jpql, FlightDetails.class);
			  query.setParameter("destination",destination);
			List<FlightDetails> recordList = query.getResultList();
			for (int i = 0; i < recordList.size()-1; i++) {
				recordList.get(i);
			}
			manager.close();
			factory.close();
			return recordList;
		}catch (Exception e) {
			e.printStackTrace();
			
		}

		return null;
	}

	@Override
	public List<FlightDetails> getFlightDetails() {
		EntityManager manager = null;
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select f from FlightDetails f";
		TypedQuery<FlightDetails> query = manager.createQuery(jpql, FlightDetails.class);
		List<FlightDetails> recordlist = query.getResultList();
		manager.close();
		factory.close();
		return recordlist;
	}

	@Override
	public List<BookingStatus> getBookingStatus() {
		
		return null;
	}

}
