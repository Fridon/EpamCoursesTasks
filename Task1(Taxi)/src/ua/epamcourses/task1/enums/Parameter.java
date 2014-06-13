package ua.epamcourses.task1.enums;

import java.util.Comparator;

import ua.epamcourses.task1.cars.Car;

/**
 * This enum provides choise from four parameters,<br>
 * what may be used to sort cars.<br>
 * Enum has abstract method getComparator(),<br>
 * that overrided in each member of enum.<br>
 * Each method returns comparator,<br>
 * which compare one of parameter from carModel.<br>
 * 
 * @author Fridon
 *
 */


public enum Parameter {
	
	COST{public Comparator getComparator(){
			return new Comparator(){
				@Override
				public int compare(Object o1, Object o2) {
					CarModel temp1 = ((Car)o1).getCarModel();
					CarModel temp2 = ((Car)o2).getCarModel();
					if(temp1.getCost() == temp2.getCost())						
						return 0;
					if(temp1.getCost() >= temp2.getCost())						
						return 1;
					return -1;
				}				
			};
		}},
	
	CONSUMPTION{public Comparator getComparator(){
			return new Comparator(){
				@Override
				public int compare(Object o1, Object o2) {
					CarModel temp1 = ((Car)o1).getCarModel();
					CarModel temp2 = ((Car)o2).getCarModel();
					if(temp1.getPetrolConsumption() == temp2.getPetrolConsumption())						
						return 0;
					if(temp1.getPetrolConsumption() >= temp2.getPetrolConsumption())						
						return 1;
					return -1;
				}				
			};
		}},
	
	MAXS_SPEED{public Comparator getComparator(){
			return new Comparator(){
				@Override
				public int compare(Object o1, Object o2) {
					CarModel temp1 = ((Car)o1).getCarModel();
					CarModel temp2 = ((Car)o2).getCarModel();
					if(temp1.getMaxSpeed() == temp2.getMaxSpeed())						
						return 0;
					if(temp1.getMaxSpeed() >= temp2.getMaxSpeed())						
						return 1;
					return -1;
				}				
			};
		}},
	
	BODY_TYPE{public Comparator getComparator(){
			return new Comparator(){
				@Override
				public int compare(Object o1, Object o2) {
					CarModel temp1 = ((Car)o1).getCarModel();
					CarModel temp2 = ((Car)o2).getCarModel();
					if(temp1.getBodyType().compareTo(temp2.getBodyType()) == 0)						
						return 0;
					if(temp1.getBodyType().compareTo(temp2.getBodyType()) >= 0)						
						return 1;
					return -1;
				}				
			};
		}};
	
	public abstract Comparator getComparator();
}
