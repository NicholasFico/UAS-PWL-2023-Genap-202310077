package com.ta.mieangke.Detail_Order;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ta.mieangke.dto.ResponseData;

@RestController
@RequestMapping("/api/detail_order")
public class Detail_OrderController {
    
    @Autowired
    private Detail_OrderServices detail_OrderServices;

    @PostMapping()
    public ResponseEntity<ResponseData<Detail_Order>> postStudents(@Valid @RequestBody Detail_Order detail_Order, Errors errors) {
        
        ResponseData<Detail_Order> responseData = new ResponseData<>();
        
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setResult(false);
            responseData.setData(null);
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setResult(true);
        List<Detail_Order>value = new ArrayList<>();
        value.add(detail_OrderServices.save(detail_Order));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public ResponseEntity<ResponseData<Detail_Order>> fetchMenu() {
        ResponseData<Detail_Order> responseData = new ResponseData<>();
        try {
            Iterable<Detail_Order> values = detail_OrderServices.findAll();
            responseData.setResult(true);
            responseData.setMessage(null);
            responseData.setData(values);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<Detail_Order>> fetchMenuById(@PathVariable("id") int id) {
        ResponseData<Detail_Order> responseData = new ResponseData<>();
        try {
            Detail_Order values = detail_OrderServices.findOne(id);
            List<Detail_Order> result = new ArrayList<>();
            result.add(values);
            responseData.setResult(true);
            responseData.setMessage(null);
            responseData.setData(result);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @PutMapping
    public ResponseEntity<ResponseData<Detail_Order>> updateMenu(@Valid @RequestBody Detail_Order detail_Order, Errors errors) {

        ResponseData<Detail_Order> responseData = new ResponseData<>();

        if (detail_Order.getId() != 0) {
            if (errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    responseData.getMessage().add(error.getDefaultMessage());
                }
                responseData.setResult(false);
                responseData.setData(null);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }

            responseData.setResult(true);
            List<Detail_Order> value = new ArrayList<>();
            value.add(detail_OrderServices.save(detail_Order));
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
        } else {
            responseData.setResult(false);
            responseData.setData(null);
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<Detail_Order>> deleteMenuById(@PathVariable("id") int id) {
        ResponseData<Detail_Order> responseData = new ResponseData<>();
        if (id != 0) {
            try {
                detail_OrderServices.removeOne(id);
                List<String> message = new ArrayList<>();
                message.add("Successfully removed");
                responseData.setMessage(message);
                responseData.setData(null);
                responseData.setResult(true);
                return ResponseEntity.ok(responseData);
            } catch (Exception e) {
                List<String> message = new ArrayList<>();
                message.add(e.getMessage());
                responseData.setMessage(message);
                responseData.setData(null);
                responseData.setResult(false);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }
        } else {
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

}

