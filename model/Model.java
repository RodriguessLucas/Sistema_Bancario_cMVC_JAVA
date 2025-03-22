package model;

import java.util.ArrayList;

public class Model {
    private final Banco banco = new Banco();
    private ArrayList<Observer> observers = new ArrayList<>();

    public Model() {}


    public String getNomeBanco() {
        return banco.getNomeBanco();
    }

    public boolean validarCpf(String cpf) {
        return cpf.matches("[0-9]{10}");
    }

    public boolean validarSenha(String senha) {
        return senha.matches("[0-9]{6}");
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
