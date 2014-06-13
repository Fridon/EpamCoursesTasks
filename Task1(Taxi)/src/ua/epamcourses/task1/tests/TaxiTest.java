package ua.epamcourses.task1.tests;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.epamcourses.task1.cars.Car;
import ua.epamcourses.task1.enums.CarModel;
import ua.epamcourses.task1.enums.Parameter;
import ua.epamcourses.task1.systems.Taxi;

public class TaxiTest {
	
	static Taxi taxi;
	
	@BeforeClass
	public static void init(){
		taxi = new Taxi();
		for(CarModel car:CarModel.values()){
			taxi.addCar(car);
		}
	}
	
	
	@Test
	public void CostOfAll_EachCarAddedToRegister_ResultExpected() {
		int expected = 320000;
		int result = taxi.costOfAllCars();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void GetCarRegister_EachCarAddedToRegister_FirstCarSprinterExpected(){
		CarModel expected = CarModel.MERSEDES_SPRINTER;
		ArrayList<Car> register = taxi.getCarRegister();
		CarModel result = register.get(0).getCarModel();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void GetCarRegister_EachCarAddedToRegister_SecondCarOktaviaExpected(){
		CarModel expected = CarModel.SKODA_OCTAVIA;
		ArrayList<Car> register = taxi.getCarRegister();
		CarModel result = register.get(1).getCarModel();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void GetCarRegister_EachCarAddedToRegister_LastCarAveoExpected(){
		CarModel expected = CarModel.CHEVROLET_AVEO;
		ArrayList<Car> register = taxi.getCarRegister();
		CarModel result = register.get(register.size()-1).getCarModel();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void Sort_EachCarAddedToRegister_SortByCost_FirstCarPobedaExpected(){
		ArrayList<Car> temp = taxi.sort(Parameter.COST);
		CarModel expected = CarModel.GAZ_POBEDA;
		CarModel result = temp.get(0).getCarModel();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void Sort_EachCarAddedToRegister_SortByPetrolConsumption_FirstCarAveoExpected(){
		ArrayList<Car> temp = taxi.sort(Parameter.CONSUMPTION);
		CarModel expected = CarModel.CHEVROLET_AVEO;
		CarModel result = temp.get(0).getCarModel();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void Sort_EachCarAddedToRegister_SortByMaxSpeed_LastCarCorollaExpected(){
		ArrayList<Car> temp = taxi.sort(Parameter.MAXS_SPEED);
		CarModel expected = CarModel.TOYOTA_COROLLA;
		CarModel result = temp.get(temp.size()-1).getCarModel();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void Sort_EachCarAddedToRegister_SortByBodyType_FirstCarOktaviaExpected(){
		ArrayList<Car> temp = taxi.sort(Parameter.BODY_TYPE);
		CarModel expected = CarModel.SKODA_OCTAVIA;
		CarModel result = temp.get(0).getCarModel();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void FindBySpeed_EachCarAddedToRegister_FindBetween160and165_FirstCarDusterExpected(){
		ArrayList<Car> temp = taxi.findBySpeed(160, 165);
		CarModel expected = CarModel.RENAULT_DUSTER;
		CarModel result = temp.get(0).getCarModel();
		Assert.assertEquals(expected, result);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void FindBySpeed_EachCarAddedToRegister_FindBetween60and80_FirstCarExceptionExpected(){
		ArrayList<Car> temp = taxi.findBySpeed(60, 80);
		CarModel result = temp.get(0).getCarModel();
	}

}
