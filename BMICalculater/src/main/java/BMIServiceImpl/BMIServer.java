/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BMIServiceImpl;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author rasel
 */
public class BMIServer {
       public static void main(String[] args) {
        try {
            BMIService bmiService = new BMIServiceImpl();

            LocateRegistry.createRegistry(1099);

            Naming.rebind("rmi://localhost:1099/BMIService", bmiService);

            System.out.println("BMI server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
}
