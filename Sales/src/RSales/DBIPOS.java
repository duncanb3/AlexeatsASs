package RSales;

/**
 * This class creates the graphical user interface
 * for the Dan'l Boone Inn Point of Sale system.
 * 
 * Author: Alexander Steinbacher
 * Last modified 23 June 2016
 * 
 * why wont this shit work
 * this shit should work why is it not
 * 
 * just to see if this shit works
 */
import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DBIPOS extends Application{
	@Override
	public void start(Stage primaryStage){
/*
 * -----------------------------------------------------------------------------------------
 * This part declares all of the panes and all of the scenes
 * -----------------------------------------------------------------------------------------
 */
		Stage closeStage = new Stage();
		Stage transferTableSelectStage = new Stage();
		
		//Create all border panes
		BorderPane mainMenuRootPane = new BorderPane();
		BorderPane partiesMenuPane = new BorderPane();
		BorderPane porchTablesRoot = new BorderPane();
		BorderPane bdrTablesRoot = new BorderPane();
		BorderPane ldrTablesRoot = new BorderPane();
		
		//create all normal panes
		Pane mainMenuPaneLeft = new Pane();
		Pane mainMenuPaneTop = new Pane();
		Pane tableInfoPane = new Pane();
		Pane newPartyPane = new Pane();
		Pane closeStagePane = new Pane();
		Pane porchTablePane = new Pane();
		Pane bdrTablesPane = new Pane();
		Pane ldrTablesPane = new Pane();
		
		
		//create and size all vbox's
		VBox inLineMainPane = new VBox();
		inLineMainPane.setPrefWidth(200);
		VBox tablesPorchVbox = new VBox();
		tablesPorchVbox.setPrefWidth(150);
		VBox tablesBDRVbox = new VBox();
		tablesBDRVbox.setPrefWidth(200);
		VBox tablesLDRVbox = new VBox();
		tablesLDRVbox.setPrefWidth(200);
		VBox tableTransferSelectVBox =new VBox();
		
		//create all tile panes
		TilePane tabsPane = new TilePane();
		TilePane seatTablePane = new TilePane();
		
		//position child panes upon root panes
		partiesMenuPane.setLeft(inLineMainPane);
		partiesMenuPane.setCenter(tabsPane);
		partiesMenuPane.setBottom(seatTablePane);
		
		mainMenuRootPane.setLeft(mainMenuPaneLeft);
		mainMenuRootPane.setTop(mainMenuPaneTop);
		
		porchTablesRoot.setLeft(tablesPorchVbox);
		porchTablesRoot.setCenter(porchTablePane);
		
		bdrTablesRoot.setLeft(tablesBDRVbox);
		bdrTablesRoot.setCenter(bdrTablesPane);
		
		ldrTablesRoot.setLeft(tablesLDRVbox);
		ldrTablesRoot.setCenter(ldrTablesPane);
		
		//create all scenes
		Scene transferTableSelect = new Scene(tableTransferSelectVBox, 300, 300);
		Scene closeStageScene = new Scene(closeStagePane,300,300);
		Scene sceneMainMenu = new Scene(mainMenuRootPane, 1200, 700);
		Scene lineScene = new Scene(partiesMenuPane,1200,700);
		Scene newPartyScene = new Scene(newPartyPane, 1200, 700);
		Scene porchTablesScene = new Scene(porchTablesRoot, 1200,700);
		Scene bdrTablesScene = new Scene(bdrTablesRoot, 1200, 700);
		Scene ldrTablesScene = new Scene(ldrTablesRoot, 1200, 700);
		Scene tableInfoScene = new Scene(tableInfoPane, 1200,700);
		
		primaryStage.setTitle("DBI POS Gui");
		primaryStage.setScene(sceneMainMenu);
		primaryStage.show();
		
		Text closeStageQuestion = new Text("Are you sure you\nwant to close?");
		closeStageQuestion.setLayoutX(100);
		closeStageQuestion.setLayoutY(20);
/*
 * --------------------------------------------------------------------------------------------------
 * This part does the text and clock at the top pane of the main menu
 * --------------------------------------------------------------------------------------------------
 */
		//set name field
				Text nameField = new Text("Dan'l Boone Inn POS System");
				nameField.setLayoutX(500);
				nameField.setLayoutY(25);
		
		//set version field
				Text versionField = new Text("V 1.0");
				versionField.setLayoutX(10);
				versionField.setLayoutY(25);
				
		//declare clock
				DigitalClock clock1 = new DigitalClock();
						
		//set up clock
				clock1.setLayoutX(1100);
				clock1.setLayoutY(15);
				
/*
 * ------------------------------------------------------------------------------------------
 * This part does the text and text boxes on the create new party pane
 * -------------------------------------------------------------------------------------------
 */
		//set party size text for the create party pane
				Text partySizeText = new Text();
				partySizeText.setText("Enter Party Size");
				partySizeText.setLayoutX(25);
				partySizeText.setLayoutY(25);
		
		//set party name text for the create party pane
				Text partyNameText = new Text();
				partyNameText.setText("Enter the name of the Party");
				partyNameText.setLayoutX(25);
				partyNameText.setLayoutY(125);
				
		//set up text field for the party size
				TextField partySize = new TextField();
				partySize.setLayoutX(125);
				partySize.setLayoutY(25);
				
		//set up text field for the party name
				TextField partyName = new TextField();
				partyName.setLayoutX(125);
				partyName.setLayoutY(130);
				
		//set up text for # of adults
				Text nAdults = new Text("0");
				nAdults.setLayoutX(750);
				nAdults.setLayoutY(35);
				
		//set up text for # of c911
				Text nC911 = new Text("0");
				nC911.setLayoutX(750);
				nC911.setLayoutY(85);
				
		//set up text for # of c68
				Text nC68 = new Text("0");
				nC68.setLayoutX(750);
				nC68.setLayoutY(135);
				
		//set up text for # of c45
				Text nC45 = new Text("0");
				nC45.setLayoutX(750);
				nC45.setLayoutY(185);
		//set up text for # of c03
				Text nC03 = new Text("0");
				nC03.setLayoutX(750);
				nC03.setLayoutY(235);
				
		//set up text for the transfer of tables stage
				Text selectDiningRoom = new Text("Select Room to Transfer\nTable to");
				
		
/*
 * -------------------------------------------------------------------------------------------
 * This part declares all the buttons on all of the panes
 * -------------------------------------------------------------------------------------------
 */
		
		//declare buttons
		TableButton bdrSelectTransfer = new TableButton(50, 150,"BDR");
		TableButton ldrSelectTransfer = new TableButton(50, 150, "LDR");
		TableButton porchSelectTransfer = new TableButton(50, 150, "Porch");
		Button computePrice = new Button("Compute Price");
		Button closeYes = new Button("Yes");
		Button closeNo = new Button("No");
		Button closeButton = new Button("Close");
		Button inLineButton = new Button("In-Line");
		Button tablesButton = new Button("Tables");
		Button reservationsButton = new Button("Reservations");
		Button giftShopTicketButton = new Button("Gift Shop Ticket");
		Button lineSceneBack = new Button("Back");
		Button lineNewParty = new Button("New Party");
		Button createParty = new Button("Create Party");
		Button createPartyBack = new Button("Back");
		Button addAdultMeal = new Button("Add Adult Meal");
		Button deleteAdult = new Button("Delete Adult Meal");
		Button addChild9_11Meal = new Button("Add Child\n9-11 Meal");
		Button deleteChild911Meal = new Button("Delete Child\n9-11 Meal");
		Button addChild6_8Meal = new Button("Add Child\n6-8 Meal");
		Button deleteChild68Meal = new Button("Delete Child\n6-8 Meal");
		Button addChild4_5Meal = new Button("Add Child\n4-5 Meal");
		Button deleteChild45Meal = new Button("Delete Child\n4-5 Meal");
		Button addChild0_3Meal = new Button("Add Child\n0-3 Meal");
		Button deleteChild03Meal = new Button("Delete Child\n4-5 Meal");
		Button tablesSceneBack = new Button("Back");
		TableButton computePriceTableInfo = new TableButton(50, 150, "Compute Price");
		TableButton tableInfoButton = new TableButton(50, 150,"Table Info");
		TableButton bdrButtonPorch = new TableButton(50, 150, "BDR");
		TableButton bdrButtonLDR = new TableButton(50, 150, "BDR");
		TableButton porchButtonBDR = new TableButton(50, 150, "Porch");
		TableButton porchButtonLDR = new TableButton(50, 150, "Porch");
		TableButton ldrButtonPorch = new TableButton(50, 150, "LDR");
		TableButton ldrButtonBDR = new TableButton(50, 150, "LDR");
		
/*
 * -----------------------------------------------------------------------------------------
 * this part creates all of the buttons that make up the tables in the 
 * porch
 * -----------------------------------------------------------------------------------------
 */
		
		TableButton p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15;
		p1 = new TableButton(90, 90, "1");
		p1.setLayoutX(0);
		p1.setLayoutY(275);
		p2 = new TableButton(90,90, "2");
		p2.setLayoutX(55);
		p2.setLayoutY(100);
		p3 = new TableButton(90, 90, "3");
		p3.setLayoutX(55);
		p3.setLayoutY(450);
		p4 = new TableButton(65, 65, "4");
		p4.setLayoutX(170);
		p4.setLayoutY(450);
		p5 = new TableButton(90, 90, "5");
		p5.setLayoutX(175);
		p5.setLayoutY(100);
		p6 = new TableButton(90, 90, "6");
		p6.setLayoutX(240);
		p6.setLayoutY(450);
		p7 = new TableButton(90, 90, "7");
		p7.setLayoutX(290);
		p7.setLayoutY(100);
		p8 = new TableButton(65, 65, "8");
		p8.setLayoutX(350);
		p8.setLayoutY(450);
		p9 = new TableButton(90, 90, "9");
		p9.setLayoutX(510);
		p9.setLayoutY(100);
		p10 = new TableButton(90, 90, "10");
		p10.setLayoutX(400);
		p10.setLayoutY(100);
		p11 = new TableButton(90, 90, "11");
		p11.setLayoutX(700);
		p11.setLayoutY(100);
		p12 = new TableButton(90, 90, "12");
		p12.setLayoutX(830);
		p12.setLayoutY(100);
		p13 = new TableButton(90, 90, "13");
		p13.setLayoutX(650);
		p13.setLayoutY(450);
		p14 = new TableButton(65, 65, "14");
		p14.setLayoutX(770);
		p14.setLayoutY(450);
		p15 = new TableButton(90, 90, "15");
		p15.setLayoutX(900);
		p15.setLayoutY(450);
		
		//create the circles for the round tops
		p1.setStyle(
                "-fx-background-radius: 5em; " +
                "-fx-min-width: 100px; " +
                "-fx-min-height: 100px; " +
                "-fx-max-width: 100px; " +
                "-fx-max-height: 100px;"
        );
		p5.setStyle(
                "-fx-background-radius: 5em; " +
                "-fx-min-width: 100px; " +
                "-fx-min-height: 100px; " +
                "-fx-max-width: 100px; " +
                "-fx-max-height: 100px;"
        );
		p9.setStyle(
                "-fx-background-radius: 5em; " +
                "-fx-min-width: 100px; " +
                "-fx-min-height: 100px; " +
                "-fx-max-width: 100px; " +
                "-fx-max-height: 100px;"
        );
		
/*
 * -----------------------------------------------------------------------------------------
 * this part creates all of the buttons that make up the tables in the 
 * bdr
 * -----------------------------------------------------------------------------------------
 */
		
		TableButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
		b1 = new TableButton(90, 90,"1");
		b1.setLayoutX(0);
		b1.setLayoutY(0);
		b2 = new TableButton(90, 90,"2");
		b2.setLayoutX(260);
		b2.setLayoutY(25);
		b3 = new TableButton(90, 90, "3");
		b3.setLayoutX(500);
		b3.setLayoutY(25);
		b4 = new TableButton(65, 65, "4");
		b4.setLayoutX(500);
		b4.setLayoutY(200);
		b5 = new TableButton(90, 90, "5");
		b5.setLayoutX(500);
		b5.setLayoutY(350);
		b6 = new TableButton(90, 90, "6");
		b6.setLayoutX(500);
		b6.setLayoutY(500);
		b7 = new TableButton(90, 90, "7");
		b7.setLayoutX(260);
		b7.setLayoutY(500);
		b8 = new TableButton(90, 90, "8");
		b8.setLayoutX(260);
		b8.setLayoutY(250);
		b9 = new TableButton(90, 90, "9");
		b9.setLayoutX(0);
		b9.setLayoutY(500);
		b10 = new TableButton(90, 90, "10");
		b10.setLayoutX(0);
		b10.setLayoutY(350);
		
		b3.setStyle(
                "-fx-background-radius: 5em; " +
                "-fx-min-width: 100px; " +
                "-fx-min-height: 100px; " +
                "-fx-max-width: 100px; " +
                "-fx-max-height: 100px;"
        );
		
/*
 * -----------------------------------------------------------------------------------------
 * this part creates all of the buttons that make up the tables in the 
 * ldr
 * -----------------------------------------------------------------------------------------
 */
		TableButton l1, l2, l3, l4, l5, l6, l7;
		l1 = new TableButton(90, 90, "1");
		l1.setLayoutX(10);
		l1.setLayoutY(0);
		l2 = new TableButton(90, 90, "2");
		l2.setLayoutX(160);
		l2.setLayoutY(0);
		l3 = new TableButton(90, 90, "3");
		l3.setLayoutX(310);
		l3.setLayoutY(0);
		l4 = new TableButton(90, 180, "4");
		l4.setLayoutX(150);
		l4.setLayoutY(200);
		l5 = new TableButton(90, 90, "5");
		l5.setLayoutX(10);
		l5.setLayoutY(400);
		l6 = new TableButton(90, 90, "6");
		l6.setLayoutX(160);
		l6.setLayoutY(400);
		l7 = new TableButton(90, 90, "7");
		l7.setLayoutX(310);
		l7.setLayoutY(400);
		
/*
 * -------------------------------------------------------------------------------------------------
 * This part does the sizing for all of the buttons *******delete and use TableButton()!!!!!!
 * -------------------------------------------------------------------------------------------------
 */
		
		//bdr select transfer
		bdrSelectTransfer.setOnAction((event -> {
			primaryStage.setScene(bdrTablesScene);
			transferTableSelectStage.close();
		}));
		
		//ldr select transfer
		ldrSelectTransfer.setOnAction((event -> {
			primaryStage.setScene(ldrTablesScene);
			transferTableSelectStage.close();
		}));
		
		//porch select transfer
		porchSelectTransfer.setOnAction((event -> {
			primaryStage.setScene(porchTablesScene);
			transferTableSelectStage.close();
		}));
		//bdr button porch
		bdrButtonPorch.setOnAction((event -> {
			primaryStage.setScene(bdrTablesScene);
		}));
		
		//ldr button porch
		ldrButtonPorch.setOnAction((event -> {
			primaryStage.setScene(ldrTablesScene);
		}));
		
		//porch button bdr
		porchButtonBDR.setOnAction((event -> {
			primaryStage.setScene(porchTablesScene);
		}));
		
		//ldr button bdr
		ldrButtonBDR.setOnAction((event -> {
			primaryStage.setScene(ldrTablesScene);
		}));
		
		//porch button ldr
		porchButtonLDR.setOnAction((event -> {
			primaryStage.setScene(porchTablesScene);
		}));
		
		//bdr button ldr
		bdrButtonLDR.setOnAction((event -> {
			primaryStage.setScene(bdrTablesScene);
		}));
		
		//close button
		closeButton.setPrefSize(150, 50);
		closeButton.setLayoutX(0);
		closeButton.setLayoutY(550);
		closeButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				closeStage.setScene(closeStageScene);
				closeStage.show();
			}
		});
		
		//tables button
		tablesButton.setPrefSize(150, 50);
		tablesButton.setLayoutX(0);
		tablesButton.setLayoutY(60);
		tablesButton.setOnAction((event -> {
			primaryStage.setScene(porchTablesScene);
		}));
		
		//tables back button
		tablesSceneBack.setPrefSize(150, 50);
		tablesSceneBack.setLayoutX(0);
		tablesSceneBack.setLayoutY(550);
		tablesSceneBack.setOnAction((event -> {
			primaryStage.setScene(sceneMainMenu);
		}));
		
		//close yes
		closeYes.setPrefSize(150, 50);
		closeYes.setLayoutX(100);
		closeYes.setLayoutY(75);
		closeYes.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				closeStage.close();
				primaryStage.close();
			}
		});
		
		//close no
		closeNo.setPrefSize(150,50);
		closeNo.setLayoutX(100);
		closeNo.setLayoutY(150);
		closeNo.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				closeStage.close();
			}
		});
		
		//create text field bound to the price of the party
		Text partyPrice = new Text("0.00");
		partyPrice.setLayoutX(1075);
		partyPrice.setLayoutY(460);
		
		//compute price button
		computePrice.setPrefSize(150, 50);
		computePrice.setLayoutX(1000);
		computePrice.setLayoutY(400);
		computePrice.setOnAction((event -> {
			double beforePrice = Party.computeTablePrice(Party.c03, Party.c45, Party.c68, Party.c911, Party.adult);
			DecimalFormat price = new DecimalFormat("#.00");
			String finalPrice;
					finalPrice = price.format(beforePrice);
			partyPrice.setText(finalPrice);
			createParty.setDisable(false);
		}));
		
		//add meals button
		addAdultMeal.setPrefSize(150, 50);
		addAdultMeal.setLayoutX(400);
		addAdultMeal.setLayoutY(0);
		addAdultMeal.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				Party.adult++;
				nAdults.setText(Integer.toString(Party.adult));
				createParty.setDisable(true);
			}
		});
		
		//delete adult meal button
		deleteAdult.setPrefSize(150, 50);
		deleteAdult.setLayoutX(550);
		deleteAdult.setLayoutY(0);
		deleteAdult.setOnAction((event -> {
			if(Party.adult > 0){
				Party.adult--;
				nAdults.setText(Integer.toString(Party.adult));
			}else{
				nAdults.setText(Integer.toString(Party.adult));
			}	
			createParty.setDisable(true);
		}));
		
		//add Child 9-11 button
		addChild9_11Meal.setPrefSize(150, 50);
		addChild9_11Meal.setLayoutX(400);
		addChild9_11Meal.setLayoutY(50);
		addChild9_11Meal.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e){
				Party.c911++;
				nC911.setText(Integer.toString(Party.c911));
				createParty.setDisable(true);
			}
		});
		
		//delete child 9-11 button
		deleteChild911Meal.setPrefSize(150, 50);
		deleteChild911Meal.setLayoutX(550);
		deleteChild911Meal.setLayoutY(50);
		deleteChild911Meal.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e){
				if(Party.c911 > 0){
					Party.c911--;
					nC911.setText(Integer.toString(Party.c911));
				}else{
					nC911.setText(Integer.toString(Party.c911));
				}
				createParty.setDisable(true);
			}
		});
		
		//add Child 6-8 button
		addChild6_8Meal.setPrefSize(150, 50);
		addChild6_8Meal.setLayoutX(400);
		addChild6_8Meal.setLayoutY(100);
		addChild6_8Meal.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e){
				Party.c68++;
				nC68.setText(Integer.toString(Party.c68));
				createParty.setDisable(true);
			}
		});
		
		
		//delete child 6-8 button 
		deleteChild68Meal.setPrefSize(150, 50);
		deleteChild68Meal.setLayoutX(550);
		deleteChild68Meal.setLayoutY(100);
		deleteChild68Meal.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e){
				if(Party.c68 > 0){
					Party.c68--;
					nC68.setText(Integer.toString(Party.c68));
				}else{
					nC68.setText(Integer.toString(Party.c68));
				}
				createParty.setDisable(true);
			}
		});
		
		//add Child 4-5 button
		addChild4_5Meal.setPrefSize(150, 50);
		addChild4_5Meal.setLayoutX(400);
		addChild4_5Meal.setLayoutY(150);
		addChild4_5Meal.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e){
				Party.c45++;
				nC45.setText(Integer.toString(Party.c45));
				createParty.setDisable(true);
			}
		});
		
		//delete child 45 button
		deleteChild45Meal.setPrefSize(150, 50);
		deleteChild45Meal.setLayoutX(550);
		deleteChild45Meal.setLayoutY(150);
		deleteChild45Meal.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e){
				if(Party.c45 > 0){
					Party.c45--;
					nC45.setText(Integer.toString(Party.c45));
				}else{
					nC45.setText(Integer.toString(Party.c45));
				}
				createParty.setDisable(true);
			}
		});
		
		//add Child 0-3 button3
		addChild0_3Meal.setPrefSize(150, 50);
		addChild0_3Meal.setLayoutX(400);
		addChild0_3Meal.setLayoutY(200);
		addChild0_3Meal.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e){
				Party.c03++;
				nC03.setText(Integer.toString(Party.c03));
				createParty.setDisable(true);
			}
		});
		
		//delete child 03 button
		deleteChild03Meal.setPrefSize(150, 50);
		deleteChild03Meal.setLayoutX(550);
		deleteChild03Meal.setLayoutY(200);
		deleteChild03Meal.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e){
				if(Party.c03 > 0){
					Party.c03--;
					nC03.setText(Integer.toString(Party.c03));
				}else{
					nC03.setText(Integer.toString(Party.c03));
				}
				createParty.setDisable(true);
			}
		});
		
		//new party button
		lineNewParty.setPrefSize(150, 50);
		lineNewParty.setLayoutX(0);
		lineNewParty.setLayoutY(150);
		lineNewParty.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				primaryStage.setScene(newPartyScene);
			}
		});
		
		createParty.setDisable(true);
		
		Party[] party = new Party[1000];
		//CheckBox[] radio = new CheckBox[1000];
		int id = 0;
		
		//create party button
		createParty.setPrefSize(150, 50);
		createParty.setLayoutX(1000);
		createParty.setLayoutY(600);
		createParty.setOnAction((event -> {
			party[id].tableName = partyName.getText();
			party[id].customerCount = Integer.parseInt(partySize.getText());
			party[id] = new Party(Party.tableName, Party.customerCount, Double.parseDouble(partyPrice.getText()),
					Party.adult, Party.c911, Party.c68, Party.c45, Party.c03, false, false, Party.identifier);
			//radio[id] = new CheckBox(party[id].tableName);
			Button btn = new Button(party[id].tableName);
			btn.setOnAction((event2 -> {
				System.out.println("hello button works!");
			}));
			tabsPane.getChildren().add(btn);
			partyName.clear();
			partySize.clear();
			partyPrice.setText("0");
			Party.adult = 0;
			Party.c911 = 0;
			Party.c68 = 0;
			Party.c45 = 0;
			Party.c03 = 0;
			nAdults.setText("0");
			nC911.setText("0");
			nC68.setText("0");
			nC45.setText("0");
			nC03.setText("0");
			Party.identifier ++;
			primaryStage.setScene(lineScene);
		}));
		
		//set up table info TextBoxs
		TextField tableNameChange = new TextField();
		tableNameChange.setLayoutX(10);
		tableNameChange.setLayoutY(10);
		TextField tableSizeChange = new TextField();
		tableSizeChange.setLayoutX(10);
		tableSizeChange.setLayoutY(40);
		TextField tablenAdultsChange = new TextField();
		tablenAdultsChange.setLayoutX(10);
		tablenAdultsChange.setLayoutY(70);
		TextField tablenC911Change = new TextField();
		tablenC911Change.setLayoutX(10);
		tablenC911Change.setLayoutY(100);
		TextField tablenC68Change = new TextField();
		tablenC68Change.setLayoutX(10);
		tablenC68Change.setLayoutY(130);
		TextField tablenC45Change = new TextField();
		tablenC45Change.setLayoutX(10);
		tablenC45Change.setLayoutY(160);
		TextField tablenC03Change = new TextField();
		tablenC03Change.setLayoutX(10);
		tablenC03Change.setLayoutY(190);
		

		//texts for table info pane
		Text tableNameChangeText = new Text("Table Name");
		tableNameChangeText.setLayoutX(200);
		tableNameChangeText.setLayoutY(20);
		Text tableSizeChangeText = new Text("Table Size");
		tableSizeChangeText.setLayoutX(200);
		tableSizeChangeText.setLayoutY(50);
		Text nAdultsTextChange = new Text("Adults");
		nAdultsTextChange.setLayoutX(200);
		nAdultsTextChange.setLayoutY(80);
		Text nC911TextChange = new Text("Children 9-11");
		nC911TextChange.setLayoutX(200);
		nC911TextChange.setLayoutY(110);
		Text nC68TextChange = new Text("Children 6-8");
		nC68TextChange.setLayoutX(200);
		nC68TextChange.setLayoutY(140);
		Text nC45TextChange = new Text("Children 4-5");
		nC45TextChange.setLayoutX(200);
		nC45TextChange.setLayoutY(170);
		Text nC03TextChange = new Text("Children 0-3");
		nC03TextChange.setLayoutX(200);
		nC03TextChange.setLayoutY(200);
		
		
		
		//Table info button
		/*
		 * tableInfoButton.setOnAction((event -> {
					for (int j = 0; j < radio.length; j++) {
						if(radio[j].isSelected() == true){
							party[j].selected = true;
							tableNameChange.setText(party[j].tableName);
							tableSizeChange.setText(Integer.toString(party[j].getCustomerCount()));
							tablenAdultsChange.setText(Integer.toString(party[j].getAdults()));
							tablenC911Change.setText(Integer.toString(party[j].getC911()));
							tablenC68Change.setText(Integer.toString(party[j].getC68()));
							tablenC45Change.setText(Integer.toString(party[j].getC45()));
							tablenC03Change.setText(Integer.toString(party[j].getC03()));
							break;
						}else{
							
						}
					}
						primaryStage.setScene(tableInfoScene);
				}));
		 */
				
				
				TableButton saveChangesTableInfo = new TableButton(50, 150, "Done");
				saveChangesTableInfo.setLayoutX(10);
				saveChangesTableInfo.setLayoutX(300);
				saveChangesTableInfo.setOnAction((event -> {
					for (int j = 0;  j < party.length; j++) {
						if(party[j].selected == true){
							party[j].setTableName(tableNameChange.getText());
							party[j].setCustomerCount(Integer.parseInt(tableSizeChange.getText()));
							party[j].setAdult(Integer.parseInt(tablenAdultsChange.getText()));
							party[j].setC911(Integer.parseInt(tablenC911Change.getText()));
							party[j].setC68(Integer.parseInt(tablenC68Change.getText()));
							party[j].setC45(Integer.parseInt(tablenC45Change.getText()));
							party[j].setC03(Integer.parseInt(tablenC03Change.getText()));
							party[j].tablePrice = Party.computeTablePrice(party[j].c03, 
									party[j].c45, party[j].c68, 
									party[j].c911, party[j].adult);
							party[j].selected = false;
							//radio[j].setSelected(false);
							primaryStage.setScene(lineScene);
							break;
						}
					}
				}));
				
		Text selectATable = new Text("Select A Table To Transfer");
		selectATable.setVisible(false);
		selectATable.setX(5);
		selectATable.setY(700);
		
		/*
		 * Button transferTable = new Button("Transfer");
		transferTable.setPrefSize(150, 50);
		transferTable.setOnAction((event -> {
			for (Party.j = 0; Party.j <radio.length; Party.j++) {
				if(radio[Party.j].isSelected()){
					party[Party.j].selected = true;
					selectATable.setVisible(false);
					transferTableSelectStage.setScene(transferTableSelect);
					transferTableSelectStage.show();
					break;
				}else{
					selectATable.setVisible(true);
				}
			}
		}));
		 */
		
		//create new party back button
		createPartyBack.setPrefSize(150, 50);
		createPartyBack.setLayoutX(10);
		createPartyBack.setLayoutY(500);
		createPartyBack.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				primaryStage.setScene(lineScene);
				Party.adult=0;
				Party.c911=0;
				Party.c45=0;
				Party.c68=0;
				partyName.clear();
				partySize.clear();
				partyPrice.setText("0.00");
				nAdults.setText("0");
			}
		});
		
		//line scene back button
		lineSceneBack.setPrefSize(150, 50);
		lineSceneBack.setLayoutX(0);
		lineSceneBack.setLayoutY(300);
		lineSceneBack.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				primaryStage.setScene(sceneMainMenu);
			}
		});
		
		//set in line button
		inLineButton.setLayoutX(0);
		inLineButton.setLayoutY(10);
		inLineButton.setPrefSize(150, 50);
		inLineButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				primaryStage.setScene(lineScene);
			}
		});
		
		//set reservations button 
		reservationsButton.setLayoutX(0);
		reservationsButton.setLayoutY(110);
		reservationsButton.setPrefSize(150, 50);
		
		//set gift shop ticket button 
		giftShopTicketButton.setLayoutX(0);
		giftShopTicketButton.setLayoutY(160);
		giftShopTicketButton.setPrefSize(150, 50);
		
		
		
		

		
