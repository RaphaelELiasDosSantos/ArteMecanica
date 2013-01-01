/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package artemecanica5;

import java.awt.Dimension;
import javafx.stage.Stage;
import java.sql.Connection;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 *
 * @author raphael
 */
public class Menu2 {

    Stage primaryStage;
    Connection con;

    public Menu2(Stage primaryStage, Connection con) {
        this.con = con;
        this.primaryStage = primaryStage;
    }
    int contador = 0;
    public int j = 0;

    public void inicia() {
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        Dimension tamTela = toolkit.getScreenSize();
        final float ajustey = (float) tamTela.height / 1080;
        final float ajustex = (float) tamTela.width / 1920;
        primaryStage.setTitle("ArteMecanica");
        Group root = new Group();
        Scene scene = new Scene(root, (int) (ajustex * 800), (int) (ajustey * 400), Color.ALICEBLUE);
        primaryStage.setScene(scene);
        VBox vbox = new VBox(20);
        final Label labels[] = new Label[20];
        final Button buttons[] = new Button[21];
        final MenuBar menuBar = new MenuBar();

        //Sub menus for Options->Submenu 1
        final MenuItem menu001 = MenuItemBuilder.create().text("Cadastro").build();
        final MenuItem menu002 = MenuItemBuilder.create().text("Alteração").build();
        final MenuItem menu003 = MenuItemBuilder.create().text("Exclusão").build();
        final MenuItem menu004 = MenuItemBuilder.create().text("Consulta").build();
        final MenuItem menu111 = MenuItemBuilder.create().text("Incluir").build();
        final MenuItem menu112 = MenuItemBuilder.create().text("Alterar").build();
        final MenuItem menu113 = MenuItemBuilder.create().text("Excluir").build();
        final MenuItem menu114 = MenuItemBuilder.create().text("Consultar").build();
        final MenuItem menu211 = MenuItemBuilder.create().text("Pendências").build();
        final MenuItem menu212 = MenuItemBuilder.create().text("Acumulados").build();
        final MenuItem menu213 = MenuItemBuilder.create().text("Configurar").build();
        final MenuItem menu214 = MenuItemBuilder.create().text("Relatórios").build();
        final MenuItem menu215 = MenuItemBuilder.create().text("Nota Fiscal").build();
        final MenuItem menu216 = MenuItemBuilder.create().text("Aniversários").build();
        final MenuItem menu311 = MenuItemBuilder.create().text("Verbas").build();
        final MenuItem menu312 = MenuItemBuilder.create().text("NES").build();
        final MenuItem menu313 = MenuItemBuilder.create().text("Contas").build();
        final MenuItem menu314 = MenuItemBuilder.create().text("Fechamento").build();
        final MenuItem menu315 = MenuItemBuilder.create().text("Estorno").build();
        final MenuItem menu316 = MenuItemBuilder.create().text("Resumo").build();
        final MenuItem menu401 = MenuItemBuilder.create().text("Menu").build();
        final MenuItem menu402 = MenuItemBuilder.create().text("Sair").build();
        menu001.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT0, KeyCombination.ALT_DOWN));
        menu002.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT1, KeyCombination.ALT_DOWN));
        menu003.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT2, KeyCombination.ALT_DOWN));
        menu004.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT3, KeyCombination.ALT_DOWN));
        menu111.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT4, KeyCombination.ALT_DOWN));
        menu112.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT5, KeyCombination.ALT_DOWN));
        menu113.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT6, KeyCombination.ALT_DOWN));
        menu114.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT7, KeyCombination.ALT_DOWN));
        menu211.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT0, KeyCombination.CONTROL_DOWN));
        menu212.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT1, KeyCombination.CONTROL_DOWN));
        menu213.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT2, KeyCombination.CONTROL_DOWN));
        menu214.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT3, KeyCombination.CONTROL_DOWN));
        menu215.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT4, KeyCombination.CONTROL_DOWN));
        menu216.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT5, KeyCombination.CONTROL_DOWN));
        menu311.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT6, KeyCombination.CONTROL_DOWN));
        menu312.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT7, KeyCombination.CONTROL_DOWN));
        menu313.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT8, KeyCombination.CONTROL_DOWN));
        menu314.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT9, KeyCombination.CONTROL_DOWN));
        menu315.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        menu316.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN));
        menu401.setAccelerator(new KeyCodeCombination(KeyCode.U, KeyCombination.CONTROL_DOWN));
        menu402.setAccelerator(new KeyCodeCombination(KeyCode.I, KeyCombination.CONTROL_DOWN));
        // Options->Submenu 1 submenu 
        MenuItem menu11 = MenuBuilder.create().text("Pedido").items(menu111, menu112, menu113, menu114).build();
        MenuItem menu12 = MenuItemBuilder.create().text("Execução").build();
        menu12.setAccelerator(new KeyCodeCombination(KeyCode.DIGIT8, KeyCombination.ALT_DOWN));
        // Options menu
        Menu menu1 = MenuBuilder.create().text("Clientes").items(menu001, menu002, menu003, menu004).build();
        Menu menu2 = MenuBuilder.create().text("Serviços").items(menu11, menu12).build();
        Menu menu4 = MenuBuilder.create().text("Mês").items(menu311, menu312, menu313, menu314, menu315, menu316).build();
        Menu menu3 = MenuBuilder.create().text("Operações").items(menu211, menu212, menu213, menu214, menu215, menu216).build();
        Menu menu5 = MenuBuilder.create().text("Exibir").items(menu401, menu402).build();
        menuBar.getMenus().addAll(menu5);
        menuBar.getMenus().addAll(menu1);
        menuBar.getMenus().addAll(menu2);
        menuBar.getMenus().addAll(menu3);
        menuBar.getMenus().addAll(menu4);
        vbox.getChildren().addAll(menuBar);
        root.getChildren().add(vbox);
        primaryStage.show();


        final TabPane tabPane = new TabPane();
        tabPane.setPrefSize((int) ((primaryStage.getWidth() - 20)), (int) ((primaryStage.getHeight() - 70)));
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.SELECTED_TAB);
        Tab tab1 = new Tab();
        tab1.setText("Tab1");
        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> prop, Number oldValue, Number newValue) {
                tabPane.setPrefSize((int) ((primaryStage.getWidth() - 20)), (int) ((primaryStage.getHeight() - 70)));
            }
        });
        primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> prop, Number oldValue, Number newValue) {
                tabPane.setPrefSize((int) ((primaryStage.getWidth() - 20)), (int) ((primaryStage.getHeight() - 70)));
            }
        });
        final ScrollPane s1 = new ScrollPane();
        Group root2 = new Group();
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
        tab1.setContent(s1);
        tabPane.getTabs().addAll(tab1);
        Tab tab2 = new Tab();
        tab2.setText("+");
        tab2.setContent(new Rectangle((int) (ajustex * 1920), (int) (ajustey * 1400), Color.ALICEBLUE));
        contador = 2;
        tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> tab, Tab oldTab, Tab newTab) {
                SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
                if (selectionModel.getSelectedItem().getText().equals("+")) {
                    selectionModel.getSelectedItem().setText("Tab" + contador);
                    final ScrollPane s1 = new ScrollPane();
                    Group root2 = new Group();
                    root2.getChildren().add(new Rectangle((int) (ajustex * 1920), (int) (ajustey * 1400), Color.ALICEBLUE));
                    final Button buttons[] = new Button[21];
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
                    selectionModel.getSelectedItem().setContent(s1);
                    Tab tabx = new Tab();
                    tabx.setText("+");
                    tabPane.getTabs().addAll(tabx);
                    contador++;
                }

            }
        });
        tabPane.getTabs().addAll(tab2);
        tabPane.setLayoutX(0);
        tabPane.setLayoutY((int) (ajustey * 40));
        root.getChildren().add(tabPane);
        //SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        // selectionModel.getSelectedItem();
       menu001.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
               ClienteCadastro x= new ClienteCadastro(con,tabPane);
               x.cadastroC();
            }
        });
       menu002.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
               ClienteAlterar x= new ClienteAlterar(con,tabPane);
               x.alterarC();
            }
        });
       menu401.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
               Menu3 x= new Menu3(con,tabPane);
               x.menuInicia();
            }
        });
       menu402.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
               System.exit(0);
            }
        });
    }
}
