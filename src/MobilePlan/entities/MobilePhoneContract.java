package MobilePlan.entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import MobilePlan.provided.Customer;

/**
 * A MobilePhoneContract base class.<br>
 * Concrete sub types must implement the units and fee structure.
 */
public abstract class MobilePhoneContract implements java.lang.Comparable<MobilePhoneContract>{
	/**
	 * Creates a string representation of this MobilePhoneContract.<br>
	 * 
	 * The returned string contains the values
	 * <ul>
	 * <li>customer string</li>
	 * <li>imei number</li>
	 * <li>carrier name</li>
	 * <li>used units</li>
	 * <li>units left</li>
	 * <li>additional fees to pay</li> 
	 * <li>a summary of all outgoing calls</li>
	 * </ul>
	 * 
	 * @ProgrammingProblem.Hint provided
	 * 
	 */
	private java.lang.String carrier;
	private java.util.List<Connection> connections;
	private Customer customer;
	private java.lang.String imei;

	public MobilePhoneContract(Customer customer,
								java.lang.String imei,
								java.lang.String carrier){
		if (customer == null||imei == null|| carrier == null){
			throw new IllegalArgumentException("Invalid arguments");
		}
	}
	public java.util.List<Connection> outgoingConnections(){
		List<Connection> outgoing = new ArrayList<>();

		for (Connection connection : connections) {
			if (connection.getCaller().getCustomer() == customer){
				outgoing.add(connection);
			}
		}
		return outgoing;
	}
	public abstract int unitsLeft();
	public abstract float additionalFee();
	public MobilePhoneContract setImei(java.lang.String imei){
		if (imei != null)
			this.imei = imei;
		return this;
	}
	public java.lang.String getImei(){
		return imei;
	}
	public Customer getCustomer(){
		return customer;
	}
	public int getUsedUnits(){
		int sum = 0;
		for (Connection outgoingConnection : outgoingConnections()) {
			sum += outgoingConnection.getUnits();
		}
		return sum;
	}
	public int compareTo(MobilePhoneContract a){
		return Integer.compare(getUsedUnits(),a.getUsedUnits());
	}
	public boolean addConnection(Connection connection){
		if (connection == null)
			return false;
		return connections.add(connection);
	}

	@Override
	public String toString() {
		return "MobilePhoneContract [\ncarrier=" + carrier  + ", customer=" + customer
				+ ", imei=" + imei + ", usedUnits="+ getUsedUnits() +",\nconnections=" + outgoingConnections() + "\n]";
	}
}
