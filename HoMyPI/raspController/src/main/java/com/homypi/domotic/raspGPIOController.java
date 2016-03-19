package com.homypi.domotic;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class raspGPIOController {

	private GpioController gpio;

	public void encenderCalefaccion() {
		GpioPinDigitalOutput rele1 = getGpio().provisionDigitalOutputPin(RaspiPin.GPIO_16, PinState.LOW);
		GpioPinDigitalOutput rele2 = getGpio().provisionDigitalOutputPin(RaspiPin.GPIO_18, PinState.LOW);
		rele1.high();
		rele2.high();
		
		rele1.low();
		rele2.low();

	}

	public void apagarCalefaccion() {

		GpioPinDigitalOutput rele2 = getGpio().provisionDigitalOutputPin(RaspiPin.GPIO_18, PinState.LOW);

		rele2.low();

	}

	public GpioController getGpio() {
		if (gpio == null) {
			return GpioFactory.getInstance();
		} else {
			return gpio;
		}
	}
	
	
	
	public static void main(String [] args){
		raspGPIOController ra = new raspGPIOController();
		System.out.println("RASP!!!!");
		ra.encenderCalefaccion();
		
	}
	
	

}
