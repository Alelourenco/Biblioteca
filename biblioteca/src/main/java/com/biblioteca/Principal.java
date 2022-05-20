package com.biblioteca;

import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) {
        try {
            Biblioteca biblioteca = new Biblioteca(
                "jdbc:mysql://localhost/biblioteca?user=root&password=8409", 
                "com.mysql.cj.jdbc.Driver");

            Livro livro = new Livro(1928739, "Harry Potter e o Calice de Fogo", 2006, 1, 1);

            try {
                // Insere o livro no banco
                biblioteca.insereLivro(livro);
            } catch (SQLException e) {
                // Caso o livro já exista no banco de dados com a PK inserida, imprime na tela que o livro já existe
                System.out.println(e);
            }

            // exbir lista após inserir 
            biblioteca.imprimeLivros(); 

            
            // Atualiza o livro com o isbn 192484848
            biblioteca.atualizaLivro(192484848, "Harry Potter e a Ordem da Fenix", 2007, 1, 1);

            // Imprime a lista de livros após o UPDATE
            biblioteca.imprimeLivros();
            

            // Delete
            biblioteca.deletaLivro(364775);

            // Imprime a lista de livros após o delete 
            biblioteca.imprimeLivros();
           

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}