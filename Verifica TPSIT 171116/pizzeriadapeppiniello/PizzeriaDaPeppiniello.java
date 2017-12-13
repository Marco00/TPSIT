/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeriadapeppiniello;
import java.util.concurrent.Semaphore;
import java.util.Random;
/**
 *
 * @author Marco
 */
public class PizzeriaDaPeppiniello {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer buffer=new BoundedBuffer();
        Random gen=new Random();
        Thread thread=null;
        int possibiliClienti=0, turno=0;
        final int CLIENTI=14;
        int controllo=1+gen.nextInt(3);
        while(possibiliClienti<=CLIENTI){
            int n=1+gen.nextInt(4);
            possibiliClienti=possibiliClienti+n;
            if(possibiliClienti>CLIENTI)
                n=CLIENTI-(possibiliClienti-n);
            turno++;
            System.out.println("! Hanno intenzione di entrare in pizzeria "+n+" clienti");
            for(int i=0; i<n; i++){
                thread=new Thread(buffer);
                if(buffer.posti.availablePermits()==0){
                    System.out.println(thread.getName()+" sta aspettando fuori che si liberi un posto...");
                    thread.join();
                }
                thread.start();
                Thread.sleep(200);
            }
            if(turno==controllo)
                System.out.println("Il cameriere è passato tra i tavoli e ha contato "+buffer.posti.availablePermits()+" posti disponibili");
            Thread.sleep(12000);
        }
    }
}

class BoundedBuffer implements Runnable{
    
    Semaphore posti;
    private Random gen=new Random();
    
    public BoundedBuffer(){
        posti = new Semaphore(12);
    }
    
    @Override
    public void run() {
        try {
            posti.acquire();
            System.out.println(Thread.currentThread().getName()+" è entrato in pizzeria. Ha occupato un posto e verrà servito");
            Thread.sleep(40000);
            int min=5, max=7;
            int random=((max-min)+1);
            int tempoPizza=gen.nextInt(random)+min;
            System.out.println(Thread.currentThread().getName()+" è stato servito e mangerà la sua pizza in "+tempoPizza+" minuti");
            Thread.sleep(tempoPizza*60000);
        } catch (InterruptedException e) { 
            e.printStackTrace();
        } finally {
            posti.release();
            System.out.println(Thread.currentThread().getName()+" esce dalla pizzeria");
        }
    }
}

