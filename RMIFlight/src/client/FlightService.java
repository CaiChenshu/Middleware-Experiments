package client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import service.PrintFlightService;

public interface FlightService extends Remote {
	public void getFlight(String leavecity, PrintFlightService printService) throws RemoteException, XPathExpressionException, ParserConfigurationException, FileNotFoundException, SAXException, IOException;
}
