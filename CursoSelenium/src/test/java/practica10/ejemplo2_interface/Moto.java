package practica10.ejemplo2_interface;

public class Moto implements IVehiculo {

	@Override
	public void encender() {
		System.out.println("Se enciende la Moto");
		
	}

	@Override
	public void girar() {
		System.out.println("Gira la Moto");
		
	}

	@Override
	public void apagar() {
		System.out.println("Se apaga la Moto");
		
	}

	@Override
	public void acelerar() {
		System.out.println("Acelera la Moto");
		
	}

	@Override
	public void frenar() {
		System.out.println("Frena la Moto");
		
	}

	

}
