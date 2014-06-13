package ua.epamcourses.task1.tests;

import junit.framework.Assert;

import org.junit.Test;

import ua.epamcourses.task1.enums.BodyType;
import ua.epamcourses.task1.enums.CarModel;

public class CarModelTest {
	
	CarModel carModel;
	
	@Test
	public void GetCost_Sprinter_Test(){
		carModel = CarModel.MERSEDES_SPRINTER;
		int expected = 60000;
		int result = carModel.getCost();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void GetPetrolConsumption_Sprinter_Test(){
		carModel = CarModel.MERSEDES_SPRINTER;
		float expected = 12.2f;
		float result = carModel.getPetrolConsumption();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void GetMaxSpeed_Sprinter_Test(){
		carModel = CarModel.MERSEDES_SPRINTER;
		int expected = 144;
		int result = carModel.getMaxSpeed();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void GetBodyType_Sprinter_Test(){
		carModel = CarModel.MERSEDES_SPRINTER;
		BodyType expected = BodyType.MINIBUS;
		BodyType result = carModel.getBodyType();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void GetCost_Oktavia_Test(){
		carModel = CarModel.SKODA_OCTAVIA;
		int expected = 23000;
		int result = carModel.getCost();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void GetPetrolConsumption_Oktavia_Test(){
		carModel = CarModel.SKODA_OCTAVIA;
		float expected = 6.4f;
		float result = carModel.getPetrolConsumption();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void GetMaxSpeed_Oktavia_Test(){
		carModel = CarModel.SKODA_OCTAVIA;
		int expected = 176;
		int result = carModel.getMaxSpeed();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void GetBodyType_Oktavia_Test(){
		carModel = CarModel.SKODA_OCTAVIA;
		BodyType expected = BodyType.SEDAN;
		BodyType result = carModel.getBodyType();
		Assert.assertEquals(expected, result);
	}
}
