package demo;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.util.List;

import org.junit.Test;

public class TestNumberFinder {
	
	@Test
	public void testReadJSONFile() {
		NumberFinder numberFinder = new NumberFinderImpl();
		List<CustomNumberEntity> readJSONFile = numberFinder.readFromFile("numbers.json");
		readJSONFile.forEach(customNumberEntity -> {
			System.out.println(customNumberEntity.getNumber());
		});
	}

	@Test
	public void testNumberFinder() {

		NumberFinder numberFinder = new NumberFinderImpl();
		List<CustomNumberEntity> listOfNumbers = numberFinder.readFromFile("numbers.json");
		long lStartTime = Instant.now().toEpochMilli();

		boolean contains = numberFinder.contains(3, listOfNumbers);
		long lEndTime = Instant.now().toEpochMilli();
		System.out.println("THE NUMBER EXIST IN THE LIST OR NOT:" + contains);

		long output = lEndTime - lStartTime;
		System.out.println("Elapsed time in milliseconds: " + output);
		assertEquals(true, contains);
	}
}
