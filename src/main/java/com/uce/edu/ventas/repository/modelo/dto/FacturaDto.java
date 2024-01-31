package com.uce.edu.ventas.repository.modelo.dto;

import java.time.LocalDateTime;

public class FacturaDto {
	
	private String numero;
	private LocalDateTime fecha;
	
	
	public FacturaDto() {
		
	}
	
	
	public FacturaDto(String numero, LocalDateTime fecha) {
		super();
		this.numero = numero;
		this.fecha = fecha;
	}



	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "FacturaDto [numero=" + numero + ", fecha=" + fecha + "]";
	}

	

}
