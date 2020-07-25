/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;
import negocio.nodoAB;
/**
 *
 * @author eduard
 */
public class clsArbol {
    private nodoAB raiz;
    public clsArbol(){
        this.raiz=null;
    }
    
    public void insertar(int n){
        nodoAB nn = new nodoAB(n);
        if (this.raiz==null) {
            this.raiz=nn;
        }else{
            insertarec(this.raiz,nn);
        }
    }
    
    public nodoAB getRaiz() {
        return raiz;
    }

    public void setRaiz(nodoAB raiz) {
        this.raiz = raiz;
    }
    
    /*
    private void insertarec(nodoAB Raux,nodoAB nn){
        if (nn.getCod()>Raux.getCod()) {
            if (Raux.getHijoDER()==null) {
                Raux.setHijoDER(nn);
            }else{
                insertarec(Raux.getHijoDER(),nn);
            }
        }else{
            if (Raux.getHijoIZQ()==null) {
                Raux.setHijoIZQ(nn);
            }else{
                insertarec(Raux.getHijoIZQ(),nn);
            }
        }
    }
*/
    
    private void insertarec(nodoAB Raux,nodoAB nn){
        if (nn.getCod()>Raux.getCod()) {
            if (Raux.getHijoDER()==null) {
                Raux.setHijoDER(nn);
            }else{
                insertarec(Raux.getHijoDER(),nn);
            }
        }else{
            if (Raux.getHijoIZQ()==null) {
                Raux.setHijoIZQ(nn);
            }else{
                insertarec(Raux.getHijoIZQ(),nn);
            }
        }
    }

    public void eliminarbol(int cod){
        if (this.raiz.getCod()==cod) {
            this.raiz=null;
        }else{
            nodoAB aux=null;
            if (cod>this.raiz.getCod()) {
                if (this.raiz.getHijoDER()!=null) {
                    aux = this.raiz.getHijoDER();
                    if (aux.getCod()==cod) {
                        if (aux.getHijoDER().getHijoIZQ()!=null) {
                            nodoAB nn = new nodoAB(aux.getHijoDER().getHijoIZQ().getCod());
                            nn.setHijoDER(this.raiz.getHijoDER().getHijoDER());
                            this.raiz.setHijoDER(nn);
                            aux.getHijoDER().setHijoIZQ(null);
                        }else{
                            if (aux.getHijoDER()!=null) {
                                this.raiz.setHijoDER(aux.getHijoDER());
                            }else{
                                this.raiz.setHijoDER(null);
                            }
                        }
                    }else{
                        eliminacionrecursivader(aux.getHijoDER(),cod,aux);
                    }
                }
            }else{
                if (this.raiz.getHijoIZQ()!=null) {
                    aux = this.raiz.getHijoIZQ();
                    if (aux.getCod()==cod) {
                        if (aux.getHijoIZQ().getHijoDER()!=null) {
                            nodoAB nn = new nodoAB(aux.getHijoIZQ().getHijoDER().getCod());
                            nn.setHijoIZQ(this.raiz.getHijoIZQ().getHijoIZQ());
                            this.raiz.setHijoIZQ(nn);
                            aux.getHijoIZQ().setHijoDER(null);
                        }else{
                            if (aux.getHijoIZQ()!=null) {
                                this.raiz.setHijoIZQ(aux.getHijoIZQ());
                            }else{
                                this.raiz.setHijoIZQ(null);
                            }
                        }
                    }else{
                        eliminacionrecursivaizq(aux.getHijoIZQ(),cod,aux);
                    }
                }
            }
        }
    }
    
    public void eliminacionrecursivader(nodoAB aux,int cod,nodoAB ant){
        if (aux.getCod()==cod) {
            if (aux.getHijoDER().getHijoIZQ()!=null) {
                nodoAB nn = new nodoAB(ant.getHijoDER().getHijoDER().getHijoIZQ().getCod());
                nn.setHijoIZQ(aux.getHijoDER().getHijoDER());
                ant.setHijoDER(nn);
                aux.getHijoDER().setHijoIZQ(null);
            }else{
                if (aux.getHijoDER()!=null) {
                    ant.setHijoDER(aux.getHijoDER());
                }else{
                    ant.setHijoDER(null);
                }
            }
        }else{
            eliminacionrecursivader(aux.getHijoDER(),cod,aux);
        }
    }
    
    public void eliminacionrecursivaizq(nodoAB aux,int cod,nodoAB ant){
        if (aux.getCod()==cod) {
            if (aux.getHijoIZQ().getHijoDER()!=null) {
                nodoAB nn = new nodoAB(aux.getHijoIZQ().getHijoIZQ().getHijoDER().getCod());
                nn.setHijoDER(ant.getHijoIZQ().getHijoIZQ());
                ant.setHijoIZQ(nn);
                aux.getHijoIZQ().setHijoDER(null);
            }else{
                if (aux.getHijoIZQ()!=null) {
                    ant.setHijoIZQ(aux.getHijoIZQ());
                }else{
                    ant.setHijoIZQ(null);
                }
            }
        }else{
            eliminacionrecursivaizq(aux.getHijoIZQ(),cod,aux);
        }
    }
    
    public void inorden(){
        inorden(this.raiz);
    }
    
    private void inorden(nodoAB nn){
        if (nn.getHijoIZQ()!=null) {
            inorden(nn.getHijoIZQ());
        }
        System.out.println(nn.getCod());
        if (nn.getHijoDER()!=null) {
            inorden(nn.getHijoDER());
        }
    }
    
    public void mandandoeliminar(int cod){
        if (this.raiz.getCod()==cod) {
            this.raiz=this.raiz.getHijoIZQ();
        }else{
            if (cod>this.raiz.getCod()) {
                if (this.raiz.getHijoDER()!=null) {
                    eliminacionnodo(this.raiz.getHijoDER(),this.raiz,cod,"der");
                }
            }
            if (this.raiz.getHijoIZQ()!=null) {
                if (this.raiz.getHijoIZQ()!=null) {
                    eliminacionnodo(this.raiz.getHijoIZQ(),this.raiz,cod,"izq");
                }
            }
            
        }
    }
    
    public void eliminacionnodo(nodoAB nn,nodoAB anterior,int cod,String ss){
        if (nn.getCod()==cod) {
            if (ss=="der") {
                if (nn.getHijoIZQ()!=null) {
                    if (nn.getHijoDER()!=null) {
                        nn.getHijoIZQ().setHijoDER(nn.getHijoDER());
                    }
                    anterior.setHijoDER(nn.getHijoIZQ());
                }
                else{
                    if (nn.getHijoDER()!=null) {
                        anterior.setHijoDER(nn.getHijoDER());
                    }else{
                        anterior.setHijoDER(null);
                    }
                }
            }else{
                if (nn.getHijoDER()!=null) {
                    if (nn.getHijoIZQ()!=null) {
                        nn.getHijoDER().setHijoIZQ(nn.getHijoIZQ());
                    }
                    anterior.setHijoIZQ(nn.getHijoDER());
                }
                else{
                    if (nn.getHijoIZQ()!=null) {
                        anterior.setHijoIZQ(nn.getHijoIZQ());
                    }else{
                        anterior.setHijoIZQ(null);
                    }
                }
            }
        }else{
            if (nn.getHijoIZQ()!=null) {
                eliminacionnodo(nn.getHijoIZQ(),nn,cod,"izq");
            }
            if (nn.getHijoDER()!=null) {
                eliminacionnodo(nn.getHijoDER(),nn,cod,"der");
            }
        }
    }
}
