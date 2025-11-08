class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private String categoria;
    private int quantidadeTotal;
    private int quantidadeDisponivel;
    
    public Livro() {}
    
    public Livro(String titulo, String autor, String isbn, int anoPublicacao, 
                 String categoria, int quantidadeTotal) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeTotal;
    }
    
    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    
    public int getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }
    
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    
    public int getQuantidadeTotal() { return quantidadeTotal; }
    public void setQuantidadeTotal(int quantidadeTotal) { this.quantidadeTotal = quantidadeTotal; }
    
    public int getQuantidadeDisponivel() { return quantidadeDisponivel; }
    public void setQuantidadeDisponivel(int quantidadeDisponivel) { 
        this.quantidadeDisponivel = quantidadeDisponivel; 
    }
    
    @Override
    public String toString() {
        return String.format("Livro[id=%d, titulo='%s', autor='%s', isbn='%s', disponivel=%d/%d]",
            id, titulo, autor, isbn, quantidadeDisponivel, quantidadeTotal);
    }
}
