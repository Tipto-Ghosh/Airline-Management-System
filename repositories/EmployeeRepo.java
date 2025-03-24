package repositories;
import java.lang.*;
import entities.*;
import interfaces.*;

public class EmployeeRepo implements IEmployeeRepo {
    private static final int maxEmployee = 100;
    private static final String FILE_PATH = "repositories/data/employee.txt";

    public void writeEmployee(Employee[] employeeList) {
        String[] employeeInfo = new String[maxEmployee];
        int count = 0;

        for (Employee employee : employeeList) {
            if (employee != null) {
                employeeInfo[count] = employee.toStringEmployee();
                count++;
            }
        }

        FileIO f = new FileIO();
        f.writeFile(employeeInfo, FILE_PATH);
    }

    public Employee[] getAllEmployeeList() {
        FileIO f = new FileIO();
        String[] data = f.readFile(FILE_PATH);
        Employee[] employeeList = new Employee[maxEmployee];

        if (data != null) {
            int i = 0;
            for (String str : data) {
                if (str != null && !str.trim().isEmpty()) {
                    Employee employee = new Employee().formEmployee(str);
                    if (employee != null) {
                        employeeList[i] = employee;
                        i++;
                    }
                }
            }
        }
        return employeeList;
    }

    public boolean addEmployee(Employee e) {
        Employee[] employeeList = this.getAllEmployeeList();
        boolean flag = false;

        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] == null) {
                employeeList[i] = e;
                flag = true;
                break;
            }
        }

        if (flag) {
            this.writeEmployee(employeeList);
        } else {
            System.out.println("Error: Employee list is full. Cannot add more employees.");
        }

        return flag;
    }

    public boolean removeEmployee(String id) {
        Employee[] employeeList = this.getAllEmployeeList();
        boolean flag = false;

        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getUserId().equals(id)) {
                employeeList[i] = null;
                flag = true;
                break;
            }
        }

        if (flag) {
            this.writeEmployee(employeeList);
        } else {
            System.out.println("Error: Employee not found with userId: " + id);
        }

        return flag;
    }

    public boolean updateEmployee(Employee e) {
        Employee[] employeeList = this.getAllEmployeeList();
        boolean flag = false;

        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getUserId().equals(e.getUserId())) {
                employeeList[i] = e;
                flag = true;
                break;
            }
        }

        if (flag) {
            this.writeEmployee(employeeList);
        } else {
            System.out.println("Error: Employee not found with userId: " + e.getUserId());
        }

        return flag;
    }

    public Employee searchEmployeeById(String id) {
        Employee[] employeeList = this.getAllEmployeeList();

        for (Employee employee : employeeList) {
            if (employee != null && employee.getUserId().equals(id)) {
                return employee;
            }
        }

        return null;
    }
}