/*
 * ------------------------------------------------------------------------------------
 * This part sets the action for each of the table buttons
 * ------------------------------------------------------------------------------------
 */
		
		/*
		 * p1.setOnAction((event -> {
			for (Party.j = 0; Party.j < radio.length; Party.j++) {
				if(radio[Party.j].isSelected() == true){
					p1.setText(radio[Party.j].getText());
					radio[Party.j].setSelected(false);
					tabsPane.getChildren().remove(radio[Party.j]);
					break;
				}
			}
		}));
		
		p2.setOnAction((event -> {
			for (Party.j = 0; Party.j < radio.length; Party.j++) {
				if(radio[Party.j].isSelected() == true){
					p2.setText(radio[Party.j].getText());
					radio[Party.j].setSelected(false);
					tabsPane.getChildren().remove(radio[Party.j]);
					break;
				}
			}
		}));
		p3.setOnAction((event -> {
			for (Party.j = 0; Party.j < radio.length; Party.j++) {
				if(radio[Party.j].isSelected() == true){
					p3.setText(radio[Party.j].getText());
					radio[Party.j].setSelected(false);
					tabsPane.getChildren().remove(radio[Party.j]);
					break;
				}
			}
		}));
		p4.setOnAction((event -> {
			for (Party.j = 0; Party.j < radio.length; Party.j++) {
				if(radio[Party.j].isSelected() == true){
					p4.setText(radio[Party.j].getText());
					radio[Party.j].setSelected(false);
					tabsPane.getChildren().remove(radio[Party.j]);
					break;
				}
			}
		}));
		p5.setOnAction((event -> {
			for (Party.j = 0; Party.j < radio.length; Party.j++) {
				if(radio[Party.j].isSelected() == true){
					p5.setText(radio[Party.j].getText());
					radio[Party.j].setSelected(false);
					tabsPane.getChildren().remove(radio[Party.j]);
					break;
				}
			}
		}));
		p6.setOnAction((event -> {
			for (Party.j = 0; Party.j < radio.length; Party.j++) {
				if(radio[Party.j].isSelected() == true){
					p6.setText(radio[Party.j].getText());
					radio[Party.j].setSelected(false);
					tabsPane.getChildren().remove(radio[Party.j]);
					break;
				}
			}
		}));
		p7.setOnAction((event -> {
			for (Party.j = 0; Party.j < radio.length; Party.j++) {
				if(radio[Party.j].isSelected() == true){
					p7.setText(radio[Party.j].getText());
					radio[Party.j].setSelected(false);
					tabsPane.getChildren().remove(radio[Party.j]);
					break;
				}
			}
		}));
		p8.setOnAction((event -> {
			for (Party.j = 0; Party.j < radio.length; Party.j++) {
				if(radio[Party.j].isSelected() == true){
					p8.setText(radio[Party.j].getText());
					radio[Party.j].setSelected(false);
					tabsPane.getChildren().remove(radio[Party.j]);
					break;
				}
			}
		}));
		p9.setOnAction((event -> {
			for (Party.j = 0; Party.j < radio.length; Party.j++) {
				if(radio[Party.j].isSelected() == true){
					p9.setText(radio[Party.j].getText());
					radio[Party.j].setSelected(false);
					tabsPane.getChildren().remove(radio[Party.j]);
					break;
				}
			}
		}));
		p10.setOnAction((event -> {
			for (Party.j = 0; Party.j < radio.length; Party.j++) {
				if(radio[Party.j].isSelected() == true){
					p10.setText(radio[Party.j].getText());
					radio[Party.j].setSelected(false);
					tabsPane.getChildren().remove(radio[Party.j]);
					break;
				}
			}
		}));
		p11.setOnAction((event -> {
			for (Party.j = 0; Party.j < radio.length; Party.j++) {
				if(radio[Party.j].isSelected() == true){
					p11.setText(radio[Party.j].getText());
					radio[Party.j].setSelected(false);
					tabsPane.getChildren().remove(radio[Party.j]);
					break;
				}
			}
		}));
		p12.setOnAction((event -> {
			for (Party.j = 0; Party.j < radio.length; Party.j++) {
				if(radio[Party.j].isSelected() == true){
					p12.setText(radio[Party.j].getText());
					radio[Party.j].setSelected(false);
					tabsPane.getChildren().remove(radio[Party.j]);
					break;
				}
			}
		}));
		p13.setOnAction((event -> {
			for (Party.j = 0; Party.j < radio.length; Party.j++) {
				if(radio[Party.j].isSelected() == true){
					p13.setText(radio[Party.j].getText());
					radio[Party.j].setSelected(false);
					tabsPane.getChildren().remove(radio[Party.j]);
					break;
				}
			}
		}));
		p14.setOnAction((event -> {
			for (Party.j = 0; Party.j < radio.length; Party.j++) {
				if(radio[Party.j].isSelected() == true){
					p14.setText(radio[Party.j].getText());
					radio[Party.j].setSelected(false);
					tabsPane.getChildren().remove(radio[Party.j]);
					break;
				}
			}
		}));
		p15.setOnAction((event -> {
			for (Party.j = 0; Party.j < radio.length; Party.j++) {
				if(radio[Party.j].isSelected() == true){
					p15.setText(radio[Party.j].getText());
					radio[Party.j].setSelected(false);
					tabsPane.getChildren().remove(radio[Party.j]);
					break;
				}
			}
		}));
		 */
		
