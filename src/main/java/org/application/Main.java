package org.application;

import org.application.controller.dao.*;
import org.application.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {


//        EmprestimoDao.criarTabelasEmprestimos();
//
//        AmigoBean amigoBean;
//
//
//        // Supondo que esses métodos existam e funcionem corretamente
//        List<LivroBean> livros = LivroDao.listarTodasComStatusATIVO();
//        System.out.println("aqui a pesquisa de todos os livros" + livros);
//        amigoBean = AmigoDao.buscarAmigoPorId(1);
//
//
//        EmprestimoBean emprestimo = new EmprestimoBean();
//        emprestimo.setIdEmprestimo(27);
//        emprestimo.setDataEmprestimo(new Date());
//        emprestimo.setDataDevolucao(new Date());
//        emprestimo.setDescricao("Imprestimo Livro");
//        emprestimo.setStatus("Disponivel");
//
//        // Adicionar livros e amigos ao empréstimo
//        System.out.println("Todos os livros que irão ser inseridos" + livros);
//        emprestimo.setListaLivros(livros);
//        emprestimo.setAmigo(amigoBean);
//
//        // Inserir o empréstimo no banco de dados
//        EmprestimoDao.inserirEmprestimo(emprestimo);

        System.out.println("Todos os emprestimos" + EmprestimoDao.listarTodosEmprestimosDetalhados());

//         Consultar o empréstimo por ID
//        List<EmprestimoBean> emprestimoConsultado = EmprestimoDao.listarTodosEmprestimos();
//        System.out.println("Empréstimo Consultado: " + emprestimoConsultado);


    }


}

