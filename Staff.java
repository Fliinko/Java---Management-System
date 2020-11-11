import java.io.*;
class Staff extends Person implements Serializable{
  // the prefix lets the program use Object Files
    protected String name, surname, ID;
    protected int StaffNo, telephoneNo;
    protected String status;
    
    public Staff(String n, String s, String ID, int TN, int SN, String st){
        super(n,s,ID,TN);
        StaffNo = SN;
        status = st;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public void setSurname(String s){
        surname = s;
    }
    
    public int getStaffNo(){
        return StaffNo;
    }
    
    public int telephoneNo(){
        return telephoneNo;
    }
    
    public void setTNO(int TNO){
        telephoneNo = TNO;
    }
    
    public String getID(){
        return ID;
    } 
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String st){
        status = st;
    }
     
    public String toString(){
        return (super.name + " " + super.surname + " " + super.ID + " " + StaffNo + " " + super.telephoneNo + " " + status + " ");
    }
    
    public boolean equals(Object obj){
        return getStaffNo()==(((Staff)obj).getStaffNo());
        //to enable indexOf() to be used in the method
    }
}