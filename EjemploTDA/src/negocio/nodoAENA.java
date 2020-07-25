/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;

/**
 *
 * @author eduard
 */
public class nodoAENA {
    private int cod;
    private ArrayList<nodoAENA> listRef;
    public nodoAENA(int cod){
        this.cod=cod; //matriz o vector de 3 x 3
        this.listRef=new ArrayList<nodoAENA>();
    }
}
