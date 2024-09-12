import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.print("Please enter the number of subjects: ");
        Scanner input = new Scanner(System.in);
        int subjects = input.nextInt();
        int sum=0;
        double average=0;
        int grade [] =new int [subjects];
        for (int i = 0; i < subjects; i++) {
            System.out.printf("Please enter the grade of subject %d: ", (i+1));
            grade[i] = input.nextInt();
            sum+=grade[i];
        }
        average = sum/subjects;
        System.out.println("********************");
        System.out.println("Total marks : "+sum);
        System.out.println("Average marks : "+average);
        char r;
        if (average>=90) {
            r = 'A';
        }
        else if (average>=80) {
            r = 'B';
        }
        else if (average>=70) {
            r = 'C';
        }
        else if (average>=60) {
            r = 'D';
        }
        else if (average>=50) {
            r = 'E';
        }
        else {
            r = 'F';
        }
        System.out.println("Your corresponding grade is : "+r);
     }
}