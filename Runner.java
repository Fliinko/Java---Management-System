import java.util.*;
import javax.swing.JOptionPane;
import java.io.*;
public class Runner{
    public static void main(String args[]){
        
        Character choice = null;
        Scanner sc = new Scanner(System.in);
        
        //Objects -----------------------------------------
        Manipulate_Staff ms = new Manipulate_Staff();
        Manipulate_Job mj = new Manipulate_Job();
        Manipulate_Paint mp = new Manipulate_Paint();
        //-------------------------------------------------
        
        //ArrayLists --------------------------------------
        ArrayList<Staff> staffList = new ArrayList<Staff>();
        ArrayList<Job> jobList = new ArrayList<Job>();
        ArrayList<Paint> paintList = new ArrayList<Paint>();
        //--------------------------------------------------
        
        do{
                       
         //try method is essetial to use Exceptions  
            try{
            // System.out.println("----------------------");
            // System.out.println("A. Use 'Job' File");
            // System.out.println("B. Use 'Paint' File");
            // System.out.println("C. Use 'Staff' File");
            // System.out.println("X. Quit");
            // System.out.println("----------------------");
            // --------------- Initial Menu ------------------------
            
            
            //JOPtionPane to use GUI
            JOptionPane.showMessageDialog(null, " A : Use 'Job' File \n B : Use 'Paint' File \n C. Use 'Staff' File \n X : Quit", "Choose your Option", JOptionPane.INFORMATION_MESSAGE);
            String option = JOptionPane.showInputDialog("Enter your option from the menu");
            choice = option.charAt(0);
        }
        catch(InputMismatchException e){
            System.out.println("Number instead of a character");
        }
        
            
           switch(choice){
                case 'A' : 
                        char choice1 = 0;
                        try{
                           System.out.println("----------------------");
                           System.out.println("1. Add a Job");
                           System.out.println("2. Finished a Job");
                           System.out.println("3. List Pending Jobs");
                           System.out.println("4. List Job History");
                           System.out.println("5. View Job Details");
                           System.out.println("Type '6' to exit");
                           System.out.println("----------------------");
                           choice1 = sc.next().charAt(0);
                        }
                        catch(InputMismatchException e){
                            System.out.println("Letter entered instead of a number");
                        }
                         
                           switch(choice1){
                               case '1': mj.addJob(jobList);
                                         break;
                               case '2': mj.jobFinished(jobList);
                                         break;
                               case '3': mj.listpending(jobList);
                                         break;
                               case '4': mj.jobhistory(jobList);
                                         break;
                               case '5': mj.jobDetails(jobList, staffList);
                                         break;
                               case '6': mj.writeList(jobList); //implies the saving on object files
                                         return;
                               default:  System.out.println("Enter a number between 1 and 5 please");
                                         break;
                                        }
                                
                case 'B' : 
                           char choice2 = 0;
                        try{
                           System.out.println("----------------------");
                           System.out.println("1. Add a Paint entity");
                           System.out.println("2. List available Paint Stock");
                           System.out.println("3. Remove a Paint entity");
                           System.out.println("4. Sort Paint by Brand");
                           System.out.println("Type '5' to exit");
                           System.out.println("----------------------");
                           choice2 = sc.next().charAt(0);
                        }
                        catch(InputMismatchException e){
                            System.out.println("Letter entered instead of a number");
                        }
                           
                           switch(choice2){
                               case '1': mp.addPaint(paintList);
                                         break;
                               case '2': mp.listAvail(paintList);
                                         break;
                               case '3': mp.removePaint(paintList);
                                         break;
                               case '4': mp.sort_Brand(paintList);
                                         mp.listAll(paintList);
                                         break;
                               case '5': mp.writeList(paintList); //implies the saving on object files
                                         return;
                               default : System.out.println("Enter digits between 1 and 4 please");
                                         break;
                                        }
                                     
                 case 'C' :
                            char choice3 = 0;
                        try{
                           System.out.println("----------------------");
                           System.out.println("1. Add a Staff member");
                           System.out.println("2. Edit Staff Credentials");
                           System.out.println("3. Remove a Staff member");
                           System.out.println("4. List all Staff - by Staff ID");
                           System.out.println("Type '5' to exit");
                           System.out.println("----------------------");
                           choice3 = sc.next().charAt(0);
                        }
                        catch(InputMismatchException e){
                            System.out.println("Letter entered instead of a number");
                        }
                           
                           switch(choice3){
                               case '1':  ms.addStaff(staffList);
                                          break;
                               case '2': String findName = null;
                                         String findSurname = null;
                                         int findTNO = 0;
                                         System.out.println("Enter the position of the staff");
                                         ms.listAll(staffList);
                                         int position = sc.nextInt();
                                          ms.staff_new_details(staffList, findName, findSurname, findTNO, position);
                                          break;
                               case '3' : ms.removeStaff(staffList);
                                          break;
                               case '4' : ms.sort_SID(staffList);
                                          ms.listAll(staffList);
                                          break;
                               case '5' : ms.writeList(staffList);
                                          return;
                               default :  System.out.println("Enter a number between 1 and 4 please");
                                          break;
                                        }
            
                 case 'X' : break;
                 
                 default : System.out.println("Please enter a letter (A / B / C ");
                }
            }while(choice!='X');
    }
}