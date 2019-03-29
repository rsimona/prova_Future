/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
/**
 *
 * @author martin
 */
@Stateless
public class ProvaEJB {

//    @Asynchronous
    public int ferFeina(int i) {
        try {
            Thread.sleep(10000);
            System.out.println("Fent feina...");
            
            return i+=1 ;
        } catch (InterruptedException ex) {
            Logger.getLogger(ProvaEJB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

}
