import java.util.*;
import java.io.*;
class Manipulate_Staff implements Serializable{
    
    public void addStaff(ArrayList<Staff> staffListIn){
        String name = null;
        String surname = null;
        int StaffNo = 0;
        String ID = null;
        int TelNo = 0;
        String status = null;
        
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        
        try{
        System.out.println("Please enter your Name: ");
        name = sc.next();
        }
       
        catch(InputMismatchException e){
            System.out.println("Number instead of a character");
            sc.next();
        }
        
        try{
        System.out.println("Please enter your Surname: ");
        surname = sc.next();
           }
        catch(InputMismatchException e){
            System.out.println("Number instead of a character");
            sc.next();
        }
        
        try{
        System.out.println("Please enter your StaffID Number: ");
        StaffNo = sc.nextInt();
           }
        catch(InputMismatchException e){
            System.out.println("Number instead of a character");
            sc.next();
        }
        
        try{
        System.out.println("Please enter your ID Card Number: ");
        ID = sc.next();
        }
       
        catch(InputMismatchException e){
            System.out.println("Incorrect data type");
            sc.next();
        }
        
        try{
        System.out.println("Please enter your Telephone Number: ");
        TelNo = sc.nextInt();
           }
        catch(InputMismatchException e){
            System.out.println("Characters instead of numbers");
            sc.next();
        }
        try{
        System.out.println("Please enter your availablity: ");
        System.out.println("Available or Occupied");
        status = sc.next();
        }
       
        catch(InputMismatchException e){
            System.out.println("Number instead of a character");
            sc.next();
        }
        
        staffListIn.add(new Staff(name, surname, ID, TelNo, StaffNo, status));
    }
    
    public void listAll(ArrayList<Staff> staffListIn){
        for(Staff s: staffListIn){
            System.out.println(s);
        }
    }
    
    public void staff_new_details(ArrayList<Staff> staffListIn, String findName, String findSurname, int findTNO, int position){
        Scanner sc = new Scanner(System.in);
        Staff tStaff;
        boolean stop = true;
        boolean result = true;
        Character choice = null;
        int StaffNo = 0;
        String ID = null;
        String status = null;
        
        tStaff = staffListIn.get(position);
        String tempName = tStaff.getName();
        String tempSurname = tStaff.getSurname();
        int tempTNO = tStaff.telephoneNo();
        String tempStatus = tStaff.getStatus();
        
        do{
            stop = false;
            
            do{
                try{
                System.out.println("A...to edit Name");
                System.out.println("B...to edit Surname");
                System.out.println("C...to edit Telephone Number");
                System.out.println("D...to edit Status");
                
                choice = sc.next().charAt(0);
                Validation v = new Validation();
                result = v.checkLetter(choice, 'A' , 'D');
            }
            catch(InputMismatchException e){
                System.out.println("Wrong data format");
                sc.next();
            }
                
            }while(result == false);
       
            if(choice == 'A'){
                System.out.println("Enter new Name: ");
                tempName = sc.next();
                tStaff.setName(tempName);
            }
            else if(choice == 'B'){
                System.out.println("Enter new Surname: ");
                tempSurname = sc.next();
                tStaff.setSurname(tempSurname);
            }
            else if(choice == 'C'){
                System.out.println("Enter new Telephone Number: ");
                tempTNO = sc.nextInt();
                tStaff.setTNO(tempTNO);
            }
            else if(choice == 'D'){
                System.out.println("Enter new Status: ");
                tempStatus = sc.next();
                tStaff.setStatus(tempStatus);
            }
            
            else stop = true;
            
        }while(stop = false);
        
    }

    public void sort_SID(ArrayList<Staff>staffListIn){
        Staff first, second, temp;
        int makeFirst, makeSecond;
        boolean change;
        
        do{
            change = false;
            for(int i =0; i < staffListIn.size() -1; i++){
                first = staffListIn.get(i);
                second = staffListIn.get(i+1);
                makeFirst = first.getStaffNo();
                makeSecond = second.getStaffNo();
                if(makeFirst < makeSecond){
                    staffListIn.set(i, second);
                    staffListIn.set(i+1, first);
                    change = true;
                }
            }
            }while(change == true);
        }
        
    public void removeStaff(ArrayList<Staff> staffListIn){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        int findSID = 0;
        
        try{
        System.out.println("Enter the Staff Number to delete the Staff Member ");
        findSID = sc.nextInt();
        }
        catch(InputMismatchException e){
        System.out.println("Letters instead of numbers");
        sc.next();
              }
        int spot = staffListIn.indexOf(new Staff(null, null, null, 0, findSID, null));
        if(spot == -1) 
        System.out.println("Staff Number not found");
        else{
            System.out.println("Found in position" + spot);
            staffListIn.remove(spot);
            System.out.println("Deleted");
        }
    }
    
    public void writeList(ArrayList<Staff>staffListIn){
        try{
            FileOutputStream staffFile = new FileOutputStream("staff1.obf");
            ObjectOutputStream staffStream = new ObjectOutputStream (staffFile);
            
            for(Staff item : staffListIn){
                staffStream.writeObject(item);
            }
            staffStream.close();
        }
        catch(IOException e){
            System.out.println("There was a problem writing the file");
        }
    }
    
    public void readList(ArrayList<Staff>staffListIn){
        Staff tempStaff;
        boolean endOfFile = false;
        try{
            //create a FileInputStream object, staff2file
            FileInputStream staffFile = new FileInputStream("staff1.obf");
            //create an ObjectInputStream object to wrap around staff2file
            ObjectInputStream staffStream = new ObjectInputStream(staffFile);
            //read the first (whole) object with the readObjet method
            tempStaff = (Staff)staffStream.readObject();
            while(endOfFile != true){
                try{
                    staffListIn.add(tempStaff);
                    //read the next (whole) object
                    tempStaff = (Staff) staffStream.readObject();
                }
                catch(EOFException e){
                    endOfFile = true;
                }
            }
            
            staffStream.close();
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
        