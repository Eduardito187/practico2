/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

/**
 *
 * @author eduard
 */
public class orden {
    
    private int funcandivisores(int n, String i, int anterior) {
        if (n>=anterior) {
            anterior=n;
            if (i.length()>0) {
                n=Integer.parseInt(i.substring(0,1));
                i=i.substring(1);
                return funcandivisores(n,i,anterior);
            }
            else{
                return 1;
            }
        }else{
            return 0;
        }
    }

    private String solopares(String i, String aux, int bandera){
        if (bandera>0) {
            if (Integer.parseInt(i.substring(0,1))%2==0) {
                aux=aux+i.substring(0,1);
                i=i.substring(1);
            }else{
                i=i.substring(1);
            }
            return solopares(i,aux,i.length());
        }else{
            return aux;
        }
    }
    
    public boolean validacion(String cad) {
        String s=cad;
        int n=Integer.parseInt(s.substring(1,2));
        int anterior =Integer.parseInt(s.substring(0,1));
        String i=s.substring(2);
        int cd = funcandivisores(n, i, anterior);
        return cd==1 ? true : false;
    }
    
    public void esono(String cad){
        cad=solopares(cad,"",cad.length());
        boolean siono;
        if (cad.length()>0) {
            siono = validacion(cad);
        }else{
            siono=false;
        }
        System.out.print(siono);
    }
}
