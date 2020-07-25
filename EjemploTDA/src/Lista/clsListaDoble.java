/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;
import negocio.nodoLD;
/**
 *
 * @author eduard
 */
public class clsListaDoble {
    private nodoLD pListaD;
    public int contador;
    public clsListaDoble(){
        this.pListaD=null;
        this.contador=0;
    }
    
     public void setpListaD(nodoLD pListaD){
        this.pListaD = pListaD;
    }
    
    public nodoLD getpListaD(){
        return this.pListaD;
    }
    
    public void insertarIzq(int dato,String detalle){
        nodoLD nn = new nodoLD(dato,detalle);
        if(this.pListaD == null){
            this.pListaD = nn;
        }else{
            if(this.pListaD.getRefIzq() == null){
                nn.setRefDer(this.pListaD);
                this.pListaD.setRefIzq(nn);
            }else{
                (this.pListaD.getRefIzq()).setRefDer(nn);
                nn.setRefIzq(this.pListaD.getRefIzq());
                nn.setRefDer(this.pListaD);
                this.pListaD.setRefIzq(nn);
            }
        }
    }
    
    public void insertarDer(int dato,String detalle){
        nodoLD nn = new nodoLD(dato,detalle);
        if(this.pListaD == null){
            this.pListaD = nn;
        }else{
            if(this.pListaD.getRefDer() == null){
                nn.setRefIzq(this.pListaD);
                this.pListaD.setRefDer(nn);
            }else{
                (this.pListaD.getRefDer()).setRefIzq(nn);
                nn.setRefDer(this.pListaD.getRefDer());
                nn.setRefIzq(this.pListaD);
                this.pListaD.setRefDer(nn);
            }
        }
    }
    
    public boolean moverDer(){
        if(this.pListaD.getRefDer() != null){
            this.pListaD = this.pListaD.getRefDer();
            return true;
        }else{
            return false;
        }
    }
    
    public boolean moverIzq(){
        if(this.pListaD.getRefIzq() != null){
            this.pListaD = this.pListaD.getRefIzq();
            return true;
        }else{
            return false;
        }
    }
    
    public void irPrimero(){
        while(moverIzq()){
            ;
        }
    }
    
    public void irUltimo(){
        while(moverDer()){
            ;
        }
    }
    
    public void eliminar(int cod){
        nodoLD aux=this.pListaD;
        nodoLD aux1=null;
        irPrimero();
        while(aux!=null){
            if (aux.getDato()==cod) {
                if (aux.getRefDer()==null) {
                    if (aux==this.pListaD) {
                        this.pListaD=null;
                    }else{
                        (aux1.getRefDer()).setRefIzq(null);
                        aux1.setRefDer(null);
                    }
                }else{
                    if (aux==this.pListaD) {
                        this.pListaD=aux.getRefDer();
                        this.pListaD.setRefIzq(null);
                        this.pListaD.setRefDer(aux.getRefDer().getRefDer());
                    }else{
                        aux1.setRefDer(aux.getRefDer());
                        aux1.setRefIzq(aux.getRefDer().getRefIzq());
                    }
                }
            }
            aux1=aux;
            aux=aux.getRefDer();
        }
    }
    
    public void longitudlistadoble(){
        nodoLD aux=this.pListaD;
        int i=0;
        irPrimero();
        while(aux!=null){
            i++;
            aux=aux.getRefDer();
        }
        setContador(i);
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    
}
