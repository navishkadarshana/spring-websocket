package lk.ijse.spring.Controller;
import lk.ijse.spring.Service.CustomerService;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    private SimpMessagingTemplate template;


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addCustomer(@RequestBody CustomerDTO dto){
        if(dto!=null){
            this.template.convertAndSend("/topic/add-customer", dto);
        }
        StandradResponse success = new StandradResponse(200, "success", null);
        return new ResponseEntity(success, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto){

        customerService.updateCustomer(dto);
        StandradResponse success = new StandradResponse(200, "success", null);
        return new ResponseEntity(success, HttpStatus.OK);
    }



    @GetMapping(path = "/{id}")
    public ResponseEntity searchCustomer(@PathVariable String id){

        CustomerDTO customerDTO = customerService.searchCustomer(id);
        StandradResponse success = new StandradResponse(200, "success", customerDTO);
        return new ResponseEntity(success, HttpStatus.OK);
    }



    @DeleteMapping(params = {"id"})
    public ResponseEntity<StandradResponse> deleteCustomer(@RequestParam String id){

        customerService.deleteCustomer(id);
        StandradResponse success = new StandradResponse(200, "success", null);
        return new ResponseEntity(success, HttpStatus.OK);
    }



    @GetMapping
    public ResponseEntity<StandradResponse> getAllCustomer(){

        List<CustomerDTO> allCustomer = customerService.getAllCustomer();
        StandradResponse success = new StandradResponse(200, "success", allCustomer);
        return new ResponseEntity(success, HttpStatus.OK);
    }

}
