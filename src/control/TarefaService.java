package ucb.aplicativo.control;
import java.util.ArrayList;
import java.util.List;
import ucb.aplicativo.model.Tarefa;

public class TarefaService {
    private List<Tarefa> tarefa = new ArrayList<>();
    private Long contadorId = 1L;
    
     public Tarefa criarTarefa(String titulo, String descricao) {
        Tarefa nova = new Tarefa(titulo, descricao);
        nova.setId(contadorId++); 
        tarefa.add(nova);
        return nova;
    }
     public boolean atualizarTarefa(long id, String novoTitulo, String novaDescricao, boolean completo) {
      for (Tarefa t : tarefa) {
            if (t.getId() == id) {
                t.setTitulo(novoTitulo);
                t.setDescricao(novaDescricao);
                t.setComplemento(completo);
                return true;
            }
        }
        return false;
    }
       public List<Tarefa> listarTarefas() {
        return tarefa;
}
    
}

public boolean marcarComoCompleta(Long id) {
    for (Tarefa t : tarefa) {
        if (t.getId().equals(id)) {
            t.setCompleto(true);
            return true; // Tarefa encontrada e marcada como completa
        }
    }
    return false; // Tarefa não encontrada
}
