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

	final byte maxLevel = 42;
	byte currentLevel = 10;

	//	public TypeCar getTypeCar() {
	//		return typeCar;
	//	}
	//
	//	public byte getMaxLevel() {
	//		return maxLevel;
	//	}
	//
	//	public byte getCurrentLevel() {
	//		return currentLevel;
	//	}
	//
	//	public void setCurrentLevel(byte currentLevel) {
	//		this.currentLevel = currentLevel;
	//	}
}