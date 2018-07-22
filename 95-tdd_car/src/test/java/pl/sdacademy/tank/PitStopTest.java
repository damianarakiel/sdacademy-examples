package pl.sdacademy.tank;

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
	Track track;

	@Mock
	Station station;

	@Mock
	Vulcanizer vulcanizer;

	@BeforeEach
	void setUp() {
		pitStop = new PitStop(station, vulcanizer);
	}

	@DisplayName("samochód zjeżdża do pitstopu dla zabrudzenia, braku paliwa, lub zużycia opon")
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