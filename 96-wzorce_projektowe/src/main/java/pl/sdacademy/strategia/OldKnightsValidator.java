package pl.sdacademy.strategia;

public class OldKnightsValidator implements KnightValidator {
	@Override
	public boolean validate(Knight knight) {
		return knight.getAge()>60;
	}
}
