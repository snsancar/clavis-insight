package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Util class used to read the JSON Files.
 * @author sankar
 *
 */
public class JSONReadUtil {
	
	private static Logger logger = LoggerFactory.getLogger(JSONReadUtil.class);

	/**
	 * This method used to read the JSON file and return as List of Java Objects.
	 * @return List<CustomNumberEntity>
	 */
	public static List<CustomNumberEntity> readJSONFile(File file) {
		
		List<CustomNumberEntity> listOfNumbers = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			FileReader fileReader = new FileReader(file);
			listOfNumbers = mapper.readValue(fileReader, new TypeReference<List<CustomNumberEntity>>() {});
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (JsonParseException e) {
			logger.error(e.getMessage());
		} catch (JsonMappingException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return listOfNumbers;
	}
}
