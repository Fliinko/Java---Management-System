public class Validation
{
    public boolean checkLetter(char letter, char first, char last){
        if(letter >= first && letter <= last)
        return true;
        else return false;
    }
}