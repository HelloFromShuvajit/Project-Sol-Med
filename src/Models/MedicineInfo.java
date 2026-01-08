package Models;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.util.*;

public class MedicineInfo {
    public void MedicineDetails()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is MedicineInfo class");
        while (true) {
            MedicineRepository meds = new MedicineRepository();
        int choice;
        try{
             System.out.println("1.Add medicine\n2.Medicine List\n3.Update stock\n4.Check Reminder\n5.Mark medicine as taken\n6.Logout.");
            choice=sc.nextInt();
            }  catch (Exception e){
            System.out.println("Invaild input. Please enter a valid input");
            continue;
        }
        switch (choice) {
            case 1:
                meds.addMedicine();
                break;
                case 2:
                meds.medList();
                break;
                case 3:
                meds.updateMeds();
                break;
                case 4:
                meds.checkReminder();
                break;
                case 5:
                meds.markMed();
                break;
                case 6:
                System.out.println("Logging Out.....");
                return;
            default:
                break;
        }
    } 
 }
}
// class Medicine 

class Medicine{
    String medName;
    LocalTime medTime;
    int medStock;
    public Medicine(String medName, LocalTime medTime,int medStock){
        this.medName=medName;
        this.medTime=medTime;
        this.medStock=medStock;
    }
}
// class MedicineRepository

class MedicineRepository{
    static List<Medicine> medicines = new ArrayList<>();
    String medName;
    LocalTime medTime; 
    Scanner sc = new Scanner(System.in);

    // addMedicine()

     public void addMedicine(){
        System.out.println("Enter the name of medicine you want to add:");
        medName = sc.nextLine();
        System.out.println("Enter the time(HH:MM) to consume the med:");
        String medtime = sc.nextLine();
        LocalTime medTime = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        try{
             medTime = LocalTime.parse(medtime, formatter);
        }
        catch (Exception e) {
        System.out.println("Invalid time format!");
        }
        System.out.println("Enter the initial Stock number you want to add:");
        int medStock = sc.nextInt();
        Medicine medicine = new Medicine(medName, medTime,medStock);
        medicines.add(medicine);
        MedicineLogRepository medLog = new MedicineLogRepository();
        medLog.SetStock(medName, medStock);
}
    // medList()

    public void medList(){
        boolean empty = medicines.isEmpty();
        if (empty) {
            System.out.println("The Medicine List is empty.");
        }else{
        System.out.println("Medicine List");
        for(Medicine m: medicines){
            System.out.println("Name of the medicine: " + m.medName+"\nTime to take the Medicine:" + m.medTime +"\nMedicine in Stock:" +m.medStock);
        }
    }
    }
        //checkReminder()

    public void checkReminder(){
        System.out.println("Enter the name of the medicine you want take:");
        String medName= sc.nextLine(); 
        for(Medicine m: medicines){
            if(m.medName.equals(medName)){
                System.out.println(medName +" is to be taken at "+ m.medTime);
                break;
            }
            System.out.println(medName + "not found in your list.");
    }
    }
    //updateMeds()

    public void updateMeds(){
        MedicineLogRepository medLog = new MedicineLogRepository();
        System.out.println("Enter the name of the medicine you want to update:");
        String medName= sc.nextLine(); 
        for(Medicine m: medicines){
            if(m.medName.equals(medName)){
                try {
                    m.medStock= medLog.MedicineUpdate(medName);
                    break;
            }    
         catch (Exception e) {
           System.out.println("Error in updating Medicine Stock"); 
        }
    }
                System.out.println(medName + "not found in your list.");

    }
}
    //markMed()
    
    public void markMed(){
        System.out.println("Enter the name of the medicine you have taken:");
        String medName= sc.nextLine(); 
        for(Medicine m: medicines){
            if(m.medName.equals(medName)){
                MedicineLogRepository medLog= new MedicineLogRepository();
                //try {
                    m.medStock= medLog.markMedTaken(medName);
                    break;
                //} catch (Exception e) {
                  //  System.out.println("Error in marking and Medicine taken is not marked.");
               // }
            }
            System.out.println(medName + " not found in your list.");
    }
    }
}
