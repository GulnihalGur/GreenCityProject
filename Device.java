public class Device {
    private String name;
    private int cost;
    private int energyEfficiency;
    private int sustainabilityScore;

    public Device(String name, int cost, int energyEfficiency, int sustainabilityScore){
        this.name = name;
        this.cost = cost;
        this.energyEfficiency = energyEfficiency;
        this.sustainabilityScore = sustainabilityScore;
    }

    public String getName(){
        return this.name;
    }

    public int getCost(){
        return this.cost;
    }

    public int getenergyEfficiency(){
        return this.energyEfficiency;
    }

    public int getsustainabilityScore(){
        return this.sustainabilityScore;
    }
}
/*
A class representing devices was created and the device name, cost, annual energy savings, 
sustainability score and device creation method were prepared.
*/