package model;
import java.util.HashMap;

public class Banco {
    private final String banco = "Banco Banco";
    private final HashMap<String,Cliente> clientes;

    public Banco() {
        clientes = new HashMap<>();
    }

    public String getNomeBanco() {
        return banco;
    }


    public void adicionaCliente(Cliente cliente) {
        if(!clientes.containsKey(cliente.getNome())) {
            clientes.put(cliente.getCpf(), cliente);
        }
    }

    public void removerCliente(Cliente cliente) {
        if(existeCliente(cliente)) {
            clientes.remove(cliente.getCpf());
        }
    }

    public boolean existeCliente(Cliente cliente) {
        return clientes.containsKey(cliente.getCpf());
    }

    public boolean existeCliente(String cpf) { return clientes.containsKey(cpf); }

    public Cliente getCliente(String cpf) {
        return clientes.get(cpf);
    }

    public Cliente getCliente(String cpf, String senha) {
        Cliente aux = clientes.get(cpf);
        if(aux == null) {
            return null;
        }
        if(aux.getSenha().equals(senha)) {
            return aux;
        }
        return null;
    }






}
