package pl.sdacademy.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Fail.fail;

// TODO: write your tests inside this class
class FizzBuzzTest {

	// this is how a test look like
	@DisplayName("do nothing - this pseudo test is here only to show how to create your own tests")
	@Test
	/*void nothing() {
		// this is how you write assertions
		assertThat(1).isEqualTo(1);
		assertThat(1).isNotEqualTo(2);
		fail("remove this pseudo test and start writing your own real tests");
	}*/
	void FizzBuzzTestNull(){
		//given
		int number = 0;
		//when
		String msg = FizzBuzz.msg(number);
		//then
		assertThat(msg).isNotEqualTo(null);
	}
	@DisplayName("If given 1 it return 1")
	@Test
	void FizzBuzzTest1(){
		//given
		int number = 1;
		//when
		String msg = FizzBuzz.msg(number);
		//then
		assertThat(msg).isEqualTo("1");
	}
	@DisplayName("If given 2 it return Wizz")
	@Test
	void FizzBuzzTest2() {
		//given
		int number = 2;
		//when
		String msg = FizzBuzz.msg(number);
		//then
		assertThat(msg).isEqualTo("Wizz");
	}
	@DisplayName("If given 3 it return FizzWizz")
	@Test
	void FizzBuzzTest3() {
		//given
		int number = 3;
		//when
		String msg = FizzBuzz.msg(number);
		//then
		assertThat(msg).isEqualTo("FizzWizz");
	}
	@DisplayName("If given 5 it return BuzzWizz")
	@Test
	void FizzBuzzTest5() {
		//given
		int number = 5;
		//when
		String msg = FizzBuzz.msg(number);
		//then
		assertThat(msg).isEqualTo("BuzzWizz");
	}
	@DisplayName("If given 6 it return Fizz")
	@Test
	void FizzBuzzTest6() {
		//given
		int number = 6;
		//when
		String msg = FizzBuzz.msg(number);
		//then
		assertThat(msg).isEqualTo("Fizz");
	}
	@DisplayName("If given 7 it return Wizz")
	@Test
	void FizzBuzzTest7() {
		//given
		int number = 7;
		//when
		String msg = FizzBuzz.msg(number);
		//then
		assertThat(msg).isEqualTo("Wizz");
	}
	@DisplayName("If given 10 it return Buzz")
	@Test
	void FizzBuzzTest10() {
		//given
		int number = 10;
		//when
		String msg = FizzBuzz.msg(number);
		//then
		assertThat(msg).isEqualTo("Buzz");
	}
	@DisplayName("If given 15 it return FizzBuzz")
	@Test
	void FizzBuzzTest15() {
		//given
		int number = 15;
		//when
		String msg = FizzBuzz.msg(number);
		//then
		assertThat(msg).isEqualTo("FizzBuzz");
	}

}
