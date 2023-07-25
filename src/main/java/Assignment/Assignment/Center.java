package Assignment.Assignment;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import Assignment.Assignment.Address;
@Entity
@Table(name="tblcenter")
public class Center {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int center_id;
	private String center_name;
	private String center_code;
	
	//////////  Making object of address //////////////
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "address_id")
	private Address address;
	
	private int student_capacity;
	
	//////// List of Course  Offered ///////
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn(name = "course_id",referencedColumnName = "course_id")
	@JsonIgnoreProperties("center")
	private Course_List courses;
	private String contact_email;
	private String contact_phone;
	
	public Center() {
		super();
		// TODO Auto-generated constructor stub
	}
    
//   CONSTRUCTOR 
    public Center(int center_id, String center_name, String center_code, Address address, int student_capacity,
			Course_List courses, String contact_email, String contact_phone) {
		super();
		this.center_id = center_id;
		this.center_name = center_name;
		this.center_code = center_code;
		this.address = address;
		this.student_capacity = student_capacity;
		this.courses = courses;
		this.contact_email = contact_email;
		this.contact_phone = contact_phone;
	}

	//    GETTER SETTER FOR FIELDS 
    public Course_List getCourses() {
		return courses;
	}

	public void setCourses(Course_List courses) {
		this.courses = courses;
	}
	
    public int getCenter_id() {
		return center_id;
	}
    
	public void setCenter_id(int center_id) {
		this.center_id = center_id;
	}

    public String getCenter_name() {
		return center_name;
	}

    public void setCenter_name(String center_name) {
		this.center_name = center_name;
	}

    public String getCenter_code() {
		return center_code;
	}

    public void setCenter_code(String center_code) {
		this.center_code = center_code;
	}

    public int getStudent_capacity() {
		return student_capacity;
	}

    public void setStudent_capacity(int student_capacity) {
		this.student_capacity = student_capacity;
	}

    public String getContact_email() {
		return contact_email;
	}

    public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

    public String getContact_phone() {
		return contact_phone;
	}

    public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}

    public Address getAddress() {
		return address;
	}

    public void setAddress(Address address) {
		this.address = address;
	}
}
