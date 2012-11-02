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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author raphael
 */
public class Menu2{
    Stage primaryStage;
    Connection con;
    public Menu2(Stage primaryStage,Connection con)
    {
        this.con=con;
        this.primaryStage=primaryStage;
    }
    int contador=0;
    public void inicia()
    {
        java.awt.Toolkit toolkit= java.awt.Toolkit.getDefaultToolkit();
	Dimension tamTela= toolkit.getScreenSize();
        final float ajustey = (float)tamTela.height/1080;
	final float ajustex = (float)tamTela.width/1920;
        primaryStage.setTitle("ArteMecanica");
        Group root = new Group();
        Scene scene = new Scene(root, (int)(ajustex*800), (int)(ajustey*400), Color.ALICEBLUE);
        primaryStage.setScene(scene);
        VBox vbox = new VBox(20);
        
        final MenuBar menuBar = new MenuBar();
         
        //Sub menus for Options->Submenu 1
        MenuItem menu111 = MenuItemBuilder.create().text("blah").build();
        final MenuItem menu112 = MenuItemBuilder.create().text("foo").build();
        final CheckMenuItem menu113 = CheckMenuItemBuilder.create().text("Show \"foo\" item").selected(true).build();
        menu113.selectedProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable valueModel) {
                menu112.setVisible(menu113.isSelected());
                System.err.println("MenuItem \"foo\" is now " + (menu112.isVisible() ? "" : "not") + " visible.");
            }
        });
        // Options->Submenu 1 submenu 
        Menu menu11 = MenuBuilder.create().text("Submenu 1").items(menu111, menu112, menu113).build();
 
        // Options->Submenu 2 submenu
        MenuItem menu121 = MenuItemBuilder.create().text("Item 1").build();
        MenuItem menu122 = MenuItemBuilder.create().text("Item 2").build();
        Menu menu12 = MenuBuilder.create().text("Submenu 2").items(menu121, menu122).build();
 
        // Options->Change Text
        final String change[] = {"Change Text", "Change Back"};
        final MenuItem menu13 = MenuItemBuilder.create().text(change[0]).accelerator(KeyCombination.keyCombination("Shortcut+C")).build();
        menu13.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                menu13.setText((menu13.getText().equals(change[0])) ? change[1] : change[0]);
            }
        });        
         
        // Options menu
        Menu menu1 = MenuBuilder.create().text("Options").items(menu11, menu12, menu13).build();
 
        menuBar.getMenus().addAll(menu1);
        vbox.getChildren().addAll(menuBar);
        root.getChildren().add(vbox);
        primaryStage.show();
        
        
        final TabPane tabPane = new TabPane();
        tabPane.setPrefSize((int)(ajustex*(primaryStage.getWidth()-20)), (int)(ajustey*(primaryStage.getHeight()-70)));
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.SELECTED_TAB);
        Tab tab1 = new Tab();
        tab1.setText("Tab1");
       primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
       @Override public void changed(ObservableValue<? extends Number> prop, Number oldValue, Number newValue) {
              tabPane.setPrefSize((int)(ajustex*(primaryStage.getWidth()-20)), (int)(ajustey*(primaryStage.getHeight()-70)));
         }
        });
       primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
       @Override public void changed(ObservableValue<? extends Number> prop, Number oldValue, Number newValue) {
              tabPane.setPrefSize((int)(ajustex*(primaryStage.getWidth()-20)), (int)(ajustey*(primaryStage.getHeight()-70)));
         }
        });
        ScrollPane s1 = new ScrollPane();
        s1.setPrefSize((int)(ajustex*1920),(int)(ajustey*1050));
        Group root2=new Group();
        root2.getChildren().add(new Rectangle((int)(ajustex*1920),(int)(ajustey*1050), Color.ALICEBLUE));
        Label label = new Label("A simple label with a graphic on the sdfdfsdf.");
        label.setLayoutX(500);
        label.setLayoutY(500);
        root2.getChildren().add(label);
        s1.setContent(root2);
        tab1.setContent(s1);
        tabPane.getTabs().addAll(tab1);
        Tab tab2 = new Tab();
        tab2.setText("+");
        tab2.setContent(new Rectangle((int)(ajustex*1920),(int)(ajustey*1050), Color.ALICEBLUE));
        contador=2;
        tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>(){
            @Override public void changed(ObservableValue<? extends Tab> tab, Tab oldTab, Tab newTab) {
                 SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
                 if(selectionModel.getSelectedItem().getText().equals("+"))
                 {
                     selectionModel.getSelectedItem().setText("Tab" + contador);
                     ScrollPane s1 = new ScrollPane();                     
                     Group root2=new Group();
                     root2.getChildren().add(new Rectangle((int)(ajustex*1920),(int)(ajustey*1050), Color.ALICEBLUE));
                     Label label = new Label("A simple label with a graphic on the left.");
                     label.setLayoutX(500);
                     label.setLayoutY(500);
                     root2.getChildren().add(label);
                     s1.setContent(root2);
                     selectionModel.getSelectedItem().setContent(s1);//tenta MUDAR (nao da resize nos scrollbars quando a tela eh minimizada)
                     Tab tabx = new Tab();
                     tabx.setText("+");
                     tabPane.getTabs().addAll(tabx);
                     contador++;
                 }      
                 
            }
        });
        tabPane.getTabs().addAll(tab2);
        tabPane.setLayoutX(0);
        tabPane.setLayoutY((int)(ajustey*30));
        root.getChildren().add(tabPane);
        //SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
       // selectionModel.getSelectedItem();
    }

  
}
