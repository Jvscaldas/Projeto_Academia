package academia.consulta;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.converter.NumberStringConverter;

public class ConsultaBoundary extends Tela{

    private TextField txtNome = new TextField();
    private Label txtCod = new Label();

    private Button btnSair = new Button("Sair");
    private Button btnPesquisar = new Button("Pesquisar");
    private Button btnVoltar = new Button("Voltar");

    private AcademiaControl control = new AcademiaControl();

    public Pane render() {
        BorderPane panPrincipal = new BorderPane();
        GridPane panCampos = new GridPane();

        panPrincipal.setCenter(panCampos);

        Bindings.bindBidirectional(txtNome.textProperty(), control.nome);
        Bindings.bindBidirectional(txtCod.textProperty(), control.cod, new NumberStringConverter());

        panCampos.setVgap(5);
        panCampos.setHgap(5);

        panCampos.setAlignment(Pos.CENTER);

        panCampos.add(new Label("Nome"), 0, 1);
        panCampos.add(txtNome, 1, 1);

        panCampos.add(new Label("Código do Aluno"), 0, 2);
        panCampos.add(txtCod, 1, 2);

        panCampos.add(btnPesquisar, 1, 5);
        panCampos.add(btnVoltar,1,6);
        panCampos.add(btnSair, 1, 7);


        btnSair.setOnAction((e) -> {
            Platform.exit();
            System.exit(0);
        });

        btnPesquisar.setOnAction((e) -> {
            control.pesquisar();
        });

        btnVoltar.setOnAction((e) -> {
            notificarComando("TELA-BOTOES");
        });

        return panPrincipal;

    }

}

