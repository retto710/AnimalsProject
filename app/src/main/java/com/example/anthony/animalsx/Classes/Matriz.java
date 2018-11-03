package com.example.anthony.animalsx.Classes;

import android.util.Log;

import java.io.Serializable;

public class Matriz implements Serializable {
    private int nfilas=3;
    private int nColumnas;
    private double[][] data;
    private int[] nAnimales;
    private int nIter;
    public Matriz()
    {
    }
    //Matriz inicial 3xN
    public Matriz(int nColumnas)
    {
        this.setnColumnas(nColumnas);
        setData(new double[getNfilas()][nColumnas]);
    }

    //Matriz final NxM
    public Matriz(int nfilas, int nColumnas) {
        this.setnColumnas(nColumnas);
        this.setNfilas(nfilas);
        setData(new double[nfilas][nColumnas]);
    }

    //Matriz a partir de otra matriz
    public Matriz(double [][]data){
        this.setNfilas(data.length);
        Log.d("nfilas",String.valueOf(data.length));
        this.setnColumnas(data[0].length);
        Log.d("ncol",String.valueOf(data[0].length));
        this.setData(new double[getNfilas()][getnColumnas()]);
        for (int i = 0; i < getNfilas(); i++)
            for (int j = 0; j < getnColumnas(); j++)
                this.getData()[i][j] = data[i][j];
    }

    //Ingresar fila BirthRate a partir de otra matriz

    public void BirthRate(Matriz A)
    {
        for (int j=0; j<this.nColumnas;j++)
        this.setData(1,j,A.getData(0,j));
    }
    //Ingresar fila Mortal a partir de otra matriz
    public void MortalRate(Matriz A)
    {
        for (int j=0; j<this.nColumnas;j++)
            this.setData(2,j,A.getData(1,j));
    }

    private Matriz(Matriz A){this(A.getData());}

    //Potencia de la matriz
    public Matriz Potencia(int a)
    {
        Matriz A = this;
        Matriz result=this;
        for (int i=1;i<a;i++)
        {
            result=result.Multiplicacion(A);
        }
        return result;
    }

    //Multiplicacion de matrices
    public Matriz Multiplicacion(Matriz B) {
        double b=0;
        Matriz A = this;
        if (A.getnColumnas() != B.getNfilas()) throw new RuntimeException("No se puede multiplicar.");
        Matriz C = new Matriz(A.getnColumnas(), B.getnColumnas());
        Log.d("nColC",String.valueOf(C.getnColumnas()));
        Log.d("NfilasC",String.valueOf(C.getNfilas()));
        for (int i = 0; i < C.getNfilas(); i++) {
            for (int j = 0; j < C.getnColumnas(); j++) {
                b = 0;
                for (int k = 0; k < A.getnColumnas(); k++) {
                    b += (A.getData()[i][k] * B.getData()[k][j]);
                }
                C.setData(i, j, b);
                C.show();
            }
        }
        return C;
    }

    //Matriz Leslie
    public Matriz LeslieMatriz(Matriz A){
        Matriz leslie= new Matriz(A.nColumnas,A.nColumnas);
        Log.d("nfilasLeslie",String.valueOf(leslie.getNfilas()));
        Log.d("ncolLeslie",String.valueOf(leslie.getnColumnas()));
        //Primera fila
        for (int j=0;j<leslie.getnColumnas();j++)
        {
            leslie.setData(0,j,A.getData(1,j));
        }
        leslie.show();
        //Segunda (diagonales)
        //double[][] d = { { 80, 40, 60 }, { 0.28, 1.2, 0.5 }, { 0.51, 0.81, 0} };
        for (int i=1;i<leslie.getNfilas();i++)
        {
            for (int j=0;j<leslie.getnColumnas();j++)
            {
                if (i==j+1)
                {leslie.setData(i,j,A.getData(2,j));
                     leslie.show();}
                else
                    leslie.setData(i,j,0);
            }
        }

        return leslie;
    }
    //Inicializar Matriz en 0
    public void init()
    {
        for (int i=0;i<nColumnas;i++){
            for (int j=0;j<nfilas;j++)
                data[i][j]=0;
        }
    }

