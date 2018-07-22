package pl.sdacademy.tank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StationTest {

	@DisplayName("should have filled car's tank")
	@ParameterizedTest
	@EnumSource(TypeCar.class)
	void stationTest1(TypeCar typeCar) {
		//given
		Car car = new Car(typeCar);
		Station station = new Station();
		//when
		int amount1 = station.fullTank(car);
		//then
		assertThat(amount1).isEqualTo(42);
	}

	@DisplayName("price for filled car's tank")
	@ParameterizedTest
	@EnumSource(TypeCar.class)
	void stationTest2(TypeCar typeCar) {
		//given
		Car car = new Car(typeCar);
		byte currentLevel = 10;
		car.setCurrentFuelLevel(currentLevel);
		Station station = new Station();
		//when
		int amount = station.fullTank(car);
		int result = station.price(car, amount);
		//then
		assertThat(amount).isEqualTo(car.getMAX_FUEL_LEVEL() - currentLevel);
		assertThat(result).isEqualTo(amount * station.getPricing().get(typeCar));
	}

	@DisplayName("chcemy umyć samochód do czysta")
	@Test
	void stationTest3() {
		//given
		Car car = new Car(TypeCar.DIESEL);
		Station station = new Station();
		car.setCarDirt(10);
		//when
		station.washCar(car);
		//then
		assertThat(car.getCarDirt()).isEqualTo(0);
	}
}