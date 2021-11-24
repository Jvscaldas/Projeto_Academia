package academia.consulta;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrincipalAcademia extends Application implements ExecutorComandos {
    private ConsultaBoundary consultaBoundary = new ConsultaBoundary();
    private OpcaoBoundary opcaoBoundary = new OpcaoBoundary();
    private ExcluiBoundary excluiBoundary = new ExcluiBoundary();
    private CadastroBoundary cadastroBoundary = new CadastroBoundary();
    private AtualizaBoundary atualizaBoundary = new AtualizaBoundary();
    private BorderPane bp = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scn = new Scene(bp, 700, 350);

        bp.setCenter(opcaoBoundary.render());

        MenuBar menuBar = new MenuBar();

        Menu mnuOpcoes = new Menu("Opcoes");
        Menu mnuConsulta = new Menu("Consulta");
        Menu mnuExclui = new Menu("Excluir");

        menuBar.getMenus().addAll(mnuOpcoes, mnuConsulta, mnuExclui);

        MenuItem mnuItemConsulta = new MenuItem("Consulta");
        mnuItemConsulta.setOnAction((e) -> {
            executarComando("TELA-CONSULTA");
        });

        MenuItem mnuItemOpcoes = new MenuItem("Botões");
        mnuItemOpcoes.setOnAction((e) -> {
            executarComando("TELA-BOTOES");
        });

        MenuItem mnuItemExclui = new MenuItem("Excluir");
        mnuItemExclui.setOnAction((e) -> {
            executarComando("TELA-EXCLUI");
        });

        MenuItem mnuItemCadastro = new MenuItem("Cadastro");
        mnuItemCadastro.setOnAction((e) -> {
            executarComando("TELA-CADASTRO");
        });

        MenuItem mnuItemAtualiza = new MenuItem("Atualizar");
        mnuItemAtualiza.setOnAction((e) -> {
            executarComando("TELA-ATUALIZAR");
        });

        opcaoBoundary.adicionarExecutor(this);
        excluiBoundary.adicionarExecutor(this);
        consultaBoundary.adicionarExecutor(this);
        cadastroBoundary.adicionarExecutor(this);
        atualizaBoundary.adicionarExecutor(this);


        mnuConsulta.getItems().addAll(mnuItemConsulta);
        mnuOpcoes.getItems().addAll(mnuItemOpcoes);
        mnuExclui.getItems().addAll(mnuItemExclui);

        bp.setTop(menuBar);

        stage.setScene(scn);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(PrincipalAcademia.class, args);
    }

    @Override
    public void executarComando(String comando) {
        if ("TELA-CONSULTA".equals(comando)) {
            bp.setCenter(consultaBoundary.render());
        } else if ("TELA-EXCLUI".equals(comando)) {
            bp.setCenter(excluiBoundary.render());
        } else if ("TELA-BOTOES".equals(comando)) {
            bp.setCenter(opcaoBoundary.render());
        } else if ("TELA-CADASTRO".equals(comando)) {
            bp.setCenter(cadastroBoundary.render());
        } else if ("TELA-ATUALIZAR".equals(comando)) {
            bp.setCenter(atualizaBoundary.render());
        }
    }
}
