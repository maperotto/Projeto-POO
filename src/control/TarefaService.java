package ucb.aplicativo.control;

import java.util.ArrayList;
import java.util.List;
import ucb.aplicativo.model.Tarefa;

public class TarefaService {
    private List<Tarefa> tarefa = new ArrayList<>();
    private Long contadorId = 1L;

    
     * @param titulo O título da tarefa.
     * @param descricao A descrição da tarefa.
     * @return A Tarefa criada, ou null se o título for inválido.
     */
    public Tarefa criarTarefa(String titulo, String descricao) {
        
        if (titulo == null || titulo.trim().isEmpty()) {
            return null;
        }

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

    public boolean removerTarefa(long id) {
        return tarefa.removeIf(t -> t.getId() == id);
    }

    public boolean marcarComoCompleta(long id) {
        for (Tarefa t : tarefa) {
            if (t.getId() == id) {
                t.setComplemento(true);
                return true;
            }
        }
        return false;
    }
}