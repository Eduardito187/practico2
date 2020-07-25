/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursividad;

/**
 *
 * @author eduard
 */
public class tarea {
    //Ordenado
    private int siestaordenado(int n, String i, int anterior) {
        if (n>=anterior) {
            anterior=n;
            if (i.length()>0) {
                n=Integer.parseInt(i.substring(0,1));
                i=i.substring(1);
                return siestaordenado(n,i,anterior);
            }
            else{
                return 1;
            }
        }else{
            return 0;
        }
    }
    
    public boolean validacion(String cad) {
        String s=cad;
        int n=Integer.parseInt(s.substring(1,2));
        int anterior =Integer.parseInt(s.substring(0,1));
        String i=s.substring(2);
        int or = siestaordenado(n, i, anterior);
        return or==1 ? true : false;
    }
    
    public void funcionordenado(int n){
        String cad=n+"";
        boolean siono;
        if (cad.length()>0) {
            siono = validacion(cad);
        }else{
            siono=false;
        }
        System.out.print(siono+"\n");
    }
    
    //Primos
    private int verificacionprimo(int n, int i) {
        if (n == i) {
            return 1;
        } else {
            return verificacionprimo(n, i + 1) + (n % i == 0 ? 1 : 0);
        }
    }

    public boolean esPrimo(int n) {
        int es = verificacionprimo(n, 1);
        return es <= 2 ? true : false;
    }
    
    public void funcionesprimo(int n){
        boolean primo = esPrimo(n);
        System.out.print(primo+"\n");
    }
    
    //Suma
    public int sumadig(int n) {
        return n < 10 ? n : (sumadig(n / 10) + n % 10);
    }
    
    public void funcionsumatori(int n){
        int res = sumadig(n);
        System.out.print(res+"\n");
    }
    //Invertir
    public int fninvertido(int n, int invertido){
        int resto=0;
        if (n>9) {
            resto=n%10;
            invertido=invertido*10+resto;
            n/=10;
            return fninvertido(n,invertido);
        }else{
            if (invertido!=0) {
                resto=n%10;
                invertido=invertido*10+resto;
                return invertido;
            }else{
                return n;
            }
        }
    }
    
    public void funcioninvertir(int n){
        int res=fninvertido(n,0);
        System.out.print(res+"\n");
    }
}
