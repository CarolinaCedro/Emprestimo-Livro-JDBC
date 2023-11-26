package org.application;

import org.application.controller.dao.AmigoDao;
import org.application.controller.dao.EmprestimoDao;
import org.application.controller.dao.LivroDao;
import org.application.model.AmigoBean;
import org.application.model.EmprestimoBean;
import org.application.model.LivroBean;

import java.util.Date;
import java.util.List;

public class Main {


    public static void main(String[] args) {


        List<LivroBean> livros;
        List<AmigoBean> amigos;

        livros = LivroDao.listarTodosOrdenadosPorNomeAsc();
        amigos = AmigoDao.listarTodos();


        EmprestimoDao.criarTabelaEmprestimos();


        EmprestimoBean emprestimo = new EmprestimoBean();
        emprestimo.setData(new Date());
        emprestimo.setSituacao("Em andamento");

        // Adicionar livros e amigos ao empréstimo
        emprestimo.setLivrosEmprestados(livros);
        emprestimo.setAmigosQuePegaramLivros(amigos);


        EmprestimoDao.inserir(emprestimo);


        EmprestimoBean emprestimoConsultado = EmprestimoDao.buscarEmprestimoPorId(emprestimo.getIdEmprestimo());
        System.out.println("Empréstimo Consultado: " + emprestimoConsultado);

//        // Exemplo de consulta: buscar empréstimos por situação
//        List<EmprestimoBean> emprestimosPorSituacao = EmprestimoDao.buscarEmprestimosPorSituacao("Em andamento");
//        System.out.println("Empréstimos por Situação 'Em andamento': " + emprestimosPorSituacao);
    }
}