/*
 * ----------------------------------------------------------------------------
 * this part gets all of the children to all of the panes
 * ----------------------------------------------------------------------------
 */
		
		mainMenuPaneTop.setPrefSize(1200, 50);
		mainMenuPaneTop.getChildren().addAll(nameField, versionField, clock1);
		mainMenuPaneLeft.getChildren().addAll(inLineButton, reservationsButton, giftShopTicketButton, closeButton,
				tablesButton);
		
		tablesPorchVbox.getChildren().addAll(bdrButtonPorch, ldrButtonPorch,tablesSceneBack);
		
		tableTransferSelectVBox.getChildren().addAll(selectDiningRoom, porchSelectTransfer, bdrSelectTransfer,
				ldrSelectTransfer);
		
		tablesBDRVbox.getChildren().addAll(porchButtonBDR, ldrButtonBDR);
		tablesLDRVbox.getChildren().addAll(bdrButtonLDR, porchButtonLDR);
		
		porchTablePane.getChildren().addAll(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11,
				p12, p13, p14, p15);
		
		bdrTablesPane.getChildren().addAll(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10);
		
		ldrTablesPane.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7);
		
		tableInfoPane.getChildren().addAll(tablenAdultsChange, tablenC03Change, tablenC45Change, 
				tablenC68Change, tablenC911Change, tableNameChange, tableSizeChange, tableNameChangeText,
				tableSizeChangeText, nAdultsTextChange, nC911TextChange, nC68TextChange,
				nC45TextChange, nC03TextChange, saveChangesTableInfo);
		
		inLineMainPane.getChildren().addAll(lineNewParty, tableInfoButton, lineSceneBack,
				selectATable);
		
		newPartyPane.getChildren().addAll(createParty, createPartyBack, partyNameText, partySizeText,
				partySize, partyName, addChild0_3Meal, addAdultMeal, addChild4_5Meal,
				addChild6_8Meal, addChild9_11Meal, partyPrice, computePrice, nAdults, deleteAdult, nC911, nC68, 
				deleteChild911Meal, deleteChild68Meal, deleteChild45Meal, deleteChild03Meal, nC45, nC03);
		
		closeStagePane.getChildren().addAll(closeStageQuestion, closeNo, closeYes);
	}
	public static void main(String[] args){
		Application.launch(args);
	}
}