package org.application.model;


//idEditora INT
//razaoSocial VARCHAR(45)
//status VARCHAR(15)

import java.util.Objects;

public class EditoraBEAN {

    private Integer idEditora;
    private String razaoSocial;
    private String status;

    public EditoraBEAN() {
    }


    public EditoraBEAN(Integer idEditora, String razaoSocial, String status) {
        this.idEditora = idEditora;
        this.razaoSocial = razaoSocial;
        this.status = status;
    }

    public EditoraBEAN(String razaoSocial, String status) {
        this.razaoSocial = razaoSocial;
        this.status = status;
    }

    public Integer getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Integer idEditora) {
        this.idEditora = idEditora;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
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
        EditoraBEAN that = (EditoraBEAN) o;
        return Objects.equals(idEditora, that.idEditora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEditora);
    }

    @Override
    public String toString() {
        return "EditoraBEAN{" +
                "idEditora=" + idEditora +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
