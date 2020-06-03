package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.FlightEntity;

public interface PrintFlightService extends Remote {
	public void printFlight(List<FlightEntity> flights) throws RemoteException;
}
