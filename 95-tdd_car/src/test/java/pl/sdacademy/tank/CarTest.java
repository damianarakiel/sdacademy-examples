package pl.sdacademy.tank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class CarTest {
	@DisplayName("jakie paliwo używa nasz samochód")
	@Test
	void tankTest0() {
		//given
		Car electricCar = new Car(TypeCar.ELECTRIC);
		Car petrolCar = new Car(TypeCar.PETROL);
		Car dieselCar = new Car(TypeCar.DIESEL);
		//when

		//then
		assertThat(petrolCar).isNotNull();
		assertThat(dieselCar).isNotNull();
		assertThat(electricCar).isNotNull();

	}

	@DisplayName("should have filled car's tank")
	@Test
	void tankTest1() {
		//given
		Car electricCar = new Car(TypeCar.ELECTRIC);
		Car petrolCar = new Car(TypeCar.PETROL);
		Car dieselCar = new Car(TypeCar.DIESEL);
		Station station = new Station();
		//when
		int amount1 = station.fullTank(petrolCar);
		//then
		assertThat(amount1).isEqualTo(42 - 10);
	}

	@DisplayName("price for filled car's tank")
	@ParameterizedTest
	@EnumSource(TypeCar.class)
	void tankTest2(TypeCar typeCar) {
		//given
		Car car = new Car(typeCar);
		byte currentLevel = 10;
		car.setCurrentLevel(currentLevel);
		Station station = new Station();
		//when
		int amount = station.fullTank(car);
		int result = station.price(car, amount);
		//then
		assertThat(amount).isEqualTo(car.getMaxLevel() - currentLevel);
		assertThat(result).isEqualTo(amount * station.getCennik().get(typeCar));
	}
}
