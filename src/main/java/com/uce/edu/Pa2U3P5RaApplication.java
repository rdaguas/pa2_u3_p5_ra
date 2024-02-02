package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.Habitacion;
import com.uce.edu.ventas.repository.modelo.Hotel;
import com.uce.edu.ventas.service.IFacturaService;
import com.uce.edu.ventas.service.IHotelService;

@SpringBootApplication
public class Pa2U3P5RaApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5RaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("------------------------ INNER JOIN ------------------------");
		List<Hotel> lista = this.hotelService.buscarHotelInnerJoin();
		for (Hotel h : lista) {
			System.out.println(h);
		}
		
		List<Factura> listaf1 = this.facturaService.buscarFacturasInnerJoin();
		for (Factura f : listaf1) {
			System.out.println(f);
		}

		System.out.println("------------------------ RIGTH JOIN ------------------------");
		
		List<Hotel> lista2 = this.hotelService.buscarHotelRightJoin();
		for (Hotel f : lista2) {
			System.out.println(f.getNombre());
		}
		
		List<Factura> listaf2 = this.facturaService.buscarFacturasRightJoin();
		for (Factura f : listaf2) {
			System.out.println(f);
		}
		
		System.out.println("------------------------ LEFT JOIN ------------------------");
		List<Hotel> lista3 = this.hotelService.buscarHotelLeftJoin();
		for (Hotel f : lista3) {
			System.out.println(f);
		}
		
		List<Factura> listaf3 = this.facturaService.buscarFacturasLeftJoin();
		for (Factura f : listaf3) {
			System.out.println(f);
		}
		
		System.out.println("------------------------ FULL JOIN ------------------------");
		List<Hotel> lista4 = this.hotelService.buscarHotelFullJoin();
		for (Hotel f : lista4) {
			System.out.println(f);
			for (Habitacion d : f.getHabitaciones()) {
				System.out.println(d);
			}
		}
		
		List<Factura> listaf4 = this.facturaService.buscarFacturasFullJoin();
		for (Factura f : listaf4) {
			System.out.println(f);
		}
		
		System.out.println("------------------------ FETCH JOIN ------------------------");
		
		List<Factura> listaf5 = this.facturaService.buscarFacturasFetchJoin();
		for (Factura f : listaf5) {
			System.out.println(f.getNumero());
			for (DetalleFactura d : f.getDetalleFacturas()) {
				System.out.println(d.getNombreProducto());
			}
		}
		List<Hotel> lista5 = this.hotelService.buacarHotelFetchJoin();
		for (Hotel f : lista5) {
			System.out.println(f);
		
	}
	}

}
