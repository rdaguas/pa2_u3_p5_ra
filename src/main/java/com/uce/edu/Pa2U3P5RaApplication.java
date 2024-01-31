package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDto;
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

		System.out.println("------------------------ UPDATE ------------------------");

		int cantidad = this.facturaService.actualizarFechas(LocalDateTime.of(2020, 1, 15, 12, 50),
				LocalDateTime.of(2024, 1, 24, 10, 49));
		System.out.println("cantidad de registros Actualizados: " + cantidad);

		System.out.println("------------------------ DELETE ------------------------");

		int cantidad2 = this.facturaService.borrarPorNumero("0001-44334");
		System.out.println("cantidad de registros ELIMINADOS: " + cantidad2);

		System.out.println("------------------------ ELIMINAR A PARTIR DEL ID ------------------------");
		//this.facturaService.borrar(1);
		
		System.out.println("------------------------ POR FACTURA DTO ------------------------");
		List<FacturaDto> listaDto =this.facturaService.buscarFacturasDto();
		for(FacturaDto fDto : listaDto) {
			System.out.println(fDto);
		}

	}

}
