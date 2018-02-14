/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risorsecondivise;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Marco
 */
public class Task implements Runnable {
    private Risorse r1;
    private Risorse r2;
    private Random generatore=new Random();
    
    public Task(Risorse r) {
        r1=r;
    }
    
    public Task(Risorse r1, Risorse r2) {
        this.r1=r1;
        this.r2=r2;
    }
   
    @Override
    public void run() {
        int durata;
        if(r2==null) {
            try{
                System.out.println(Thread.currentThread().getName()+": sta andando ad acquisire la risorsa "+r1.getNomeRisorsa());    
                r1.semaforo.acquire();
                System.out.println(Thread.currentThread().getName()+" ha acquisito la risorsa "+r1.getNomeRisorsa());
                durata=1+generatore.nextInt(5);
                TimeUnit.SECONDS.sleep(durata);
                System.out.println(Thread.currentThread().getName()+": l'acquisione della risorsa "+r1.getNomeRisorsa()+" è durata "+durata+" secondi");
            } catch(InterruptedException e){
                e.printStackTrace();
            } finally {
                r1.semaforo.release();
                System.out.println(Thread.currentThread().getName()+": ha rilasciato la risorsa " + r1.getNomeRisorsa()); 
            }
        } else {
            try{
                System.out.println(Thread.currentThread().getName()+": sta andando ad acquisire la risorsa "+r1.getNomeRisorsa());    
                r1.semaforo.acquire();
                System.out.println(Thread.currentThread().getName()+" ha acquisito la risorsa "+r1.getNomeRisorsa());
                durata=1+generatore.nextInt(5);
                TimeUnit.SECONDS.sleep(durata);
                System.out.println(Thread.currentThread().getName()+": l'acquisione della risorsa "+r1.getNomeRisorsa()+" è durata "+durata+" secondi");
                
                System.out.println(Thread.currentThread().getName()+": sta andando ad acquisire la risorsa "+r2.getNomeRisorsa());
                r2.semaforo.acquire();
                System.out.println(Thread.currentThread().getName()+" ha acquisito la risorsa "+r2.getNomeRisorsa());
                durata=1+generatore.nextInt(5);
                TimeUnit.SECONDS.sleep(durata);
                System.out.println(Thread.currentThread().getName()+": l'acquisione della risorsa "+r2.getNomeRisorsa()+" è durata "+durata+" secondi");
            } catch(InterruptedException e){
                e.printStackTrace();
            } finally {
                r1.semaforo.release();
                System.out.println(Thread.currentThread().getName()+": ha rilasciato la risorsa " + r1.getNomeRisorsa());
                r2.semaforo.release();
                System.out.println(Thread.currentThread().getName()+": ha rilasciato la risorsa " + r2.getNomeRisorsa());
            }
        }
    }
}