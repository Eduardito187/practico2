/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import java.util.concurrent.ThreadLocalRandom;
import negocio.nodoLD;

/**
 *
 * @author eduard
 */
public class clsListaCircular {
    private nodoLD ListaC;
    private nodoLD refsuerte;
    private nodoLD siguiente;
    public int longi;
    public int contadordepares;
    public int ndpromedio;
    public int ndprimos;
    public clsListaCircular(){
        this.ListaC=null;
        this.refsuerte=null;
        this.siguiente=null;
        this.longi=0;
        this.contadordepares=0;
        this.ndpromedio=0;
        this.ndprimos=0;
    }
    
     public void setListaC(nodoLD ListaC){
        this.ListaC = ListaC;
    }
    
    public nodoLD getListaC(){
        return this.ListaC;
    }
    
    public void insertarIzq(int dato,String detalle){
        nodoLD nn = new nodoLD(dato,detalle);
        if(this.ListaC == null){
            this.ListaC = nn;
        }else{
            if(this.ListaC.getRefIzq() == null){
                nn.setRefDer(this.ListaC);
                this.ListaC.setRefIzq(nn);
            }else{
                (this.ListaC.getRefIzq()).setRefDer(nn);
                nn.setRefIzq(this.ListaC.getRefIzq());
                nn.setRefDer(this.ListaC);
                this.ListaC.setRefIzq(nn);
            }
        }
    }
    
    public void insertarDer(int dato,String detalle){
        nodoLD nn = new nodoLD(dato,detalle);
        if(this.ListaC == null){
            this.ListaC = nn;
            this.ListaC.setRefDer(nn);
            this.ListaC.setRefIzq(nn);
        }else{
            if(this.ListaC.getRefDer() == null){
                nn.setRefIzq(this.ListaC);
                this.ListaC.setRefDer(nn);
                this.ListaC.setRefIzq(nn);
                nn.getRefDer().setRefDer(this.ListaC);
            }else{
                (this.ListaC.getRefDer()).setRefIzq(nn);
                nn.setRefDer(this.ListaC.getRefDer());
                nn.setRefIzq(this.ListaC);
                this.ListaC.setRefDer(nn);
            }
        }
    }
    
    public boolean moverDer(){
        if(this.ListaC.getRefDer() != null){
            this.ListaC = this.ListaC.getRefDer();
            return true;
        }else{
            return false;
        }
    }
    
    public boolean moverIzq(){
        if(this.ListaC.getRefIzq() != null){
            this.ListaC = this.ListaC.getRefIzq();
            return true;
        }else{
            return false;
        }
    }
    
    public void imprimirenconsola(){
        nodoLD aux=this.ListaC;
        nodoLD aux1=this.ListaC;
        while(aux!=null){
            System.out.print(aux.devolverdatos()+" - ");
            if (aux.getRefDer()==aux1) {
                aux=null;
            }else{
                aux=aux.getRefDer();
            }
        }
        System.out.print("\n");
    }
    public void longituddecircular(){
        nodoLD aux=this.ListaC;
        nodoLD aux1=this.ListaC;
        this.longi=1;
        while(aux!=null){
            if (aux.getRefDer()==aux1) {
                aux=null;
            }else{
                aux=aux.getRefDer();
                this.longi++;
            }
        }
    }

    public int getLongi() {
        return longi;
    }

    public void setLongi(int longi) {
        this.longi = longi;
    }
    
    public void nodospares(){
        nodoLD aux=this.ListaC;
        nodoLD aux1=this.ListaC;
        int auxz=0;
        while(aux!=null){
            //System.out.print(aux.devolverdatos()+" - ");
            if (aux.getRefDer()==aux1) {
                aux=null;
            }else{
                if (aux.getDato()%2==0) {
                    auxz++;
                }
                aux=aux.getRefDer();
            }
        }
        setContadordepares(auxz);
    }
    public void nodospromedio(){
        longituddecircular();
        nodoLD aux=this.ListaC;
        nodoLD aux1=this.ListaC;
        int auxc=0;
        while(aux!=null){
            if (aux.getRefDer()==aux1) {
                aux=null;
            }else{
                auxc=auxc+aux.getDato();
                aux=aux.getRefDer();
            }
        }
        auxc=auxc/this.longi;
        setNdpromedio(auxc);
    }
    
    private int funcandivisores(int n, int i) {
        if (n == i) {
            return 1;
        } else {
            return funcandivisores(n, i + 1) + (n % i == 0 ? 1 : 0);
        }
    }
    
    public boolean esPrimo(int n) {
        int cd = funcandivisores(n, 1);
        return cd <= 2 ? true : false;
    }
    
    public void nodosprimos(){
        nodoLD aux=this.ListaC;
        nodoLD aux1=this.ListaC;
        int andprimos=0;
        while(aux!=null){
            if (aux.getRefDer()==aux1) {
                aux=null;
            }else{
                if (esPrimo(aux.getDato())) {
                    andprimos++;
                }
                aux=aux.getRefDer();
            }
        }
        setNdprimos(andprimos);
    }

    public int getContadordepares() {
        return contadordepares;
    }

    public void setContadordepares(int contadordepares) {
        this.contadordepares = contadordepares;
    }

    public int getNdpromedio() {
        return ndpromedio;
    }

    public void setNdpromedio(int ndpromedio) {
        this.ndpromedio = ndpromedio;
    }

    public int getNdprimos() {
        return ndprimos;
    }

    public void setNdprimos(int ndprimos) {
        this.ndprimos = ndprimos;
    }

    public nodoLD getRefsuerte() {
        return refsuerte;
    }

    public void setRefsuerte(nodoLD refsuerte) {
        this.refsuerte = refsuerte;
    }
    
    public void moversuerte(){
        nodoLD aux=this.ListaC;
        int ra = ThreadLocalRandom.current().nextInt(20, 99);
        int i=0;
        while(aux!=null){
            if (i==ra) {
                this.refsuerte=aux.getRefDer();
                aux=null;
            }else{
                aux=aux.getRefDer();
            }
            i++;
        }
    }
    public void moversig(){
        this.siguiente=this.ListaC.getRefDer();
        
        nodoLD aux=this.ListaC;
        int ra = ThreadLocalRandom.current().nextInt(20, 99);
        int i=0;
        while(aux!=null){
            if (i==ra) {
                this.siguiente=aux.getRefDer();
                aux=null;
            }else{
                aux=aux.getRefDer();
            }
            i++;
        }
    }

    public nodoLD getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoLD siguiente) {
        this.siguiente = siguiente;
    }
    
    /*
    public void eliminar(String detalle){
        nodoLD aux1=this.ListaC;
        boolean ban = false;
        while(ban!=true){
            if (aux1==this.ListaC.getRefDer()) {
                ban=true;
            }
            if (this.ListaC.getRefDer().getDetalle()==detalle) {
                this.ListaC.setRefDer(this.ListaC.getRefDer().getRefDer());
            }
            this.ListaC=this.ListaC.getRefDer();
        }
    }*/
    
    public void eliminar(){
        longituddecircular();
        if(this.longi>0){
            if(this.ListaC.getRefDer()==this.ListaC){
                this.ListaC=null;
            }else{
                this.ListaC=this.ListaC.getRefIzq();
                this.ListaC.setRefDer(this.ListaC.getRefDer().getRefDer());
                this.ListaC.getRefDer().setRefIzq(this.ListaC);
            }
        }
    }
}
