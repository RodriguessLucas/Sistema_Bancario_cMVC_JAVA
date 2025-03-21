package model;

import java.util.ArrayList;

public class Model {
    private final Banco banco = new Banco();
    private Cliente clienteAtuenticacao;
    private ArrayList<Observer> observers = new ArrayList<>();

    public Model() {}


    public String getNomeBanco() {
        return banco.getNomeBanco();
    }

    public void notifica(){
        for(Observer o : observers){
            o.update();
        }
    }

    public void attachObserver(Observer o){
        if(o!=null){
            observers.add(o);
        }
    }
    public void detachObserver(Observer o){
        if(o!=null){
            observers.remove(o);
        }
    }
    public int countObservers(){
        return observers.size();
    }






}
