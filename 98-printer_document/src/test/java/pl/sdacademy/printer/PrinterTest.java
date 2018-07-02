package pl.sdacademy.printer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PrinterTest {

	@DisplayName("should print text")
	@Test
	void test0() {
		//given
		Printer printer = new Printer(1);
		Document document = new Document(false);
		//when
		printer.print(document);
		//then
		assertThat(document.isPrinted()).isTrue();
	}

	@DisplayName("should not print documents is minimum number of document is not reached")
	@Test
	void test1() {
		//given
		int documentsThreshold = 4;
		Printer printer = new Printer(documentsThreshold);
		Document doc0 = notPrintedDocument();
		Document doc1 = notPrintedDocument();
		Document doc2 = notPrintedDocument();
		//when
		printer.print(doc0);
		printer.print(doc1);
		printer.print(doc2);
		//then
		assertThat(doc1.isPrinted()).isFalse();
		assertThat(doc0.isPrinted()).isFalse();
		assertThat(doc2.isPrinted()).isFalse();
	}

	@DisplayName("should print documents is minimum number of document is reached")
	@Test
	void test2() {
		//given
		int documentsThreshold = 3;
		Printer printer = new Printer(documentsThreshold);
		Document doc0 = notPrintedDocument();
		Document doc1 = notPrintedDocument();
		Document doc2 = notPrintedDocument();
		//when
		printer.print(doc0);
		printer.print(doc1);
		printer.print(doc2);
		//then
		assertThat(doc1.isPrinted()).isTrue();
		assertThat(doc0.isPrinted()).isTrue();
		assertThat(doc2.isPrinted()).isTrue();
	}

	@DisplayName("should print documents is minimum number of document is reached")
	@Test
	void test3() {
		//given
		int documentsThreshold = 2;
		Printer printer = new Printer(documentsThreshold);
		Document doc0 = notPrintedDocument();
		Document doc1 = notPrintedDocument();
		Document doc2 = notPrintedDocument();
		//when
		printer.print(doc0);
		printer.print(doc1);
		printer.print(doc2);
		//then
		assertThat(doc1.isPrinted()).isTrue();
		assertThat(doc0.isPrinted()).isTrue();
		assertThat(doc2.isPrinted()).isFalse();
	}

	private Document notPrintedDocument() {
		return new Document(false);
	}

}
