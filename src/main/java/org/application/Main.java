package org.application;

import org.application.controller.dao.AmigoDao;
import org.application.controller.dao.EmprestimoDao;
import org.application.controller.dao.LivroDao;
import org.application.model.AmigoBean;
import org.application.model.EmprestimoBean;
import org.application.model.LivroBean;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        List<LivroBean> livros;
        AmigoBean amigoBean;

        // Supondo que esses métodos existam e funcionem corretamente
        livros = LivroDao.listarTodosOrdenadosPorNomeAsc();
        amigoBean = AmigoDao.buscarAmigoPorId(8);

        EmprestimoDao.criarTabelaEmprestimos();

        EmprestimoBean emprestimo = new EmprestimoBean();
        emprestimo.setDataEmprestimo(new Date());
        emprestimo.setDataDevolucao(new Date());
        emprestimo.setDescricao("Imprestimo Livro");
        emprestimo.setStatus("Disponivel");

        // Adicionar livros e amigos ao empréstimo
        emprestimo.setListaLivros(livros);
        emprestimo.setAmigo(amigoBean);

        // Inserir o empréstimo no banco de dados
        EmprestimoDao.inserirLivrosEmprestimo(emprestimo);

        // Consultar o empréstimo por ID
        List<EmprestimoBean> emprestimoConsultado = EmprestimoDao.listarTodosEmprestimos();
        System.out.println("Empréstimo Consultado: " + emprestimoConsultado);

//        // Exemplo de consulta: buscar empréstimos por situação
//        List<EmprestimoBean> emprestimosPorSituacao = EmprestimoDao.buscarEmprestimosPorSituacao("Em andamento");
//        System.out.println("Empréstimos por Situação 'Em andamento': " + emprestimosPorSituacao);
    }
}

