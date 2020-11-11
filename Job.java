import java.io.*;
import java.util.*;
class Job implements Serializable{
    
    private int JobNo;
    private String PlaneRegNo;
    private String status;
    private int staffID;
    
    public Job(int JN, String PN, String st, int sID){
        JobNo = JN;
        PlaneRegNo = PN;
        status = st;
        staffID = sID;
    }
   
    public int getsID(){
        return staffID;
    }
    
    public int getJobNo(){
        return JobNo;
    }
    
    public String getPlaneRegNo(){
        return PlaneRegNo;
    }
    
    public void setPlaneRegNo(String PN){
        PlaneRegNo = PN;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String st){
        status = st;
    }
    
    public String toString(){
        return JobNo + " " + PlaneRegNo + " " + status + " " + staffID + " ";
    }
    
    public boolean equals(Object obj){
        return getJobNo()==(((Job)obj).getJobNo());
    }
}