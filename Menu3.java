/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package artemecanica5;

import java.awt.Dimension;
import java.sql.Connection;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 *
 * @author Ademir
 */
public class Menu3 {
    Connection con;
    TabPane tabPane;
    public Menu3(Connection con,TabPane tabPane)
     {
         this.con=con;
         this.tabPane=tabPane;
     }
    int j;
    public void menuInicia()
    {
        final ScrollPane s1 = new ScrollPane();
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        Dimension tamTela = toolkit.getScreenSize();
        final float ajustey = (float) tamTela.height / 1080;
        final float ajustex = (float) tamTela.width / 1920;
        final Label labels[] = new Label[20];
        final Button buttons[] = new Button[21];
        Group root2= new Group();
        root2.getChildren().add(new Rectangle((int) (ajustex * 1920), (int) (ajustey * 1400), Color.ALICEBLUE));
        buttons[0] = new Button("Cadastro");
        buttons[0].setLayoutX((int) (ajustex * 80));
        buttons[0].setLayoutY((int) (ajustey * 260));
        buttons[1] = new Button("Alteração");
        buttons[1].setLayoutX((int) (ajustex * 80));
        buttons[1].setLayoutY((int) (ajustey * 460));
        buttons[2] = new Button("Exclusão");
        buttons[2].setLayoutX((int) (ajustex * 80));
        buttons[2].setLayoutY((int) (ajustey * 660));
        buttons[3] = new Button("Consulta");
        buttons[3].setLayoutX((int) (ajustex * 80));
        buttons[3].setLayoutY((int) (ajustey * 860));
        buttons[4] = new Button("Cadastrar Pedido");
        buttons[4].setLayoutX((int) (ajustex * 580));
        buttons[4].setLayoutY((int) (ajustey * 260));
        buttons[5] = new Button("Alterar Pedido");
        buttons[5].setLayoutX((int) (ajustex * 580));
        buttons[5].setLayoutY((int) (ajustey * 460));
        buttons[6] = new Button("Excluir Pedido");
        buttons[6].setLayoutX((int) (ajustex * 580));
        buttons[6].setLayoutY((int) (ajustey * 660));
        buttons[7] = new Button("Consultar Pedido");
        buttons[7].setLayoutX((int) (ajustex * 580));
        buttons[7].setLayoutY((int) (ajustey * 860));
        buttons[8] = new Button("Execução");
        buttons[8].setLayoutX((int) (ajustex * 580));
        buttons[8].setLayoutY((int) (ajustey * 1060));
        buttons[9] = new Button("Pendências");
        buttons[9].setLayoutX((int) (ajustex * 1100));
        buttons[9].setLayoutY((int) (ajustey * 260));
        buttons[10] = new Button("Acumulados");
        buttons[10].setLayoutX((int) (ajustex * 1100));
        buttons[10].setLayoutY((int) (ajustey * 460));
        buttons[11] = new Button("Configurar");
        buttons[11].setLayoutX((int) (ajustex * 1100));
        buttons[11].setLayoutY((int) (ajustey * 660));
        buttons[12] = new Button("Relatórios");
        buttons[12].setLayoutX((int) (ajustex * 1100));
        buttons[12].setLayoutY((int) (ajustey * 860));
        buttons[13] = new Button("Nota Fiscal");
        buttons[13].setLayoutX((int) (ajustex * 1100));
        buttons[13].setLayoutY((int) (ajustey * 1060));
        buttons[14] = new Button("Aniversários");
        buttons[14].setLayoutX((int) (ajustex * 1100));
        buttons[14].setLayoutY((int) (ajustey * 1260));
        buttons[15] = new Button("Verbas");
        buttons[15].setLayoutX((int) (ajustex * 1560));
        buttons[15].setLayoutY((int) (ajustey * 260));
        buttons[16] = new Button("NES");
        buttons[16].setLayoutX((int) (ajustex * 1560));
        buttons[16].setLayoutY((int) (ajustey * 460));
        buttons[17] = new Button("Contas");
        buttons[17].setLayoutX((int) (ajustex * 1560));
        buttons[17].setLayoutY((int) (ajustey * 660));
        buttons[18] = new Button("Fechamento");
        buttons[18].setLayoutX((int) (ajustex * 1560));
        buttons[18].setLayoutY((int) (ajustey * 860));
        buttons[19] = new Button("Estorno");
        buttons[19].setLayoutX((int) (ajustex * 1560));
        buttons[19].setLayoutY((int) (ajustey * 1060));
        buttons[20] = new Button("Resumo");
        buttons[20].setLayoutX((int) (ajustex * 1560));
        buttons[20].setLayoutY((int) (ajustey * 1260));
        for (j = 0; j <= 20; j++) {
            buttons[j].setPrefSize((int) (ajustex * 200), (int) (ajustey * 100));
            buttons[j].setFont(Font.font("Arial", (int) (20 * ajustex)));
            buttons[j].setStyle("-fx-background-color:#c3c4c4,"
                    + "linear-gradient(#d6d6d6 50%, white 100%),"
                    + "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);"
                    + "-fx-background-radius: 30;"
                    + "-fx-background-insets: 0,1,1;"
                    + "-fx-text-fill: black;");
        }
        final DropShadow shadow = new DropShadow();
        buttons[0].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[0].setEffect(shadow);
                    }
                });
        buttons[0].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[0].setEffect(null);
                    }
                });
        buttons[0].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        ClienteCadastro x= new ClienteCadastro(con,tabPane);
                        x.cadastroC();
                    }
                });
        buttons[1].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[1].setEffect(shadow);
                    }
                });
        buttons[1].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[1].setEffect(null);
                    }
                });
        buttons[1].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        ClienteAlterar x= new ClienteAlterar(con,tabPane);
                        x.alterarC();
                    }
                });
        buttons[2].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[2].setEffect(shadow);
                    }
                });
        buttons[2].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[2].setEffect(null);
                    }
                });
        buttons[2].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[3].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[3].setEffect(shadow);
                    }
                });
        buttons[3].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[3].setEffect(null);
                    }
                });
        buttons[3].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[4].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[4].setEffect(shadow);
                    }
                });
        buttons[4].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[4].setEffect(null);
                    }
                });
        buttons[4].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[5].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[5].setEffect(shadow);
                    }
                });
        buttons[5].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[5].setEffect(null);
                    }
                });
        buttons[5].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[6].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[6].setEffect(shadow);
                    }
                });
        buttons[6].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[6].setEffect(null);
                    }
                });
        buttons[6].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[7].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[7].setEffect(shadow);
                    }
                });
        buttons[7].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[7].setEffect(null);
                    }
                });
        buttons[7].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[8].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[8].setEffect(shadow);
                    }
                });
        buttons[8].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[8].setEffect(null);
                    }
                });
        buttons[8].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[9].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[9].setEffect(shadow);
                    }
                });
        buttons[9].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[9].setEffect(null);
                    }
                });
        buttons[9].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[10].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[10].setEffect(shadow);
                    }
                });
        buttons[10].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[10].setEffect(null);
                    }
                });
        buttons[10].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[11].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[11].setEffect(shadow);
                    }
                });
        buttons[11].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[11].setEffect(null);
                    }
                });
        buttons[11].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[12].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[12].setEffect(shadow);
                    }
                });
        buttons[12].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[12].setEffect(null);
                    }
                });
        buttons[12].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[13].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[13].setEffect(shadow);
                    }
                });
        buttons[13].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[13].setEffect(null);
                    }
                });
        buttons[13].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[14].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[14].setEffect(shadow);
                    }
                });
        buttons[14].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[14].setEffect(null);
                    }
                });
        buttons[14].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[15].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[15].setEffect(shadow);
                    }
                });
        buttons[15].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[15].setEffect(null);
                    }
                });
        buttons[15].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[16].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[16].setEffect(shadow);
                    }
                });
        buttons[16].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[16].setEffect(null);
                    }
                });
        buttons[16].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[17].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[17].setEffect(shadow);
                    }
                });
        buttons[17].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[17].setEffect(null);
                    }
                });
        buttons[17].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[18].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[18].setEffect(shadow);
                    }
                });
        buttons[18].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[18].setEffect(null);
                    }
                });
        buttons[18].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[19].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[19].setEffect(shadow);
                    }
                });
        buttons[19].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[19].setEffect(null);
                    }
                });
        buttons[19].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        buttons[20].addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[20].setEffect(shadow);
                    }
                });
        buttons[20].addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        buttons[20].setEffect(null);
                    }
                });
        buttons[20].addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                    }
                });
        labels[0] = new Label("Clientes");
        labels[0].setLayoutX((int) (ajustex * 115));
        labels[0].setLayoutY((int) (ajustey * 150));
        labels[0].setFont(Font.font("Arial", (int) (35 * ajustex)));
        labels[1] = new Label("Serviços");
        labels[1].setLayoutX((int) (ajustex * 615));
        labels[1].setLayoutY((int) (ajustey * 150));
        labels[1].setFont(Font.font("Arial", (int) (35 * ajustex)));
        labels[2] = new Label("Operações");
        labels[2].setLayoutX((int) (ajustex * 1115));
        labels[2].setLayoutY((int) (ajustey * 150));
        labels[2].setFont(Font.font("Arial", (int) (35 * ajustex)));
        labels[3] = new Label("Mês");
        labels[3].setLayoutX((int) (ajustex * 1615));
        labels[3].setLayoutY((int) (ajustey * 150));
        labels[3].setFont(Font.font("Arial", (int) (35 * ajustex)));
        labels[4] = new Label("Menu");
        labels[4].setLayoutX((int) (ajustex * 900));
        labels[4].setLayoutY((int) (ajustey * 50));
        labels[4].setFont(Font.font("Arial", (int) (50 * ajustex)));
        //adicionar o button ao root2, nao esquecer de dar set font, nem de adicionar labels para indicar a que os botoes se referem.
        for (j = 0; j <= 20; j++) {
            root2.getChildren().add(buttons[j]);
        }
        root2.getChildren().add(labels[0]);
        root2.getChildren().add(labels[1]);
        root2.getChildren().add(labels[2]);
        root2.getChildren().add(labels[3]);
        root2.getChildren().add(labels[4]);
        s1.setContent(root2);
        tabPane.getSelectionModel().getSelectedItem().setContent(s1);
    }
    
}
