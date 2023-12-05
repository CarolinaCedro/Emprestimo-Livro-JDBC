package org.application.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmprestimoBean {

    private Integer idEmprestimo;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private String descricao;
    private List<LivroBean> listaLivros;
    private AmigoBean amigo;
    private String status;

    public EmprestimoBean() {
    }

    public EmprestimoBean(Integer idEmprestimo, Date dataEmprestimo, Date dataDevolucao, String descricao, List<LivroBean> listaLivros, AmigoBean amigo, String status) {
        this.idEmprestimo = idEmprestimo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.descricao = descricao;
        this.listaLivros = listaLivros;
        this.amigo = amigo;
        this.status = status;
    }


    public Integer getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Integer idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<LivroBean> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(List<LivroBean> listaLivros) {
        this.listaLivros = listaLivros;
    }

    public AmigoBean getAmigo() {
        return amigo;
    }

    public void setAmigo(AmigoBean amigo) {
        this.amigo = amigo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "** Emprestimos ** " + "\n" +
                "Id Emprestimo = " + idEmprestimo + "\n" +
                "DataEmprestimo = " + dataEmprestimo + "\n" +
                "DataDevolucao = " + dataDevolucao + "\n" +
                "Descricao = " + descricao + "\n" +
                "Lista de Livros = " + listaLivros + "\n" +
                "Amigo = " + amigo + "\n" +
                "Status = " + status + "\n \n";

    }
}
