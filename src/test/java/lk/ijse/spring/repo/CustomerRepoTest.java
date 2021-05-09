package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CustomerRepoTest {

    @Autowired
    CustomerRepo repo;

    @Test
    public void saveCustomer(){
        Customer customer1=new Customer("C001","Danapala","Panadura",123400);
        Customer customer2=new Customer("C002","Amarapala","Colombo",12000);
        Customer customer3=new Customer("C003","Gunapala","Kandy",35000);
        Customer customer4=new Customer("C004","kasun","Piliyandara",300000);

        repo.save(customer1);
        repo.save(customer2);
        repo.save(customer3);
        repo.save(customer4);


        List<Customer> all = repo.findAll();
        assertTrue(all.size()==4);

    }

    @Test
    public void getCustomerByName(){
        Customer name = repo.findCustomerByName("Danapala");
        Assert.assertNotNull(name);
        assertNotNull(name);
        System.out.println("========================================");
        System.out.println(name.getAddress());
        System.out.println("========================================");
    }



    @Test
    public void findAllByAddress(){
        List<Customer> address = repo.findAllByAddress("Panadura");
        Assert.assertNotNull(address);
        assertNotNull(address);
        System.out.println("========================================");
        System.out.println(address.size());
        System.out.println("========================================");

    }


    @Test
    public void countByID(){

        long id = repo.countAllById("C002");
        Assert.assertNotNull(id);
        assertNotNull(id);
        System.out.println("========================================");
        System.out.println(id);
        System.out.println("========================================");

    }



    @Test
    public void findCustomerByIdAndName(){

        Customer customerByNameAndAddress = repo.findCustomerByNameAndAddress("Amarapala", "Colombo");
        Assert.assertNotNull(customerByNameAndAddress);
        assertNotNull(customerByNameAndAddress);
        System.out.println("========================================");
        System.out.println(customerByNameAndAddress.getId());
        System.out.println("========================================");

    }



    @Test
    public void findCustomerByAddressContainig(){

        List<Customer> customerByAddressContaining = repo.findCustomerByAddressContaining("P");
        Assert.assertNotNull(customerByAddressContaining);
        assertNotNull(customerByAddressContaining);
        System.out.println("========================================");
        System.out.println(customerByAddressContaining.size());
        System.out.println(customerByAddressContaining.get(0).getId());
        System.out.println("========================================");

    }


    @Test
    public void findCustomerByNativeQuery(){

        Customer myCustomer = repo.getMyCustomer();
        System.out.println("========================================");
        System.out.println(myCustomer.getName());
        System.out.println("========================================");


    }


    @Test
    public void findCustomerByPositionalParameters(){

        Customer myCustomer1 = repo.getMyCustomer2("C002","Amarapala");
        System.out.println("========================================");
        System.out.println(myCustomer1.getName());
        System.out.println("========================================");


    }


    @Test
    public void findCustomerByNamedParameters(){

        Customer myCustomer1 = repo.getMyCustomer3("C002","Amarapala");
        System.out.println("========================================");
        System.out.println(myCustomer1.getSalary());
        System.out.println("========================================");
    }


    @Test
    public void findCustomerByJPQL(){

        List<Customer> customers = repo.allCustomers();
        System.out.println("========================================");
        System.out.println(customers.size());
        System.out.println(customers.get(2).getId());
        System.out.println("========================================");
    }


    @Test
    public void findCustomerByJPQL2(){

        Customer customer=repo.allCustomers2("C002");
        System.out.println("========================================");
        System.out.println(customer.getName());
        System.out.println("========================================");
    }


    @Test
    public void findCustomerByHQL(){

        List<Customer> customers = repo.allCustomers3();
        System.out.println("========================================");
        System.out.println(customers.size());
        System.out.println(customers.get(2).getId());
        System.out.println("========================================");
    }

}