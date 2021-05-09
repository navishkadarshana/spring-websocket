package lk.ijse.spring.Service.Impl;

import lk.ijse.spring.Service.CustomerService;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Service//---->//@Component
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired//---> CustomerRepo eke contax eke thiyanawanam ekh genala inject karanawa
    CustomerRepo repo;

    @Autowired
    ModelMapper mapper;


    @Override
    public void saveCustomer(CustomerDTO dto) {

        /*Customer customer =new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary());*/
        if(!repo.existsById(dto.getId())){

            Customer customer = mapper.map(dto, Customer.class);

            repo.save(customer);

        }else{

            throw  new RuntimeException("Customer is already exist!");

        }



    }

    @Override
    public void updateCustomer(CustomerDTO dto) {

        if (repo.existsById(dto.getId())){

            Customer customer = mapper.map(dto, Customer.class);

            repo.save(customer);
        }else {
            throw new RuntimeException("No Such Customer For Update!");
        }






    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        Optional<Customer> customer = repo.findById(id);
        if(customer.isPresent()){
            CustomerDTO cus = mapper.map(customer.get(), CustomerDTO.class);
            return cus;
        }else {
            throw new RuntimeException("No Customer For Update ID : "+id);
        }
    }

    @Override
    public void deleteCustomer(String id) {

        if(repo.existsById(id)){
            repo.deleteById(id);
        }else {
            throw new RuntimeException("No Customer For Delete ID : "+id);
        }


    }

    @Override
    public List<CustomerDTO> getAllCustomer() {

        List<Customer> all = repo.findAll();
        return mapper.map(all,new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public void getNotCustomer() {
        repo.getCustomerByIdIsNot("233");
    }
}
