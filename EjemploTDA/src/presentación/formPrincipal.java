/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentación;
import Pilas.Pila;
import Cola.Cola;
import Lista.clsListaSimple;
import Lista.clsListaDoble;
import Lista.clsListaCircular;
import Lista.lscolor;
import Arbol.clsArbol;
import negocio.nodo;
import negocio.nodoLD;
import negocio.coloresnd;
import negocio.nodoAB;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author pc
 */
public class formPrincipal extends javax.swing.JFrame {
    double xp1=300;
    double yp1=300;
    double xp2=10;
    double yp2=300;
    double sin60=Math.sin(3.14/3.);
    int nivel_de_recursividad=6;
    /**
     * Creates new form formPrincipal
     */
    private Pila objePila;
    private Cola objcola;
    private clsListaSimple objlista; 
    private clsListaDoble objld;
    private clsListaCircular oblc;
    private clsArbol arbolbin;
    private lscolor colores;
    private int px,py,auxz;
    private double radianes;
    public boolean bandera;
    
    public formPrincipal() {
        initComponents();
        this.arbolbin= new clsArbol();
        this.objePila = new Pila();
        this.objcola = new Cola();
        this.objlista = new clsListaSimple();
        this.objld=new clsListaDoble();
        this.oblc=new clsListaCircular();
        this.colores=new lscolor();
        this.bandera=false;
        px = 80;
        radianes=0;
        py = 110;
        auxz=0;
    }
    
    public void graficar(){
        py=180;
        Graphics dibujar = this.getGraphics();
        dibujar.clearRect(px, py, 300, 400);
        nodo nn = this.objePila.getCima();
        int i = 0;
        dibujar.drawString("Cima->", px-45, py+25);
        while(nn != null){
            String dd = nn.getDato();
            dibujar.setColor(Color.RED);
            dibujar.drawRect(px, py+i*35, 80, 30);
            dibujar.setColor(Color.BLACK);
            dibujar.drawString(dd, px, py+i*35+25);
            i++;
            nn = nn.getRefNodo();
        }
    }
    
    public void graficarcola(){
        py=180;
        Graphics gg = this.getGraphics();
        gg.clearRect(px, py, 600, 300);
        gg.setColor(Color.red);
        nodo objC = this.objcola.getRefPri();
        int i=0,w=80,h=30,r=10;
        while(objC != null){
            String ss = objC.getDato();
            gg.drawRect(px+i*w, py, w-r, h);
            gg.fillRect(px+(i+1)*w-2*r, py, r, h);
            gg.drawLine(px+(i+1)*w-r, py+h/2, px+(i+1)*w, py+h/2);
            gg.drawString(ss, px+i*w+5, py+h-5);
            objC=objC.getRefNodo();
            if (objC == this.objcola.getRefUlt()) {
                gg.setColor(Color.BLUE);
                gg.drawLine(px+(i+2)*w, py+h, px+(i+2)*w, py+h/2);
                gg.drawLine(px+(i+2)*w-(5), py+h, px+(i+2)*w+5, py+h);
                gg.drawLine(px+(i+2)*w-(5), py+h+3, px+(i+2)*w+5, py+h+3);
            }else{
                gg.setColor(Color.BLACK);
            }
            i++;
        }
    }
    public void graficarlista(){
        Graphics gg = this.getGraphics();
        gg.clearRect(px, py, 600, 300);
        nodo objC = this.objlista.getRefPri();
        int i=0,w=80,h=30,r=10;
        while(objC != null){
            String ss = objC.getDato();
            objC=objC.getRefNodo();
            //objC == this.objlista.getRefUlt()
            i++;
            if (i==1) {
                gg.setColor(Color.RED);
            }
            else if (this.auxz==i) {
                gg.setColor(Color.BLUE);
                
                gg.drawLine(px+(i+1)*w, py+h, px+(i+1)*w, py+h/2);
                gg.drawLine(px+(i+1)*w-(5), py+h, px+(i+1)*w+5, py+h);
                gg.drawLine(px+(i+1)*w-(5), py+h+3, px+(i+1)*w+5, py+h+3);
            }else{
                gg.setColor(Color.BLACK);
            }
            gg.drawRect(px+i*w, py, w-r, h);
            gg.fillRect(px+(i+1)*w-2*r, py, r, h);
            gg.drawLine(px+(i+1)*w-r, py+h/2, px+(i+1)*w, py+h/2);
            gg.drawString(ss, px+i*w+5, py+h-5);
        }
    }
    
