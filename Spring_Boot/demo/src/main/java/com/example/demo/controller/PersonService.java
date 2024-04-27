package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService{
    @Autowired
    private PersonRepo pr;
    public Person createPatient(Person p){
        return pr.save(p);
    }

    public List<Person> getAllPatients(){
        return pr.findAll();
    }
    public Optional<Person> getPatientById(Integer CustomerId){
        return pr.findById(CustomerId);
    }
    public boolean updateDetails(int CustomerId,Person l)
    {
        if(this.getPatientById(CustomerId)==null)
        {
            return false;
        }
        try{
            pr.save(l);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
public boolean deleteStudent(int CustomerId)
    {
        if(this.getPatientById(CustomerId) == null)
        {
            return false;
        }
        pr.deleteById(CustomerId);
        return true;
    }



}