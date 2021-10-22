package practica10.ejemplo2_interface;

public class Auto {

	public static void main(String[] args) {
	IVehiculo ivCoche = new Coche();
	IVehiculo ivMoto = new Moto();
	ivCoche.encender();
	ivCoche.acelerar();
	ivCoche.girar();
	ivCoche.frenar();
	ivCoche.apagar();
	
	
	ivMoto.encender();
	ivMoto.acelerar();
	ivMoto.frenar();
	ivMoto.apagar();
	}

}
