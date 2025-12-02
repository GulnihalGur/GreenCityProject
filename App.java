import java.util.*;

public class App {
    public static void main(String[] args){
            Scanner scan = new Scanner(System.in);  //We create a scanner object to get a sample budget from the user.

            List<Device> devices = Arrays.asList(  //Creating a list to hold devices
            //Each device has a name, cost, annual energy savings, sustainability score

                new Device("Solar Water Heater", 2450,500 ,5),
                new Device("Energy Saving Air Conditioner",5000 ,700 ,4),
                new Device("Motion Sensor Lamp", 1000, 200 ,5),
                new Device("Smart Socker", 350, 75,3),
                new Device("Recycle Bin", 300, 0,5),
                new Device("Thermal Insulation Material", 3000,350,4),
                new Device("Electric Board", 4500,200,4),
                new Device("Eco-Friendly Printer", 6000,300,3),
                new Device("Smart Lighting System", 3000,450, 5),
                new Device("Solar Panel", 7000,1000,5),
                new Device("Biometric Entry System", 5000,100,3),
                new Device("Solar Panel", 7000, 1000,5),
                new Device("Low Consumption Computer", 8000,300,4),
                new Device("Smart Fire Sensor", 1300,50,3),
                new Device("Solar Garden Light", 1300,120,5),
                new Device("High Efficiency Projector", 4200, 250,4),
                new Device("Energy Monitoring System", 5250,900 ,5),
                new Device("Smart Sunshade", 6000,160,4),
                new Device("Smart Ventilation System", 5600, 650,4),
                new Device("Led Panel Lamp", 500,120,5),
                new Device("Smart Thermostat", 2500,300,4),
                new Device("E-Book Reader", 2000,150,4)
            );

        System.out.print("\nPlease enter the budget (TL): "); //We get a sample budget entry from the user
        int budget = scan.nextInt();

        boolean[] selected = Knapsack.solve(devices, budget);  //The Knapsack algorithm is called and the most efficient product at the most affordable price is selected.

        int totalCost = 0;
        int totalSaving = 0;
        int totalSustainability = 0;
        //initial values ​​are set to zero

        System.out.println("Selected Devices: ");
        for(int i=0; i<devices.size(); i++){
            if(selected[i]){
                Device dev = devices.get(i);
                System.out.println("- " + dev.getName() + "(₺" + dev.getCost() + ")");
                totalCost += dev.getCost();
                totalSaving += dev.getenergyEfficiency();
                totalSustainability += dev.getsustainabilityScore();
            }
        }

        System.out.println("\nTotal Cost: ₺" + totalCost);
        System.out.println("Annual energy Saving:" + totalSaving + "kwh");
        System.out.println("Total Sustainability Score:" + totalSustainability);
        //the selected devices are printed on the screen. Total cost, savings and sustainability scores are added up

        scan.close();
    }
}
