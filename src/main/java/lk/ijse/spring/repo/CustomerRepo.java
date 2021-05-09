package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    Customer findCustomerByName(String name);

    Customer getCustomerByIdIsNot(String id);

    List<Customer> findAllByAddress(String address);

    long countAllById(String id);

    Customer findCustomerByNameAndAddress(String name,String address);

    List<Customer> findCustomerByAddressContaining(String customer);//like,contains,containing----

    @Query(value = "SELECT * FROM customer WHERE id='C002'",nativeQuery = true)
    Customer getMyCustomer();


//  params
    //* positional parameters
    //* Named parameters

    //* positional parameters--->

    @Query(value = "SELECT * FROM customer WHERE id=?1 AND name=?2",nativeQuery = true)
    Customer getMyCustomer2(String id,String name);

    //* Named parameters---->

    @Query(value = "SELECT * FROM customer WHERE id=:myId AND name=:myName",nativeQuery = true)
    Customer getMyCustomer3(@Param("myId") String id, @Param("myName") String name);

    //JPQL
    @Query(value = "SELECT C FROM Customer C")
    List<Customer> allCustomers();

    //JPQL
    @Query(value = "SELECT c FROM Customer c WHERE c.id=?1")
    Customer allCustomers2(String id);


    //HQL
    @Query(value = "FROM Customer C")
    List<Customer> allCustomers3();


}
