/**

 * 
 */
package com.employee.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.entity.Employee;

/**
 * @author usere
 *
 */
@Sql(scripts= {"classpath:/db/create-table.sql"})
@ContextConfiguration("classpath:data-context.xml")
@RunWith(SpringRunner.class)
public class EmployeeDaoImplTest {
	
	
	
	@Autowired
	EmployeeDao employeeDaoImpl;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void dbConnectionTest() throws SQLException {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		String user = "employee_user";
		String password = "employee123";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		Connection dbCon = null;
		
		try {
			dbCon = DriverManager.getConnection(jdbcUrl, user, password);
			
			assertThat(dbCon).isNotNull();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			dbCon.close();
		}
	}
	
	@Test
	public void saveEmployeeToDBTest() {
		
		Employee newEmployee = new Employee();
		newEmployee.setFirstname("Mary");
		newEmployee.setLastname("Black");
		newEmployee.setEmail("mary@gmail.com");
		newEmployee.setPhoneNUmber("08062871275");
		newEmployee.setDateOfBirth(Date.valueOf("2000-07-24"));
		
		
		assertThat(employeeDaoImpl).isNotNull();
		
		employeeDaoImpl.saveEmployee(newEmployee);
		
		int id = newEmployee.getEmployeeId();
		
		System.out.print("New Employee");
		
		Employee existingEmployee = employeeDaoImpl.getById(id);
		assertThat(existingEmployee).isNotNull();
		
		existingEmployee.setDateOfBirth(Date.valueOf("2000-07-24"));
		
		employeeDaoImpl.saveEmployee(existingEmployee);
				
	}

}
