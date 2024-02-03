//*******************************************************************************************
//*  Hakan Gezginci
//* 
//*  The program demonstrates an object-oriented approach to representing an organizational
//*  hierarchy, facilitating scalability and maintainability in managing complex organizational structures.
//*  The provided tests ensure the correctness of the implemented functionality.
//*******************************************************************************************

/** 
* 
*  Organization Management System
*
*  This program models an organization management system using a hierarchy of employee classes.
*  The Employee interface serves as the base abstraction with methods for retrieving the
*  employee's name, role, and displaying details. Three leaf classes (HumanResources, Developer,
*  Sales) represent different types of employees, each with unique attributes and roles.
*  The Composite class (Department) is responsible for managing a group of employees and
*  implements logic for adding employees to departments based on specific criteria.
*  The OrganizationDemo class demonstrates the construction of an organization structure by
*  creating instances of employees and departments, adding them to the organization, and
*  displaying the overall hierarchy.
*  
*  Components:
*  - Base Interface: Employee
*  - Leaf Classes: HumanResources, Developer, Sales
*  - Composite Class: Department
*  - Client Code: OrganizationDemo
*  - Test Class: OrganizationDemoTest
*  
*  The Department class includes methods for adding and removing employees while enforcing
*  business rules, such as only adding salespersons meeting revenue targets. The OrganizationDemo
*  class illustrates the organization's structure and employee hierarchy.
*  
*  Unit tests in OrganizationDemoTest validate the functionality of individual classes and
*  their interactions. These tests cover scenarios such as employee details retrieval,
*  department management, and business rules enforcement.
*/



public class OrganizationDemo {
    public static void main(String[] args) {
        Developer dev1 = new Developer("John Doe", "Software Engineer", "Youtube");
        Developer dev2 = new Developer("Jane Smith", "UI/UX Designer", "Google Maps");
        Developer dev3 = new Developer("Bob Miller", "Senior Software Engineer", "Youtube");

        Sales sales1 = new Sales("Alice Johnson", "Sales Executive", 54975, 100000);
        Sales sales2 = new Sales("Tom White", "Sales Manager", 97400, 100000);
        Sales sales3 = new Sales("Sam Brown", "Sales Executive", 24966, 100000);
        Sales sales4 = new Sales("Sara Johnson", "Sales Executive", 100000, 100000);
        Sales sales5 = new Sales("Tom White", "Sales Manager", 100000, 100000);

        HumanResources hr1 = new HumanResources("Mary Miller", "Tech Recruiter");
        HumanResources hr2 = new HumanResources("David Smith", "HR Manager");
        HumanResources hr3 = new HumanResources("Linda Johnson", "Tech Talent Trainer");

        Department engineeringDept = new Department("Engineering Department");
        engineeringDept.addEmployee(dev1);
        engineeringDept.addEmployee(dev2);
        engineeringDept.addEmployee(dev3);

        Department salesDept = new Department("Sales Department");
        salesDept.addEmployee(sales1);
        salesDept.addEmployee(sales2);
        salesDept.addEmployee(sales3);
        salesDept.addEmployee(sales4);
        salesDept.addEmployee(sales5);

        Department hrDept = new Department("HR Department");
        hrDept.addEmployee(hr1);
        hrDept.addEmployee(hr2);
        hrDept.addEmployee(hr3);

        Department organization = new Department("XYZ Corporation");
        organization.addEmployee(engineeringDept);
        organization.addEmployee(salesDept);
        organization.addEmployee(hrDept);

        organization.displayEmployeeDetails();
    }
}
