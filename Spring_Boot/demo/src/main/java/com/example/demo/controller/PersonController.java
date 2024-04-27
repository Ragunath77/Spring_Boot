package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class PersonController{
    @Autowired
    private PersonService ps;

    @PostMapping("/emp")
    public ResponseEntity<Person> createPatient(@RequestBody Person product){
        Person createdProduct=ps.createPatient(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping("/emp")
    public List<Person> getAllPatients(){
        return ps.getAllPatients();
    }

    @GetMapping("/emp/{empid}")
    public Optional<Person> getPatientById(@PathVariable int empid){
        Optional<Person> product=ps.getPatientById(empid);
        return product;
    }
    @PutMapping("/emp/{empid}")
    public ResponseEntity<Person> putMethod(@PathVariable("empid") int empid,@RequestBody Person l)
    {
        if(ps.updateDetails(empid,l) == true)
        {
            return new ResponseEntity<>(l,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("/emp/{empid}")
    public ResponseEntity<Boolean> delete(@PathVariable("empid") int empid)
    { 
        if(ps.deleteStudent(empid) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

}