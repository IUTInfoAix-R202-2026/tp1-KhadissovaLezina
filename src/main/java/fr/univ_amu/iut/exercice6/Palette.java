package fr.univ_amu.iut.exercice6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Exercice 6 - Palette de couleurs (capstone).
 *
 * <p>Dernier exercice du TP : synthèse des concepts vus jusqu'ici (layout, boutons, événements,
 * mise à jour d'un label) sur une petite application autonome.
 *
 * <h3>Comportement attendu</h3>
 *
 * <pre>
 * ┌──────────────────────────────┐
 * │ [Rouge] [Vert] [Bleu]        │  ← HBox de 3 boutons
 * ├──────────────────────────────┤
 * │                              │
 * │     (zone de couleur)        │  ← Pane "#zone" dont le fond change
 * │                              │
 * ├──────────────────────────────┤
 * │ Rouge: 0  Vert: 0  Bleu: 0   │  ← Label "#compteurs"
 * └──────────────────────────────┘
 * </pre>
 *
 * <p>Chaque clic sur un bouton :
 *
 * <ul>
 *   <li>change la couleur de fond de la zone centrale ;
 *   <li>incrémente le compteur correspondant dans le label du bas.
 * </ul>
 *
 * <p>Les trois compteurs sont indépendants : cliquer "Rouge" n'affecte pas les compteurs "Vert" et
 * "Bleu".
 */
public class Palette extends Application {

  private int compteurRouge = 0;
  private int compteurVert = 0;
  private int compteurBleu = 0;

  @Override
  public void start(Stage primaryStage) {
    // TODO exercice 6 : implémenter la palette décrite dans la Javadoc.
    //
    // Stratégie conseillée :
    //
    // 1. Créer un BorderPane comme racine.
    //
    // 2. Top : un HBox avec trois boutons "Rouge", "Vert", "Bleu".
    // Donne-leur les ids "btn-rouge", "btn-vert", "btn-bleu" - les tests
    // les retrouvent via robot.lookup("#btn-rouge") etc.
    //
    // 3. Center : un Pane avec l'id "zone", taille minimale 300×200.
    // Change sa couleur via setStyle("-fx-background-color: red;") etc.
    //
    // 4. Bottom : un Label avec l'id "compteurs", texte initial
    // "Rouge: 0 Vert: 0 Bleu: 0".
    //
    // 5. Trois entiers compteur_rouge, compteur_vert, compteur_bleu
    // (ou trois variables d'instance). Chaque clic incrémente le bon
    // compteur et reformate le texte du label.
    //
    // 6. Attention au format du texte du label : les tests vérifient la
    // présence exacte des substrings "Rouge: 2", "Vert: 0", "Bleu: 1"
    // après une séquence de clics.

    BorderPane root = new BorderPane();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);

    Button boutonRouge = new Button("Rouge");
    Button boutonVert = new Button("Vert");
    Button boutonBleu = new Button("Bleu");
    boutonRouge.setId("btn-rouge");
    boutonVert.setId("btn-vert");
    boutonBleu.setId("btn-bleu");

    HBox hbox = new HBox();
    hbox.getChildren().addAll(boutonRouge, boutonVert, boutonBleu);
    root.setTop(hbox);

    Pane zone = new Pane();
    zone.setId("zone");
    root.setCenter(zone);
    zone.setMinSize(300, 200);

    Label label = new Label("Rouge: 0 Vert: 0 Bleu: 0");
    label.setId("compteurs");
    root.setBottom(label);

    boutonRouge.setOnAction(
        e -> {
          compteurRouge++;
          zone.setStyle("-fx-background-color: red;");
          label.setText(
              "Rouge: " + compteurRouge + " Vert: " + compteurVert + " Bleu: " + compteurBleu);
        });
    boutonVert.setOnAction(
        e -> {
          compteurVert++;
          zone.setStyle("-fx-background-color: green;");
          label.setText(
              "Rouge: " + compteurRouge + " Vert: " + compteurVert + " Bleu: " + compteurBleu);
        });
    boutonBleu.setOnAction(
        e -> {
          compteurBleu++;
          zone.setStyle("-fx-background-color: blue;");
          label.setText(
              "Rouge: " + compteurRouge + " Vert: " + compteurVert + " Bleu: " + compteurBleu);
        });

    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