    public void llenadolabel(){
        this.objlista.longitudlista();
        this.objlista.contadorprimos();
        this.primosl.setText("Primos: " + Integer.toString(this.objlista.getCantidadnodosprimos()));
        this.auxz=this.objlista.getTotaldedatos();
        this.longitud.setText("Longitud: "+Integer.toString(this.auxz));
        this.objlista.cantidadnodospar();
        int zxua=this.objlista.getCantidadnpar();
        this.objlista.promedionodos();
        int promedio=this.objlista.getPromedio();
        this.npar.setText("Nodos Par: "+Integer.toString(zxua));
        this.promn.setText("Promedio: "+Integer.toString(promedio));
    }
    public void rangodatos(){
        int tn = Integer.parseInt(this.tn.getText());
        int tm = Integer.parseInt(this.tm.getText());
        this.objlista.sumaintervalo(tn, tm);
        this.resuma.setText(Integer.toString(this.objlista.getTotaldelintervalo()));
    }
    
    public void graficarlistadoble(){
        Graphics gg = this.getGraphics();
        gg.clearRect(px, py, 600, 300);
        nodoLD ObjLD = this.objld.getpListaD();
        int i=0,w=80,h=30,r=10;
        while(ObjLD != null){
            String ss = ObjLD.devolverdatos();
            if (ObjLD.getRefDer()==null) {
                gg.setColor(Color.BLUE);
                
                gg.drawLine(px+(i+1)*w, py+h, px+(i+1)*w, py+h/2);
                gg.drawLine(px+(i+1)*w-(5), py+h, px+(i+1)*w+5, py+h);
                gg.drawLine(px+(i+1)*w-(5), py+h+3, px+(i+1)*w+5, py+h+3);
            }
            if (ObjLD.getRefIzq()==null) {
                gg.setColor(Color.RED);
                
                gg.drawLine(px+(i)*w-(10), py+h/2, px+(i)*w, py+h/2);
                gg.drawLine(px+(i)*w-10, py+h, px+(i)*w-10, py+h/2);
                gg.drawLine(px+(i)*w-(15), py+h, px+(i)*w-5, py+h);
                gg.drawLine(px+(i)*w-(15), py+h+3, px+(i)*w-5, py+h+3);
            }
            
            gg.drawRect(px+i*w, py, w-r, h);
            gg.fillRect(px+(i+1)*w-2*r, py, r, h);
            gg.drawLine(px+(i+1)*w-r, py+h/2, px+(i+1)*w, py+h/2);
            gg.drawString(ss, px+i*w+5, py+h-5);
            ObjLD=ObjLD.getRefDer();
            //ObjLD=ObjLD.getRefIzq();
            i++;
        }
    }
    
