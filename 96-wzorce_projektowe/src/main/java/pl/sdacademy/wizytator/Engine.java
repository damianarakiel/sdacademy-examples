package pl.sdacademy.wizytator;

class Engine implements CarElement {
	public void accept(final CarElementVisitor visitor) {
		visitor.visit(this);
	}
}