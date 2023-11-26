package org.application.model;



import java.util.Objects;

public class AmigoBean {

    private Integer idAmigo;
    private String nome;
    private String documento;
    private String status;

    public AmigoBean(Integer idAmigo, String nome, String documento, String status) {
        this.idAmigo = idAmigo;
        this.nome = nome;
        this.documento = documento;
        this.status = status;
    }

    public AmigoBean(String nome, String documento, String status) {
        this.nome = nome;
        this.documento = documento;
        this.status = status;
    }

    public AmigoBean() {
    }


    public Integer getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(Integer idAmigo) {
        this.idAmigo = idAmigo;
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
        AmigoBean amigoBean = (AmigoBean) o;
        return Objects.equals(idAmigo, amigoBean.idAmigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAmigo);
    }

    @Override
    public String toString() {
        return "AmigoBean{" +
                "idAmigo=" + idAmigo +
                ", nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
