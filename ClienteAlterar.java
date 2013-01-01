/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package artemecanica5;

import java.awt.Dimension;
import java.sql.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
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
    public void alterarC()
    {
        final ScrollPane s1 = new ScrollPane();
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        Dimension tamTela = toolkit.getScreenSize();
        final float ajustey = (float) tamTela.height / 1080;
        final float ajustex = (float) tamTela.width / 1920;
        Label tit = new Label("Alteração de Cliente");
        tit.setFont(Font.font("Arial", (int) (50 * ajustex)));
        tit.setLayoutX((int) (ajustex * 750));
        tit.setLayoutY((int) (ajustey * 50));
        final Label labels[] = new Label[20];
        final TextField texts[] = new TextField[20];
        final ObservableList strings = FXCollections.observableArrayList(
            "Código", "Nome", "Email",
            "Estado", "Cidade", "Endereço",
            "Complemento",
            "Bairro", "CEP", "CPF/CNPJ",
            "RG", "IE", "Data Nasc", "Telefone" , "Celular", "Veículo", "Placa");
        Group root2 = new Group();
        root2.getChildren().add(new Rectangle((int) (ajustex * 1920), (int) (ajustey * 1400), Color.ALICEBLUE));
        final ComboBox Options = new ComboBox();
        Options.setPromptText("Selecione a opção de busca");
        Options.setItems(FXCollections.observableArrayList(strings.subList(0, 17)));
        Options.setLayoutX((int) (ajustex * 250));
        Options.setLayoutY((int) (ajustey * 250));
        Options.setPrefSize((int) (ajustex * 320), (int) (ajustey * 50));
        //Options.getSelectionModel().getSelectedIndex(); --- para ver o index do item selecionado!!!
        root2.getChildren().add(Options);
        root2.getChildren().add(tit);
        s1.setContent(root2);
        tabPane.getSelectionModel().getSelectedItem().setContent(s1);
    }
}
