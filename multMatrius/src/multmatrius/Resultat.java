package multmatrius;

public class Resultat extends Thread{

    private int res;
    private int[][] matriuA;
    private int[][] matriuB;
    private int i;
    private int j;
    
    public Resultat() {
    }

    public Resultat(int[][] matriuA, int[][] matriuB, int i, int j) {
        this.matriuA = matriuA;
        this.matriuB = matriuB;
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
    
    public int[][] getMatriuA() {
        return matriuA;
    }

    public void setMatriuA(int[][] matriuA) {
        this.matriuA = matriuA;
    }

    public int[][] getMatriuB() {
        return matriuB;
    }

    public void setMatriuB(int[][] matriuB) {
        this.matriuB = matriuB;
    }
    
    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
    
    @Override
    public void run() {
        for (int k = 0; k < matriuA[0].length; k++) { // aColumn
            setRes((matriuA[i][k] * matriuB[k][j]) + this.getRes()); 
        }
    }
    
}
