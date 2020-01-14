package com.stackroute.demo01;

public class RecordService 
{
    DatabaseDAO database;
    NetworkDAO network;
     
    //setters and getters
 
    public boolean save(String fileName) 
    {
        database.save(fileName);
        System.out.println("Saved in database in Main class");
         
        network.save(fileName);
        System.out.println("Saved in network in Main class");
         
        return true;
    }
    
    public boolean exceptioncheck() throws RuntimeException{
 
    	throw new RuntimeException();
    }
}