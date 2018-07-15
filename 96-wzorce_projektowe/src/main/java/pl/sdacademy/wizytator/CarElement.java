package pl.sdacademy.wizytator;

interface CarElement {
	void accept(CarElementVisitor visitor);
}