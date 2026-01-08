package Models;
import java.util.*;
import java.util.Scanner;

public class User {
    private String userID;
    private String userName;
    private String userEmail;
    private String userpassword;
    private String userPhoneNo;
    private String userAge;
    private String userGender;
    public User(String userName, String userEmail, String userpassword, String userPhoneNo, String userAge, String userGender) {
        
        this.userID = SetUserID.setUserID();
        this.userName = userName;
        this.userEmail = userEmail;
        this.userpassword = userpassword;
        this.userPhoneNo = userPhoneNo;
        this.userAge = userAge;
        this.userGender = userGender;
    }
    public String getUserID(){
        return userID;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserPassword(){
        return userpassword;
    }
    public String getUserEmail(){
        return userEmail;
    }
    public String getUserPhoneNo(){
        return userPhoneNo;
    }
    public String getUserAge(){
        return userAge;
    }
    public String getUserGender(){
        return userGender;
    }
}
class SetUserID{
        static int id = 100;
    public static  String setUserID(){
        return "SM-UID"+id++;
    }
}

class UserRepository{
        static List<User> users = new ArrayList<>();
        Scanner sc = new Scanner (System.in);

        // registerNewUser()

        public void registerNewUser(){
        System.out.println("Enter the name:");
        String uName = sc.nextLine();
        String uEmail;
        while(true){
        System.out.println("Enter the email:");
        uEmail = sc.nextLine();
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if(uEmail != null && uEmail.matches(emailRegex))
        {
            break;
        }
        }
        System.out.println("Enter the password:");
        String uPassword = sc.nextLine();
        System.out.println("Enter the phone number:");
        String uPhoneNo = sc.nextLine();
        System.out.println("Enter the age:");
        String uAge = sc.nextLine();
        System.out.println("Enter the gender:");
        String uGender = sc.nextLine();
        User newUser = new User(uName, uEmail, uPassword, uPhoneNo, uAge, uGender);
        users.add(newUser);
        System.out.println("User registered successfully with ID:" + newUser.getUserID());
    }

    // loginUser()

    public void loginUser(){
        boolean empty = users.isEmpty();
        if(empty){
            System.out.println("No user is registered.");
        }else{
        try{
                System.out.println("Enter User Email: ");
                String uEmail= sc.nextLine();
        for( User UR : users)
        {
            if (UR.getUserEmail().equals(uEmail)) {
                System.out.println("Enter Password:");
                String passWord = sc.nextLine();
                if (UR.getUserPassword().equals(passWord)) {
                    System.out.println("Password Matched!!");
                    MedicineInfo medInfo = new MedicineInfo();
                    medInfo.MedicineDetails();
                    
                    //UserServices.UserServices();                   from here call userservices.java
                }
                else{
                    System.out.println("Wrong password!!");
                    loginUser();
                }
                return;
            }
            System.out.println("User email does not exist.");

        }
        }  // endof try
        catch(Exception e){
            System.out.println("Error in reading login user ID");
            return;
        }
    }
}
}