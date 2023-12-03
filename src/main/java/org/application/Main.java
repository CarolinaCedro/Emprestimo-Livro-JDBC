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

//        AmigoDao.createDataBase();

//
//        AmigoBean amigoBean = new AmigoBean(1, "Carolina Cedro", "6737747475", "ATIVO");
//        AutorBean autorBean = new AutorBean(1, "Marina", "873457347", "ATIVO");
//        EditoraBEAN editoraBEAN = new EditoraBEAN(1, "Mark Editora", "ATIVO");
//        LivroBean livroBean = new LivroBean(1, "Love is LOve", "ATIVO", 1, 1, null, null);
//        LivroBean livroBean2 = new LivroBean(2, "Bristh nano", "ATIVO", 1, 1, null, null);
//        LivroBean livroBean3 = new LivroBean(3, "Tekas mommy", "ATIVO", 1, 1, null, null);
//
//        AmigoDao.criarTabelaAmigos();
//        AmigoDao.inserir(amigoBean);
//
//        AutorDao.criarTabelaAutores();
//        AutorDao.inserir(autorBean);
//
//        EditoraDao.criarTabelaEditoras();
//        EditoraDao.inserir(editoraBEAN);
//
//        LivroDao.criarTabelaLivros();
//        LivroDao.inserir(livroBean);
//        LivroDao.inserir(livroBean2);
//        LivroDao.inserir(livroBean3);


        EmprestimoDao.criarTabelasEmprestimos();

        AmigoBean amigoBean;


        // Supondo que esses métodos existam e funcionem corretamente
        List<LivroBean> livros = LivroDao.listarTodasComStatusATIVO();
        System.out.println("aqui a pesquisa de todos os livros" + livros);
        amigoBean = AmigoDao.buscarAmigoPorId(1);


        EmprestimoBean emprestimo = new EmprestimoBean();
        emprestimo.setIdEmprestimo(null);
        emprestimo.setDataEmprestimo(new Date());
        emprestimo.setDataDevolucao(new Date());
        emprestimo.setDescricao("Imprestimo Livro");
        emprestimo.setStatus("Disponivel");

        // Adicionar livros e amigos ao empréstimo
        System.out.println("Todos os livros que irão ser inseridos" + livros);
        emprestimo.setListaLivros(livros);
        emprestimo.setAmigo(amigoBean);

        // Inserir o empréstimo no banco de dados
        EmprestimoDao.inserirEmprestimo(emprestimo);

        System.out.println("Todos os emprestimos" + EmprestimoDao.listarTodosEmprestimosDetalhados());

//         Consultar o empréstimo por ID
//        List<EmprestimoBean> emprestimoConsultado = EmprestimoDao.listarTodosEmprestimos();
//        System.out.println("Empréstimo Consultado: " + emprestimoConsultado);


    }


}

