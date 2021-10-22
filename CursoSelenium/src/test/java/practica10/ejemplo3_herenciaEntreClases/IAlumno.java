package practica10.ejemplo3_herenciaEntreClases;

//extends hereda de la clase IPersona, cuando son interface, herencia entre interfaces
//significa que tendran los mismos metodos de IAlumno y IPerona
public interface IAlumno extends IPersona{
	
	void obteneCurso(String curso);
	void calcularPromedio(int promedio);
}
