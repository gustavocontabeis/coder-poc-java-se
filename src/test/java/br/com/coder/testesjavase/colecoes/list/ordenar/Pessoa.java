package br.com.coder.testesjavase.colecoes.list.ordenar;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author f768557 <gustavo.silva@to-brasil.com>
 */
public class Pessoa implements Serializable, Comparable<Pessoa> {

    private Integer id;
    private String nome;

    public Pessoa() {
    }

    public Pessoa(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int compareTo(Pessoa other) {

        //First field
        if (this.id == null ^ other.id == null) {
            return (this.id == null) ? -1 : 0;
        }
        if (this.id == null && other.id == null) {
            return 0;
        }
        int i = id.compareTo(other.id);

        if (i != 0) {
            return i;
        }

        //Second field
        if (this.nome == null ^ other.nome == null) {
            return (this.nome == null) ? -1 : 0;
        }
        if (this.nome == null && other.nome == null) {
            return 0;
        }
        return nome.compareTo(other.nome);

    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + String.valueOf(id) + ", nome=" + String.valueOf(nome) + '}';
    }

}
