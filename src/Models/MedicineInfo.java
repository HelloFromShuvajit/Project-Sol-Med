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
class Medicine{
    String medName;
    String medTime;
    public Medicine(String medName, LocalTime medTime){
        this.medName=medName;
        this.medTime=medName;
    }
}
class MedicineRepository{
    static List<Medicine> medicines = new ArrayList<>();
    String medName;
    String medTime; 
    Scanner sc = new Scanner(System.in);
     public void addMedicine(){
        System.out.println("Enter the name of medicine you want to add:");
        medName = sc.nextLine();
        System.out.println("Enter the time(HH:MM) to consume the med:");
        String medtime = sc.nextLine();
        LocalTime medTime = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        try{
             medTime = LocalTime.parse(medtime, formatter);
             System.out.println(medTime);
        }
        catch (Exception e) {
        System.out.println("Invalid time format!");
        }
        Medicine medicine = new Medicine(medName, medTime);
        medicines.add(medicine);

}
    public void medList(){
        boolean empty = medicines.isEmpty();
        if (empty) {
            System.out.println("The Medicine List is empty.");
        }else{
        System.out.println("Medicine List");
        for(Medicine m: medicines){
            System.out.println("Name of the medicine: " + m.medName+"\nTime to take the Medicine:" + m.medTime);
        }
    }
    }
    public void checkReminder(){
        System.out.println("Enter the name of the medicine you have taken:");
        String medName= sc.nextLine(); 
        System.out.println(medName);
        for(Medicine m: medicines){
            if(m.medName.equals(medName)){
                System.out.println(medName +"is reminded"); // improve this update 1 less in this med stock
                break;
            }
            System.out.println(medName + "not found in your list.");
    }
    }
    public void updateMeds(){
        System.out.println("This is updateMeds.");
        MedicineLog medLog = new MedicineLog();
        medLog.MedicineUpdate();

    }
    public void markMed(){
        System.out.println("This is markMed.");
    }
}
