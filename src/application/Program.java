package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
//		System.out.println("===== findById seller teste =====");
//		Seller seller = sellerDao.findById(3);
//		System.out.println(seller);
//		System.out.println();
//		
//		
//		System.out.println("===== findById department teste =====");
//		Department department = departmentDao.findById(2);
//		System.out.println(department);
//		System.out.println();
//	
//		
//		List<Seller> vendedores = new ArrayList<>();
//		System.out.println("===== findByDepartment test =====");
//		Department department2 = new Department(2, null);
//		vendedores = sellerDao.findByDepartment(department2);
//		for (Seller sel : vendedores) {
//			System.out.println(sel);
//		}
//		System.out.println();
//		
//		
//		System.out.println("===== FindAll test =====");
//		vendedores = sellerDao.findAll();
//		for (Seller sel : vendedores) {
//			System.out.println(sel);
//		}
//		System.out.println();
//		
//		
//		System.out.println("===== INSERT test =====");
//		Seller seller2 = new Seller(null, "Kristian Kirschner", "kristianlll@hotmail.com", new Date(), 5000.0, department2);
//		sellerDao.insert(seller2);
//		System.out.println("Inserted! New id = " + seller2.getId());
//		System.out.println();
//		
//		
//		System.out.println("===== UPDATE test =====");
//		Department department3 = new Department(3, null);
//		Seller seller3 = new Seller(null, "Kristiano Ronaldo", "Kristiano@gmail.com", new Date(), 2300.0, department3);
//		sellerDao.update(seller3, 5);
//		System.out.println();
//		
//		
//		System.out.println("===== DELETE test =====");
//		sellerDao.deleteById(13);
//		System.out.println();
		
// 		#####################################################################################################
		
//		System.out.println("===== insert department teste =====");
//		Department department = new Department(null, "Executivo");
//		departmentDao.insert(department);
//		System.out.println("Inserted! New id = " + department.getId());
//		System.out.println();
		
//		System.out.println("===== update department teste =====");
//		Department department = new Department(null, "Administrativo");
//		departmentDao.update(department, 7);
//		System.out.println();
		
//		System.out.println("===== delete department teste =====");
//		departmentDao.deleteById(7);
//		System.out.println();
		
//		System.out.println("===== delete department teste =====");
//		Department dep =  departmentDao.findById(3);
//		System.out.println(dep);
		
		System.out.println("===== findAll department teste =====");
		List<Department> departments = new ArrayList<>();
		departments = departmentDao.findAll();
		for (Department dep : departments) {
			System.out.println(dep);
		}
		
	}

}
