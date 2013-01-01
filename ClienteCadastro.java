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
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 *
 * @author Ademir
 */
public class ClienteCadastro {

    Connection con;
    TabPane tabPane;

    public ClienteCadastro(Connection con, TabPane tabPane) {
        this.con = con;
        this.tabPane = tabPane;
    }

    public void cadastroC() {
        final ScrollPane s1 = new ScrollPane();
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        Dimension tamTela = toolkit.getScreenSize();
        final float ajustey = (float) tamTela.height / 1080;
        final float ajustex = (float) tamTela.width / 1920;
        Label tit = new Label("Cadastro de Cliente");
        tit.setFont(Font.font("Arial", (int) (50 * ajustex)));
        tit.setLayoutX((int) (ajustex * 750));
        tit.setLayoutY((int) (ajustey * 50));
        final Label labels[] = new Label[20];
        final TextField texts[] = new TextField[20];
        Group root2 = new Group();
        labels[0] = new Label("Código :");
        labels[0].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[0].setLayoutX((int) (ajustex * 50));
        labels[0].setLayoutY((int) (ajustey * 200));
        labels[1] = new Label("Nome :");
        labels[1].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[1].setLayoutX((int) (ajustex * 700));
        labels[1].setLayoutY((int) (ajustey * 200));
        texts[0] = new TextField();
        texts[0].setPromptText("Nome");
        texts[0].setMaxSize((int) (ajustex * 300), (int) (ajustey * 30));
        texts[0].setLayoutX((int) (ajustex * 790));
        texts[0].setLayoutY((int) (ajustey * 200));
        labels[2] = new Label("Email :");
        labels[2].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[2].setLayoutX((int) (ajustex * 1400));
        labels[2].setLayoutY((int) (ajustey * 200));
        labels[3] = new Label("Estado :");
        labels[3].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[3].setLayoutX((int) (ajustex * 50));
        labels[3].setLayoutY((int) (ajustey * 350));
        texts[1] = new TextField();
        texts[1].setPromptText("Email");
        texts[1].setMaxSize((int) (ajustex * 300), (int) (ajustey * 30));
        texts[1].setLayoutX((int) (ajustex * 1490));
        texts[1].setLayoutY((int) (ajustey * 200));
        texts[2] = new TextField();
        texts[2].setPromptText("Estado");
        texts[2].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
        texts[2].setLayoutX((int) (ajustex * 150));
        texts[2].setLayoutY((int) (ajustey * 350));
        labels[4] = new Label("Cidade :");
        labels[4].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[4].setLayoutX((int) (ajustex * 700));
        labels[4].setLayoutY((int) (ajustey * 350));
        texts[3] = new TextField();
        texts[3].setPromptText("Cidade");
        texts[3].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
        texts[3].setLayoutX((int) (ajustex * 800));
        texts[3].setLayoutY((int) (ajustey * 350));
        labels[5] = new Label("Endereço :");
        labels[5].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[5].setLayoutX((int) (ajustex * 1400));
        labels[5].setLayoutY((int) (ajustey * 350));
        texts[4] = new TextField();
        texts[4].setPromptText("Endereço");
        texts[4].setMaxSize((int) (ajustex * 400), (int) (ajustey * 30));
        texts[4].setLayoutX((int) (ajustex * 1530));
        texts[4].setLayoutY((int) (ajustey * 350));
        labels[6] = new Label("Complemento :");
        labels[6].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[6].setLayoutX((int) (ajustex * 50));
        labels[6].setLayoutY((int) (ajustey * 500));
        texts[5] = new TextField();
        texts[5].setPromptText("Complemento");
        texts[5].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
        texts[5].setLayoutX((int) (ajustex * 220));
        texts[5].setLayoutY((int) (ajustey * 500));
        labels[7] = new Label("Bairro :");
        labels[7].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[7].setLayoutX((int) (ajustex * 700));
        labels[7].setLayoutY((int) (ajustey * 500));
        texts[6] = new TextField();
        texts[6].setPromptText("Bairro");
        texts[6].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
        texts[6].setLayoutX((int) (ajustex * 790));
        texts[6].setLayoutY((int) (ajustey * 500));
        labels[8] = new Label("CEP :");
        labels[8].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[8].setLayoutX((int) (ajustex * 1400));
        labels[8].setLayoutY((int) (ajustey * 500));
        texts[7] = new TextField() {
            @Override
            public void replaceText(int start, int end, String text) {
                // If the replaced text would end up being invalid, then simply
                // ignore this call!
                if (!(start==9||text.matches("[a-z]")||(text.matches("[A-Z]")))) {
                    //System.out.println(texts[1].getText()); JEITO DE FAZER MASCARAS!!!!!!!!!, PEGUE O VAlor do text[7] e verifique!!
                    //texts[7] + text = palavra digitada
                    super.replaceText(start, end, text);
                }
            }

            @Override
            public void replaceSelection(String text) {
                if (!(text.matches("[a-z]")||(text.matches("[A-Z]")))) {
                    super.replaceSelection(text);
                }
            }
        };
        texts[7].setPromptText("CEP");
        texts[7].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
        texts[7].setLayoutX((int) (ajustex * 1480));
        texts[7].setLayoutY((int) (ajustey * 500));
        labels[9] = new Label("CPF/CNPJ :");
        labels[9].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[9].setLayoutX((int) (ajustex * 50));
        labels[9].setLayoutY((int) (ajustey * 650));
        texts[8] = new TextField() {
            @Override
            public void replaceText(int start, int end, String text) {
                // If the replaced text would end up being invalid, then simply
                // ignore this call!
                if (!(start==30||text.matches("[a-z]")||(text.matches("[A-Z]")))) {
                    //System.out.println(texts[1].getText()); JEITO DE FAZER MASCARAS!!!!!!!!!, PEGUE O VAlor do text[7] e verifique!!
                    //texts[7] + text = palavra digitada
                    super.replaceText(start, end, text);
                }
            }

            @Override
            public void replaceSelection(String text) {
                if (!(text.matches("[a-z]")||(text.matches("[A-Z]")))) {
                    super.replaceSelection(text);
                }
            }
        };
        texts[8].setPromptText("CPF/CNPJ");
        texts[8].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
        texts[8].setLayoutX((int) (ajustex * 190));
        texts[8].setLayoutY((int) (ajustey * 650));
        labels[10] = new Label("RG :");
        labels[10].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[10].setLayoutX((int) (ajustex * 700));
        labels[10].setLayoutY((int) (ajustey * 650));
        texts[9] = new TextField();
        texts[9].setPromptText("RG");
        texts[9].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
        texts[9].setLayoutX((int) (ajustex * 770));
        texts[9].setLayoutY((int) (ajustey * 650));
        labels[11] = new Label("IE :");
        labels[11].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[11].setLayoutX((int) (ajustex * 1400));
        labels[11].setLayoutY((int) (ajustey * 650));
        texts[10] = new TextField();
        texts[10].setPromptText("IE");
        texts[10].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
        texts[10].setLayoutX((int) (ajustex * 1450));
        texts[10].setLayoutY((int) (ajustey * 650));
        labels[12] = new Label("Data Nasc :");
        labels[12].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[12].setLayoutX((int) (ajustex * 50));
        labels[12].setLayoutY((int) (ajustey * 800));
        texts[11] = new TextField() {
            @Override
            public void replaceText(int start, int end, String text) {
                // If the replaced text would end up being invalid, then simply
                // ignore this call!
                if (!(start==10||text.matches("[a-z]")||(text.matches("[A-Z]")))) {
                    //System.out.println(texts[1].getText()); JEITO DE FAZER MASCARAS!!!!!!!!!, PEGUE O VAlor do text[7] e verifique!!
                    //texts[7] + text = palavra digitada
                    super.replaceText(start, end, text);
                }
            }

            @Override
            public void replaceSelection(String text) {
                if (!(text.matches("[a-z]")||(text.matches("[A-Z]")))) {
                    super.replaceSelection(text);
                }
            }
        };
        texts[11].setPromptText("DD/MM/AAAA");
        texts[11].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
        texts[11].setLayoutX((int) (ajustex * 180));
        texts[11].setLayoutY((int) (ajustey * 800));
        labels[13] = new Label("Telefone :");
        labels[13].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[13].setLayoutX((int) (ajustex * 700));
        labels[13].setLayoutY((int) (ajustey * 800));
        texts[12] = new TextField() {
            @Override
            public void replaceText(int start, int end, String text) {
                // If the replaced text would end up being invalid, then simply
                // ignore this call!
                if (!(start==15||text.matches("[a-z]")||(text.matches("[A-Z]")))) {
                    //System.out.println(texts[1].getText()); JEITO DE FAZER MASCARAS!!!!!!!!!, PEGUE O VAlor do text[7] e verifique!!
                    //texts[7] + text = palavra digitada
                    super.replaceText(start, end, text);
                }
            }

            @Override
            public void replaceSelection(String text) {
                if (!(text.matches("[a-z]")||(text.matches("[A-Z]")))) {
                    super.replaceSelection(text);
                }
            }
        };
        texts[12].setPromptText("Telefone");
        texts[12].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
        texts[12].setLayoutX((int) (ajustex * 820));
        texts[12].setLayoutY((int) (ajustey * 800));
        labels[14] = new Label("Celular :");
        labels[14].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[14].setLayoutX((int) (ajustex * 1400));
        labels[14].setLayoutY((int) (ajustey * 800));
        texts[13] = new TextField() {
            @Override
            public void replaceText(int start, int end, String text) {
                // If the replaced text would end up being invalid, then simply
                // ignore this call!
                if (!(start==15||text.matches("[a-z]")||(text.matches("[A-Z]")))) {
                    //System.out.println(texts[1].getText()); JEITO DE FAZER MASCARAS!!!!!!!!!, PEGUE O VAlor do text[7] e verifique!!
                    //texts[7] + text = palavra digitada
                    super.replaceText(start, end, text);
                }
            }

            @Override
            public void replaceSelection(String text) {
                if (!(text.matches("[a-z]")||(text.matches("[A-Z]")))) {
                    super.replaceSelection(text);
                }
            }
        };
        texts[13].setPromptText("Celular");
        texts[13].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
        texts[13].setLayoutX((int) (ajustex * 1500));
        texts[13].setLayoutY((int) (ajustey * 800));
        labels[15] = new Label("Veículo :");
        labels[15].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[15].setLayoutX((int) (ajustex * 50));
        labels[15].setLayoutY((int) (ajustey * 950));
        texts[14] = new TextField();
        texts[14].setPromptText("Veículo");
        texts[14].setMaxSize((int) (ajustex * 400), (int) (ajustey * 30));
        texts[14].setLayoutX((int) (ajustex * 150));
        texts[14].setLayoutY((int) (ajustey * 950));
        labels[16] = new Label("Placa :");
        labels[16].setFont(Font.font("Arial", (int) (22 * ajustex)));
        labels[16].setLayoutX((int) (ajustex * 700));
        labels[16].setLayoutY((int) (ajustey * 950));
        texts[15] = new TextField();
        texts[15].setPromptText("Placa");
        texts[15].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
        texts[15].setLayoutX((int) (ajustex * 790));
        texts[15].setLayoutY((int) (ajustey * 950));
        root2.getChildren().add(new Rectangle((int) (ajustex * 1920), (int) (ajustey * 1400), Color.ALICEBLUE));
        root2.getChildren().add(tit);
        for (int i = 0; i <=16; i++) {
            root2.getChildren().add(labels[i]);
        }
        for (int i = 0; i <=15; i++) {
            root2.getChildren().add(texts[i]);
        }
        Image imageOk = new Image(getClass().getResourceAsStream("ok.png"));
        final Button button = new Button("Cadastrar", new ImageView(imageOk));
        button.setPrefWidth((int) (ajustex * 250));
        button.setLayoutX((int) (ajustex * 1500));
        button.setLayoutY((int) (ajustey * 1150));
        final DropShadow shadow = new DropShadow();
        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        button.setEffect(shadow);
                    }
                });
        button.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        button.setEffect(null);
                    }
                });
        button.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        ClienteCadastro x= new ClienteCadastro(con,tabPane);
                        x.cadastroC();
                    }
                });
        Image imageOff = new Image(getClass().getResourceAsStream("done.png"));
        final Button button2 = new Button("Resetar", new ImageView(imageOff));
        button2.setPrefWidth((int) (ajustex * 250));
        button2.setLayoutX((int) (ajustex * 1200));
        button2.setLayoutY((int) (ajustey * 1150));
        button2.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        button2.setEffect(shadow);
                    }
                });
        button2.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        button2.setEffect(null);
                    }
                });
        button2.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        ClienteCadastro x= new ClienteCadastro(con,tabPane);
                        x.cadastroC();
                    }
                });
        root2.getChildren().add(button);
        root2.getChildren().add(button2);
        s1.setContent(root2);
        tabPane.getSelectionModel().getSelectedItem().setContent(s1);
    }
}