    public void graficarListaDoble(){
        Graphics gg = this.getGraphics();
        gg.clearRect(px, py, 1200, 300);
        /// es para clonar un objeto
        clsListaDoble objAuxLD = new clsListaDoble();
        objAuxLD.setpListaD(this.objld.getpListaD());
        objAuxLD.irPrimero();
        
        nodoLD nodoLDPri = objAuxLD.getpListaD();
        
        int i = 0,w=80,h=30,r=10;
        while(nodoLDPri != null){
            if(nodoLDPri == this.objld.getpListaD()){
                gg.setColor(Color.red);
            }else{
                gg.setColor(Color.BLACK);
            }
            String ss = ""+nodoLDPri.getDato();
            gg.drawRect(px+i*w, py, w-r, h); // rectángulo
            gg.fillRect(px+(i+1)*w-2*r, py, r, h); // relleno
            gg.setColor(Color.red);
            gg.drawLine(px+(i+1)*w-r, py+h/3, px+(i+1)*w, py+h/3);
            gg.setColor(Color.BLACK);
            gg.drawLine(px+(i+1)*w-r, py+2*h/3, px+(i+1)*w, py+2*h/3);
            gg.drawString(ss, px+i*w+5, py+h-5);
            i++;
            nodoLDPri = nodoLDPri.getRefDer();
        }
    }
    
    public void graficarlistacircular(){
        Graphics gg = this.getGraphics();
        Graphics2D g2d=(Graphics2D)gg;
        gg.clearRect(20, py, 600, 280);
        /*
        this.radianes=this.radianes+0.01;
        g2d.translate(200/2, 200);
        g2d.rotate(this.radianes);*/
        nodoLD nodoaux = this.oblc.getListaC();
        nodoLD nodoaux1 = this.oblc.getListaC();
        int i =0;
        this.oblc.longituddecircular();
        int longitud=this.oblc.getLongi();
        int sumagrados=0;
        int cuadro=py;
        int texto=py+15;
        
        lscolor objAuxLD = new lscolor();
        objAuxLD.setIndex(this.colores.getIndex());
        objAuxLD.irPrimero();
        
        coloresnd nodoLDPri = objAuxLD.getIndex();
        
        while(nodoaux!=null){
            int grados=0;
            int rojo = nodoLDPri.getRojo();
            int azul = nodoLDPri.getAzul();
            int verde = nodoLDPri.getVerde();
            String ss = nodoaux.getDetalle();
            g2d.setColor(new Color(rojo,verde, azul));
            if (nodoaux.getRefDer()==nodoaux1) {
                if (i==0) {
                    grados = 1 * 360 / 1;
                    g2d.fillArc(25, py, 200, 200, 0, grados);
                    g2d.fillRect(250, cuadro, 20, 20);
                    gg.drawString(ss, 275, texto);
                    sumagrados=sumagrados+grados;
                }
                else{
                    grados = 1 * 360 / longitud;
                    g2d.fillArc(25, py, 200, 200, sumagrados, grados);
                    g2d.fillRect(250, cuadro, 20, 20);
                    gg.drawString(ss, 275, texto);
                    sumagrados=sumagrados+grados;
                }
                nodoaux=null;
            }else{
                if (i==0) {
                    grados = 1 * 360 / longitud;
                    g2d.fillArc(25, py, 200, 200, 0, grados);
                    g2d.fillRect(250, cuadro, 20, 20);
                    gg.drawString(ss, 275, texto);
                    sumagrados=sumagrados+grados;
                }
                else{
                    grados = 1 * 360 / longitud;
                    g2d.fillArc(25, py, 200, 200, sumagrados, grados);
                    g2d.fillRect(250, cuadro, 20, 20);
                    gg.drawString(ss, 275, texto);
                    sumagrados=sumagrados+grados;
                }
                cuadro=cuadro+30;
                texto=texto+30;
                nodoaux=nodoaux.getRefDer();
            }
            i++;
            nodoLDPri = nodoLDPri.getRefDer();
        }
    }
    
    public void movercoloresruleta(){
        int ii=this.oblc.getLongi()-1;
        while(this.bandera==false){
            try {
                //Ponemos a "Dormir" el programa durante los ms que queremos
                Thread.sleep(500);
                this.oblc.moversig();
                graficarmov(ii);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Fallo");
            }
            if (ii==0) {
                ii=this.oblc.getLongi()-1;
            }else{
                ii--;
            }
        }
    }
    
