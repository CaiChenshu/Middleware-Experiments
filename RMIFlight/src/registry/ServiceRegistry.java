package registry;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import client.FlightService;
import service.FlightServiceImpl;

public class ServiceRegistry {
	public static void main(String[] args) {
		FlightService flightService;
		try {
			flightService = new FlightServiceImpl();
			LocateRegistry.createRegistry(32479);
			Naming.bind("rmi://127.0.0.1:32479/FlightService", flightService);
			System.out.println("Service is started...");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}