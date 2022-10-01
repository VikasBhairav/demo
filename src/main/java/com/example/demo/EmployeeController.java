package com.example.demo;

import com.example.demo.config.AppDevConfig;
import com.example.demo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AppDevConfig appConfig;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Vikas";
    }

    @GetMapping("/app-config")
    public String getAppConfig(){
        return appConfig.toString();
    }

    @Operation(summary="Get employee by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "302", description = "Found the book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class)) })
    }
    )
    @GetMapping("/employee")
    public ResponseEntity<Employee> getEmployee(@RequestParam("id") Integer id){
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee.isPresent() ? employee.get() : null, employee.isPresent() ? HttpStatus.FOUND : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> add(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.add(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.update(employee), HttpStatus.OK);
    }
}

