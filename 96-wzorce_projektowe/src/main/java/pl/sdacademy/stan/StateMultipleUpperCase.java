package pl.sdacademy.stan;

class StateMultipleUpperCase implements Statelike{
	private int count = 0;

	@Override
	public void writeName(final StateContext context, final String name) {
		System.out.println(name.toUpperCase());
		if (++count > 1) {
			context.setState(new StateLowerCase());
		}
	}
}
