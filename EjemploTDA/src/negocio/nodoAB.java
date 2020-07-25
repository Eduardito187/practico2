/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author eduard
 */
public class nodoAB {
    private nodoAB hijoDER,hijoIZQ;
    private int cod;

    public nodoAB(int cod){
        this.hijoDER=null;
        this.hijoIZQ=null;
        this.cod=cod;
    }

    public nodoAB getHijoDER() {
        return hijoDER;
    }

    public void setHijoDER(nodoAB hijoDER) {
        this.hijoDER = hijoDER;
    }

    public nodoAB getHijoIZQ() {
        return hijoIZQ;
    }

    public void setHijoIZQ(nodoAB hijoIZQ) {
        this.hijoIZQ = hijoIZQ;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
    
}
