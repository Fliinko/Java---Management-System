import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
public class Manipulate_Job implements Serializable{
    
    public void addJob(ArrayList<Job>jobListIn){
        int tempJobNo = 0;
        String tempPlaneRegNo = null;
        String tempStatus = null;
        int tempsID = 0;
        
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        
        try{
        System.out.print("Please enter the Job Number: ");
        tempJobNo = sc.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Number instead of a character");
            sc.next();
        }
        try{
        System.out.print("Please enter the Plane Registration Number: ");
        tempPlaneRegNo = sc.next();
        }
        catch(InputMismatchException e){
            System.out.println("Number instead of a character");
            sc.next();
        }
        try{
        System.out.print("Please enter the Job Status: ");
        tempStatus = sc.next();
        }
        catch(InputMismatchException e){
            System.out.println("Number instead of a character");
            sc.next();
        }
        try{
            System.out.println("Please enter the staff ID number working on the job");
            tempsID = sc.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Character instead of number");
            sc.next();
        }
        jobListIn.add(new Job(tempJobNo, tempPlaneRegNo, tempStatus, tempsID ));
    }
    
    public void ask_new_details(ArrayList<Job>jobListIn, int findJob, int pos){
        Scanner keyboard = new Scanner(System.in);
        keyboard.useDelimiter("\n");
        Job tJob;
        boolean stop, result;
        char choice;
        tJob = jobListIn.get(pos);
        String tempPlaneRN = tJob.getPlaneRegNo();
        String tempStatus = tJob.getStatus();
        
        do{
            stop = false;
            
            do{
                System.out.println("A.. to edit Plane Registration Number");
                System.out.println("B.. to edit Status");
                System.out.println("C.. to exit");
                
                choice = keyboard.next().charAt(0);
                Validation v = new Validation();
                result = v.checkLetter(choice, 'A', 'C');
                
            }while( result == false);
                
                if(choice == 'A'){
                    System.out.println("New Plane Registration Number");
                    tempPlaneRN = keyboard.next();
                    tJob.setPlaneRegNo(tempPlaneRN);
                }
                
                else if(choice == 'B'){
                    System.out.println("New Status");
                    tempStatus = keyboard.next();
                    tJob.setStatus(tempStatus);
                }
                
                else stop = true;
                
            }while(stop == false);
            
                    
    }
    
    public void jobDetails(ArrayList<Job>jobListIn, ArrayList<Staff>staffListIn){
     int tempJID = 0;
     int tempSID;
     int pos;
     int pos2;
     int spot2;
     boolean found;
     Job j;
     Staff s;
     
    
        
       do{
        found = true;
        Scanner sc = new Scanner(System.in);
      
      try{
        System.out.println("Input the Job ID to get details");
        tempJID = sc.nextInt();
      }
       catch(InputMismatchException e){
         System.out.println("Character instead of number");
         sc.next();
       }
        
        int spot = jobListIn.indexOf(new Job(tempJID, null, null, 0));
        if(spot == -1){
            JOptionPane.showMessageDialog(null, "Not Found");
            found = false;
        }
        else
        {
        j = jobListIn.get(spot);
        pos2 = j.getsID();

       spot2 = staffListIn.indexOf(new Staff(null, null, null, 0, pos2, null));
        if(spot2 == -1){
            JOptionPane.showMessageDialog(null, "Not Found");
            found = false;
       }
      else
         {
        s = staffListIn.get(spot2);
        System.out.println(s.toString());
        
        }
      }
     }while(found==false);
        
        }
        
    
    public void jobFinished(ArrayList<Job>jobListIn){
           int pos, counter = 0;
           int findJNO = 0;
           int tempJNO;
           String tempPRN;
           String tempStatus;
           
           Scanner keyboard = new Scanner(System.in);
           keyboard.useDelimiter("\n");
           
           boolean found = true;
          
           do{
               found = true;
               do{
               try{
               System.out.println("Enter the Job Number to Edit its Status");
               findJNO = keyboard.nextInt();
            }
             catch(InputMismatchException e){
             System.out.println("Character instead of number");
             found = false;
             keyboard.next();
            }
              }while(found==false);
               
               int spot = jobListIn.indexOf(new Job(findJNO, null, null, 0));
               
               if(spot>=0){
                   System.out.println("IndexOf method returns: " + spot);
                   ask_new_details(jobListIn, findJNO, spot);
                   found = true;
                }
                
                else{
                    System.out.println("Job Number " + findJNO + " not found");
                    found = false;
                }
            }while(found == false);
        }
        
    public void listpending(ArrayList<Job>jobListIn){
          for(Job item : jobListIn){
            if(item.getStatus().equals("Pending"))
            System.out.println(item);
        }
    }
    
    public void jobhistory(ArrayList<Job>jobListIn){
        for(Job item : jobListIn){
            if(item.getStatus().equals("Finished"))
            System.out.println(item);
        }
    }
    
    public void writeList(ArrayList<Job>jobListIn){
        try{
            FileOutputStream jobFile = new FileOutputStream("job1.obf");
            ObjectOutputStream jobStream = new ObjectOutputStream(jobFile);
            
            for(Job item : jobListIn){
                jobStream.writeObject(item);
            }
            jobStream.close();
        }
        
        catch(IOException e){
            System.out.println("There was a problem writing the file");
        }
    }
    
     public void readList(ArrayList<Job>jobListIn){
        Job tempJob;
        boolean endOfFile = false;
        try{
            //create a FileInputStream object, staff2file
            FileInputStream jobFile = new FileInputStream("job1.obf");
            //create an ObjectInputStream object to wrap around staff2file
            ObjectInputStream jobStream = new ObjectInputStream(jobFile);
            //read the first (whole) object with the readObjet method
            tempJob = (Job)jobStream.readObject();
            while(endOfFile != true){
                try{
                    jobListIn.add(tempJob);
                    //read the next (whole) object
                    tempJob = (Job) jobStream.readObject();
                }
                catch(EOFException e){
                    endOfFile = true;
                }
            }
            
            jobStream.close();
        }
        
        // hand the exception that is thrown by the FileReader constructor if the file is not found
        catch(FileNotFoundException e){
            System.out.println("\nNo file was read");
        }
        catch(ClassNotFoundException e) //thrown by readObject
        {
            System.out.println("\nTrying to read an object of an unknown class");
        }
        catch(StreamCorruptedException e) //thrown by the constructor
        {
            System.out.println("\nUnreadable file format");
        }
        
        //handle the exception thrown by the FileReader methods
        catch(IOException e){
            System.out.println("\nThere was a problem reading the file");
        }
    }
}