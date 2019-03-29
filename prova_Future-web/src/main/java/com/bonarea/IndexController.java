/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ramon.simona
 */
@Named
@ViewScoped
public class IndexController implements Serializable {

    @Inject
    ProvaEJB provaEJB;

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    @PostConstruct
    public void init() {

    }

//    public void ferFeina() throws InterruptedException, ExecutionException {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        Future<Integer> future = provaEJB.ferFeina(1);
//
//        while (!future.isDone()) {
//            System.out.println("treballant...");
//        }
//        
//        System.out.println("Resultat: "+future.get());
//    }
//    
    public void ferFeina2() {
        System.out.println("No asíncron");
    }

//    public void testFutureCreationNew() throws InterruptedException {
//        CompletableFuture<String> future = new CompletableFuture<>();
//
//        future.whenCompleteAsync((s, e) -> System.out.println("Result: " + s), executor);
//        Thread.sleep(2000);
//        future.complete("Completado!");
//    }
//
//    public void testFutureCreationRunAsync() {
//        CompletableFuture<Void> futureAsync = CompletableFuture.runAsync(() -> {
//            System.out.println("Comenzando runAsync...");
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            System.out.println("Terminado runAsync!");
//        }, executor);
//
//        futureAsync.whenCompleteAsync((s, e) -> System.out.println("Sin resultado..."), executor);
//        System.out.println("Terminado main thread");
//    }
    public void testFutureCreationSupplyAsync() {
        CompletableFuture<String> futureAsync = CompletableFuture.supplyAsync(() -> {
//            System.out.println("Comenzando supplyAsync...");
//            try {
//                Thread.sleep(6000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            System.out.println("Terminado supplyAsync!");
            //Integer.parseInt(provaEJB.ferFeina(1));
            return "Terminado " + provaEJB.ferFeina(1);

        }, executor);

        futureAsync.whenCompleteAsync((s, e) -> System.out.println("Resultado supplyAsync: " + s +", excepcio="+e),
                executor);
        System.out.println("Terminado main thread");
    }
}
