/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientwscalculator;

import javax.xml.ws.WebServiceRef;
import pack.Calc_Service;

/**
 *
 * @author entrar
 */
public class Main {
    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/Calc/Calc.wsdl")
    private static Calc_Service service;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(sum(1,2));
        System.out.println(rest(1,2));
    }

    private static int sum(int n1, int n2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pack.Calc port = service.getCalcPort();
        return port.sum(n1, n2);
    }

    private static int rest(int n1, int n2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pack.Calc port = service.getCalcPort();
        return port.rest(n1, n2);
    }
    
}
