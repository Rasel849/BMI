/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BMIServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BMIServiceImpl extends UnicastRemoteObject implements BMIService {
    public BMIServiceImpl() throws RemoteException {
        super();
    }

    public double calculateBMI(double weight, double height) throws RemoteException {
        // BMI calculation formula: BMI = weight (kg) / (height (m) * height (m))
        return weight / (height * height);
    }
}