    public void graficarmov(int ii){
        Graphics gg = this.getGraphics();
        gg.clearRect(px, py, 600, 280);
        nodoLD nodoaux = this.oblc.getListaC();
        nodoLD nodoaux1 = this.oblc.getListaC();
        int i =0;
        this.oblc.longituddecircular();
        int longitud=this.oblc.getLongi();
        int sumagrados=0;
        int cuadro=py;
        int texto=py+15;
        
        lscolor objAuxLD = new lscolor();
        objAuxLD.setIndex(this.colores.getIndex());
        objAuxLD.irPrimero();
        
        coloresnd nodoLDPri = objAuxLD.getIndex();
        
        while(nodoaux!=null){
            int grados=0;
            int rojo = nodoLDPri.getRojo();
            int azul = nodoLDPri.getAzul();
            int verde = nodoLDPri.getVerde();
            String ss = nodoaux.getDetalle();
            gg.setColor(new Color(rojo,verde, azul));
            if (ii==i) {
                gg.setColor(new Color(255,255, 255));
            }
            if (nodoaux.getRefDer()==nodoaux1) {
                if (i==0) {
                    grados = 1 * 360 / 1;
                    gg.fillArc(25, py, 200, 200, 0, grados);
                    gg.fillRect(250, cuadro, 20, 20);
                    gg.drawString(ss, 275, texto);
                    sumagrados=sumagrados+grados;
                }
                else{
                    grados = 1 * 360 / longitud;
                    gg.fillArc(25, py, 200, 200, sumagrados, grados);
                    gg.fillRect(250, cuadro, 20, 20);
                    gg.drawString(ss, 275, texto);
                    sumagrados=sumagrados+grados;
                }
                nodoaux=null;
            }else{
                if (i==0) {
                    grados = 1 * 360 / longitud;
                    gg.fillArc(25, py, 200, 200, 0, grados);
                    gg.fillRect(250, cuadro, 20, 20);
                    gg.drawString(ss, 275, texto);
                    sumagrados=sumagrados+grados;
                }
                else{
                    grados = 1 * 360 / longitud;
                    gg.fillArc(25, py, 200, 200, sumagrados, grados);
                    gg.fillRect(250, cuadro, 20, 20);
                    gg.drawString(ss, 275, texto);
                    sumagrados=sumagrados+grados;
                }
                cuadro=cuadro+30;
                texto=texto+30;
                nodoaux=nodoaux.getRefDer();
            }
            i++;
            nodoLDPri = nodoLDPri.getRefDer();
        }
    }
    
    public void llenadodata2(){
        this.oblc.longituddecircular();
        this.oblc.nodosprimos();
        this.oblc.nodospares();
        this.oblc.nodospromedio();
        this.primosl.setText("Primos: " + Integer.toString(this.oblc.getNdprimos()));
        this.longitud.setText("Longitud: "+Integer.toString(this.oblc.getLongi()));
        this.npar.setText("Nodos Par: "+Integer.toString(this.oblc.getContadordepares()));
        this.promn.setText("Promedio: "+Integer.toString(this.oblc.getNdpromedio()));
    }
    
    public void paint(){
        Graphics g = this.getGraphics();
        paintRecursivo(g,nivel_de_recursividad,xp1,yp1,xp2,yp2);
    }

