package pl.sdacademy.tank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
	private final TypeCar typeCar;

	public Car(TypeCar typeCar) {
		this.typeCar = typeCar;
	}

	final int MAX_FUEL_LEVEL = 42;
	final int MAX_DIRT_VALUE = 100;
	final int MAX_TIRES_USAGE_VALUE = 100;
	int currentFuelLevel = 0;
	int carDirt = 0;
	int tires = 0;

	//	public TypeCar getTypeCar() {
	//		return typeCar;
	//	}
	//
	//	public byte getMAX_FUEL_LEVEL() {
	//		return MAX_FUEL_LEVEL;
	//	}
	//
	//	public byte getCurrentFuelLevel() {
	//		return currentFuelLevel;
	//	}
	//
	//	public void setCurrentFuelLevel(byte currentFuelLevel) {
	//		this.currentFuelLevel = currentFuelLevel;
	//	}
}