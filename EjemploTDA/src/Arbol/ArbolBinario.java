/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

/**
 *
 * @author eduard
 */
import java.io.*;
class NodoBinario{
    int dato;
    NodoBinario Hizq, Hder;
    //Constructores
    NodoBinario (int Elem){
            dato = Elem;
            NodoBinario Hizq, Hder = null;
    }
 
    //Insercion de un elemento
    public void InsertaBinario (int Elem){
            if(Elem < dato){
                    if (Hizq == null)
                            Hizq = new NodoBinario(Elem);
                    else
                            Hizq.InsertaBinario(Elem);
            }
            else{
                    if (Elem > dato){
                            if (Hder == null)
                                    Hder = new NodoBinario (Elem);
                            else
                                    Hder.InsertaBinario(Elem);
                    }
            }
    }
}
 
//Definicion de la clase Arbol
class Arbol{
	Cola Cola = new Cola();
	NodoBinario Padre;
	NodoBinario Raiz;
 
	//Constructor
	public Arbol(){
		Raiz = null;
	}
 
	//Insercion de un elemento en el arbol
	public void InsertaNodo(int Elem){
		if(Raiz == null)
			Raiz = new NodoBinario (Elem);
		else
			Raiz.InsertaBinario (Elem);
	}
 
	//Preorden Recursivo del arbol
	public void Preorden (NodoBinario Nodo){
		if(Nodo == null)
			return;
		else{
			System.out.print (Nodo.dato + " ");
			Preorden (Nodo.Hizq);
			Preorden (Nodo.Hder);
		}
	}
 
	//PostOrden recursivo del arbol
	public void PostOrden (NodoBinario Nodo){
		if(Nodo == null)
			return;
		else{
			PostOrden (Nodo.Hizq);
			PostOrden (Nodo.Hder);
			System.out.print (Nodo.dato + " ");
		}
	}
 
	//Inorden Recursivo del arbol
	public void Inorden (NodoBinario Nodo){
		if(Nodo == null)
			return;
		else{
			Inorden (Nodo.Hizq);
			System.out.print(Nodo.dato + " ");
			Inorden (Nodo.Hder);
		}
	}
 
	//Busca un elemento en el arbol
	void Busqueda (int Elem, NodoBinario A){
		if((A == null) | (A.dato == Elem)){
			System.out.print(A.dato + " ");
			return;
		}
		else{
			if(Elem>A.dato)
				Busqueda (Elem, A.Hder);
			else
				Busqueda ( Elem, A.Hizq);
		}
	}
 
	//Altura del arbol
	public int Altura (NodoBinario Nodo){
		int Altder = (Nodo.Hder == null? 0:1 + Altura (Nodo.Hder));
		int Altizq = (Nodo.Hizq == null? 0:1 + Altura (Nodo.Hizq));
		return Math.max(Altder,Altizq);
	}
 
	//Recorrido en anchura del arbol
	public void Anchura (NodoBinario Nodo){
		Cola cola= new Cola();
		NodoBinario T = null;
		System.out.print ("El recorrido en Anchura es: ");
		if(Nodo != null){
			cola.InsertaFinal (Nodo);
			while(!(cola.VaciaLista ())){
				T = cola.PrimerNodo.datos;
				cola.EliminaInicio();
				System.out.print(T.dato + " ");
				if (T.Hizq != null)
					cola.InsertaFinal (T.Hizq);
				if (T.Hder != null)
					cola.InsertaFinal (T.Hder);
			}
		}
		System.out.println();
	}
}
 
//Definición de la Clase NodoLista
class NodosListaA{
  	NodoBinario datos;
    NodosListaA siguiente;
 
     //Construtor  Crea un nodo del tipo Object
	NodosListaA (NodoBinario  valor){
		datos =valor;
	    siguiente = null;  //siguiente con valor de nulo
	 }
 
	// Constructor Crea un nodo del Tipo Object y al siguiente nodo de la lista
	NodosListaA (NodoBinario valor, NodosListaA signodo){
		datos = valor;
    	siguiente = signodo; //siguiente se refiere al siguiente nodo
	}
}
 
