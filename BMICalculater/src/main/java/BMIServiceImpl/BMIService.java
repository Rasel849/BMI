/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BMIServiceImpl;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BMIService extends Remote {
    double calculateBMI(double weight, double height) throws RemoteException;
}
