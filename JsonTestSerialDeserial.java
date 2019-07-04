package JsonSerializeDeserialize;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTestSerialDeserial {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		//Deserialzing Json to Java object
		ObjectMapper objectMapper = new ObjectMapper();

		System.out.println("-----------------------------");
		String carJson =
		    "{ \"brand\" : \"Mercedes\", \"doors\" : null }";

		
		Car car=null;
		try {
		    car = objectMapper.readValue(carJson, Car.class);

		    
		    System.out.println("car brand = " + car.getBrand());
		    System.out.println("car doors = " + car.getDoors());
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		
		//Serializing java object to Json string
		System.out.println("-----------------------------");
		String json=objectMapper.writeValueAsString(car);
		System.out.println(json);
		
		
		//Deserializing series of objects
		System.out.println("-----------------------------");
		deserializingForArrayAndMaps();
	}
	
	public static void deserializingForArrayAndMaps() throws JsonParseException, JsonMappingException, IOException
	{
		String jsonArray = "[{\"brand\":\"ford\"}, {\"brand\":\"Fiat\"}]";
		String jsonObject = "{\"brand\":\"ford\", \"doors\":5}";

		ObjectMapper objectMapper = new ObjectMapper();
		List<Car> cars1 = objectMapper.readValue(jsonArray, new TypeReference<List<Car>>(){});
		
		for (Car car : cars1) {
			System.out.println(car.getBrand());
		}
		
		Map<String, Object> jsonMap = objectMapper.readValue(jsonObject,
			    new TypeReference<Map<String,Object>>(){});
		
		System.out.println(jsonMap.entrySet());
	
	}
	
}

