package com.uce.edu.funcional;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. Supplier
		System.out.println("******************************** SUPPLIER *************************************");
		// Implementacion mediante CLASES
		System.out.println("-------------------------------  CLASES  -------------------------------");
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl<>();
		System.out.println(supplierClase.getId());

		// Implementacion mediante LAMDAS
		System.out.println("-------------------------------  LAMBDAS  -------------------------------");

		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula = "1710";
			cedula = cedula + " Canton";
			return cedula;
		};
		System.out.println(supplierLambda.getId());

		IPersonaSupplier<String> supplierLambda2 = () -> "1710" + " Pais";
		System.out.println(supplierLambda2.getId());

		IPersonaSupplier<Integer> supplierLambda3 = () -> {
			Integer valor1 = Integer.valueOf(100);
			valor1 = valor1 * Integer.valueOf(50) / Integer.valueOf(5);
			return valor1;
		};
		System.out.println(supplierLambda3.getId());

		// Implementacion mediante Metodos Referenciados
		
		
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");


		// 2. Consumer
		System.out.println("******************************** CONSUMER *************************************");
		// Implementacion mediante CLASES
		System.out.println("-------------------------------  CLASES  -------------------------------");
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");
		
		// Implementacion mediante LAMBDA
		System.out.println("-------------------------------  LAMBDA  -------------------------------");
		IPersonaConsumer<String> consumerLambda = cadena -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("Licenciado");

		// Implementacion mediante Metodos Referenciados
		
		
		
		
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		
		//3. Predicate
		System.out.println("******************************** PREDICATE *************************************");
		// Implementacion mediante LAMBDA
		System.out.println("-------------------------------  LAMBDA  -------------------------------");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7)==0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(8)));
		
		IPersonaPredicate<String> predicateLambda1 = letra ->"Roberto".contains(letra);

		System.out.println(predicateLambda1.evaluar("o"));
		
		
		
	}

}
