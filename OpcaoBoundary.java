package academia.consulta;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class OpcaoBoundary extends Tela {

    private Button btnSair = new Button("Sair");

    private Button btnCadastro = new Button("Cadastro Alunos");
    private Button btnConsulta = new Button("Consultar Alunos");
    private Button btnExclui = new Button("Excluir Alunos");
    private Button btnAltera = new Button("Alterar Alunos");

    private ConsultaBoundary consultaBoundary = new ConsultaBoundary();

    @Override
    public Pane render(){
        BorderPane panPrincipal = new BorderPane();
        GridPane panCampos = new GridPane();

        panPrincipal.setCenter(panCampos);

        panCampos.setVgap(5);
        panCampos.setHgap(5);

        panCampos.setAlignment(Pos.CENTER);

        panCampos.add(btnCadastro, 0, 0);
        panCampos.add(btnConsulta, 1, 0);
        panCampos.add(btnExclui, 0, 1);
        panCampos.add(btnAltera, 1, 1);
        panCampos.add(btnSair, 0, 6);

        btnSair.setOnAction((e) -> {
            Platform.exit();
            System.exit(0);
        });

        btnConsulta.setOnAction((e) -> {
            notificarComando("TELA-CONSULTA");
        });

        btnCadastro.setOnAction((e) -> {
            notificarComando("TELA-CADASTRO");
        });

        btnAltera.setOnAction((e) -> {
            notificarComando("TELA-ATUALIZAR");
        });

        btnExclui.setOnAction((e) -> {
            notificarComando("TELA-EXCLUI");
        });

        return panPrincipal;
    }

}
