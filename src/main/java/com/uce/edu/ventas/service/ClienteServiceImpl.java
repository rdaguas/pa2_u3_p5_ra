package com.uce.edu.ventas.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.IClienteRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
		try {
			this.clienteRepository.insertar(cliente);
			try {
				//buscca
				//valida
				//etc
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RuntimeException e) {
			System.out.println(e.getClass());
		}
	}
	@Transactional(value = TxType.SUPPORTS)
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println("Este es un metodo SUPPORTS");
		System.out.println("Prueba Supports: "+TransactionSynchronizationManager.isActualTransactionActive());

	}
	@Override
	@Transactional(value = TxType.NEVER)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("Este es un metodo NEVER");
		System.out.println("Prueba NEVER: "+TransactionSynchronizationManager.isActualTransactionActive());

	}

}
