package com.steve.boot.launch.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

@Data
@Configuration
@PropertySource(value = "classpath:employee.properties")
public class Employee {
    @Value("#{'${employee.names}'.split('\\|')}")
    private List<String> names;

    @Value("#{'${employee.names}'.split('\\|')[0]}")
    private String firstEmployeeName;

    @Value("#{'${employee.names}'.split('\\|')[2]}")
    private String lastEmployeeName;

    @Value("#{${employee.age}}")
    private Map<String, Integer> employeeAges;

    //@Value("#{${employee.age}.two}")
    @Value("#{${employee.age}['two']}")
    private String employeeAgeTwo;

    @Value("#{${employee.age}['five']?:31}")
    private String employeeAgeDefaultValue;

    @Value("#{systemProperties['user.dir']}")
    private String userDir;

    @Value("#{systemProperties['java.home']}")
    private String javaHome;
}
