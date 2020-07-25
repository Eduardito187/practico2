/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;
import negocio.nodo;
/**
 *
 * @author eduard
 */
public class clsListaSimple {
    private nodo refPri;
    public int totaldedatos;
    public int promedio;
    public int cantidadnpar;
    public int totaldelintervalo;
    public int cantidadnodosprimos;

    public clsListaSimple(){
        this.refPri=null;
        this.totaldedatos=0;
        this.promedio=0;
        this.cantidadnpar=0;
        this.totaldelintervalo=0;
        this.cantidadnodosprimos=0;
    }

    public nodo getRefPri() {
        return refPri;
    }

    public void setRefPri(nodo refPri) {
        this.refPri = refPri;
    }
    
    public int getTotaldedatos() {
        return totaldedatos;
    }

    public void setTotaldedatos(int totaldedatos) {
        this.totaldedatos = totaldedatos;
    }

    public boolean estaVacia(){
        return this.refPri == null ? true : false;
    }
    public void insertarOrdenado(int dato, String detalle){
        nodo nn = new nodo(dato, detalle);
        if(estaVacia()){
            this.refPri = nn;
        }else{
            if(dato < this.refPri.getCod()){
                nn.setRefNodo(this.refPri);
                this.refPri = nn;
            }else{
                nodo p = refPri;
                boolean sw = false;
                while(p.getRefNodo() != null){
                    if(nn.getCod() < p.getRefNodo().getCod()){
                        sw = true;
                        nn.setRefNodo(p.getRefNodo());
                        p.setRefNodo(nn);
                        break; //corte del proceso repetitivo
                    }else{
                        p = p.getRefNodo();
                    }
                }
                if(sw == false){
                    p.setRefNodo(nn);
                }
            }
        }
    }
    public void mostrar(){
        nodo aux=this.refPri;
        this.totaldedatos=0;
        while(aux!=null){
            //System.out.print(aux.getDato()+" - ");
            aux=aux.getRefNodo();
            this.totaldedatos++;
        }
        this.setTotaldedatos(totaldedatos);
        //System.out.println();
    }
    public void visualizacodrconsola(){
        nodo aux=this.refPri;
        while(aux!=null){
            System.out.print(aux.getDato()+" - ");
            aux=aux.getRefNodo();
        }
        System.out.println();
    }
    
    public void elimina(){
        if (!estaVacia()) {
            this.refPri=this.refPri.getRefNodo();
        }
    }
    
    public void eliminarporcodigo(int cod){
        nodo actual = new nodo();
        nodo anterior = new nodo();
        actual=this.refPri;
        anterior=null;
        while(actual!=null){
            if (actual.getCod()==cod) {
                if (actual==this.refPri) {
                    this.refPri=this.refPri.getRefNodo();
                    nodo p = this.refPri;
                    while(p.getRefNodo()!=null&& cod>=p.getRefNodo().getCod()){
                    }
                }
                else{
                    anterior.setRefNodo(actual.getRefNodo());
                }
            }
            anterior=actual;
            if (actual.getRefNodo()!=null) {
                actual=actual.getRefNodo();
            }
        }
    }
    
    public void eliporcdogigoing(int cod){
        nodo p = this.refPri;
        while(p.getRefNodo() != null && cod >= p.getRefNodo().getCod()){
            if (p.getRefNodo().getCod() == cod) {
                p.setRefNodo(p.getRefNodo().getRefNodo());
                //break;
            }else{
                p=p.getRefNodo();
            }
        }
        if (this.refPri.getCod()==cod) {
            this.refPri=this.refPri.getRefNodo();
        }
    }
    
    public void longitudlista(){
        nodo aux=this.refPri;
        this.totaldedatos=0;
        while(aux!=null){
            aux=aux.getRefNodo();
            this.totaldedatos++;
        }
        this.setTotaldedatos(totaldedatos);
    }
    public void cantidadnodospar(){
        nodo aux=this.refPri;
        this.cantidadnpar=0;
        while(aux!=null){
            if (aux.getCod()%2==0) {
                this.cantidadnpar++;
            }
            aux=aux.getRefNodo();
        }
        this.setCantidadnpar(cantidadnpar);
    }
    
    public int getCantidadnpar() {
        return cantidadnpar;
    }

    public void setCantidadnpar(int cantidadnpar) {
        this.cantidadnpar = cantidadnpar;
    }
    
    public void promedionodos(){
        nodo aux=this.refPri;
        this.promedio=0;
        int auxz=0;
        longitudlista();
        while(aux!=null){
            auxz=auxz+aux.getCod();
            aux=aux.getRefNodo();
        }
        if (auxz==0) {
            this.promedio=0;
        }else{
            this.promedio=auxz/this.totaldedatos;
        }
        this.setPromedio(promedio);
    }
    
    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }
    
    public void sumaintervalo(int n,int m){
        nodo aux=this.refPri;
        this.totaldelintervalo=0;
        while(aux!=null){
            if (aux.getCod() >= n && aux.getCod() <= m) {
                this.totaldelintervalo=this.totaldelintervalo+aux.getCod();
            }
            aux=aux.getRefNodo();
        }
        setTotaldelintervalo(totaldelintervalo);
    }
    
    public int getTotaldelintervalo() {
        return totaldelintervalo;
    }

    public void setTotaldelintervalo(int totaldelintervalo) {
        this.totaldelintervalo = totaldelintervalo;
    }
    
    public void eliminarultimo(){
        nodo auxi = new nodo();
        auxi=this.refPri;
        int i = 0;
        while(auxi!=null){
            i++;
            if (this.totaldedatos >= 3 && this.totaldedatos == i+2) {
                auxi=auxi.getRefNodo();
                if (auxi.getRefNodo()!=null) {
                    auxi.setRefNodo(null);
                    auxi=auxi.getRefNodo();
                }
            }
            else if (this.totaldedatos ==i+1) {
                auxi.setRefNodo(null);
                auxi=auxi.getRefNodo();
            }
            else{
                if (this.totaldedatos ==1) {
                    auxi=auxi.getRefNodo();
                    this.refPri=this.refPri.getRefNodo();
                }
                else{
                    auxi=auxi.getRefNodo();
                }
            }
        }
    }
    
    public void EliminarnodosPares(){
        nodo p = this.refPri;
        if (p.getCod()%2==0) {
            this.refPri=p.getRefNodo();
        }
        while(p.getRefNodo() != null){
            if (p.getRefNodo().getCod() %2==0) {
                p.setRefNodo(p.getRefNodo().getRefNodo());
                //break;
            }else{
                p=p.getRefNodo();
            }
        }
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
    
    public void contadorprimos(){
        nodo aux=this.refPri;
        this.cantidadnodosprimos=0;
        while(aux!=null){
            if (esPrimo(aux.getCod())) {
                this.cantidadnodosprimos++;
            }
            aux=aux.getRefNodo();
        }
        this.setCantidadnodosprimos(cantidadnodosprimos);
    }

    public int getCantidadnodosprimos() {
        return cantidadnodosprimos;
    }

    public void setCantidadnodosprimos(int cantidadnodosprimos) {
        this.cantidadnodosprimos = cantidadnodosprimos;
    }
    
    
}
