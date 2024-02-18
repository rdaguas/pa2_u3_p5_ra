package com.uce.edu.funcional;

public class MetodosReferenciados {

	public String obtenerId() {
		// TODO Auto-generated method stub
		String cedula = "1710";
		cedula = cedula + " Provincia";
		return cedula;
	}
	
	public void procesar(String cadena) {
		System.out.println(cadena);
		System.out.println("Se procesa la cadena");
	}
	
	public boolean evaluar(String cadena) {
		return "Roberto".contains(cadena);
	}
	
	public boolean procesar(Integer numero) {
		return 8 == numero;
	}
	
	public Ciudadano cambiar(Empleado empl) {
		Ciudadano ciud = new Ciudadano();
		String nombre= empl.getNombreCompleto().split(" ")[0];
		String apellido= empl.getNombreCompleto().split(" ")[1];
		ciud.setNombre(nombre);
		ciud.setApellido(apellido);
		ciud.setProvincia("Chimborazo");
		return ciud;
	}
	
	public Empleado procesar(Empleado empl) {
		empl.setNombreCompleto(empl.getNombreCompleto()+ " " + empl.getPais());
		empl.setPais(empl.getPais()+ " de Nacimiento");
		return empl;
	}

}