    private void paintRecursivo(Graphics g, int i, double xp12, double yp12, double xp22, double yp22 ) {

        double dx=(xp22-xp12)/2.;
        double dy=(yp22-yp12)/2.;
        double xp32=xp12+dx-2*dy*sin60;
        double yp32=yp12+dy+2*dx*sin60;

        double dx1=(xp22+xp12)/2.;
        double dy1=(yp22+yp12)/2.;
        double dx2=(xp32+xp22)/2.;
        double dy2=(yp32+yp22)/2.;
        double dx3=(xp12+xp32)/2.;
        double dy3=(yp12+yp32)/2.;

        if(i<=0){
            g.drawLine((int)xp12,(int)yp12,(int)xp22,(int)yp22);
            g.drawLine((int)xp22,(int)yp22,(int)xp32,(int)yp32);
            g.drawLine((int)xp32,(int)yp32,(int)xp12,(int)yp12);
        }
        else{
            paintRecursivo(g,i-1,xp12,yp12,dx1,dy1);
            paintRecursivo(g,i-1,dx1,dy1,xp22,yp22);
            paintRecursivo(g,i-1,dx3,dy3,dx2,dy2);
        }

    }
 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_Codigo = new javax.swing.JTextField();
        txt_detalle = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tn = new javax.swing.JTextField();
        tm = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        resuma = new javax.swing.JLabel();
        longitud = new javax.swing.JLabel();
        npar = new javax.swing.JLabel();
        promn = new javax.swing.JLabel();
        primosl = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_Codigo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txt_detalle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("N:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Detalle:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Código:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("M:");

        tn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tm.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Sumar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        resuma.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        resuma.setText("M:");

        longitud.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        longitud.setText("Longitud:");

        npar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        npar.setText("Nodos Par:");

        promn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        promn.setText("Promedio:");

        primosl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        primosl.setText("Primos:");

        jButton2.setText("Mover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jMenu1.setText("Menú");

        jMenuItem4.setText("Graficar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Pilas");

        jMenuItem1.setText("Insetar Pila");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Sacar dato pila");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Esta vacia");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Colas");

        jMenuItem5.setText("Insertar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Eliminar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Lista Simple");

        jMenuItem7.setText("Insertar Ordenado");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("Eliminar por codigo");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("Eliminar Primero");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setText("Eliminar Ultimo");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuItem13.setText("Eliminar Pares");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem13);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Lista Doble");

