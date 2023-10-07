package org.application.orm;

public class Querys<T> {

    // Comandos de criação
    public String CreateAutorQuery = "CREATE TABLE autor (idAutores int PRIMARY KEY, nome varchar(255), documento varchar(255), status varchar(255));";
    public String CreateEditoraQuery = "CREATE TABLE editora (idEditora int PRIMARY KEY, razaoSocial varchar(255), status varchar(255));";
    public String CreateLivroQuery = "CREATE TABLE livro (idLivros int PRIMARY KEY, titulo varchar(255), status varchar(255));";

    // Comandos de população
    public String InsertAutorQuery = "INSERT INTO autor (idAutores, nome, documento, status) VALUES (?, ?, ?, ?);";
    public String InsertEditoraQuery = "INSERT INTO editora (idEditora, razaoSocial, status) VALUES (?, ?, ?);";
    public String InsertLivroQuery = "INSERT INTO livro (idLivros, titulo, status) VALUES (?, ?, ?);";

    // Comandos de atualização
    public String UpdateAutorQuery = "UPDATE autor SET nome = ?, documento = ?, status = ? WHERE idAutores = ?;";
    public String UpdateEditoraQuery = "UPDATE editora SET razaoSocial = ?, status = ? WHERE idEditora = ?;";
    public String UpdateLivroQuery = "UPDATE livro SET titulo = ?, status = ? WHERE idLivros = ?;";

    // Comandos de exclusão
    public String DeleteAutorQuery = "DELETE FROM autor WHERE idAutores = ?;";
    public String DeleteEditoraQuery = "DELETE FROM editora WHERE idEditora = ?;";
    public String DeleteLivroQuery = "DELETE FROM livro WHERE idLivros = ?;";
}
