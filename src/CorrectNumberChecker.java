import java.util.NoSuchElementException;
import java.util.Scanner;

public class CorrectNumberChecker {

    int upperLimit;
    int lowerLimit;


    public CorrectNumberChecker(int lowerLimit, int upperLimit) {
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
    }
    public CorrectNumberChecker ()
    {

    }


    public boolean check (int inputNumber)
    {
        if(inputNumber < lowerLimit || inputNumber >= upperLimit)
            return false;
        else
            return true;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public int detailedChecks ()
    {
        int enteredNum = 0;
        boolean isInputCorrect = false;
        Scanner scan = new Scanner(System.in);
        do{
            try{
                enteredNum = scan.nextInt();
                isInputCorrect = check(enteredNum);
                if(!isInputCorrect)
                    System.out.println("The entered number is out of the specified range! Please try again!");
                scan.nextLine();


            }catch (NoSuchElementException e)
            {
                //Reading enter key press from buffer
                scan.nextLine();
                System.out.println("Invalid input! Please try again!");
                isInputCorrect = false;
            }
        }while (!isInputCorrect);

        return enteredNum;
    }
}
