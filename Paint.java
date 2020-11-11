import java.io.*;
class Paint implements Serializable{
    
    private String brand, colour, PaintID;
    private int quantity;
    private String status;
    
    public Paint(String b, String c, String PID, int qty, String st){
        brand = b;
        colour = c;
        PaintID = PID;
        quantity = qty;
        status = st;
    }
    
    public String getPID(){
        return PaintID;
    }
    
    public String getBrand(){
        return brand;
    }
    
    public String getColour(){
        return colour;
    }
    
    public int getQty(){
        return quantity;
    }
    
    public String getStatus(){
        return status;
    }
    
    public String toString(){
        return (brand + " " + colour + " " + PaintID + " " + quantity + " " + status + " ");
    }
    
    public boolean equals(Object obj){
        return getPID().equals(((Paint)obj).getPID());
    }
}