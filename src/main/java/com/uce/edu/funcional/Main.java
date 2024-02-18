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
		System.out.println("-------------------------------  Metodos Referenciados  -------------------------------");
		MetodosReferenciados met = new MetodosReferenciados();
		IPersonaSupplier<String> supplierLambda4 = met::obtenerId;
		System.out.println(supplierLambda4.getId());

		System.out.println("          ");
		System.out.println("          ");
		System.out.println("          ");

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
		System.out.println("-------------------------------  Metodos Referenciados  -------------------------------");
		IPersonaConsumer<String> consumer2 = met::procesar;
		consumer2.accept("Roberto Referenciado");

		System.out.println("  ");
		System.out.println("  ");
		System.out.println("  ");

		// 3. Predicate
		System.out.println("******************************** PREDICATE *************************************");
		// Implementacion mediante LAMBDA
		System.out.println("-------------------------------  LAMBDA  -------------------------------");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(8)));

		IPersonaPredicate<String> predicateLambda1 = letra -> "Roberto".contains(letra);

		System.out.println(predicateLambda1.evaluar("o"));

		// Implementacion mediante Metodos Referenciados
		System.out.println("-------------------------------  Metodos Referenciados  -------------------------------");
		IPersonaPredicate<String> predicateMR = met::evaluar;
		System.out.println(predicateMR.evaluar("o"));

		IPersonaPredicate<Integer> predicateMR2 = met::procesar;
		System.out.println(predicateMR2.evaluar(8));

		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");

		// 4. Function
		System.out.println("******************************** FUCTION *************************************");
		// Implementacion mediante LAMBDA
		System.out.println("-------------------------------  LAMBDA  -------------------------------");
		IPersonaFunction<String, Integer> functionLambda = numero -> {
			numero = numero + Integer.valueOf(10);
			String numeroString = numero.toString().concat(" -Valor");
			return numeroString;
		};
		System.out.println(functionLambda.aplicar(7));

		IPersonaFunction<Empleado, Ciudadano> functionLambda1 = ciudadano -> {
			Empleado empl = new Empleado();
			empl.setNombreCompleto(ciudadano.getNombre() + " " + ciudadano.getApellido());
			if (ciudadano.getProvincia().compareTo("pichincha") == 0) {
				empl.setPais("Ecuador");
			}
			return empl;
		};

		Ciudadano ciud = new Ciudadano();
		ciud.setApellido("Aguas");
		ciud.setNombre("Roberto");
		ciud.setProvincia("pichincha");

		Empleado empl = functionLambda1.aplicar(ciud);
		System.out.println(empl);

		// Implementacion mediante Metodos Referenciados
		System.out.println("-------------------------------  Metodos Referenciados  -------------------------------");
		Empleado empl2 = new Empleado();
		empl2.setNombreCompleto("Daniel Valencia");
		empl2.setPais("Inglaterra");
		IPersonaFunction<Ciudadano, Empleado> fuctionMR = met::cambiar;
		System.out.println(fuctionMR.aplicar(empl2));

		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");

		// 5. UNARY OPERATOR
		System.out.println("******************************** UNARY OPERATOR *************************************");
		// Implementacion mediante LAMBDA
		System.out.println("-------------------------------  LAMBDA  -------------------------------");
		IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> numero + (numero * 2);
		System.out.println(unaryOperatorLambda.aplicar(14));

		IPersonaUnaryOperatorFunction<Integer> unaryOperatorFunctionLambda = numero -> numero + (numero * 3);
		System.out.println(unaryOperatorFunctionLambda.aplicar(14));

		// Implementacion mediante Metodos Referenciados
		System.out.println("-------------------------------  Metodos Referenciados  -------------------------------");
		IPersonaUnaryOperatorFunction<Empleado> unary3 = met::procesar;
		Empleado empl3 = unary3.aplicar(empl2);
		System.out.println(empl3);
	}

}
