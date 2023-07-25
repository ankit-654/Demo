package Assignment.Assignment;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "course")
public class Course_List {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int course_id;
private String course_name;
public Course_List() {
	super();
	// TODO Auto-generated constructor stub
}
public Course_List(int course_id, String course_name) {
	super();
	this.course_id = course_id;
	this.course_name = course_name;
}
public int getCourse_id() {
	return course_id;
}
public void setCourse_id(int course_id) {
	this.course_id = course_id;
}
public String getCourse_name() {
	return course_name;
}
public void setCourse_name(String course_name) {
	this.course_name = course_name;
}

//// mapping to store list of course
@OneToMany(fetch = FetchType.EAGER,mappedBy = "courses",cascade = CascadeType.MERGE)
@JsonIgnoreProperties("courses")
private Set<Center>center=new HashSet<Center>();
public Set<Center> getCenter() {
	return center;
}
public void setCenter(Set<Center> center) {
	this.center = center;
}
}
