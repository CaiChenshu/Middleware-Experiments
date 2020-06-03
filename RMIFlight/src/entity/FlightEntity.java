package entity;

import java.io.Serializable;

public class FlightEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2693414575559803735L;
	private String flightcode;
	private String company;
	private String leaveairport;
	private String arriveairport;
	private String leavetime;
	private String arrivetime;
	private String mode;
	
	public FlightEntity(String flightcode, String company, String leaveairport, String arriveairport, String leavetime,
			String arrivetime, String mode) {
		super();
		this.flightcode = flightcode;
		this.company = company;
		this.leaveairport = leaveairport;
		this.arriveairport = arriveairport;
		this.leavetime = leavetime;
		this.arrivetime = arrivetime;
		this.mode = mode;
	}

	public String getFlightcode() {
		return flightcode;
	}

	public void setFlightcode(String flightcode) {
		this.flightcode = flightcode;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLeaveairport() {
		return leaveairport;
	}

	public void setLeaveairport(String leaveairport) {
		this.leaveairport = leaveairport;
	}

	public String getArriveairport() {
		return arriveairport;
	}

	public void setArriveairport(String arriveairport) {
		this.arriveairport = arriveairport;
	}

	public String getLeavetime() {
		return leavetime;
	}

	public void setLeavetime(String leavetime) {
		this.leavetime = leavetime;
	}

	public String getArrivetime() {
		return arrivetime;
	}

	public void setArrivetime(String arrivetime) {
		this.arrivetime = arrivetime;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
}
