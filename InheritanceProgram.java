class Employee {
     public static double salary;

     void DisplaySalary() {
          System.out.println("Base Salary: " + salary);
     }
}

class FullTimeEmployee extends Employee {
     double hike = salary * 0.5 + salary;

     void CalSalary() {
          System.out.println("Full Time Employee Salary: " + hike);
     }
}

class InternEmployee extends Employee {
     double hike = salary * 0.25 + salary;

     void CalSalary() {
          System.out.println("Intern Employee Salary Salary: " + hike);
     }
}

public class InheritanceProgram {
     public static void main(String args[]) {
          Employee.salary = 25000.00;

          Employee em = new Employee();
          FullTimeEmployee ftem = new FullTimeEmployee();
          InternEmployee item = new InternEmployee();

          em.DisplaySalary();
          ftem.CalSalary();
          item.CalSalary();
     }
}