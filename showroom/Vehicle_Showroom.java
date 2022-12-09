package showroom;
import java.util.Scanner;
import java.util.Vector;




public class Vehicle_Showroom {
	
	static
    {
   	 System.out.println("\n                           Welcome                              ");
   	 System.out.println("-----------------------------------------------------------------");
    }
	 public static void main(String[] args) {

	        Menu menu = new Menu();
	        menu.menuDisplayMenu();
	        
	        menu.menuChooseOption();
	    }

}

//Menu Class Starts

 class Menu 
 {
    int menuOption;
    AddVehicle addvehicle = new AddVehicle();
    RemoveVehicle removevehicle = new RemoveVehicle();
    ///VehicleVisitors vehiclevisitors = new VehicleVisitors();
    
    void menuDisplayMenu() {
        System.out.println();
        System.out.println("Vehicle Managements");
        
        System.out.println("1 Add Vehicle");
        System.out.println("2 Remove Vehicle");
        System.out.println("3 Show List of Vehicles ");
        System.out.println("4 Show List of Vehicles with Details");
        System.out.println();
    }
    
    void menuChooseOption()
    {
        System.out.println("Choose Opntion ( 1 / 2 / 3 / 4): ");
        System.out.println("===========================================");
        
        Scanner scanner = new Scanner(System.in);
        menuOption = scanner.nextInt();
        
        System.out.println();
        
        switch(menuOption) {
            case 1:
                addvehicle.addVehicleDisplayMenu();
                addvehicle.addVehicleChooseOption();
                ///System.out.println("Add Vehicle");
                break;
            case 2:
                removevehicle.removeVehicleDisplayMenu();
                removevehicle.removeVehicleChooseOption();
                ///System.out.println("Remove Vehicle");
                break;
            case 3:
              
                System.out.println("Normal Vehicle: " + NormalVehicle.nv);
                System.out.println("Sports Vehicle: " + SportsVehicle.sv);
                System.out.println("Heavy Vehicle: " + HeavyVehicle.hv);
                
                menuDisplayMenu();
                menuChooseOption();
                break;
            case 4:
                System.out.println("\nNormal Vehicle Details.");
                System.out.println("------------------------\n");
                NormalVehicle normalvehicle = new NormalVehicle();
                normalvehicle.details();
        
                System.out.println("\nSports Vehicle Details.");
                System.out.println("------------------------\n");
                SportsVehicle sportsvehicle = new SportsVehicle();
                sportsvehicle.details();
        
                System.out.println("\nHeavy Vehicle Details.");
                System.out.println("------------------------\n");
                HeavyVehicle heavyvehicle = new HeavyVehicle();
                heavyvehicle.details();   
                break;
        }
        
    }
}
 
 //Menu Class Ends
 

 
 ///AddVehicle Class Strts
 
 class AddVehicle 
 {
	    Integer addVehicleOption, addVehicleWeight;
	    //String addVehicleModelNumber, addVehicleEngineType, addVehicleEnginePower, addVehicleTireSize;
	    
	    void addVehicleDisplayMenu() {
	        System.out.println("Add Vehicle Showroom");
	        
	        System.out.println("1 Normal Vehicle");
	        System.out.println("2 Sports Vehicle");
	        System.out.println("3 Heavy Vehicle");
	        System.out.println("4 Back");
	    }
	    
	    
	    void addVehicleChooseOption()
	    {
	        System.out.print("Choose Opntion ( 1 / 2 / 3 / 4): ");
	        Scanner scanner = new Scanner(System.in);
	        addVehicleOption = scanner.nextInt();
	        
	        switch(addVehicleOption) {
	            case 1:
	                NormalVehicle normalvehicle = new NormalVehicle();// AddNormalVehicle Object
	                normalvehicle.addVehicle();//it will call the addVehicle
	                
	                NormalVehicle.normalVector.add(normalvehicle);//it will add one vehicle in Vector 
	                System.out.println("Normal Vehicle Creation and Addition Succeeded!");
	                System.out.println("===========================================");
	                
	                
	              
	                Menu normalMenu = new Menu();
	                normalMenu.menuDisplayMenu();
	                normalMenu.menuChooseOption();
	                break;
	            case 2:
	                SportsVehicle sportsvehicle = new SportsVehicle();
	                sportsvehicle.addVehicle();
	                
	                SportsVehicle.sportsVector.add(sportsvehicle);//it will add one vehicle in Vector 
	                System.out.println("Sports Vehicle Creation and Addition Succeeded!");
	                System.out.println("===========================================");
	                
	                
	                Menu sportsMenu = new Menu();
	                sportsMenu.menuDisplayMenu();
	                sportsMenu.menuChooseOption();
	                break;
	            case 3:
	                HeavyVehicle heavyvehicle = new HeavyVehicle();
	                heavyvehicle.addVehicle();
	                
	                HeavyVehicle.heavyVector.add(heavyvehicle);
	                System.out.println("Heavy Vehicle Creation and Addition Succeeded!");
	                
	                System.out.println("===========================================");
	                
					
	                
	                Menu heavyMenu = new Menu();
	                heavyMenu.menuDisplayMenu();
	                heavyMenu.menuChooseOption();
	                break;
	            case 4:
	                Menu menu = new Menu();
	                menu.menuDisplayMenu();
	                menu.menuChooseOption();
	                break;
	        }
	    }
	}
 
 //AddVehicles Ends

 class CVehicle {
    String m_modelNumber, m_engineType, m_enginePower, m_tireSize;
    
    Scanner scanner = new Scanner(System.in);
    
    Menu menu = new Menu();
    
	
}

 interface IVehicle //interface to use method overriding
 {
    void addVehicle();//no body 
    void details();
    void removeVehicle();
}

 
 //Sub-class and Super-Class haveing same method name
 
 //NormalVehicle Class Starts 
