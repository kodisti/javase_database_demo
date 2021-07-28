package hu.ulyssys.java.course.database.jpa;

import hu.ulyssys.java.course.database.jpa.dao.CustomerDAO;
import hu.ulyssys.java.course.database.jpa.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAMain {

    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = new Customer();
        customer.setCash(1);
        customer.setFullName("Szüts Bálint");
        customer.setUserName("szutsb");
        customerDAO.save(customer);

        customerDAO.findAll().forEach(customer1 -> {
            System.out.println(customer1.getId() + " " + customer1.getFullName() + " " + customer1.getUserName());
        });

        customerDAO.findByName("Szüts Bálint").forEach(customer1 -> {
            System.out.println(customer1.getId() + " " + customer1.getFullName() + " " + customer1.getUserName());
        });
    }
}
