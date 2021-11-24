package academia.consulta;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class AcademiaControl {

    StringProperty nome = new SimpleStringProperty("");
    IntegerProperty cod = new SimpleIntegerProperty();

    private AcademiaDAO academiaDAO = new AcademiaDAOImpl();

    private List<Academia> cursosGeral = new ArrayList<>();
    private ObservableList<Academia> cursos = FXCollections.observableArrayList();

    public void adicionar() {
        Academia a = toEntity();
        academiaDAO.adicionar(a);
    }

    public void atualizar() {
        Academia acad = toEntity();
        academiaDAO.atualizar(cod.get(), acad);
    }

    public void pesquisar() {
        cursos.clear();
        List<Academia> encontrados = academiaDAO.pesquisarPorNome(nome.get());
        cursos.addAll(encontrados);
        if (!cursos.isEmpty()) {
            fromEntity(cursos.get(0));
        }
    }

    public void remover(int cod) {
        academiaDAO.remover(cod);
    }

    public Academia toEntity() {
        Academia a = new Academia();
        a.setCod(cod.get());
        a.setNome(nome.get());
        return a;
    }

    public void fromEntity(Academia c) {
        nome.set(c.getNome());
        cod.set(c.getCod());
    }

    public ObservableList<Academia> getLista() {
        return cursos;
    }
}
