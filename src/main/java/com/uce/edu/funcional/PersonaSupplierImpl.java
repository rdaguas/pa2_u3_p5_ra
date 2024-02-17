package com.uce.edu.funcional;

public class PersonaSupplierImpl<T> implements IPersonaSupplier<String>{

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		String cedula= "1710";
		cedula = cedula + " Provincia";
		return cedula;
	}

}
