package demo;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
/**
 * Class used to implement NumberFinder methods
 * @author sankar
 *
 */
public class NumberFinderImpl implements NumberFinder {
	
	/**
	 * This method used to check the number is exist in the list or not.
	 * @param valueToFind
	 * @param list
	 */
	public boolean contains(int valueToFind, List<CustomNumberEntity> list) {
		Set<CustomNumberEntity> uniqueNumbersList = new HashSet<CustomNumberEntity>(list);
		FastestComparator comparator = new FastestComparator();
		Optional<CustomNumberEntity> findFirst = uniqueNumbersList.stream()
				.filter(customNumberEntity -> comparator.compare(valueToFind, customNumberEntity) == 0).findFirst();
		return findFirst.isPresent();
	}

	/**
	 * This method used to read the JSON file based on filePath and return the List of Numbers.
	 * @param filePath
	 */
	public List<CustomNumberEntity> readFromFile(String filePath) {
		File file = new File(getClass().getClassLoader().getResource(filePath).getFile());
		List<CustomNumberEntity> listOfNumbers = JSONReadUtil.readJSONFile(file);
		return listOfNumbers;
	}
}
