package ua.epamcourses.task1.systems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import ua.epamcourses.task1.cars.Car;
import ua.epamcourses.task1.enums.CarModel;
import ua.epamcourses.task1.enums.Parameter;


public class Taxi {
	SupplyDepartment supplyDepartment;
	ArrayList<Car> register;
	
	public Taxi(){
		supplyDepartment = SupplyDepartment.getInstance();
		register = new ArrayList<Car>();
	}
	
	
	/**
	 * This method adds car to register.
	 * @param carModel Model of car to add
	 */
	public void addCar(CarModel carModel){
		Car temp = supplyDepartment.buyCar(carModel);
		register.add(temp);
	}
	
	/**
	 * This method returns ArrayList of added cars(copy of register).
	 * @param carModel Model of car to add
	 */
	public ArrayList<Car> getCarRegister(){
		ArrayList<Car> temp = new ArrayList<Car>(register);
		return temp;
	}
	
	/**
	 * This method calculates summary cost of all cars.
	 * @return Summary cost
	 */
	public int costOfAllCars(){
		int temp = 0;
		for(Car car:register){
			temp += car.getCarModel().getCost();
		}	
		return temp;
	}
	
	/**
	 * This method creates copy of register and returns sorted list of cars.
	 * @param parameter Spesified parameter to sort
	 */
	public ArrayList<Car> sort(Parameter parameter){
		ArrayList<Car> temp = new ArrayList<Car>(register);
		Collections.sort(temp, parameter.getComparator());
		return temp;
	}
	
	/**
	 * This method returns ArrayList,<br>
	 * which contains cars with max speed,<br>
	 * what lays between specified min and max speed
	 * 
	 * @param minSpeed
	 * @param maxSpeed
	 * @return
	 */
	public ArrayList<Car> findBySpeed(int minSpeed, int maxSpeed){
		ArrayList<Car> temp  = new ArrayList<Car>();
		for(Car car:register){
			int speed = car.getCarModel().getMaxSpeed();
			if(speed >= minSpeed && speed <= maxSpeed)
				temp.add(car);
		}
		return temp;
	}
	
	
}
