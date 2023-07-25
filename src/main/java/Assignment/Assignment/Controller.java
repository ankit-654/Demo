package Assignment.Assignment;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
//CROSS PLATFORM
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class Controller {

@Autowired           // Interface for Address
AddressRepository addressrepo;

@Autowired 
CenterRepository centerrepo;

//    FOR CENTER APIs 
@GetMapping("/center/info")
public List<Center>getCourseInfo(){
	List<Center>lst=new ArrayList<Center>();

    for(Center t:(List<Center>)centerrepo.findAll()) {
    	t.getAddress().setCenter(null);    // to stop repetition of object.. set (null)
                  
    	lst.add(t);
    }
    return lst;
}

@Autowired
Cousre_List_Repository course_list_repo;
@GetMapping("/courselist")     //   GET MAPPING APIs FOR COUSRE OFFERED LISTS
public List<Course_List>GetCourseList(){ 
	List<Course_List>lst=new ArrayList<Course_List>();
	for(Course_List cl:(List<Course_List>)course_list_repo.findAll()) {
		cl.setCenter(null);
		lst.add(cl);
	}
	return lst;
}

//// POST MAPPING APIs

@PostMapping("/centerpost/info")
public String AddCenters(@RequestBody Center cv) {
	System.out.println("inside the post method");
	LocalDateTime localDateTime = LocalDateTime.now();   // FOR GETTING SYSTEM GENERATED TIME
	Timestamp t=Timestamp.valueOf(localDateTime);
	System.out.println(t);

	System.out.println(cv.getCenter_id()+" "+cv.getCenter_name()+" "+cv.getCenter_code()+" "+cv.getAddress().getDetailed_address()
			          +" "+cv.getAddress().getCity()+" "+cv.getAddress().getState()+" "+cv.getAddress().getPincode()
			          +" "+cv.getStudent_capacity()+" "+cv.getCourses().getCourse_name()+" "+cv.getContact_email()
			          +" "+cv.getContact_phone());
	
	centerrepo.save(cv);
	return "added";
}

}