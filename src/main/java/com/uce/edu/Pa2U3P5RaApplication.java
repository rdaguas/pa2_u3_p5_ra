package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.IClienteRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5RaApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private IClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5RaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		
		
		Factura fact = new Factura();
		fact.setNumero("001-007");
		fact.setCedula("12241090");
		fact.setFecha(LocalDateTime.now());
		
		
		Cliente clie = new Cliente();
		clie.setApellido(null);
		clie.setNombre("Jesus");
		this.facturaService.guardar(fact, clie);
	}

}
