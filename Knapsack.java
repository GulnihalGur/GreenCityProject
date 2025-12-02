import java.util.List;

public class Knapsack {
    public static boolean[] solve(List<Device> devices, int budget) {  //This method selects the most efficient device according to the user's budget.
        int a = devices.size(); // a = number of appliances 
        int[] values = new int[a]; // values = total benefits score of appliances
        int[] costs = new int[a]; // costs = prices of devices

        for(int i = 0; i < a; i++){
            Device appliance = devices.get(i);
            values[i] = appliance.getenergyEfficiency() + appliance.getsustainabilityScore() * 10; // we use this formula for calculate 
            costs[i] = appliance.getCost();
        }

        int[][] dpt = new int[a + 1][budget + 1]; // dpt = Dynamic programming table
        boolean[][] choosen = new boolean[a + 1][budget + 1]; // choosen = which devices was selected 

        //We fill the table with dynamic programming
        for(int i = 1; i <= a; i++){ 
            for(int r = 0; r <= budget; r++){   // r = remaining budget
                if(costs[i - 1] <= r){
                    //after device is added
                    int include = values[i - 1] + dpt[i - 1][r - costs[i - 1]];
                    //if not added 
                    int exclude = dpt[i-1][r];

                    //most useful option
                    if(include > exclude){
                        dpt[i][r] = include;
                        choosen[i][r] = true;  // we selected this appliance
                    }else{
                        dpt[i][r] = exclude;
                    }
                }else{                         //previous option if exceeds budget
                    dpt[i][r] = dpt[i - 1][r];
                }
            }
        }

        //identify selected devices, follow table backwards
        boolean[] chosenAppliances = new boolean[a];
        int  remainingBudget = budget;
        for (int i = a; i > 0; i--){
            if(choosen[i][remainingBudget]){
                chosenAppliances[i - 1] = true; // we are check it and mark which devices are selected
                remainingBudget -= costs[i - 1];//The device cost is deducted from the budget
            }
        }
        

    return chosenAppliances;
    }

}

