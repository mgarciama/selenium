package practica10.ejemplo3_herenciaEntreClases;

public class Universidad {

	public static void main(String[] args) {
		IProfesor iprofesorMatematicas = new ProfesorAdjunto();
		IAlumno ialumno = new AlumnoUniversitario();
		System.out.println("**************************\n profesor:");
		iprofesorMatematicas.mostrarNombre("Jose Francisco");
		iprofesorMatematicas.mostrarDni("05123648-B");
		iprofesorMatematicas.obtenerMateria("Rama de Matemáticas");
		iprofesorMatematicas.obtenerSalario("3000€");
		System.out.println("**************************\n Alumno:");
		ialumno.mostrarNombre("Manuel");
		ialumno.mostrarDni("05610970 - B");
		ialumno.obteneCurso("Matemática");
		ialumno.calcularPromedio(7);

	}

}
