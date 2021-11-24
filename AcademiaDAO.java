package academia.consulta;

import java.util.List;

public interface AcademiaDAO {

    void adicionar(Academia a);
    List<Academia> pesquisarPorNome(String nome);
    void remover(int cod);
       void atualizar(int cod, Academia a);
}
