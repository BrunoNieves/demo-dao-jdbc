package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===TEST 1: Department findById ===");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		
		System.out.println("=== TEST 2: Department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("=== TEST 3: insert Department ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id: " + newDepartment.getId());
		
		
		System.out.println("=== TEST 4 Department update ===");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update Completed!");
		
		System.out.println("=== TEST 5: delete Department ===");
		System.out.println("Enter id for delete test: ");
		int id = teclado.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted completed: ");
		
		teclado.close();
	}
}
