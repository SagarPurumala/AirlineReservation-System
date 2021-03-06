package com.jfsfeb.airlinereservationsystemspring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jfsfeb.airlinereservationsystemspring.bean.BookingDetails;
import com.jfsfeb.airlinereservationsystemspring.bean.FlightDetails;
import com.jfsfeb.airlinereservationsystemspring.exception.ARSException;


@Repository
public class AdminDAOJPAImpl implements AdminDAO{
    @PersistenceUnit
	EntityManagerFactory factory = null;
	
	@Override
	public boolean addFlights(FlightDetails flightDetails) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			
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
			
		}
	}

	@Override
	public boolean removeFlight(int flightId) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			
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
			
		}
	}

	@Override
	public List<FlightDetails> searchFlightByName(String flightname) {
		EntityManager manager = null;
		try {
			
			manager = factory.createEntityManager();
			String jpql = "Select f from FlightDetails f where flightName=:name";
			TypedQuery<FlightDetails> query = manager.createQuery(jpql, FlightDetails.class);
			  query.setParameter("name",flightname);
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

	@Override
	public List<FlightDetails> searchFlightBySource(String source) {
		EntityManager manager = null;
		try {
			
			manager = factory.createEntityManager();
			String jpql = "Select f from FlightDetails f where source=:source";
			TypedQuery<FlightDetails> query = manager.createQuery(jpql, FlightDetails.class);
			  query.setParameter("source",source);
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

	@Override
	public List<FlightDetails> searchFlightByDestination(String destination) {
		EntityManager manager = null;
		try {
			
			manager = factory.createEntityManager();
			String jpql = "Select f from FlightDetails f where destination=:destination";
			TypedQuery<FlightDetails> query = manager.createQuery(jpql, FlightDetails.class);
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
	public List<BookingDetails> getBookingStatus() {
		EntityManager manager = null;
		
		manager = factory.createEntityManager();
		String jpql = "select b from BookingDetails b";
		TypedQuery<BookingDetails> query = manager.createQuery(jpql, BookingDetails.class);
		List<BookingDetails> recordlist = query.getResultList();
		manager.close();
		
		return recordlist;
	}

}
