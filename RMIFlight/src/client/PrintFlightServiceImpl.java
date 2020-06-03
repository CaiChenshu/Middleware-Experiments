package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import entity.FlightEntity;
import service.PrintFlightService;

public class PrintFlightServiceImpl extends UnicastRemoteObject implements PrintFlightService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9003621676912641299L;

	protected PrintFlightServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printFlight(List<FlightEntity> flights) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("flight--> 	flightcode	company   leaveairport   arriveairport   leavetime   arrivetime   mode");
		for(FlightEntity i : flights) {
			System.out.println("flight-->" + i.getFlightcode() + " " + i.getCompany() + " " + i.getLeaveairport() + 
					" " + i.getArriveairport() + " " + i.getLeavetime() + " " + i.getArrivetime() + " " + i.getMode());
		}
	}
}
