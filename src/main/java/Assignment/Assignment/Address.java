package Assignment.Assignment;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbladdress")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int address_id;
	private String detailed_address;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String detailed_address, String city, String state, int pincode, Center center) {
		super();
		this.detailed_address = detailed_address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.center = center;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getDetailed_address() {
		return detailed_address;
	}

	public void setDetailed_address(String detailed_address) {
		this.detailed_address = detailed_address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	private String city;
	private String state;
	private int pincode;
	
	@OneToOne(mappedBy = "address")    // FOR MAKING ADDRESS AS A OBJECT
	private Center center;     // TO STORE ADDRESS(OBJECT) WITHIN CENTER
	
}

