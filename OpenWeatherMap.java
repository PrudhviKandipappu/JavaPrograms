// Get a given city temperature

import java.io.*;
import java.net.*;
import org.python.util.PythonInterpreter;
import org.python.core.*;

class WeatherData
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String location = null;
		System.out.print("Enter City name: ");
		location = br.readLine();
		float temperature = getTemperature(location);
		System.out.println("Temperature of " + location + " is: " + temperature);
	}

	public static float getTemperature(String location) throws Exception {
		String webURL = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=abe3a0f4d0b6cebfbe7393b4b4e3aa28&units=metric";
		URL response = new URL(webURL);
		HttpURLConnection connection = (HttpURLConnection) response.openConnection();
		BufferedReader dr = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		PythonInterpreter pyInterpreter = new PythonInterpreter();
		pyInterpreter.set("data", new PyString(dr.readLine()));
		pyInterpreter.exec("data = eval(data)");
		pyInterpreter.exec("temperature = data['main']['temp']");
		PyObject data = pyInterpreter.get("temperature");
		return Float.parseFloat(pyInterpreter.get("temperature").toString());
	}
}