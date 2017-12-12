/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jaxws;

/**
 *
 * @author Formacao
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CalcService serv = new CalcService();
        Calc servPort = serv.getCalcPort(); 
        
        System.out.println("A soma de 1 com 2 é " + servPort.add("1", "2"));
        System.out.println("A subtração de 1 com 2 é " + servPort.subtract("1", "2"));
    }
    
}
