package com.aht;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.aht.entities.Contract;
import com.aht.entities.ContractEmployee;
import com.aht.entities.Department;
import com.aht.entities.Employee;
import com.aht.entities.Parts;
import com.aht.entities.Training;
import com.aht.entities.TrainingEmployee;
import com.aht.service.ContractEmployeeService;
import com.aht.service.ContractService;
import com.aht.service.DepartmentService;
import com.aht.service.EmployeeService;
import com.aht.service.PartsService;
import com.aht.service.TrainingEmployeeService;
import com.aht.service.TrainingService;



@SpringBootApplication

public class QlnsApplication implements CommandLineRunner{

	@Autowired private PartsService partsService;
	@Autowired private DepartmentService departmentService;
	@Autowired private EmployeeService employeeService;
	@Autowired private TrainingService trainingService;
	@Autowired private TrainingEmployeeService trainingEmployeeService;
	@Autowired private ContractService contractService;
	@Autowired private ContractEmployeeService contractEmployeeService;
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(QlnsApplication.class);
    }
	
	
	public static void main(String[] args) {

		SpringApplication.run(QlnsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Parts part1 = new Parts("Part1");
//		Parts part2 = new Parts("Part2");
//		Parts part3 = new Parts("Part3");	
//		partsService.createPart(part1);
//		partsService.createPart(part2);
//		partsService.createPart(part3);
//		
//		
//		Department department1 = new Department("Department1",part1);
//		Department department2 = new Department("Department2",part1);
//		Department department3 = new Department("Department3",part2);
//		departmentService.createDepartment(department1);
//		departmentService.createDepartment(department2);
//		departmentService.createDepartment(department3);
//		
//		Date date1 = new Date();
//		Employee employee1 = new Employee("Employe1",date1,1, "insurance1", "Ha tay", "0974018099", 1,department1);
//		Employee employee2 = new Employee("Employe2",date1,0, "insurance2", "Ha tay", "0974018099", 2,department1);
//		Employee employee3 = new Employee("Employe3",date1,1, "insurance3", "Ha tay", "0974018099", 2,department2);
//		Employee employee4 = new Employee("Employe4",date1,0, "insurance4", "Ha tay", "0974018099", 1,department3);
//		employeeService.createEmployee(employee1);
//		employeeService.createEmployee(employee2);
//		employeeService.createEmployee(employee3);
//		employeeService.createEmployee(employee4);
//		
//		Contract contract1 = new Contract("contractCode1",1);
//		Contract contract2 = new Contract("contractCode2",0);
//		Contract contract3 = new Contract("contractCode2",3);
//		contractService.createContract(contract1);
//		contractService.createContract(contract2);
//		contractService.createContract(contract3);
//		
//		ContractEmployee contractEmployee1 = new ContractEmployee(date1,date1,1,contract1,employee1);
//		ContractEmployee contractEmployee2 = new ContractEmployee(date1,date1,1,contract1,employee3);
//		ContractEmployee contractEmployee3 = new ContractEmployee(date1,date1,1,contract2,employee1);
//		ContractEmployee contractEmployee4 = new ContractEmployee(date1,date1,1,contract2,employee1);
//		ContractEmployee contractEmployee5 = new ContractEmployee(date1,date1,1,contract3,employee2);
//		contractEmployeeService.createContractEmployee(contractEmployee1);
//		contractEmployeeService.createContractEmployee(contractEmployee2);
//		contractEmployeeService.createContractEmployee(contractEmployee3);
//		contractEmployeeService.createContractEmployee(contractEmployee4);
//		contractEmployeeService.createContractEmployee(contractEmployee5);
//		
//		
//		Training training1 = new Training("traningCode1", "Traning1", date1, date1, 1);
//		Training training2 = new Training("traningCode2", "Traning2", date1, date1, 0);
//		Training training3 = new Training("traningCode3", "Traning3", date1, date1, 1);
//		trainingService.createTraining(training1);
//		trainingService.createTraining(training2);
//		trainingService.createTraining(training3);
//		
//		TrainingEmployee trainingEmployee1 = new TrainingEmployee("truot", employee1, training1);
//		TrainingEmployee trainingEmployee2 = new TrainingEmployee("truot", employee1, training1);
//		TrainingEmployee trainingEmployee3 = new TrainingEmployee("qua", employee2, training2);
//		TrainingEmployee trainingEmployee4 = new TrainingEmployee("truot", employee2, training3);
//		TrainingEmployee trainingEmployee5 = new TrainingEmployee("qua", employee3, training2);
//		trainingEmployeeService.createTrainingEmployee(trainingEmployee1);
//		trainingEmployeeService.createTrainingEmployee(trainingEmployee2);
//		trainingEmployeeService.createTrainingEmployee(trainingEmployee3);
//		trainingEmployeeService.createTrainingEmployee(trainingEmployee4);
//		trainingEmployeeService.createTrainingEmployee(trainingEmployee5);
		
	}
}
