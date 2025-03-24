package entities;

import java.lang.*;

public class Employee extends User {
    private String designation;
    private int salary;

    public Employee() {
        super();
    }

    public Employee(String userId, String name, String email, String phoneNo, String gender, int age, String address, int role, String securityAns, String password, String designation, int salary) {
        super(userId, name, email, phoneNo, gender, age, address, role, securityAns, password);
        this.designation = designation;
        this.salary = salary;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return this.designation;
    }

    public int getSalary() {
        return this.salary;
    }

    public String toStringEmployee() {
        return this.userId + "," + this.name + "," + this.email + "," + this.phoneNo + "," + this.gender + "," + this.age + "," + this.address + "," + this.role + "," + this.securityAns + "," + this.password + "," + this.designation + "," + this.salary + "\n";
    }

    public Employee formEmployee(String employeeInfoLine) {
        String[] employeeInfo = employeeInfoLine.split(",");
        if (employeeInfo.length < 12) {
            System.out.println("Missing info to form an Employee.");
            return null;
        }

        try {
            Employee employee = new Employee();
            employee.setUserId(employeeInfo[0]);
            employee.setName(employeeInfo[1]);
            employee.setEmail(employeeInfo[2]);
            employee.setPhoneNo(employeeInfo[3]);
            employee.setGender(employeeInfo[4]);
            employee.setAge(Integer.parseInt(employeeInfo[5]));
            employee.setAddress(employeeInfo[6]);
            employee.setRole(Integer.parseInt(employeeInfo[7]));
            employee.setSecurityAns(employeeInfo[8]);
            employee.setPassword(employeeInfo[9]);
            employee.setDesignation(employeeInfo[10]);
            employee.setSalary(Integer.parseInt(employeeInfo[11]));
            return employee;
        }
        catch (Exception e) {
            System.out.println("Missing Info format in employeeInfoLine.");
            return null;
        }
    }
}
