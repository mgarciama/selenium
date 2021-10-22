package practica10.ejemplo3_herenciaEntreClases;

public class ProfesorAdjunto implements IProfesor{
//al implementar el interface IProfesor, se añade automaticamente dos más de la clase IPersona porque está heredando entre ellas.
	@Override
	public void mostrarNombre(String name) {
		System.out.println("Nombre: "+ name);
		
	}

	@Override
	public void mostrarDni(String dni) {
		System.out.println("DNI: "+ dni);
		
	}

	@Override
	public void obtenerSalario(String salario) {
		System.out.println("Salario: "+ salario);
		
	}

	@Override
	public void obtenerMateria(String materia) {
		System.out.println("Material/Rama de estudio: "+ materia);
		
	}

}
