package org.application.model;


//idAutores INT
//nome Varchar(200)
//documento Varchar(45)
//status Varchar(15)

import java.util.Objects;

public class AutorBean {
    private Integer idAutor;
    private String nome;
    private String documento;
    private String status;

    public AutorBean() {
    }

    public AutorBean(Integer idAutor, String nome, String documento, String status) {
        this.idAutor = idAutor;
        this.nome = nome;
        this.documento = documento;
        this.status = status;
    }

    public AutorBean(String nome, String documento, String status) {
        this.nome = nome;
        this.documento = documento;
        this.status = status;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
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
        return Objects.equals(idAutor, autorBean.idAutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAutor);
    }

    @Override
    public String toString() {
        return "AutorBean{" +
                "idAutores=" + idAutor +
                ", nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
