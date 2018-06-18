package pl.sdacademy.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class AnagramTest {
	@DisplayName("should convert pies to siep")
	@Test
	@Disabled
	void piesTest(){
		//given
		String str = "pies";
		//when
		Set<String> piescidelko = Anagram.convert(str);
		//than
		assertThat(piescidelko).contains("siep");
	}
	@DisplayName("should convert pies to epis")
	@Test
	@Disabled
	void piesTest1(){
		//given
		String str = "pies";
		//when
		Set<String> piescidelko = Anagram.convert(str);
		//than
		assertThat(piescidelko).contains("epis");
	}
	@DisplayName("should convert jo to all anagrams")
	@Test
	void JoTest(){
		//given
		String str = "jo";
		//when
		Set<String> piescidelko = Anagram.convert(str);
		//than
		assertThat(piescidelko).containsOnly("jo", "oj");
	}
	@DisplayName("should convert jo to all anagrams")
	@Test
	void OoTest(){
		//given
		String str = "oo";
		//when
		Set<String> piescidelko = Anagram.convert(str);
		//than
		assertThat(piescidelko).containsOnly("oo");
	}
	@DisplayName("should convert jo to all anagrams")
	@Test
	void kotTest(){
		//given
		String str = "kot";
		//when
		Set<String> piescidelko = Anagram.convert(str);
		//than
		assertThat(piescidelko).containsOnly("kot","tok","kto","otk","okt","otk");
	}
}
