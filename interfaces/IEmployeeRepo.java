package interfaces;

import java.lang.*;
import entities.*;

public interface IEmployeeRepo {
     
    Employee searchEmployeeById(String id);
    Employee[] getAllEmployeeList();
    boolean addEmployee(Employee e);
    boolean updateEmployee(Employee e);
    boolean removeEmployee(String id);

}