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
        return cpf.matches("[0-9]{11}");
    }

    public boolean validarSenha(String senha) {
        return senha.matches("[0-9]{6}");
    }

    public boolean validarCliente(String cpf, String senha) {
        Cliente aux = banco.getCliente(cpf,senha);
        return aux != null;
    }

    public Cliente getCliente(String cpf, String senha) {
        return banco.getCliente(cpf,senha);
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
