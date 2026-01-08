package Models;
import java.util.Scanner;
public class MainApp {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        Scanner sc = new Scanner (System.in);
        System.out.println("----------Sol-Med Application Started----------");
        int choice;
        while(true){
        try{
            System.out.println("1.Register for new User\n2.Login for existing User\n3.Exit Application");
            choice = sc.nextInt();
            sc.nextLine(); 
        } catch (Exception e){
            System.out.println("Invaild input. Please enter a valid input");
            continue;
        }
        switch (choice) {
            case 1: 
                userRepository.registerNewUser();
                break;
            case 2:
                userRepository.loginUser();
                break;
                case 3:
                    System.out.println("Exiting.......");
                    return;
            default: 
                System.out.println("Enter a valid input!!");
                break;
        }           // end of swtich
    }       //end of while
    }           // end of main        
}           // end of MainApp
