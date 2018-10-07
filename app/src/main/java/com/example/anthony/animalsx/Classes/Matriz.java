package com.example.anthony.animalsx.Classes;

import android.util.Log;

public class Matriz {
    private int nfilas=3;
    private int nColumnas;
    private double[][] data;

    public Matriz(int nColumnas)
    {
        this.setnColumnas(nColumnas);
        setData(new double[getNfilas()][nColumnas]);
    }
    public Matriz(int nColumnas, int nfilas) {
        this.setnColumnas(nColumnas);
        this.setNfilas(nfilas);
        setData(new double[nColumnas][nfilas]);
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


    public Matriz times(Matriz B) {
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
        for (int i=0;i<leslie.getnColumnas();i++)
        {
            Log.d("Aux Primer",Double.toString(A.getData()[i][1]));
            leslie.setData(i,0,A.getData()[i][1]);
            Log.d("Leslie Primer",Double.toString(leslie.getData()[i][0]));
        }
        //Segunda
        for (int i=0;i<leslie.getnColumnas()-1;i++)
            leslie.setData(i,i+1,A.getData()[i][2]);
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
    public void show()
    {
        for (int i=0;i<nColumnas;i++){
            for (int j=0;j<nfilas;j++)
            {Log.d("D",String.valueOf(data[i][j]));}
            Log.d("D","next");}
    }
}
