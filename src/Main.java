/**
 * Main class
 */
public class Main {

    public static void main(String args[]) {
        System.out.println("These questions are about the part of the robot that extends on the outer side of the fulcrum");
        double tipTorque = calcTorque(gravityForce(Double.parseDouble(Input.question("What is the weight of this part of the robot in kilograms?"))), Double.parseDouble(Input.question("How far is the center of mass of the robot past the fulcrum horizontally in meters?")), Double.parseDouble(Input.question("How far is the center of mass of the robot past the fulcrum vertically in meters?")));

        System.out.println();
        System.out.println("These questions are about the part of the robot on the other side of the fulcrum");
        double stableTorque = calcTorque(gravityForce(Double.parseDouble(Input.question("What is the weight of this part of the robot in kilograms?"))), Double.parseDouble(Input.question("How far is the center of mass of the robot past the fulcrum horizontally in meters?")), Double.parseDouble(Input.question("How far is the center of mass of the robot past the fulcrum vertically in meters?")));

        System.out.println();
        boolean robotTip = findTip(tipTorque, stableTorque);

        if (robotTip) {
            System.out.println("The robot will tip while idle");
            System.out.println("The torque on the tipping side is " + tipTorque + " Nm versus " + stableTorque + " Nm");
        } else {
            System.out.println("The robot will not not tip while idle");
            System.out.println("The torque on the tipping side is " + tipTorque + " Nm versus " + stableTorque + " Nm");
        }
    }

    public static boolean findTip(double tipTorque, double stableTorque) {
        return tipTorque >= stableTorque;
    }

    public static double gravityForce(double weight) {
        return weight * 9.8;
    }

    public static double calcTorque(double force, double xToPivot, double yToPivot) {
        double angleSine = Math.sin(Math.atan2(xToPivot, yToPivot));
        double diagonalDist = Math.sqrt(Math.pow(xToPivot, 2) + Math.pow(yToPivot, 2));
        return force * diagonalDist * angleSine;
    }
}