        jMenuItem11.setText("Insertar Izquierda");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuItem12.setText("Insertar Derecha");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuItem14.setText("Mover Izquierda");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem14);

        jMenuItem15.setText("Mover Derecha");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem15);

        jMenuItem22.setText("Eliminar");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem22);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Lista Circular");

        jMenuItem16.setText("Insertar Derecha");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem16);

        jMenuItem17.setText("Buscar un Nodo");
        jMenu6.add(jMenuItem17);

        jMenuItem18.setText("Eliminar");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem18);

        jMenuItem20.setText("Mover Izquierda");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem20);

        jMenuItem21.setText("Mover Derecha");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem21);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Arbol Binario");

        jMenuItem19.setText("Insertar");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem19);

        jMenuItem23.setText("Eliminar");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem23);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Arbol Balanceado");

        jMenuItem24.setText("Insertar");
        jMenu8.add(jMenuItem24);

        jMenuItem25.setText("Eliminar");
        jMenu8.add(jMenuItem25);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tm, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                        .addComponent(resuma)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(npar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(promn)
                                        .addGap(90, 90, 90)
                                        .addComponent(primosl)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(longitud)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txt_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(longitud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txt_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(npar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(promn)
                            .addComponent(primosl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resuma)
                    .addComponent(jLabel1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        graficar();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.py=120;
        int cod = Integer.parseInt(txt_Codigo.getText());
        String ss = txt_detalle.getText();
        this.objePila.insertar(cod, ss);
        graficar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        String ss = this.objePila.sacarDatos();
        JOptionPane.showMessageDialog(this, ss);
        graficar();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        this.objcola.eliminar();
        graficarcola();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        this.py=180;
        int cod = Integer.parseInt(txt_Codigo.getText());
        String ss = txt_detalle.getText();
        this.objcola.insertar(cod, ss);
        graficarcola();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        this.py=180;
        int cod = Integer.parseInt(txt_Codigo.getText());
        String ss = txt_detalle.getText();
        this.objlista.insertarOrdenado(cod,ss);
        llenadolabel();
        graficarlista();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        this.py=180;
        int cod = Integer.parseInt(txt_Codigo.getText());
        //this.objlista.eliminarporcodigo(cod);
        this.objlista.eliporcdogigoing(cod);
        llenadolabel();
        graficarlista();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        this.objlista.elimina();
        llenadolabel();
        graficarlista();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        this.objlista.eliminarultimo();
        llenadolabel();
        graficarlista();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        rangodatos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        this.py=180;
        int cod = Integer.parseInt(txt_Codigo.getText());
        String ss = txt_detalle.getText();
        this.objld.insertarIzq(cod,ss);
        graficarlistadoble();
        this.objld.longitudlistadoble();
        this.longitud.setText("Longitud: "+this.objld.getContador());
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        this.py=180;
        int cod = Integer.parseInt(txt_Codigo.getText());
        String ss = txt_detalle.getText();
        this.objld.insertarDer(cod,ss);
        graficarlistadoble();
        this.objld.longitudlistadoble();
        this.longitud.setText("Longitud: "+this.objld.getContador());
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        this.objlista.EliminarnodosPares();
        llenadolabel();
        graficarlista();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        if(this.objld.moverDer()){
            JOptionPane.showMessageDialog(this, "ok mover Derecha");
            graficarListaDoble();
        }else{
            JOptionPane.showMessageDialog(this, "No de puede mover Der");
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        if(this.objld.moverIzq()){
            JOptionPane.showMessageDialog(this, "ok mover Izquierda");
            graficarListaDoble();
        }else{
            JOptionPane.showMessageDialog(this, "No de puede mover Izq");
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        this.py=180;
        int rojo = ThreadLocalRandom.current().nextInt(0, 255);
        int verde = ThreadLocalRandom.current().nextInt(0, 255);
        int azul = ThreadLocalRandom.current().nextInt(0, 255);
        this.colores.insertarDer(rojo, verde, azul);
        int cod = Integer.parseInt(txt_Codigo.getText());
        String ss = txt_detalle.getText();
        this.oblc.insertarDer(cod, ss);
        llenadodata2();
        graficarlistacircular();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        this.oblc.moverIzq();
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        this.oblc.moverDer();
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //this.oblc.moversuerte();
        //movercoloresruleta();
        paint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        int cod = Integer.parseInt(txt_Codigo.getText());
        this.objld.eliminar(cod);
        graficarlistadoble();
        this.objld.longitudlistadoble();
        this.longitud.setText("Longitud: "+this.objld.getContador());
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        this.oblc.eliminar();
        llenadodata2();
        graficarlistacircular();
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        int cod = Integer.parseInt(txt_Codigo.getText());
        this.arbolbin.insertar(cod);
        funciondegrabol();
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        int cod = Integer.parseInt(txt_Codigo.getText());
        this.arbolbin.mandandoeliminar(cod);
        funciondegrabol();
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    public void funciondegrabol(){
        int x=200,y=180,dx=120,dy=113;
        Graphics g = this.getGraphics();
        g.clearRect(0, 180, 600, 280);
        graficoarbolrecursivo(g,this.arbolbin.getRaiz(),x,y,"raiz",(int)(dx*0.3),(int)(dy*0.4));
    }
    public void graficoarbolrecursivo(Graphics g,nodoAB nn,int x,int y,String ss,int dx,int dy){
        if (nn.getHijoIZQ()!=null) {
            graficoarbolrecursivo(g,nn.getHijoIZQ(),x-dx,y+dy,"izq",dx,dy);
        }
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.WHITE);
        g.drawString(""+nn.getCod(), x+5, y+25);
        g.setColor(Color.red);
        if (nn.getHijoIZQ()!=null) {
            g.drawLine(x, y+15, x-dx, y+dy+15);
        }if (nn.getHijoDER()!=null) {
            g.drawLine(x+30, y+15, x+30+dx, y+dy+15);
        }
        if (nn.getHijoDER()!=null) {
            graficoarbolrecursivo(g,nn.getHijoDER(),x+dx+30,y+dy,"der",dx,dy);
        }
    }
    
    
    
    
    
    
    
    
    
    public void graficarbolbinarioizq(Graphics g,int x,int y,nodoAB arbol){
        if (arbol!=null) {
            g.setColor(Color.red);
            g.drawLine(x, y+22, x-15, y+50);
            g.setColor(Color.black);
            g.fillOval(x-35, y+50, 30, 30);
            g.setColor(Color.white);
            g.drawString(arbol.getCod()+"", x-25, y+73);
            if (arbol.getHijoDER()!=null) {
                graficarbolbinarioider(g,x,y,arbol.getHijoDER());
            }
            arbol=arbol.getHijoIZQ();
            x=x-35;
            y=y+50;
            graficarbolbinarioizq(g,x,y,arbol);
        }
    }
    
    public void graficarbolbinarioider(Graphics g,int x,int y,nodoAB arbol){
        if (arbol!=null) {
            g.setColor(Color.red);
            g.drawLine(x+30, y+15, x+50, y+46);
            g.setColor(Color.black);
            g.fillOval(x+40, y+45, 30, 30);
            g.setColor(Color.white);
            g.drawString(arbol.getCod()+"", x+45, y+68);
            if (arbol.getHijoIZQ()!=null) {
                graficarbolbinarioizq(g,x+12,y-10,arbol.getHijoIZQ());
            }
            arbol=arbol.getHijoDER();
            x=x+30;
            y=y+58;
            graficarbolbinarioider(g,x,y,arbol);
        }
    }
 
    public void mandargraficarbol(){
        this.px=200;
        this.py=180;
        int x=200,y=180;
        nodoAB arbol = this.arbolbin.getRaiz();
        Graphics g = this.getGraphics();
        g.clearRect(0, 180, 600, 280);
        if (arbol!=null) {
            g.setColor(Color.black);
            g.fillOval(x, y, 30, 30);
            g.setColor(Color.white);
            g.drawString(arbol.getCod()+"", x+5, y+18);
            if (arbol.getHijoIZQ()!=null) {
                graficarbolbinarioizq(g,x,y,arbol.getHijoIZQ());
            }
            if (arbol.getHijoDER()!=null) {
                graficarbolbinarioider(g,x,y,arbol.getHijoDER());
            }
        }
    }
    
    
    
    
    public void graficarArbol(){
        Graphics g = this.getGraphics();
        g.clearRect(0, 180, 600, 280);
        graficarArbol(this.arbolbin.getRaiz(),150,180,300,50);
    }
    
    private void graficarArbol(nodoAB nn, int x, int y, int dx, int dy){
        if (nn.getHijoIZQ()!=null) {
            graficarArbol(nn.getHijoIZQ(),x-dx,y+dy,(int)(dx*0.8),(int)(dy*0.8));
        }
        graficarNodoAB(nn,x,y,dx,dy);
        if (nn.getHijoDER()!=null) {
            graficarArbol(nn.getHijoDER(),x+dx+30,y-dy,(int)(dx*0.8),(int)(dy*0.8));
        }
    }
    
    public void graficarNodoAB(nodoAB nn,int x,int y,int dx, int dy){
        Graphics gg = this.getGraphics();
        gg.setColor(Color.black);
        gg.fillOval(x, y, 30, 30);
        gg.setColor(Color.white);
        gg.drawString(""+nn.getCod(), x+5, y+25);
        gg.setColor(Color.red);
        gg.drawLine(x, y+15, x-dx, y+dy+15);
        gg.drawLine(x+30, y+15, x+30+dx, y+dy+15);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JLabel longitud;
    private javax.swing.JLabel npar;
    private javax.swing.JLabel primosl;
    private javax.swing.JLabel promn;
    private javax.swing.JLabel resuma;
    private javax.swing.JTextField tm;
    private javax.swing.JTextField tn;
    private javax.swing.JTextField txt_Codigo;
    private javax.swing.JTextField txt_detalle;
    // End of variables declaration//GEN-END:variables
}
