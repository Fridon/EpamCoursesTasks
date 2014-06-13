package ua.epamcourses.task1.cars;

import ua.epamcourses.task1.enums.CarModel;

/**
 * 
 * This class is a container which has a car model<br>
 * and state number.
 * 
 * @author Fridon
 *
 */


public class Car {
	private CarModel carModel;
	private String stateNumber;
	
	public CarModel getCarModel() {
		return carModel;
	}

	public String getStateNumber() {
		return stateNumber;
	}

	public Car(CarModel carModel, String stateNumber){
		this.carModel = carModel;
		this.stateNumber = stateNumber;
	}
	
}
