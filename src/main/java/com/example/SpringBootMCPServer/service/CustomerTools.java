package com.example.SpringBootMCPServer.service;

import com.example.SpringBootMCPServer.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;

import java.util.List;

@Component
public class CustomerTools {

    private final EmployeeService employeeService;

    public CustomerTools(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @McpTool(
            name = "get_employee_by_first_name",
            description = "Get customer information by first name"
    ) // @McpTool = Expose this Java method as an MCP tool
    public List<Employee> getEmployeeByFirstName(
            @McpToolParam(
                    description = "The customer first name",
                    required = true
            )
            String firstName
    ) {
        return employeeService.findByFirstName(firstName);
    }
}
