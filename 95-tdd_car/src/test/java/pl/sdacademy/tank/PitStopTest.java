package pl.sdacademy.tank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PitStopTest {

	PitStop pitStop;

	@Mock
	Station station;

	@Mock
	Vulcanizer vulcanizer;

	@BeforeEach
	void setUp() {
		pitStop = new PitStop(station, vulcanizer);
	}

	@DisplayName("samochód ma możliwość sprawdzenia czy muszę zjechać do pitstopu")
	@Test
	void pitStopTest01() {
		//given
		Car car = new Car(TypeCar.DIESEL);
		//when
		pitStop.ifServiceNeeded(car);
		//then
		BDDMockito.then(station).should().ifWashNeeded(car);
		BDDMockito.then(station).should().ifFuelNeeded(car);
		BDDMockito.then(vulcanizer).should().ifNewTiresNeeded(car);
	}
}