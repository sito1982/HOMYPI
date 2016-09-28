package com.homypi.domotic;

public class SerialCallMain {
	
	public static void main(String[] args) {

		if (args.length == 1) {
			String accion = args[0];

			if (accion.equals(SerialRaspberryController.APAGAR)) {
				SerialRaspberryController.genericSerialRequest(SerialRaspberryController.APAGAR);
			}
			if (accion.equals(SerialRaspberryController.ENCENDER)) {
				SerialRaspberryController.genericSerialRequest(SerialRaspberryController.ENCENDER);
			}
			if (accion.equals(SerialRaspberryController.GET_CONSUMO)) {
				SerialRaspberryController.genericSerialRequest(SerialRaspberryController.GET_CONSUMO);
			}
			if (accion.equals(SerialRaspberryController.GET_TEMPERATURA)) {
				SerialRaspberryController.genericSerialRequest(SerialRaspberryController.GET_TEMPERATURA);
			}
		}
	}

}
