package client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

public class TestClient {
	public static void main(String[] args) throws XPathExpressionException, FileNotFoundException, ParserConfigurationException, SAXException, IOException {
		FlightService flightService;
		try {
			flightService = (FlightService)Naming.lookup("rmi://127.0.0.1:32479/FlightService");
			flightService.getFlight("±±¾©", new PrintFlightServiceImpl());
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
