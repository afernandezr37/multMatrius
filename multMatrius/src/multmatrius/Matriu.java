package multmatrius;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import multmatrius.Resultat;
import multmatrius.Resultat;


public class Matriu extends Thread{
    private int [][] matriu = new int [0][0];
    private ArrayList<Resultat> res = new ArrayList<Resultat>();
    private int [][] aux;

    public Matriu() {
    }
    
    public Matriu(int fil, int col) {
        int [][] mat = new int [fil][col];
        for (int i =0; i<mat.length; i++) {
            for (int j = 0; j<mat[0].length; j++) {
                mat[i][j] = (int)(1 + Math.round(Math.random()*10));
            }
        }
        setMatriu(mat);
    }
    
    public int[][] getMatriu() {
        return matriu;
    }

    public void setMatriu(int[][] matriu) {
        this.matriu = matriu;
    }

    public ArrayList<Resultat> getRes() {
        return res;
    }

    public void setRes(ArrayList<Resultat> res) {
        this.res = res;
    }
    
    
    
    public Matriu threadMult(Matriu b) {
        int colAFilB = this.getMatriu()[0].length;
        int filA = this.getMatriu().length;
        int colB = b.getMatriu()[0].length;
        Matriu c = new Matriu();
        if (getMatriu()[0].length != b.getMatriu().length) {
            System.out.println("Les matrius no són multiplicables");
            c = this;
        }
        else {
            aux = new int [filA] [colB];
            for (int i = 0; i<filA; i++) {
                for (int j = 0; j < colB; j++) {
                    Resultat r = new Resultat(this.getMatriu(), b.getMatriu(), i, j);
                    r.start();
                    res.add(r);
                    
                }
            }
            run();
            for (int k =0; k<res.size(); k++) {
                
            }
            
            c.setMatriu(aux);
        }
        return c;
    }
    
    public Matriu noThreadMult(Matriu b) {
        int colAFilB = this.getMatriu()[0].length;
        int filA = this.getMatriu().length;
        int colB = b.getMatriu()[0].length;
        Matriu c = new Matriu();
        if (getMatriu()[0].length != b.getMatriu().length) {
            System.out.println("Les matrius no són multiplicables");
            c = this;
        }
        else {
            this.aux = new int [filA] [colB];
            for (int i = 0; i<filA; i++) {
                for (int j = 0; j < colB; j++) {
                    for (int k = 0; k < this.getMatriu()[0].length; k++) {
                        aux[i][j] += this.getMatriu()[i][k] * b.getMatriu()[k][j]; 
                    }
                    
                }
            }
            c.setMatriu(aux);
        }
        return c;
    }
    
    
    @Override
    public void run() {
        for (int i = 0; i<res.size(); i++) {
            try {
                res.get(i).join();
                aux[res.get(i).getI()] [res.get(i).getJ()] = res.get(i).getRes();
            } catch (InterruptedException ex) {
                Logger.getLogger(Matriu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void mostrar() {
        for (int i = 0; i<matriu.length; i++) {
            for (int j = 0; j<matriu[0].length; j++) {
                System.out.print(String.valueOf(matriu[i][j]) + " ");
            }
            System.out.println();
        }
    }
}
