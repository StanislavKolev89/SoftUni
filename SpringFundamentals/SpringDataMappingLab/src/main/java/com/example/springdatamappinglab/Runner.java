package com.example.springdatamappinglab;

import com.example.springdatamappinglab.entity.*;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    private final AddressRepository addressRepository;
    private final EmployeeRepository employeeRepository;

    public Runner(AddressRepository addressRepository, EmployeeRepository employeeRepository) {
        this.addressRepository = addressRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {


     ModelMapper mp = new ModelMapper();
//        Address address = new Address("sgasafds");
//        Address address2 = new Address("asgqagafsasf");
//        Employee employeeFirst = new Employee("gosho", "petrov", BigDecimal.valueOf(1000), LocalDate.now(), address, false);
//        Employee employeeSecond = new Employee("mariq", "vvvvv", BigDecimal.valueOf(2000), LocalDate.now(), address2, false);
//        Employee manager = new Employee("shefa", "pesho", BigDecimal.valueOf(1000000), LocalDate.now(), address, true);
//        employeeFirst.setManager(manager);
//        employeeSecond.setManager(manager);
//        addressRepository.save(address);
//        addressRepository.save(address2);
//        employeeRepository.save(manager);
//        employeeRepository.save(employeeFirst);
//        employeeRepository.save(employeeSecond);


        List<Employee> allEmployees = employeeRepository.findAllByBirthdayBeforeOrderBySalaryDesc(LocalDate.of(2025, 1, 1));
        allEmployees.forEach(e->{
            System.out.println(mp.map(e,EmployeeDto.class));
        });
    }
}
