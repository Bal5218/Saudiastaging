package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class QaRepositery {

	public Properties init() throws IOException {
		Properties obj = new Properties();
		String propsDir = System.getProperty("user.dir") + "\\repository";
		String[] files = { "RegisterCorporate", "Flight", "FlightBooking", "FlightBookingForEmployees","AddTraveler" };
		String propsFileSuffix = ".properties";

		for (String file : files) {
			file = propsDir + "\\" + file + propsFileSuffix;
			FileInputStream inputStream = new FileInputStream(file);
			obj.load(inputStream);
		}
		return obj;
	}
}
