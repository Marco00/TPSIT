/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risorsecondivise;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Marco
 */
public class Risorse {
    protected Semaphore semaforo;
    private String nomeRisorsa;

    public Risorse (String nomeRisorsa){
        this.nomeRisorsa=nomeRisorsa;
        this.semaforo=new Semaphore(1);
    }

    public String getNomeRisorsa(){
        return nomeRisorsa;
    }
}