package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;
import util.DatabaseUtil;

public class EmployeeDAO {
	
    private Connection connection;

    // Constructor que inicializa la conexi�n
    public EmployeeDAO() throws SQLException {
        connection = DatabaseUtil.getConnection();
    }
	
	// M�todo para agregar un empleado a la base de datos
	public void addEmployee(Employee employee) throws SQLException {
		String sql = "INSERT INTO employees (emp_no, birth_date, first_name, last_name, gender, hire_date) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection connection = DatabaseUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, employee.getEmpNo());
			statement.setDate(2, java.sql.Date.valueOf(employee.getBirthDate()));
			statement.setString(3, employee.getFirstName());
			statement.setString(4, employee.getLastName());
			statement.setString(5, employee.getGender());
			statement.setDate(6, java.sql.Date.valueOf(employee.getHireDate()));
			statement.executeUpdate();
		}
	}

	// M�todo para obtener un empleado por su n�mero de empleado
	public Employee getEmployee(int empNo) throws SQLException {
		String sql = "SELECT * FROM employees WHERE emp_no = ?";
		try (Connection connection = DatabaseUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, empNo);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return new Employee(resultSet.getInt("emp_no"), resultSet.getDate("birth_date").toLocalDate(),
						resultSet.getString("first_name"), resultSet.getString("last_name"),
						resultSet.getString("gender"), resultSet.getDate("hire_date").toLocalDate());
			} else {
				return null;
			}
		}
	}

	// M�todo para actualizar los datos de un empleado
	public void updateEmployee(Employee employee) throws SQLException {
		String sql = "UPDATE employees SET birth_date = ?, first_name = ?, last_name = ?, gender = ?, hire_date = ? "
				+ "WHERE emp_no = ?";
		try (Connection connection = DatabaseUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setDate(1, java.sql.Date.valueOf(employee.getBirthDate()));
			statement.setString(2, employee.getFirstName());
			statement.setString(3, employee.getLastName());
			statement.setString(4, employee.getGender());
			statement.setDate(5, java.sql.Date.valueOf(employee.getHireDate()));
			statement.setInt(6, employee.getEmpNo());
			statement.executeUpdate();
		}
	}

	// M�todo para eliminar un empleado por su n�mero de empleado
	public void deleteEmployee(int empNo) throws SQLException {
		String sql = "DELETE FROM employees WHERE emp_no = ?";
		try (Connection connection = DatabaseUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, empNo);
			statement.executeUpdate();
		}
	}
}