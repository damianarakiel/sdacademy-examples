package pl.sdacademy.wizytator;

interface CarElementVisitor {
	void visit(Body body);
	void visit(Car car);
	void visit(Engine engine);
	void visit(Wheel wheel);
}