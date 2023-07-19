package com.ta.mieangke.Menu;

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
import com.ta.mieangke.dto.SearchData;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    
    @Autowired
    private MenuServices menuServices;

    @PostMapping()
    public ResponseEntity<ResponseData<Menu>> postStudents(@Valid @RequestBody Menu menu, Errors errors) {
        
        ResponseData<Menu> responseData = new ResponseData<>();
        
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setResult(false);
            responseData.setData(null);
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setResult(true);
        List<Menu>value = new ArrayList<>();
        value.add(menuServices.save(menu));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public ResponseEntity<ResponseData<Menu>> fetchMenu() {
        ResponseData<Menu> responseData = new ResponseData<>();
        try {
            Iterable<Menu> values = menuServices.findAll();
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
    public ResponseEntity<ResponseData<Menu>> fetchMenuById(@PathVariable("id") int id) {
        ResponseData<Menu> responseData = new ResponseData<>();
        try {
            Menu values = menuServices.findOne(id);
            List<Menu> result = new ArrayList<>();
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
    public ResponseEntity<ResponseData<Menu>> updateMenu(@Valid @RequestBody Menu menu, Errors errors) {

        ResponseData<Menu> responseData = new ResponseData<>();

        if (menu.getId() != 0) {
            if (errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    responseData.getMessage().add(error.getDefaultMessage());
                }
                responseData.setResult(false);
                responseData.setData(null);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }

            responseData.setResult(true);
            List<Menu> value = new ArrayList<>();
            value.add(menuServices.save(menu));
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
    public ResponseEntity<ResponseData<Menu>> deleteMenuById(@PathVariable("id") int id) {
        ResponseData<Menu> responseData = new ResponseData<>();
        if (id != 0) {
            try {
                menuServices.removeOne(id);
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

    @PostMapping("/search")
  public ResponseEntity<ResponseData<Menu>> getMenuByName(@RequestBody SearchData searchData) {
    ResponseData<Menu> responseData = new ResponseData<>();

    try{
      Iterable<Menu> values = menuServices.findByName(searchData.getSearchKey());
      responseData.setResult(true);
      responseData.setMessage(null);
      responseData.setData(values);
      return ResponseEntity.ok(responseData);

    } catch (Exception e ) {
      List<String> message = new ArrayList<>();
      message.add(e.getMessage());
      responseData.setMessage(message);
      responseData.setData(null);
      responseData.setResult(false);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }
  }
}

