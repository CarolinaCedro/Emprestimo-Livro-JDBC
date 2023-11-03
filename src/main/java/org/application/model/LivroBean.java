package org.application.model;

//idLivros INT
//titulo VARCHAR(200)
//status VARCHAR(15)
//Editoras_idEDitora INT (PK)
//Autores_idAutores INT (PK)


import java.util.Objects;

public class LivroBean {

    private Integer idLivro;
    private String titulo;
    private String status;
    private Integer editora_id;
    private Integer autor_id;
    private String editora_nome;
    private String autor_nome;


    public LivroBean(Integer idLivro, String titulo, String status, Integer editora_id, Integer autor_id, String editora_nome, String autor_nome) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.status = status;
        this.editora_id = editora_id;
        this.autor_id = autor_id;
        this.editora_nome = editora_nome;
        this.autor_nome = autor_nome;
    }

    public LivroBean() {
    }

    public LivroBean(String titulo, String status, Integer editora_id, Integer autor_id) {
        this.titulo = titulo;
        this.status = status;
        this.editora_id = editora_id;
        this.autor_id = autor_id;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public String getEditora_nome() {
        return editora_nome;
    }

    public void setEditora_nome(String editora_nome) {
        this.editora_nome = editora_nome;
    }

    public String getAutor_nome() {
        return autor_nome;
    }

    public void setAutor_nome(String autor_nome) {
        this.autor_nome = autor_nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getEditora_id() {
        return editora_id;
    }

    public void setEditora_id(Integer editora_id) {
        this.editora_id = editora_id;
    }

    public Integer getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(Integer autor_id) {
        this.autor_id = autor_id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivroBean livroBean = (LivroBean) o;
        return Objects.equals(idLivro, livroBean.idLivro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLivro);
    }

    @Override
    public String toString() {
        return "LivroBean{" +
                "idLivros=" + idLivro +
                ", titulo='" + titulo + '\'' +
                ", status='" + status + '\'' +
                ", editora_id=" + editora_id +
                ", autor_id=" + autor_id +
                '}';
    }
}
