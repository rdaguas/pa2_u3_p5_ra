package com.uce.edu.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Factura seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f WHERE f.numero=:numero",
				Factura.class);
		myQuery.setParameter("numero", numero);
		Factura fact = myQuery.getSingleResult();
		fact.getDetalleFacturas().size();// le digo que cargue el detalle bajo demanda
		return fact;
	}

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> seleccionarFacturasInnerJoin() {
		// TODO Auto-generated method stub
		// SELEC * FROM Factura f inner join detalle_factura d on
		// f.fact_id=d.defa_id_factura
		// JPQL: SELECT f FROM Factura f INNER JOIN f.detalleFactura d
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalleFacturas d",
				Factura.class);
		List<Factura> lista = myQuery.getResultList();
//		for (Factura f : lista) {
//			f.getDetalleFacturas().size();//señal
//		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalleFacturas d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFacturas().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalleFacturas d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFacturas().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFullJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f FULL JOIN f.detalleFacturas d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFacturas().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasWhereJoin() {
		// TODO Auto-generated method stub

		// SQL: SELECT f.* FROM factura f, detalle_factura d
		// WHERE f.fact_id = d.defa_id_factura
		// JPQL: SELECT f FROM Factura f, DetalleFactura
		// d WHERE f.id = d.factura.id

		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM  Factura f, DetalleFactura d WHERE f = d.factura", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFacturas().size();// señal
		}
		return lista;

	}

	@Override
	public List<Factura> seleccionarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f JOIN FETCH f.detalleFacturas d", Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
		
	}

	@Override
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		//SQL: UPDATE factura set fact_fecha=:fechaNueva WHERE fact_fecha >= fechaActual
		//JPQL: UPDATE Factura f SET f.fecha =:fechaNueva WHERE f.fecha >= :fechaActual
		Query myQuery = this.entityManager.createQuery("UPDATE Factura f SET f.fecha= :fechaNueva WHERE f.fecha >= :fechaActual");
		myQuery.setParameter("fechaNueva", fechaNueva);
		myQuery.setParameter("fechaActual", fechaActual);
		return myQuery.executeUpdate();//cantidad de registors afectados/actualizados
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		//	Factura con todos los atributos
		// detalle factura
		// Delete de los detalles
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public int eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("DELETE FROM Factura f WHERE f.numero =:numero");
		myQuery.setParameter("numero", numero);
		return myQuery.executeUpdate();
	}

	public Factura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public List<FacturaDto> seleccionarFacturasDto() {
		// TODO Auto-generated method stub
		TypedQuery<FacturaDto> myQuery = this.entityManager.createQuery("SELECT NEW com.uce.edu.ventas.repository.modelo.dto.FacturaDto(f.numero, f.fecha) FROM Factura f", FacturaDto.class);
		return myQuery.getResultList();
	}

}
