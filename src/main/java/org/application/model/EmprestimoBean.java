package org.application.model;

import java.util.Date;
import java.util.List;

public class EmprestimoBean {

    private Integer idEmprestimo;
    private Date data;
    private String situacao;

    // Relacionamento muitos para muitos entre Livro e Amigo
    private List<LivroBean> livrosEmprestados;
    private List<AmigoBean> amigosQuePegaramLivros;

    public EmprestimoBean() {
    }

    // Métodos getters e setters

    public Integer getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Integer idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public List<LivroBean> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(List<LivroBean> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }

    public List<AmigoBean> getAmigosQuePegaramLivros() {
        return amigosQuePegaramLivros;
    }

    public void setAmigosQuePegaramLivros(List<AmigoBean> amigosQuePegaramLivros) {
        this.amigosQuePegaramLivros = amigosQuePegaramLivros;
    }


    @Override
    public String toString() {
        return "Emprestimo" + "\n" +
                "Id Emprestimo " + idEmprestimo + "\n" +
                "Data " + data + "\n" +
                "Situacacao " + situacao + "\n" +
                "Livros Emprestados " + livrosEmprestados + "\n" +
                "Amigos que Pegaram o Livro " + amigosQuePegaramLivros + "\n" ;

    }

}
