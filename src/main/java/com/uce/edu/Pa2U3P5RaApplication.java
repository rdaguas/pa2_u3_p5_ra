package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5RaApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5RaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Factura fac = new Factura();
		fac.setCedula("1710441617");
		fac.setFecha(LocalDateTime.now());
		fac.setNumero("0001-44334");
		// this.facturaService.guardar(fac);

		DetalleFactura det1 = new DetalleFactura();
		det1.setCantidad(44);
		det1.setCodigoBarras("565656");
		det1.setFactura(fac);
		det1.setNombreProducto("Gomitas");

		DetalleFactura det2 = new DetalleFactura();
		det2.setCantidad(99);
		det2.setCodigoBarras("223344");
		det2.setFactura(fac);
		det2.setNombreProducto("Cachitos");

		DetalleFactura det3 = new DetalleFactura();
		det3.setCantidad(25);
		det3.setCodigoBarras("7788877");
		det3.setFactura(fac);
		det3.setNombreProducto("Comida para Perro");

		List<DetalleFactura> detalle = new ArrayList<>();
		detalle.add(det1);
		detalle.add(det2);
		detalle.add(det3);
		fac.setDetalleFacturas(detalle);

//		//this.facturaService.guardar(fac);
//		Factura fac1 = this.facturaService.buscarPorNumero("0001-0234");
//		for(DetalleFactura det : fac1.getDetalleFacturas()) {
//			System.out.println(det.getCodigoBarras());
//		}
//		System.out.println(fac1);
//		

		System.out.println("------------------------------- INNER JOIN ------------------------------------");

		List<Factura> lista = this.facturaService.buscarFacturasInnerJoin();
		for (Factura f : lista) {
			System.out.println(f);
		}
		System.out.println("------------------------------- RIGHT JOIN ------------------------------------");
		List<Factura> lista2 = this.facturaService.buscarFacturasRightJoin();
		for (Factura f : lista2) {
			System.out.println(f.getNumero());
		}
		System.out.println("------------------------------- LEFT JOIN ------------------------------------");
		List<Factura> lista3 = this.facturaService.buscarFacturasLeftJoin();
		for (Factura f : lista3) {
			System.out.println(f);
		}

		System.out.println("------------------------------- FULL JOIN ------------------------------------");
		List<Factura> lista4 = this.facturaService.buscarFacturasFullJoin();
		for (Factura f : lista4) {
			System.out.println(f);
			for (DetalleFactura d : f.getDetalleFacturas()) {
				System.out.println(d);
			}
		}

	}

}
