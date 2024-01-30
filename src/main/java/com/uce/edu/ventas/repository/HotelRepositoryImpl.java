package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Transactional
@Repository
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public List<Hotel> seleccionarHotelInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT f FROM Hotel f JOIN f.habitaciones d", Hotel.class);
		List<Hotel> lista = myQuery.getResultList();
		for(Hotel f: lista) {
			f.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHotelRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT f FROM Hotel f RIGHT JOIN f.habitaciones d", Hotel.class);
		List<Hotel> lista = myQuery.getResultList();
		for(Hotel f: lista) {
			f.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHotelLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT f FROM Hotel f LEFT JOIN f.habitaciones d", Hotel.class);
		List<Hotel> lista = myQuery.getResultList();
		for(Hotel f: lista) {
			f.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHotelFullJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT f FROM Hotel f FULL JOIN f.habitaciones d", Hotel.class);
		List<Hotel> lista = myQuery.getResultList();
		for(Hotel f: lista) {
			f.getHabitaciones().size();
		}
		return lista;
	}

}
