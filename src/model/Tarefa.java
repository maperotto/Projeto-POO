package ucb.aplicativo.model;

import java.time.LocalDateTime;



public class Tarefa {
    private long id;
    private String titulo;
    private String descricao;
    private LocalDateTime  dataHora;
    private boolean  completo;
    
    //Costrutores
    public Tarefa(){
        this.dataHora=LocalDateTime.now();
        this.completo=false;
    }
    
    public Tarefa(String titulo){
    this();    //chama o construtor padrão 
    this.titulo=titulo;
    }
    
    public Tarefa(String titulo,String descricao){
    this(titulo);
    this.descricao=descricao;
    }
     public Tarefa(long id, String titulo, String descricao, boolean completo) {
    this.id = id;
    this.titulo = titulo;
    this.descricao = descricao;
    this.dataHora = LocalDateTime.now();
    this.completo = completo;
}

    
    //gets e sets METODOS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isComplemento() {
        return completo;
    }

    public void setComplemento(boolean complemento) {
        this.completo = complemento;
    }

   
    
    
    
}