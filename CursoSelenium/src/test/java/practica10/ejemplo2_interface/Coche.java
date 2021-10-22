package practica10.ejemplo2_interface;

public class Coche implements IVehiculo{

	@Override
	public void encender() {
		System.out.println("Se enciende el Coche");
		
	}

	@Override
	public void girar() {
		System.out.println("Gira el Coche");
		
	}

	@Override
	public void apagar() {
		System.out.println("Se apaga el Coche");
		
	}

	@Override
	public void acelerar() {
		System.out.println("Acelera el Coche");
		
	}

	@Override
	public void frenar() {
		System.out.println("frena el Coche");
		
	}

}
