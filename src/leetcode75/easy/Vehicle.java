package leetcode75.easy;

sealed class Vehicle permits Car, Bike {
    public void startVehicle(){
        System.out.println("Starting vehicle");
    }

}
