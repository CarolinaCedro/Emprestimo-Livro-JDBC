package org.application;

import org.application.config.ConnectionMySQLDAO;
import org.application.view.LivroCRUDGUI;

public class Main {

    public static void main(String[] args) {
        System.out.println("Iniciando ...");

        ConnectionMySQLDAO.getConnection();


//        System.out.println("Criando uma tabela no banco");
//        String queryCreateTable = "CREATE TABLE Persons (\n" +
//                "    PersonID int,\n" +
//                "    LastName varchar(255),\n" +
//                "    FirstName varchar(255),\n" +
//                "    Address varchar(255),\n" +
//                "    City varchar(255)\n" +
//                ");";
//
//        try {
//            ConnectionMySQLDAO.executeQuery(queryCreateTable);
//            System.out.println("Tabela criada com sucesso");
//        } catch (RuntimeException exception) {
//            System.out.println("Erro: " + exception);
//        }


//        System.out.println("Populando tabela");
//        String queryCreate =  "INSERT INTO Persons (PersonID, LastName, FirstName, Address, City)\n" +
//                "VALUES ('1', 'Carol Teste', 'Carol Teste', 'Carol Teste', 'Carol Teste');";
//
//        try {
//            ConnectionMySQLDAO.executeQuery(queryCreate);
//            System.out.println("Tabela populada com sucesso");
//        } catch (RuntimeException exception) {
//            System.out.println("Erro: " + exception);
//        }


    }

}
