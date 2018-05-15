package com.aht.admincontroller;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aht.entities.Employee;
import com.aht.service.EmployeeService;

@Controller
public class AdminEmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = { "/employeeList" })
	public String employeeList(){
		return "employee-list";

	}
	
	
	@RequestMapping(value = { "/employeesadmin" }, method = RequestMethod.GET)
	public String personList(Model model) {

		List<Employee> employeeList = employeeService.findAll();

		model.addAttribute("employeeList", employeeList);

		return "employee-list";
	}

	@RequestMapping(value = { "/employeesadmin/delete/{id}" }, method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteEmployee(@PathVariable("id") Long id, Model model) {
		System.out.println(id);
		employeeService.deleteEmployee(id);
		
		model.addAttribute("employeeList",employeeService.findAll());
		return "employee-list";

	}
	

	
	@GetMapping(value = { "/employeeAdd" })
	public String employeeAdd(){
		return "employeeAdd";

	}
	
	@PostMapping(value = "/AddEmployee")
	public String Addemployee(@ModelAttribute("employee") Employee employee,Model model){
		employeeService.createEmployee(employee);
		model.addAttribute("employeeList",employeeService.findAll());
	
		return "employeeAdd";

	}
	
	
	@GetMapping(value= {"/employeesadmin/edit/{id}"})
	public String employeeE( Model model, @PathVariable("id")long id) {
		
		employeeService.findOne(id);
		model.addAttribute("employee",employeeService.findOne(id));
		return "employee-edit";
	}
	// update student 
	@GetMapping(value= {"/editEmployee"})
	public String updateEmployee( Model model,
			@RequestParam("id")long id,
			@RequestParam("name")String name,
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@RequestParam("birthday") Date birthday,
			@RequestParam("sex")int sex,
			@RequestParam("insurance")String insurance,
			@RequestParam("address")String address,
			@RequestParam("phone")String phone,
			@RequestParam("level")int level) {
		
		Employee employee = new Employee(id,name,birthday, sex,insurance, address, phone,level);
		employeeService.updateEmployee(employee);
		
		model.addAttribute("employeeList",employeeService.findAll());
		return "employee-list";
		
			
	}
	
	

}
