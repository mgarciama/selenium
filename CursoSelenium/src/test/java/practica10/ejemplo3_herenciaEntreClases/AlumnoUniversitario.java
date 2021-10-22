package practica10.ejemplo3_herenciaEntreClases;

public class AlumnoUniversitario implements IAlumno{

	@Override
	public void mostrarNombre(String nombre) {
		System.out.println("nombre del alumno "+ nombre);
		
	}

	@Override
	public void mostrarDni(String dni) {
		System.out.println("DNI del alumno: "+ dni);
		
	}

	@Override
	public void obteneCurso(String curso) {
		System.out.println("Curso del alumno: "+ curso);
		
	}

	@Override
	public void calcularPromedio(int promedio) {
		System.out.println("Nota media "+ promedio);
		
	}

}
