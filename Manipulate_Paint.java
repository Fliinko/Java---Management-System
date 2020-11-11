import java.util.*;
import java.io.*;
public class Manipulate_Paint implements Serializable{
    
    public void addPaint(ArrayList<Paint> paintListIn){
        String tempPM = null;
        String tempBrand = null;
        String tempColour = null;
        String tempPID = null;
        int tempQTY = 0;
        String tempST = null;
        
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        
        try{
        System.out.println("Please enter the paint brand: ");
        tempBrand = sc.next();
         }
       catch(InputMismatchException e){
            System.out.println("Number instead of a character");
            sc.next();
        }
        
        try{
        System.out.println("Please enter the colour: ");
        tempColour = sc.next();
        }
       catch(InputMismatchException e){
            System.out.println("Number instead of a character");
            sc.next();
        }
        
        try{
        System.out.println("Please enter the paintID: ");
        tempPID = sc.next();
       }
        catch(InputMismatchException e){
            System.out.println("Number instead of a character");
            sc.next();
        }
        
        try{
        System.out.println("Please enter the quantity: ");
        tempQTY = sc.nextInt();
       }
       catch(InputMismatchException e){
            System.out.println("Number instead of a character");
            sc.next();
        }
        
        try{
        System.out.println("Please enter the status: ");
        tempST = sc.next();
        }
       catch(InputMismatchException e){
            System.out.println("Number instead of a character");
            sc.next();
        }
        
        paintListIn.add(new Paint(tempBrand, tempColour, tempPID, tempQTY, tempST));
    }
    
    public void listAll(ArrayList<Paint> paintListIn){
        for(Paint item : paintListIn){
            System.out.println(item);
        }
    }
    
    public void listAvail(ArrayList<Paint>paintListIn){
            for(Paint item : paintListIn){
                if(item.getStatus().equals("Available"))
                System.out.println(item);
            }
        }
        
    public void removePaint(ArrayList<Paint> paintListIn){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        String findPID = null;
        
       
        System.out.println("Enter the Paint ID to delete the Paint entity ");
        findPID = sc.next();
 
        
        int spot = paintListIn.indexOf(new Paint(null, null, findPID, 0, null));
        if(spot == -1) 
        System.out.println("Paint ID not found");
        else{
            System.out.println("Found in position" + spot);
            paintListIn.remove(spot);
            System.out.println("Deleted");
        }
    }
    
    public void sort_Brand(ArrayList<Paint>paintListIn){
        Paint first, second, temp;
        String makeFirst, makeSecond;
        boolean change;
        
        do{
            change = false;
            for(int i =0; i < paintListIn.size() -1; i++){
                first = paintListIn.get(i);
                second = paintListIn.get(i+1);
                makeFirst = first.getBrand();
                makeSecond = second.getBrand();
                if(makeFirst.compareTo(makeSecond) >0){
                    paintListIn.set(i, second);
                    paintListIn.set(i+1, first);
                    change = true;
                }
            }
            }while(change == true);
        }
        
   
    public void writeList(ArrayList<Paint>paintListIn){
        try{
            FileOutputStream paintFile = new FileOutputStream("paint1.obf");
            ObjectOutputStream paintStream = new ObjectOutputStream(paintFile);
            
            for(Paint item : paintListIn){
                paintStream.writeObject(item);
            }
            paintStream.close();
        }
        //handle the exception by the FileWriter methohds
        catch(IOException e){
            System.out.println("There was a problem writing the file");
        }
    }
    
    
     public void readList(ArrayList<Paint>paintListIn){
        Paint tempPaint;
        boolean endOfFile = false;
        try{
            //create a FileInputStream object, staff2file
            FileInputStream paintFile = new FileInputStream("paint1.obf");
            //create an ObjectInputStream object to wrap around staff2file
            ObjectInputStream paintStream = new ObjectInputStream(paintFile);
            //read the first (whole) object with the readObjet method
            tempPaint = (Paint) paintStream.readObject();
            while(endOfFile != true){
                try{
                    paintListIn.add(tempPaint);
                    //read the next (whole) object
                    tempPaint = (Paint) paintStream.readObject();
                }
                catch(EOFException e){
                    endOfFile = true;
                }
            }
            
            paintStream.close();
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

    
    
    
        
        