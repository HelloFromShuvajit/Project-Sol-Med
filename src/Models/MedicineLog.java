package Models;
import java.util.*;
public class MedicineLog {
        String medInfoName;
        int medInfoStock;
    public MedicineLog(String medName, int medStock){
        this.medInfoName=medName;
        this.medInfoStock=medStock;
    }
    public String getMedName(){
        return this.medInfoName;
    }
    public int getMedStock(){
        return this.medInfoStock;
    }
    public void setMedStock(int Stock){
        this.medInfoStock= Stock;

    }
}
// class MedicineLogRepository

    class MedicineLogRepository{
        static List<MedicineLog> medInfos = new ArrayList<>();
        public void SetStock(String medName, int medStock){
            String medInfoName = medName;
            int medInfoStock = medStock; 
        MedicineLog newMed = new MedicineLog(medInfoName,medInfoStock);
        medInfos.add(newMed);
        }
    public int MedicineStock(String medName){
        boolean medstockEmpty= medInfos.isEmpty();
        int medStock=0;
        if(medstockEmpty)
        {
            System.out.println("No Medicine to show.");
            return 0;
        } else{
            for(MedicineLog m : medInfos){
                if (m.getMedName().equals(medName)) {
                    medStock = m.getMedStock();
            }   
            }
        }
        return medStock;
        }
        // MedicineUpdate()

    public int MedicineUpdate(String medName) {
        
        System.out.println("Enter the number you are adding:");
        Scanner sc = new Scanner (System.in);
        int medInfoStock = 0;
        int medStockUpdate= sc.nextInt();
        boolean medstockEmpty= medInfos.isEmpty();
        if(medstockEmpty)
        {
            System.out.println("No Medicine to show.");
        }else{
            for(MedicineLog m : medInfos){
             if (m.getMedName().equals(medName)) {
        medInfoStock = m.getMedStock() + medStockUpdate;
        m.setMedStock(medInfoStock);
        System.out.println("Updated Medicine "+ medName +", new stock is " + medInfoStock);
                }
            }
            }
        return medInfoStock;
}

    //markMedTaken()

    public int markMedTaken(String medName) {
        int medInfoStock = 0;
         boolean medstockEmpty= medInfos.isEmpty();
        if(medstockEmpty)
        {
            System.out.println("No Medicine to show.");
        }else{
            for(MedicineLog m : medInfos){
            if (m.getMedName().equals(medName)) {
                medInfoStock = m.getMedStock(); 
                if(medInfoStock==0){
                    System.out.println("Not enough Medicine, please fill the stock urgently!!");
                    } else if(medInfoStock>=1){
                        medInfoStock= medInfoStock-1;
                        m.setMedStock(medInfoStock);
                        System.out.println(medName +" is taken."); 
                            }
            if(medInfoStock<5 && medInfoStock>0){
             System.out.println("Medicine stock is about to end please fill the stock. Remaining:" +medInfoStock);
            }
    }
}
}        

        return medInfoStock;
}
}