class NormalVehicle extends CVehicle implements IVehicle 

{
	
    static Integer nv = 0;
    static Vector<NormalVehicle> normalVector = new Vector<NormalVehicle>();
    //<NormalVehicle> this means this is store details of only NormalVehicles

   
    public void addVehicle() /// @Override addVehicle
    {
        System.out.print("Enter Model Number: ");
        m_modelNumber = scanner.nextLine();
        
        System.out.print("Enter Engine Type: ");
        m_engineType = scanner.nextLine();
        
        System.out.print("Enter Engine Power (HP): ");
        m_enginePower = scanner.nextLine();
        
        System.out.print("Enter Tire Size (Inch): ");
        m_tireSize = scanner.nextLine();
        
        nv++;//it will count the how many added vehicles or increments
//        menu.menuDisplayMenu();
//        menu.menuChooseOption();
    }

    
    public void removeVehicle() ///@Override
    {
        Integer size = NormalVehicle.normalVector.size();//className.ReferenceVar NormalVehicle to count the size of added vehicles
        
        if(size > 0){
            NormalVehicle.normalVector.removeElementAt(size-1);
            size--;
            
			
            
            System.out.println("Normal Vehicle Remove Succeeded!");
            
            nv--;
            menu.menuDisplayMenu();
            menu.menuChooseOption();
        }else{
            System.out.println("No Available Normal Vehicle to Remove.");
            
            menu.menuDisplayMenu();
            menu.menuChooseOption();
        }
    }

    @Override
    public void details() {
        Integer size = NormalVehicle.normalVector.size();
        
        for(Integer i=0; i<size; i++){
            System.out.println("Model Name: "+NormalVehicle.normalVector.elementAt(i).m_modelNumber);
            System.out.println("Engine Type: "+NormalVehicle.normalVector.elementAt(i).m_engineType);
            System.out.println("Engine Power (HP): "+NormalVehicle.normalVector.elementAt(i).m_enginePower);
            System.out.println("Tire Size (Inch): "+NormalVehicle.normalVector.elementAt(i).m_tireSize);
        }
        
//        menu.menuDisplayMenu();
//        menu.menuChooseOption();
    }
    
}


 
 
 //RemoveVehicle Class Starts
 class RemoveVehicle 
 
 {
    Integer removeVehicleOption;//non premitive data type//wrapper class
    
    void removeVehicleDisplayMenu() 
    {
        System.out.println("Vehicle Showroom");
        
        System.out.println("1 Normal Vehicle");
        System.out.println("2 Sports Vehicle");
        System.out.println("3 Heavy Vehicle");
        System.out.println("4 Back");
    }
    
    void removeVehicleChooseOption()
    {
        System.out.print("Choose Opntion ( 1 / 2 / 3 / 4): ");
        Scanner scanner = new Scanner(System.in);
        removeVehicleOption = scanner.nextInt();
        
        switch(removeVehicleOption) {
            case 1:
                NormalVehicle normalvehicle = new NormalVehicle();
                normalvehicle.removeVehicle();
                break;
            case 2:
                SportsVehicle sportsvehicle = new SportsVehicle();
                sportsvehicle.removeVehicle();
                break;
            case 3:
                HeavyVehicle heavyvehicle = new HeavyVehicle();
                heavyvehicle.removeVehicle();
                break;
            case 4:
                Menu menu = new Menu();
                menu.menuDisplayMenu();
                menu.menuChooseOption();
                break;
        }
    }
}



