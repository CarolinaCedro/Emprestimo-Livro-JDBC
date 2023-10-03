package org.application.model;


//idAutores INT
//nome Varchar(200)
//documento Varchar(45)
//status Varchar(15)

import java.util.Objects;

public class AutorBean {
    private Integer idAutores;
    private String nome;
    private String documento;
    private String status;

    public AutorBean() {
    }

    public AutorBean(Integer idAutores, String nome, String documento, String status) {
        this.idAutores = idAutores;
        this.nome = nome;
        this.documento = documento;
        this.status = status;
    }


    public Integer getIdAutores() {
        return idAutores;
    }

    public void setIdAutores(Integer idAutores) {
        this.idAutores = idAutores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutorBean autorBean = (AutorBean) o;
        return Objects.equals(idAutores, autorBean.idAutores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAutores);
    }

    @Override
    public String toString() {
        return "AutorBean{" +
                "idAutores=" + idAutores +
                ", nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
