/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package artemecanica5;

import java.awt.Dimension;
import java.sql.Connection;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 *
 * @author Ademir
 */
public class ClienteAlterar {

    Connection con;
    TabPane tabPane;

    public ClienteAlterar(Connection con, TabPane tabPane) {
        this.con = con;
        this.tabPane = tabPane;
    }
    Group root2 = new Group();
    ComboBox Options = new ComboBox();
    TableView tableView = new TableView();
    TextField textBox;
    public void alterarC() {
        final ScrollPane s1 = new ScrollPane();
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        Dimension tamTela = toolkit.getScreenSize();
        final float ajustey = (float) tamTela.height / 1080;
        final float ajustex = (float) tamTela.width / 1920;
        Label tit = new Label("Alteração de Cliente");
        tit.setFont(Font.font("Arial", (int) (50 * ajustex)));
        tit.setLayoutX((int) (ajustex * 750));
        tit.setLayoutY((int) (ajustey * 50));
        final ObservableList<String> strings = FXCollections.observableArrayList(
                "Código", "Nome", "Email",
                "Estado", "Cidade", "Endereço",
                "Complemento",
                "Bairro", "CEP", "CPF/CNPJ",
                "RG", "IE", "Data Nasc", "Telefone", "Celular", "Veículo", "Placa");

        root2.getChildren().add(new Rectangle((int) (ajustex * 1920), (int) (ajustey * 1400), Color.ALICEBLUE));
        Options.setPromptText("Selecione a opção de busca");
        Options.setItems(FXCollections.observableArrayList(strings.subList(0, 17)));
        Options.setLayoutX((int) (ajustex * 150));
        Options.setLayoutY((int) (ajustey * 160));
        Options.setPrefSize((int) (ajustex * 320), (int) (ajustey * 30));
        //Options.getSelectionModel().getSelectedIndex(); --- para ver o index do item selecionado!!!
        Options.valueProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                    tableView.setItems(null);
                    textBox.setText("");
                }
            });
        String searchBoxCss = ClienteAlterar.class.getResource("SearchBox.css").toExternalForm();
        VBox vbox = VBoxBuilder.create().build();
        vbox.getStylesheets().add(searchBoxCss);
        vbox.setPrefWidth((int) (ajustex * 200));
        vbox.getChildren().add(new SearchBox());
        vbox.setLayoutX((int) (ajustex * 550));
        vbox.setLayoutY((int) (ajustey * 160));


        root2.getChildren().add(vbox);
        root2.getChildren().add(Options);
        root2.getChildren().add(tit);
        s1.setContent(root2);
        tabPane.getSelectionModel().getSelectedItem().setContent(s1);
    }

    public static class Person {

        private StringProperty Codigo;
        private StringProperty Nome;
        private StringProperty email;
        private StringProperty Estado;
        private StringProperty Cidade;
        private StringProperty Endereço;
        private StringProperty Complemento;
        private StringProperty Bairro;
        private StringProperty CEP;
        private StringProperty CPF;
        private StringProperty RG;
        private StringProperty IE;
        private StringProperty Data;
        private StringProperty Telefone;
        private StringProperty Celular;
        private StringProperty Veiculo;
        private StringProperty Placa;

        private Person(String Codigo, String Nome, String email, String Estado, String Cidade, String Endereço, String Complemento, String Bairro, String CEP, String CPF, String RG, String IE, String Data, String Telefone, String Celular, String Veiculo, String Placa) {
            this.Codigo = new SimpleStringProperty(Codigo);
            this.Nome = new SimpleStringProperty(Nome);
            this.email = new SimpleStringProperty(email);
            this.Estado = new SimpleStringProperty(Estado);
            this.Cidade = new SimpleStringProperty(Cidade);
            this.Endereço = new SimpleStringProperty(Endereço);
            this.Complemento = new SimpleStringProperty(Complemento);
            this.Bairro = new SimpleStringProperty(Bairro);
            this.CEP = new SimpleStringProperty(CEP);
            this.CPF = new SimpleStringProperty(CPF);
            this.RG = new SimpleStringProperty(RG);
            this.IE = new SimpleStringProperty(IE);
            this.Data = new SimpleStringProperty(Data);
            this.Telefone = new SimpleStringProperty(Telefone);
            this.Celular = new SimpleStringProperty(Celular);
            this.Veiculo = new SimpleStringProperty(Veiculo);
            this.Placa = new SimpleStringProperty(Placa);
        }

        public StringProperty CodigoProperty() {
            return Codigo;
        }

        public StringProperty NomeProperty() {
            return Nome;
        }

        public StringProperty emailProperty() {
            return email;
        }

        public StringProperty EstadoProperty() {
            return Estado;
        }

        public StringProperty CidadeProperty() {
            return Cidade;
        }

        public StringProperty EndereçoProperty() {
            return Endereço;
        }

        public StringProperty ComplementoProperty() {
            return Complemento;
        }

        public StringProperty BairroProperty() {
            return Bairro;
        }

        public StringProperty CEPProperty() {
            return CEP;
        }

        public StringProperty CPFProperty() {
            return CPF;
        }

        public StringProperty RGProperty() {
            return RG;
        }

        public StringProperty IEProperty() {
            return IE;
        }

        public StringProperty DataProperty() {
            return Data;
        }

        public StringProperty TelefoneProperty() {
            return Telefone;
        }

        public StringProperty CelularProperty() {
            return Celular;
        }

        public StringProperty VeiculoProperty() {
            return Veiculo;
        }

        public StringProperty PlacaProperty() {
            return Placa;
        }
    }

    public class SearchBox extends Region {
        private Button clearButton;
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        Dimension tamTela = toolkit.getScreenSize();
        final float ajustey = (float) tamTela.height / 1080;
        final float ajustex = (float) tamTela.width / 1920;
        ObservableList<Person> clientes;
        ScrollPane s3 = new ScrollPane();
        Label labels[] = new Label[20];
        TextField texts[] = new TextField[20];

        public SearchBox() {
            clientes = FXCollections.observableArrayList(
                    new Person("1111", "Smith", "jacob.smith@example.com", "dssd", "ldslds", "dssd", "ldslds", "dssd", "ldslds", "dssd", "ldslds", "dssd", "ldslds", "dssd", "ldslds", "dssd", "ldslds"),
                    new Person("1111", "Smith2", "jacob.smith@example.com", "dssd", "ldslds", "dssd", "ldslds", "dssd", "ldslds", "dssd", "ldslds", "dssd", "ldslds", "dssd", "ldslds", "dssd", "ldslds"));
            Group tabela = new Group();
            tabela.getChildren().add(new Rectangle((int) (ajustex * 2600), (int) (ajustey * 400), Color.ALICEBLUE));
            TableColumn Codigo = new TableColumn();
            Codigo.setText("Código");
            Codigo.setMinWidth((int) (ajustex * 100));
            Codigo.setCellValueFactory(new PropertyValueFactory("Codigo"));
            TableColumn Nome = new TableColumn();
            Nome.setText("Nome");
            Nome.setMinWidth((int) (ajustex * 300));
            Nome.setCellValueFactory(new PropertyValueFactory("Nome"));
            TableColumn emailCol = new TableColumn();
            emailCol.setText("Email");
            emailCol.setMinWidth((int) (ajustex * 200));
            emailCol.setCellValueFactory(new PropertyValueFactory("email"));
            TableColumn Estado = new TableColumn();
            Estado.setText("Estado");
            Estado.setMinWidth((int) (ajustex * 100));
            Estado.setCellValueFactory(new PropertyValueFactory("Estado"));
            TableColumn Cidade = new TableColumn();
            Cidade.setText("Cidade");
            Cidade.setMinWidth((int) (ajustex * 100));
            Cidade.setCellValueFactory(new PropertyValueFactory("Cidade"));
            TableColumn Endereço = new TableColumn();
            Endereço.setText("Endereço");
            Endereço.setMinWidth((int) (ajustex * 400));
            Endereço.setCellValueFactory(new PropertyValueFactory("Endereço"));
            TableColumn Complemento = new TableColumn();
            Complemento.setText("Complemento");
            Complemento.setMinWidth((int) (ajustex * 200));
            Complemento.setCellValueFactory(new PropertyValueFactory("Complemento"));
            TableColumn Bairro = new TableColumn();
            Bairro.setText("Bairro");
            Bairro.setMinWidth((int) (ajustex * 100));
            Bairro.setCellValueFactory(new PropertyValueFactory("Bairro"));
            TableColumn CEP = new TableColumn();
            CEP.setText("CEP");
            CEP.setMinWidth((int) (ajustex * 100));
            CEP.setCellValueFactory(new PropertyValueFactory("CEP"));
            TableColumn CPF = new TableColumn();
            CPF.setText("CPF/CNPJ");
            CPF.setMinWidth((int) (ajustex * 100));
            CPF.setCellValueFactory(new PropertyValueFactory("CPF"));
            TableColumn RG = new TableColumn();
            RG.setText("RG");
            RG.setMinWidth((int) (ajustex * 100));
            RG.setCellValueFactory(new PropertyValueFactory("RG"));
            TableColumn IE = new TableColumn();
            IE.setText("IE");
            IE.setMinWidth((int) (ajustex * 100));
            IE.setCellValueFactory(new PropertyValueFactory("IE"));
            TableColumn Data = new TableColumn();
            Data.setText("Data Nasc");
            Data.setMinWidth((int) (ajustex * 100));
            Data.setCellValueFactory(new PropertyValueFactory("Data"));
            TableColumn Telefone = new TableColumn();
            Telefone.setText("Telefone");
            Telefone.setMinWidth((int) (ajustex * 100));
            Telefone.setCellValueFactory(new PropertyValueFactory("Telefone"));
            TableColumn Celular = new TableColumn();
            Celular.setText("Celular");
            Celular.setMinWidth((int) (ajustex * 100));
            Celular.setCellValueFactory(new PropertyValueFactory("Celular"));
            TableColumn Veiculo = new TableColumn();
            Veiculo.setText("Veículo");
            Veiculo.setMinWidth((int) (ajustex * 300));
            Veiculo.setCellValueFactory(new PropertyValueFactory("Veiculo"));
            TableColumn Placa = new TableColumn();
            Placa.setText("Placa");
            Placa.setMinWidth((int) (ajustex * 100));
            Placa.setCellValueFactory(new PropertyValueFactory("Placa"));
            tableView.setItems(null);
            tableView.getColumns().addAll(Codigo, Nome, emailCol, Estado, Cidade, Endereço, Complemento, Bairro, CEP, CPF, RG, IE, Data, Telefone, Celular, Veiculo, Placa);
            ScrollPane s2 = new ScrollPane();
            s2.setLayoutX((int) (ajustex * 50));
            s2.setLayoutY((int) (ajustey * 300));
            DropShadow shadow2 = new DropShadow();
            s2.setEffect(shadow2);
            tabela.getChildren().add(tableView);
            s2.setContent(tabela);
            s2.setPrefHeight((int) (ajustey * 350));
            s2.setPrefWidth((int) (ajustex * 900));
            root2.getChildren().add(s2);

            s3.setLayoutX((int) (ajustex * 50));
            s3.setLayoutY((int) (ajustey * 800));
            s3.setPrefHeight((int) (ajustey * 550));
            s3.setPrefWidth((int) (ajustex * 1800));
            s3.setVisible(false);
            s3.setEffect(shadow2);
            root2.getChildren().add(s3);

            Image edit = new Image(getClass().getResourceAsStream("editar.png"));
            final Button button = new Button("Alterar", new ImageView(edit));
            button.setPrefWidth((int) (ajustex * 150));
            button.setLayoutX((int) (ajustex * 1200));
            button.setLayoutY((int) (ajustey * 450));
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
                            if (tableView.getSelectionModel().getSelectedIndex() != -1 && Options.getSelectionModel().getSelectedIndex() != -1) {
                                s3.setVisible(true);
                                Person p1=(Person) tableView.getSelectionModel().getSelectedItem();
                                labels[0] = new Label("Código :  " + p1.Codigo.getValue());
                                labels[0].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[0].setLayoutX((int) (ajustex * 50));
                                labels[0].setLayoutY((int) (ajustey * 50));
                                labels[1] = new Label("Nome :");
                                labels[1].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[1].setLayoutX((int) (ajustex * 700));
                                labels[1].setLayoutY((int) (ajustey * 50));
                                texts[0] = new TextField();
                                texts[0].setPromptText("Nome");
                                texts[0].setMaxSize((int) (ajustex * 300), (int) (ajustey * 30));
                                texts[0].setLayoutX((int) (ajustex * 790));
                                texts[0].setLayoutY((int) (ajustey * 50));
                                texts[0].setText(p1.Nome.getValue());
                                labels[2] = new Label("Email :");
                                labels[2].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[2].setLayoutX((int) (ajustex * 1400));
                                labels[2].setLayoutY((int) (ajustey * 50));
                                labels[3] = new Label("Estado :");
                                labels[3].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[3].setLayoutX((int) (ajustex * 50));
                                labels[3].setLayoutY((int) (ajustey * 200));
                                texts[1] = new TextField();
                                texts[1].setPromptText("Email");
                                texts[1].setMaxSize((int) (ajustex * 300), (int) (ajustey * 30));
                                texts[1].setLayoutX((int) (ajustex * 1490));
                                texts[1].setLayoutY((int) (ajustey * 50));
                                texts[1].setText(p1.email.getValue());
                                texts[2] = new TextField();
                                texts[2].setPromptText("Estado");
                                texts[2].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
                                texts[2].setLayoutX((int) (ajustex * 150));
                                texts[2].setLayoutY((int) (ajustey * 200));
                                texts[2].setText(p1.Estado.getValue());
                                labels[4] = new Label("Cidade :");
                                labels[4].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[4].setLayoutX((int) (ajustex * 700));
                                labels[4].setLayoutY((int) (ajustey * 200));
                                texts[3] = new TextField();
                                texts[3].setPromptText("Cidade");
                                texts[3].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
                                texts[3].setLayoutX((int) (ajustex * 800));
                                texts[3].setLayoutY((int) (ajustey * 200));
                                texts[3].setText(p1.Cidade.getValue());
                                labels[5] = new Label("Endereço :");
                                labels[5].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[5].setLayoutX((int) (ajustex * 1400));
                                labels[5].setLayoutY((int) (ajustey * 200));
                                texts[4] = new TextField();
                                texts[4].setPromptText("Endereço");
                                texts[4].setMaxSize((int) (ajustex * 400), (int) (ajustey * 30));
                                texts[4].setLayoutX((int) (ajustex * 1530));
                                texts[4].setLayoutY((int) (ajustey * 200));
                                texts[4].setText(p1.Endereço.getValue());
                                labels[6] = new Label("Complemento :");
                                labels[6].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[6].setLayoutX((int) (ajustex * 50));
                                labels[6].setLayoutY((int) (ajustey * 350));
                                texts[5] = new TextField();
                                texts[5].setPromptText("Complemento");
                                texts[5].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
                                texts[5].setLayoutX((int) (ajustex * 220));
                                texts[5].setLayoutY((int) (ajustey * 350));
                                texts[5].setText(p1.Complemento.getValue());
                                labels[7] = new Label("Bairro :");
                                labels[7].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[7].setLayoutX((int) (ajustex * 700));
                                labels[7].setLayoutY((int) (ajustey * 350));
                                texts[6] = new TextField();
                                texts[6].setPromptText("Bairro");
                                texts[6].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
                                texts[6].setLayoutX((int) (ajustex * 790));
                                texts[6].setLayoutY((int) (ajustey * 350));
                                texts[6].setText(p1.Bairro.getValue());
                                labels[8] = new Label("CEP :");
                                labels[8].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[8].setLayoutX((int) (ajustex * 1400));
                                labels[8].setLayoutY((int) (ajustey * 350));
                                texts[7] = new TextField() {
                                    @Override
                                    public void replaceText(int start, int end, String text) {
                                        // If the replaced text would end up being invalid, then simply
                                        // ignore this call!
                                        if (!(start == 9 || text.matches("[a-z]") || (text.matches("[A-Z]")))) {
                                            //System.out.println(texts[1].getText()); JEITO DE FAZER MASCARAS!!!!!!!!!, PEGUE O VAlor do text[7] e verifique!!
                                            //texts[7] + text = palavra digitada
                                            super.replaceText(start, end, text);
                                        }
                                    }

                                    @Override
                                    public void replaceSelection(String text) {
                                        if (!(text.matches("[a-z]") || (text.matches("[A-Z]")))) {
                                            super.replaceSelection(text);
                                        }
                                    }
                                };
                                texts[7].setPromptText("CEP");
                                texts[7].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
                                texts[7].setLayoutX((int) (ajustex * 1480));
                                texts[7].setLayoutY((int) (ajustey * 350));
                                texts[7].setText(p1.CEP.getValue());
                                labels[9] = new Label("CPF/CNPJ :");
                                labels[9].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[9].setLayoutX((int) (ajustex * 50));
                                labels[9].setLayoutY((int) (ajustey * 500));
                                texts[8] = new TextField() {
                                    @Override
                                    public void replaceText(int start, int end, String text) {
                                        // If the replaced text would end up being invalid, then simply
                                        // ignore this call!
                                        if (!(start == 30 || text.matches("[a-z]") || (text.matches("[A-Z]")))) {
                                            //System.out.println(texts[1].getText()); JEITO DE FAZER MASCARAS!!!!!!!!!, PEGUE O VAlor do text[7] e verifique!!
                                            //texts[7] + text = palavra digitada
                                            super.replaceText(start, end, text);
                                        }
                                    }

                                    @Override
                                    public void replaceSelection(String text) {
                                        if (!(text.matches("[a-z]") || (text.matches("[A-Z]")))) {
                                            super.replaceSelection(text);
                                        }
                                    }
                                };
                                texts[8].setPromptText("CPF/CNPJ");
                                texts[8].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
                                texts[8].setLayoutX((int) (ajustex * 190));
                                texts[8].setLayoutY((int) (ajustey * 500));
                                texts[8].setText(p1.CPF.getValue());
                                labels[10] = new Label("RG :");
                                labels[10].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[10].setLayoutX((int) (ajustex * 700));
                                labels[10].setLayoutY((int) (ajustey * 500));
                                texts[9] = new TextField();
                                texts[9].setPromptText("RG");
                                texts[9].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
                                texts[9].setLayoutX((int) (ajustex * 770));
                                texts[9].setLayoutY((int) (ajustey * 500));
                                texts[9].setText(p1.RG.getValue());
                                labels[11] = new Label("IE :");
                                labels[11].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[11].setLayoutX((int) (ajustex * 1400));
                                labels[11].setLayoutY((int) (ajustey * 500));
                                texts[10] = new TextField();
                                texts[10].setPromptText("IE");
                                texts[10].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
                                texts[10].setLayoutX((int) (ajustex * 1450));
                                texts[10].setLayoutY((int) (ajustey * 500));
                                texts[10].setText(p1.IE.getValue());
                                labels[12] = new Label("Data Nasc :");
                                labels[12].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[12].setLayoutX((int) (ajustex * 50));
                                labels[12].setLayoutY((int) (ajustey * 650));
                                texts[11] = new TextField() {
                                    @Override
                                    public void replaceText(int start, int end, String text) {
                                        // If the replaced text would end up being invalid, then simply
                                        // ignore this call!
                                        if (!(start == 10 || text.matches("[a-z]") || (text.matches("[A-Z]")))) {
                                            //System.out.println(texts[1].getText()); JEITO DE FAZER MASCARAS!!!!!!!!!, PEGUE O VAlor do text[7] e verifique!!
                                            //texts[7] + text = palavra digitada
                                            super.replaceText(start, end, text);
                                        }
                                    }

                                    @Override
                                    public void replaceSelection(String text) {
                                        if (!(text.matches("[a-z]") || (text.matches("[A-Z]")))) {
                                            super.replaceSelection(text);
                                        }
                                    }
                                };
                                texts[11].setPromptText("DD/MM/AAAA");
                                texts[11].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
                                texts[11].setLayoutX((int) (ajustex * 180));
                                texts[11].setLayoutY((int) (ajustey * 650));
                                texts[11].setText(p1.Data.getValue());
                                labels[13] = new Label("Telefone :");
                                labels[13].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[13].setLayoutX((int) (ajustex * 700));
                                labels[13].setLayoutY((int) (ajustey * 650));
                                texts[12] = new TextField() {
                                    @Override
                                    public void replaceText(int start, int end, String text) {
                                        // If the replaced text would end up being invalid, then simply
                                        // ignore this call!
                                        if (!(start == 15 || text.matches("[a-z]") || (text.matches("[A-Z]")))) {
                                            //System.out.println(texts[1].getText()); JEITO DE FAZER MASCARAS!!!!!!!!!, PEGUE O VAlor do text[7] e verifique!!
                                            //texts[7] + text = palavra digitada
                                            super.replaceText(start, end, text);
                                        }
                                    }

                                    @Override
                                    public void replaceSelection(String text) {
                                        if (!(text.matches("[a-z]") || (text.matches("[A-Z]")))) {
                                            super.replaceSelection(text);
                                        }
                                    }
                                };
                                texts[12].setPromptText("Telefone");
                                texts[12].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
                                texts[12].setLayoutX((int) (ajustex * 820));
                                texts[12].setLayoutY((int) (ajustey * 650));
                                texts[12].setText(p1.Telefone.getValue());
                                labels[14] = new Label("Celular :");
                                labels[14].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[14].setLayoutX((int) (ajustex * 1400));
                                labels[14].setLayoutY((int) (ajustey * 650));
                                texts[13] = new TextField() {
                                    @Override
                                    public void replaceText(int start, int end, String text) {
                                        // If the replaced text would end up being invalid, then simply
                                        // ignore this call!
                                        if (!(start == 15 || text.matches("[a-z]") || (text.matches("[A-Z]")))) {
                                            //System.out.println(texts[1].getText()); JEITO DE FAZER MASCARAS!!!!!!!!!, PEGUE O VAlor do text[7] e verifique!!
                                            //texts[7] + text = palavra digitada
                                            super.replaceText(start, end, text);
                                        }
                                    }

                                    @Override
                                    public void replaceSelection(String text) {
                                        if (!(text.matches("[a-z]") || (text.matches("[A-Z]")))) {
                                            super.replaceSelection(text);
                                        }
                                    }
                                };
                                texts[13].setPromptText("Celular");
                                texts[13].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
                                texts[13].setLayoutX((int) (ajustex * 1500));
                                texts[13].setLayoutY((int) (ajustey * 650));
                                texts[13].setText(p1.Celular.getValue());
                                labels[15] = new Label("Veículo :");
                                labels[15].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[15].setLayoutX((int) (ajustex * 50));
                                labels[15].setLayoutY((int) (ajustey * 800));
                                texts[14] = new TextField();
                                texts[14].setPromptText("Veículo");
                                texts[14].setMaxSize((int) (ajustex * 400), (int) (ajustey * 30));
                                texts[14].setLayoutX((int) (ajustex * 150));
                                texts[14].setLayoutY((int) (ajustey * 800));
                                texts[14].setText(p1.Veiculo.getValue());
                                labels[16] = new Label("Placa :");
                                labels[16].setFont(Font.font("Arial", (int) (22 * ajustex)));
                                labels[16].setLayoutX((int) (ajustex * 700));
                                labels[16].setLayoutY((int) (ajustey * 800));
                                texts[15] = new TextField();
                                texts[15].setPromptText("Placa");
                                texts[15].setMaxSize((int) (ajustex * 200), (int) (ajustey * 30));
                                texts[15].setLayoutX((int) (ajustex * 790));
                                texts[15].setLayoutY((int) (ajustey * 800));
                                texts[15].setText(p1.Placa.getValue());
                                Group alteraDados = new Group();
                                alteraDados.getChildren().add(new Rectangle((int) (ajustex * 1920), (int) (ajustey * 900), Color.rgb(255, 247, 255)));
                                for (int i = 0; i <= 16; i++) {
                                    alteraDados.getChildren().add(labels[i]);
                                }
                                for (int i = 0; i <= 15; i++) {
                                    alteraDados.getChildren().add(texts[i]);
                                }
                                Image imageOk = new Image(getClass().getResourceAsStream("ok.png"));
                                final Button button2 = new Button("Confirmar", new ImageView(imageOk));
                                button2.setPrefWidth((int) (ajustex * 250));
                                button2.setLayoutX((int) (ajustex * 1400));
                                button2.setLayoutY((int) (ajustey * 770));
                                final DropShadow shadow = new DropShadow();
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
                                            }
                                        });
                                alteraDados.getChildren().add(button2);
                                s3.setContent(alteraDados);
                            } else {
                                DialogFX dialog = new DialogFX();
                                dialog.setTitleText("Cliente não encontrado");
                                dialog.setMessage("Selecionar o cliente a ser alterado.");
                                dialog.showDialog();
                            }
                        }
                    });
            root2.getChildren().add(button);

            setId("SearchBox");
            getStyleClass().add("search-box");
            setPrefSize((int) (ajustex * 200), (int) (ajustey * 24));
            textBox = new TextField();
            textBox.setPromptText("Procurar...");
            clearButton = new Button();
            clearButton.setVisible(false);
            getChildren().addAll(textBox, clearButton);
            clearButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    textBox.setText("");
                    textBox.requestFocus();
                }
            });
            textBox.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                    clearButton.setVisible(textBox.getText().length() != 0);
                    //implementar a busca por palavras aqui! palavra digitada = newValue

                    tableView.setItems(clientes);
                    if (textBox.getText().length() == 0) {
                        tableView.setItems(null);
                    }

                }
            });
            textBox.addEventHandler(MouseEvent.MOUSE_CLICKED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            if (Options.getSelectionModel().getSelectedIndex() == -1) {
                                DialogFX dialog = new DialogFX();
                                dialog.setTitleText("Cliente não encontrado");
                                dialog.setMessage("Colocar a opção de busca.");
                                dialog.showDialog();
                            }
                        }
                    });
        }

        @Override
        public void layoutChildren() {
            textBox.resize(getWidth(), getHeight());
            clearButton.resizeRelocate(getWidth() - 18, 6, 12, 13); //verificar o que significa os parametros
        }
    }
}
