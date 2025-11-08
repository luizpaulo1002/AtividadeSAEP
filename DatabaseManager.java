import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:biblioteca.db";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
    
    public static void initDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS livros (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    titulo TEXT NOT NULL,
                    autor TEXT NOT NULL,
                    isbn TEXT UNIQUE NOT NULL,
                    ano_publicacao INTEGER,
                    categoria TEXT,
                    quantidade_total INTEGER DEFAULT 1,
                    quantidade_disponivel INTEGER DEFAULT 1
                )
            """);
            
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS usuarios (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    email TEXT UNIQUE NOT NULL,
                    telefone TEXT,
                    data_cadastro DATE DEFAULT CURRENT_DATE
                )
            """);
            
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS emprestimos (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    livro_id INTEGER NOT NULL,
                    usuario_id INTEGER NOT NULL,
                    data_emprestimo DATE DEFAULT CURRENT_DATE,
                    data_devolucao_prevista DATE NOT NULL,
                    data_devolucao_real DATE,
                    status TEXT DEFAULT 'ativo',
                    FOREIGN KEY (livro_id) REFERENCES livros(id),
                    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
                )
            """);
            
            System.out.println("✓ Banco de dados inicializado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inicializar banco: " + e.getMessage());
        }
    }
}