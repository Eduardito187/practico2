/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentación;

import Cola.Cola;
import Lista.clsListaSimple;
import Lista.clsListaCircular;
import Lista.lscolor;
import p1.orden;
//import recursividad.tarea;
import Arbol.clsArbol;
//import Lista.clsListaDoble;
/**
 *
 * @author pc
 */
public class clsPrincipal {
    public static void main(String[] args) {
        clsArbol obj = new clsArbol();
        obj.insertar(50);
        obj.insertar(40);
        obj.insertar(30);
        obj.insertar(25);
        obj.insertar(35);
        obj.eliminarbol(40);
        //tarea re = new tarea();
        //re.funcioninvertir(49284);
        //re.funcionordenado(12489);
        //re.funcionesprimo(37);
        //re.funcionsumatori(123456789);
        
        //orden ord = new orden();
        //ord.esono("22222222");
        //ord.esono("1268");
        //ord.esono("12664");
        /*
        clsListaCircular oblc = new clsListaCircular();
        oblc.insertarDer(71, "Carlos");
        oblc.insertarDer(21, "Juana");
        oblc.insertarDer(72, "Pepe");
        oblc.insertarDer(50, "Pedro");
        oblc.insertarDer(70, "Mario");
        oblc.imprimirenconsola();
        oblc.longituddecircular();
        oblc.eliminar();
        oblc.imprimirenconsola();
        oblc.longituddecircular();
        oblc.eliminar();
        oblc.imprimirenconsola();*/
        //lscolor color = new lscolor();
        /*
        clsListaSimple obj = new clsListaSimple(); 
        obj.insertarOrdenado(20, "Juana");
        obj.insertarOrdenado(50, "Pedro");
        obj.insertarOrdenado(70, "Mario");
        obj.insertarOrdenado(25, "Ana");
        obj.insertarOrdenado(71, "Maria");
        obj.EliminarnodosPares();
        obj.visualizacodrconsola();*/
        /*
        clsListaDoble obj = new clsListaDoble();
        obj.insertarDer(10,"ash");
        obj.insertarDer(20,"ash");
        obj.insertarIzq(30,"ash");
        obj.insertarIzq(150,"ash");
        */
    }
}