    public int getNfilas() {
        return this.nfilas;
    }

    public void setNfilas(int nfilas) {
        this.nfilas = nfilas;
    }

    public int getnColumnas() {
        return this.nColumnas;
    }

    public void setnColumnas(int nColumnas) {
        this.nColumnas = nColumnas;
    }

    public double[][] getData() {
        return data;
    }

    public void setData(double[][] data) {
        this.data = data;
    }

    public void setData(int i,int j,double value){
        data[i][j]=value;
    }

    public double getData(int i , int j){
        return data[i][j];
    }

    //Esto es solo de prueba para que veas los resultados en el Logcat mientras esta en desarrollo el APP
    public void show()
    {

        String text="";
        Log.d("nfilas",String.valueOf(this.getNfilas()));
        Log.d("ncolumnas",String.valueOf(this.getnColumnas()));
        for (int i=0;i<nfilas;i++){
            {
            for (int j=0;j<nColumnas;j++)
            {
                text=text+String.valueOf(data[i][j])+"--" ;
            }
            Log.d("Fila "+i,text);
            text="";
            }
        }
    }

    public String toString()
    {
        String text="";

                for (int i=0;i<nfilas;i++)
                {

                    text=text+String.valueOf(data[i][0])+"\n" ;
                }
        return text;
    }
    public String toString2()
    {
        String text="";

        for (int i=0;i<nfilas;i++)
        {

            text=text+"Rango "+ String.valueOf(i+1)+ ": "+ String.valueOf(Math.round(data[i][0]))+"\n" ;
        }
        return text;
    }
    public Matriz transpose() {
        Matriz A = new Matriz(this.getnColumnas(), this.getNfilas());
        for (int i = 0; i < this.getNfilas(); i++)
            for (int j = 0; j < this.getnColumnas(); j++)
            {
                if (i!=0)
                    A.data[j][i] = 0;
                else
                    A.data[j][0] = this.data[i][j];
            }

        return A;
    }

    public void nInteracciones(int i)
    {
        nAnimales= new int[i+1];
    }

    public int[] getnAnimales() {
        return nAnimales;
    }

    public void setnAnimales(int[] nAnimales) {
        this.nAnimales = nAnimales;
    }

    public void Interacciones(Matriz Pobl,int nInt)
    {
        this.nInteracciones(nInt);
        Matriz base= new Matriz(this.data);
        //Interaccion inicial
        for (int j=0;j<Pobl.nfilas;j++)
        {
            this.nAnimales[0]+=Math.round(Pobl.getData(j,0));
        }
        Log.d("Interaccion "+String.valueOf(0),String.valueOf(this.nAnimales[0]));
        //Interacciones
        for (int i=0;i<nInt;i++)
        {
            Matriz potencia = new Matriz(base.Potencia(i+1));
            potencia.show();
            Matriz aux = new Matriz(potencia.Multiplicacion(Pobl));
            aux.show();
            for (int j=0;j<aux.nColumnas;j++)
            {
                this.nAnimales[i+1]+=Math.round(aux.getData(j,0));
            }
            Log.d("Interaccion "+String.valueOf(i+1),String.valueOf(this.nAnimales[i+1]));
        }
    }

    public Matriz UltInteracciones(Matriz Pobl,int nInt)
    {
        this.nInteracciones(nInt);
        Matriz base= new Matriz(this.data);
        Matriz potencia = new Matriz(base.Potencia(nInt));
        Matriz aux = new Matriz(potencia.Multiplicacion(Pobl));
        return aux;
    }
    public int getnIter() {
        return nIter;
    }

    public void setnIter(int nIter) {
        this.nIter = nIter;
    }
}
