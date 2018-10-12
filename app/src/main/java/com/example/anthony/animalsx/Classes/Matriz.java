package com.example.anthony.animalsx.Classes;

import android.util.Log;

import javax.xml.transform.Result;

public class Matriz {
    private int nfilas=3;
    private int nColumnas;
    private double[][] data;

    public Matriz(int nColumnas)
    {
        this.setnColumnas(nColumnas);
        setData(new double[getNfilas()][nColumnas]);
    }
    public Matriz(int nfilas, int nColumnas) {
        this.setnColumnas(nColumnas);
        this.setNfilas(nfilas);
        setData(new double[nfilas][nColumnas]);
    }


    public Matriz(double [][]data){
        setNfilas(data.length);
        setnColumnas(data[0].length);
        this.setData(new double[getNfilas()][getnColumnas()]);
        for (int i = 0; i < getNfilas(); i++)
            for (int j = 0; j < getnColumnas(); j++)
                this.getData()[i][j] = data[i][j];
    }

    private Matriz(Matriz A){this(A.getData());}

    public Matriz timesM(int a)
    {
        Matriz A = this;
        Matriz result=this;
        for (int i=1;i<a;i++)
        {
            result=result.Multiplicacion(A);
        }
        return result;
    }

    public Matriz Multiplicacion(Matriz B) {
        Matriz A = this;
        if (A.getnColumnas() != B.getNfilas()) throw new RuntimeException("Illegal Matriz dimensions.");
        Matriz C = new Matriz(A.getnColumnas(), B.getNfilas());
        for (int i = 0; i < C.getnColumnas(); i++)
            for (int j = 0; j < C.getNfilas(); j++)
                for (int k = 0; k < A.getNfilas(); k++)
                    C.getData()[i][j] += (A.getData()[i][k] * B.getData()[k][j]);
        return C;
    }

    public Matriz LeslieMatriz(Matriz A){
        Matriz leslie=this;
        //Primera fila
        for (int j=0;j<leslie.getNfilas();j++)
        {
            leslie.setData(0,j,A.getData(1,j));
        }
        //Segunda (diagonales)
        //double[][] d = { { 80, 40, 60 }, { 0.28, 1.2, 0.5 }, { 0.51, 0.81, 0} };
        for (int i=1;i<leslie.getNfilas();i++)
        {
            for (int j=0;j<leslie.getnColumnas();j++)
            {
                if (i==j+1)
                    leslie.setData(i,j,A.getData(2,j));
                else
                    leslie.setData(i,j,0);
            }
        }

        return leslie;
    }

    public void init()
    {
        for (int i=0;i<nColumnas;i++){
            for (int j=0;j<nfilas;j++)
                data[i][j]=0;
        }
    }
    public int getNfilas() {
        return nfilas;
    }

    public void setNfilas(int nfilas) {
        this.nfilas = nfilas;
    }

    public int getnColumnas() {
        return nColumnas;
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
    public Matriz transpose() {
        Matriz A = new Matriz(nColumnas, nfilas);
        for (int i = 0; i < nColumnas; i++)
            for (int j = 0; j < nfilas; j++)
            {
                if (i!=0)
                    A.data[j][i] = 0;
                else
                    A.data[j][i] = this.data[i][j];
            }

        return A;
    }
}
