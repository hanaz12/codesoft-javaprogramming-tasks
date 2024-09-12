import java.util.*;
public class Main {
    public static void main(String[] args) {
         boolean want_to_play = true;
        System.out.println("Welcome to number game!!\n Can you guess my number which is between 1 and 100? ");
         while (want_to_play) {
             int rand=new Random().nextInt(100);
             int chance=0;
             while(chance <= 5){
             chance++;
                 System.out.print("Enter a guess : ");
                 String guess=new Scanner(System.in).nextLine();
                 int val=Integer.parseInt(guess);
                 if (val==rand){
                     System.out.println("True guess after " + chance + " attempts");
                     break;
                 }
                 else if (val < rand){
                     System.out.println("your value is lower try again : ");
                 }
                 else{
                     System.out.println("your value is higher try again : ");
                 }
            }
             if (chance > 6){
                 System.out.println("Good luck The guessed number was " + rand);
             }
             System.out.print("Still want to play again (yes/no): ");
             String answer=new Scanner(System.in).nextLine();
             if (answer.equalsIgnoreCase("no")){
                 want_to_play=false;
             }
        }
    }
}