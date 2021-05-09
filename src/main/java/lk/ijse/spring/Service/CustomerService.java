package lk.ijse.spring.Service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;

import java.util.List;

public interface CustomerService {

   void saveCustomer(CustomerDTO dto);
   void updateCustomer(CustomerDTO dto);
   CustomerDTO searchCustomer(String id);
   void deleteCustomer(String id);
   List<CustomerDTO> getAllCustomer();
   void getNotCustomer();

}
