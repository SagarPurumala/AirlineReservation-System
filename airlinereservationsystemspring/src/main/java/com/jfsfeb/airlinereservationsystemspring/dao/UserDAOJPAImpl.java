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
import com.jfsfeb.airlinereservationsystemspring.bean.User;
import com.jfsfeb.airlinereservationsystemspring.exception.ARSException;

@Repository
public class UserDAOJPAImpl implements UserDAO {
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public List<FlightDetails> searchFlightByName(String flightname) {
		EntityManager manager = null;
		try {

			manager = factory.createEntityManager();
			String jpql = "Select f from FlightDetails f where flightName=:name";
			TypedQuery<FlightDetails> query = manager.createQuery(jpql, FlightDetails.class);
			query.setParameter("name", flightname);
			List<FlightDetails> recordList = query.getResultList();
			for (int i = 0; i < recordList.size() - 1; i++) {
				recordList.get(i);
			}
			manager.close();

			return recordList;
		} catch (Exception e) {
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
			query.setParameter("source", source);
			List<FlightDetails> recordList = query.getResultList();
			for (int i = 0; i < recordList.size() - 1; i++) {
				recordList.get(i);
			}
			manager.close();

			return recordList;
		} catch (Exception e) {
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
			query.setParameter("destination", destination);
			List<FlightDetails> recordList = query.getResultList();
			for (int i = 0; i < recordList.size() - 1; i++) {
				recordList.get(i);
			}
			manager.close();

			return recordList;
		} catch (Exception e) {
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
	public BookingDetails bookRequest(BookingDetails BookingDetails) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		FlightDetails flightDetails = new FlightDetails();
		User user = new User();
		int flightId = 0;
		int userId = 0;
		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			flightDetails = manager.find(FlightDetails.class, BookingDetails.getFlightId());

			if (flightDetails != null) {
				flightId = flightDetails.getFlightId();
				transaction.commit();
				if (flightId == BookingDetails.getFlightId()) {
					transaction.begin();
					user = manager.find(User.class, BookingDetails.getId());
					if (user != null) {
						userId = user.getId();
						transaction.commit();
						if (userId == BookingDetails.getId()) {
							transaction.begin();
							manager.persist(BookingDetails);
							transaction.commit();
						}
					} else {
						throw new ARSException("Invalid Request, User ID Not Found");
					}
				}

			} else {
				throw new ARSException("Invalid Request, Flight ID Not Found");
			}
		} catch (ARSException e) {
			throw new ARSException(e.getMessage());
		} finally {
			manager.close();

		}

		return null;
	}

	@Override
	public List<FlightDetails> searchFlightBySourceAndDestination(String source, String destination) {
		EntityManager manager = null;
		try {

			manager = factory.createEntityManager();
			String jpql = "Select f from FlightDetails f where source=:source and destination=:destination";
			TypedQuery<FlightDetails> query = manager.createQuery(jpql, FlightDetails.class);
			query.setParameter("source", source);
			query.setParameter("destination", destination);
			List<FlightDetails> recordList = query.getResultList();
			for (int i = 0; i < recordList.size() - 1; i++) {
				recordList.get(i);
			}
			manager.close();

			return recordList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean cancelTicket(int ticketId) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookingDetails BookingDetails = manager.find(BookingDetails.class, ticketId);
			manager.remove(BookingDetails);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new ARSException("TicketId Can't Be Removed or Deleted from Booking Details");
		} finally {
			manager.close();
		}
	}

	@Override
	public List<BookingDetails> getTicketDetails(int userId) {
		EntityManager manager = null;
		try {

			manager = factory.createEntityManager();
			String jpql = "Select f from BookingDetails f where f.id=:id";
			TypedQuery<BookingDetails> query = manager.createQuery(jpql, BookingDetails.class);
			query.setParameter("id", userId);
			List<BookingDetails> recordList = query.getResultList();
			for (int i = 0; i < recordList.size() - 1; i++) {
				recordList.get(i);
			}
			manager.close();

			return recordList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
