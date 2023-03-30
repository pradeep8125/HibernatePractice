package annotation.main;
import annotation.datasource.DataSource;
import annotation.enitty.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class ExecutionAnnotationMain {
    public static void main(String[] args) {
        Employee employee = new Employee();
        DataSource dataSource = new DataSource();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter Emp Name");
        String empName = scanner.next();
        employee.setEmpName(empName);

        System.out.println("Enter emp Salary::");
        double salary = scanner.nextDouble();
        employee.setSalary(salary);

        //store to DB
        dataSource.storeDataInDatabase(employee);
    }
}
