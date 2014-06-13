package ua.epamcourses.task1.enums;

/**
 * This enum provides provides choise from some car models<br>
 * and contains constant parameters of this models.
 * 
 * @author Fridon
 *
 */


public enum CarModel {
	
	MERSEDES_SPRINTER(60000, 12.2f, 144, BodyType.MINIBUS),
	SKODA_OCTAVIA(23000, 6.4f, 176, BodyType.SEDAN),
	GAZ_POBEDA(3000, 8f, 91, BodyType.SEDAN),
	RENAULT_DUSTER(50000, 9.3f, 165, BodyType.PICKUP),
	BMW_530d(47500, 7.6f, 156, BodyType.ESTATE),
	RENAULT_LOGAN_PICKUP(16300, 7.9f, 152, BodyType.PICKUP),
	SUBARU_BAJA(17000, 7.5f, 164, BodyType.PICKUP),
	FORD_FOCUS_WAGON(15400, 7.8f, 159, BodyType.ESTATE),
	KIA_CEED_SW(18200, 7.8f, 162, BodyType.ESTATE),
	OPEL_ASTRA_H_CARAVAN(16000, 7.4f, 155, BodyType.ESTATE),
	PEUGEOT_301(18000, 6.9f, 170, BodyType.SEDAN),
	TOYOTA_COROLLA(20000, 7.1f, 180, BodyType.SEDAN),
	CHEVROLET_AVEO(15600, 6.3f, 150, BodyType.SEDAN);
	
	private final int cost;
	private final float petrolConsumption;
	private final int maxSpeed;
	private final BodyType bodyType;
	
	CarModel(int cost, float petronConsumption, int maxSpeed, BodyType bodyType){
		this.cost = cost;
		this.petrolConsumption = petronConsumption;
		this.maxSpeed = maxSpeed;
		this.bodyType = bodyType;
	}

	public int getCost() {
		return cost;
	}

	public float getPetrolConsumption() {
		return petrolConsumption;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public BodyType getBodyType() {
		return bodyType;
	}
		
}
