import java.util.*;
import java.io.*;
class Moderator extends Person implements Serializable{
    
    protected String name, surname, ID, password;
    protected int StaffNo, telephoneNo;
    
    public Moderator(String n, String s, String ID, String p, int SN, int TN){
     super(n,s,ID,TN);
     password = p;
     StaffNo = SN;
    }
    
    public String getName(){
        return name;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public String getID(){
        return ID;
    }
    
    public String getPassword(){
        return password;
    }
    
    public int getStaffNo(){
        return StaffNo;
    }
    
    public int getTelNo(){
        return telephoneNo;
    }
    
     public String toString(){
        return name + " " + surname + " " + ID + " " + password + " " + StaffNo + " " + telephoneNo + " ";
    }
    
    public boolean equalst(Object obj){
        return getPassword()==(((Moderator)obj).getPassword());
    }
}