//RemoveVehicle ends



 class SportsVehicle extends CVehicle implements IVehicle
{
    static Integer sv = 0;
    static Vector<SportsVehicle> sportsVector = new Vector<SportsVehicle>();
    //<SportsVehicle>  this will store only SportsVehicle only
    boolean turbo = true;

    @Override
    public void addVehicle() {
        m_engineType = "Oil";
        
        System.out.print("Enter Model Number: ");
        m_modelNumber = scanner.nextLine();
        
        System.out.print("Enter Engine Power (HP): ");
        m_enginePower = scanner.nextLine();
        
        System.out.print("Enter Tire Size (Inch): ");
        m_tireSize = scanner.nextLine();
        
        sv++; // it will count the how many added vehicles or increments
//        menu.menuDisplayMenu();
//        menu.menuChooseOption();
    }

    @Override
    public void removeVehicle() {
        Integer size = SportsVehicle.sportsVector.size();
        //className.Vector refernce Var and find the size() method
        
        if(size > 0)
        {
            SportsVehicle.sportsVector.removeElementAt(size-1);
            // it will remove the added Vehicle by inbuilt removeElementAt
            size--;// it will remove the Added Vehicle one by one
            
   
            
            System.out.println("Sports Vehicle Remove Succeeded!");
            
            sv--;
            menu.menuDisplayMenu();
            menu.menuChooseOption();
        }else{
            System.out.println("No Available Sports Vehicle to Remove.");
            
            menu.menuDisplayMenu();
            menu.menuChooseOption();
        }
    }

    @Override
    public void details() {
        Integer size = SportsVehicle.sportsVector.size();
        //it will count the size of SportsVehicles by size() method
        
        for(Integer i=0; i<size; i++){
            System.out.println("Model Name: "+SportsVehicle.sportsVector.elementAt(i).m_modelNumber);
            System.out.println("Engine Type: "+SportsVehicle.sportsVector.elementAt(i).m_engineType);
            System.out.println("Engine Power (HP): "+SportsVehicle.sportsVector.elementAt(i).m_enginePower);
            System.out.println("Tire Size (Inch): "+SportsVehicle.sportsVector.elementAt(i).m_tireSize);
            
            System.out.println("Turbo: Yes");
        }
        
//        menu.menuDisplayMenu();
//        menu.menuChooseOption();
    }
    
}



 


 class HeavyVehicle extends CVehicle implements IVehicle {
    static Integer hv = 0;
    static Vector<HeavyVehicle> heavyVector = new Vector<HeavyVehicle>();
    
    //A static variable can be accessed directly by the class name and doesn’t need any object
    Integer m_weight;

    @Override
    public void addVehicle() {
        m_engineType = "Oil";
        
        System.out.print("Enter Model Number: ");
        m_modelNumber = scanner.nextLine();
        
        System.out.print("Enter Engine Power (HP): ");
        m_enginePower = scanner.nextLine();
        
        System.out.print("Enter Tire Size (Inch): ");
        m_tireSize = scanner.nextLine();
        
        System.out.print("Enter Weight (Kg): ");
        m_weight = scanner.nextInt();
        
        hv++;
//  
    }

    @Override
    public void removeVehicle() {
        Integer size = HeavyVehicle.heavyVector.size();
        
        if(size > 0){
            HeavyVehicle.heavyVector.removeElementAt(size-1);
            size--;
            
			/*
			 * CVehicle.m_visitorNumberFlag--; CVehicle.m_visitorNumberHandler();
			 */
            
            System.out.println("Heavy Vehicle Remove Succeeded!");
            
            hv--;
            menu.menuDisplayMenu();
            menu.menuChooseOption();
        }else{
            System.out.println("No Available Heavy Vehicle to Remove.");
            
            menu.menuDisplayMenu();
            menu.menuChooseOption();
        }
    }

    @Override
    public void details() {
        Integer size = HeavyVehicle.heavyVector.size();
        //it will show the How many HeavyVehicle Added
        
        for(Integer i=0; i<size; i++)
        {
            System.out.println("Model Name: "+HeavyVehicle.heavyVector.elementAt(i).m_modelNumber);
            //it store in index 0//class Name.Vector Ref var Name.method name
            
            System.out.println("Engine Type: "+HeavyVehicle.heavyVector.elementAt(i).m_engineType);//it will store in index 1
            System.out.println("Engine Power (HP): "+HeavyVehicle.heavyVector.elementAt(i).m_enginePower);
            System.out.println("Tire Size (Inch): "+HeavyVehicle.heavyVector.elementAt(i).m_tireSize);
            
            System.out.println("Weight (Kg): "+HeavyVehicle.heavyVector.elementAt(i).m_weight);//it will store index 4
        }
        
//        menu.menuDisplayMenu();
//        menu.menuChooseOption();
    }
    
    


    
    
}
 
