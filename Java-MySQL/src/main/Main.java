package main;

import java.sql.SQLException;
import java.time.LocalDate;

import dao.EmployeeDAO;
import model.Employee;

public class Main {
	public static void main(String[] args) {
		// Ejemplo de uso del DAO para agregar un nuevo empleado
		try {
			EmployeeDAO employeeDAO = new EmployeeDAO();
//			Employee newEmployee = new Employee(10001, LocalDate.of(1990, 5, 15), "John", "Doe", "M",
//					LocalDate.of(2020, 1, 1));
//			employeeDAO.addEmployee(newEmployee);
//			System.out.println("Empleado agregado correctamente.");

			// Ejemplo de uso del DAO para obtener un empleado por su número de empleado
			int empNo = 10001;
			Employee retrievedEmployee = employeeDAO.getEmployee(empNo);
			System.out.println("Empleado recuperado: " + retrievedEmployee);

//			// Ejemplo de uso del DAO para actualizar los datos de un empleado
//			retrievedEmployee.setFirstName("Jane");
//			employeeDAO.updateEmployee(retrievedEmployee);
//			System.out.println("Empleado actualizado correctamente.");
//
//			// Ejemplo de uso del DAO para eliminar un empleado por su número de empleado
//			employeeDAO.deleteEmployee(empNo);
//			System.out.println("Empleado eliminado correctamente.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
