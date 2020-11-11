import java.util.*;
import java.io.*;
class Person implements Serializable{
    
    protected String name, surname, ID;
    protected int telephoneNo;
    
    //parametered constructor -----------------------------
    public Person(String n, String s, String ID, int TNO){
        name = n;
        surname = s;
        this.ID = ID;
        telephoneNo = TNO;
    }
    //-----------------------------------------
    //setters------------------------------------
    public void setName(String n){
        name = n;
    }
    
    public void setSurname(String s){
        surname = s;
    }
    
    public void setID(String ID){
        this.ID = ID;
    }
  
    public void setTNO(int TNO){
        telephoneNo = TNO;
    }
    //-----------------------------------------------
    //getters----------------------------------------
    public String getName(){
        return name;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public String getID(){
        return ID;
    }
    
    public int getTNO(){
        return telephoneNo;
    }
    
    public String toString(){
        return  (name + " " + surname + " " + ID + " " + telephoneNo + " ");
    }
}
    