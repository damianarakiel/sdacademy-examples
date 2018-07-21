package pl.sdacademy.tank;

public class Car {
	private final TypeCar typeCar;

	public TypeCar getTypeCar() {
		return typeCar;
	}

	public Car(TypeCar typeCar) {
		this.typeCar = typeCar;
	}

	public byte getMaxLevel() {
		return maxLevel;
	}

	public byte getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(byte currentLevel) {
		this.currentLevel = currentLevel;
	}

	final byte maxLevel = 42;
	byte currentLevel = 10;
}