//Definición de la Clase Lista
class Cola{
	NodosListaA PrimerNodo;
	NodosListaA UltimoNodo;
	String Nombre;
 
	//Constructor construye una lista vacia con un nombre de List
	public Cola(){
		this ("Lista");
	}
 
	//Constructor
 	public Cola (String s){
		Nombre = s;
	    PrimerNodo = UltimoNodo =null;
	}
 
	//Retorna True si Lista Vacía
	public boolean VaciaLista() {
		return PrimerNodo == null;
	}
 
	//Inserta un Elemento al Frente de la Lista
	public void InsertaInicio (NodoBinario ElemInser){
		if(VaciaLista())
	    	PrimerNodo = UltimoNodo = new NodosListaA (ElemInser);
	    else
	    	PrimerNodo = new NodosListaA (ElemInser, PrimerNodo);
	}
 
	//Inserta al Final de la Lista
	public void InsertaFinal(NodoBinario ElemInser){
		if(VaciaLista())
	        PrimerNodo = UltimoNodo = new NodosListaA (ElemInser);
	    else
	  	     UltimoNodo=UltimoNodo.siguiente =new NodosListaA (ElemInser);
	}
 
	//Eliminar al Inicio
	public void EliminaInicio(){
		if(VaciaLista())
	    	System.out.println ("No hay elementos");
 
	 	// Restablecer  las referencias de PrimerNodo y UltimoNodo
	 	if(PrimerNodo.equals (UltimoNodo))
	    	PrimerNodo = UltimoNodo = null;
	    else
	    	PrimerNodo = PrimerNodo.siguiente;
	}
 
	//Elimina al final
	public void EliminaFinal (){
	    if(VaciaLista())
	      System.out.println ("No hay elementos");
 
		// Restablecer  las referencias de PrimerNodo y UltimoNodo
		if (PrimerNodo.equals (UltimoNodo))
	    	PrimerNodo = UltimoNodo = null;
	    else{
	    	NodosListaA Actual =PrimerNodo;
			while (Actual.siguiente != UltimoNodo)
				Actual = Actual.siguiente;
 
			UltimoNodo =Actual;
			Actual.siguiente = null;
	    }
	}
}
 
 
class ArbolBinarioA{
	public static void main (String[]args)throws IOException
		{
		Arbol A = new Arbol();
 
 
            String dato;
        int indice;
    	int opc=0;
 
 
    		InputStreamReader en=new InputStreamReader(System.in);
    		BufferedReader br=new BufferedReader(en);
    		System.out.println("****BIENVENIDO A ARBOL BINARIO ORDENADO****");
    		do{
 
    			System.out.println("MENU\n");
    			System.out.println("1.Insertar");
    			System.out.println("2.Eliminar");
    			System.out.println("3.Recorrido en Pre orden");
    			System.out.println("4.Recorrido en In orden");
    			System.out.println("5.Recorrido en Pos orden");
    			System.out.println("6.Salir");
    			System.out.println("seleccione opcion --->\n");
        String decide=br.readLine();
         opc=Integer.parseInt(decide);
        switch(opc)
        {
        	case 1:
        			System.out.println("Dame numero\n");
        			dato=br.readLine();
                	int p=Integer.parseInt(dato);
        		     A.InsertaNodo(p);
        			break;
        	case 2:
        		  // 	System.out.println("Dame el numero a borrar\n");
        		  // 	String g=br.readLine();
        		  // 	indice=Integer.parseInt(g);
        		  // 	A.Busqueda(indice);
        		   	break;
            case 3:
            	System.out.print("El recorrido en Preorden es: ");
	         	A.Preorden (A.Raiz);
        		System.out.println();
 
        		   	break;
        	case 4:
        		System.out.print("El recorrido en Inorden es: ");
		       A.Inorden (A.Raiz);
		       System.out.println();
 
 
        		   	break;
            case 5:
        		   System.out.print("El recorrido en Postorden es: ");
		A.PostOrden (A.Raiz);
		System.out.println();
 
        		   	break;
 
        }//fin switch	
    	    	}while(opc!=6);//fin do
 
 
 
		//System.out.println("La altura del arbol es: " + A.Altura (A.Raiz));
	//	A.Anchura (A.Raiz);	
	}
}
