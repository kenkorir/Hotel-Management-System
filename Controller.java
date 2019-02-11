package Restaurant;

import Connectivity.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    public TextField chickenburgertxt;
    public TextField cheeseburgertxt;
    public TextField chickenfriestxt;
    public TextField quantitytxt;
    public TextField currencytxt;
    public TextField receipttxt;

    @FXML
    public Label costofdrinkslbl;
    public Label costofmeallbl;
    public Label convertlbl;
    public Label taxlbl;
    public Label subtotallbl;
    public Label Totallbl;


    @FXML
    public ComboBox<String> comboBoxjc;
    public ComboBox<String> countryjc;

    @FXML
    public Button TotalBtn;
    public Button exitBtn;
    public Button resetbtn;
    public Button convertbtn;
    public Button closebtn;
    public Button receiptbtn;

    public Controller() {
    }

    public void initialize(){

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        comboBoxjc.getItems().removeAll(comboBoxjc.getItems());
        comboBoxjc.setPromptText("Select One");
        comboBoxjc.getItems().addAll("Tea", "Coffee", "Ice_Tea","Cola");

        countryjc.getItems().removeAll(countryjc.getItems());
        countryjc.setPromptText("Choose One");
        countryjc.getItems().addAll("Tanzania", "Uganda", "Ethopia");

    }
    
    @FXML
    public void onConvertPress(ActionEvent event){
        boolean selectedItem = true;
        int selectedValue ;
        int Currency;
        double convertedValue ;

        currencytxt.setPromptText("KES");


        if(selectedItem){

            selectedValue = countryjc.getSelectionModel().getSelectedIndex();

            Currency = Integer.parseInt(currencytxt.getText());
            currencytxt.getOnKeyTyped();

            switch (selectedValue) {
                case 0:
                    convertedValue = Currency * 20.0;
                    break;
                case 1:
                    convertedValue = Currency * 25.5;
                    break;
                case 2:
                    convertedValue = Currency * 15.0;
                    break;
                    default:
                        convertedValue = 0.0;
            }
            convertlbl.setText(String.valueOf(convertedValue));
        }

    }

    public void onClosePress(ActionEvent event){
        currencytxt.setText(null);
        convertlbl.setText(null);
        countryjc.setValue("Choose One");
    }

    @FXML
    public  void onTotalBtnPress(ActionEvent event){

        Connection connection = new Connection();
        java.sql.Connection connection1 = connection.getConnection();
        try {

            String chickenBurger = chickenburgertxt.getText();
            String cheeseBuger  = cheeseburgertxt.getText();
            String chickenFries  = chickenfriestxt.getText();
            //prices

            Double priceChickenBurger;
            Double priceCheeseBurger;
            Double priceChickenFries;

            if(chickenBurger.isEmpty()){

                priceChickenBurger = 0.0;

            }else {

                String sql = "INSERT INTO FOOD(ChickenBurger) VALUES('"+chickenburgertxt.getText()+"')";
                Statement statement = connection1.createStatement();
                statement.executeUpdate(sql);

                        priceChickenBurger = Double.parseDouble(chickenBurger) * 900.0;
            }


            if(chickenFries.isEmpty()){

                priceChickenFries = 0.0;

            }else {

                String sql = "INSERT INTO FOOD(ChickenFries) VALUES('"+chickenfriestxt.getText()+"')";
                Statement statement = connection1.createStatement();
                statement.executeUpdate(sql);

                        priceChickenFries = Double.parseDouble(chickenFries)*700.0;
            }

            if (cheeseBuger.isEmpty()){

                priceCheeseBurger = 0.0;

            }else {

                String sql = "INSERT INTO FOOD(CheeseBurger) VALUES('"+cheeseburgertxt.getText()+"')";
                Statement statement = connection1.createStatement();
                statement.executeUpdate(sql);
                        priceCheeseBurger = Double.parseDouble(cheeseBuger) * 400.0;
            }


           costofmeallbl.setText(String.valueOf(priceCheeseBurger + priceChickenBurger + priceChickenFries));

            //---------------------Drinks-------------------------------------//
            boolean selected = true;
            int selected_item;
            double drink_price = 0;
            int drink_quantity;
            String drink_quantity_ = quantitytxt.getText();


            if(selected){

               selected_item = comboBoxjc.getSelectionModel().getSelectedIndex();

               if (drink_quantity_.isEmpty()){

                   drink_quantity = 0;
               }else{

                   drink_quantity = Integer.parseInt(drink_quantity_);
               }

               
                switch (selected_item){

                    case 0:

                        String sqlTea = "INSERT INTO FOOD(Tea) VALUES('"+quantitytxt.getText()+"')";
                        Statement statement = connection1.createStatement();
                        statement.executeUpdate(sqlTea);

                        drink_price = drink_quantity* 100.0;
                        break;

                    case 1:

                        String sqlCoffee = "INSERT INTO FOOD(Tea) VALUES('"+quantitytxt.getText()+"')";
                        Statement statement1 = connection1.createStatement();
                        statement1.executeUpdate(sqlCoffee);

                        drink_price = drink_quantity* 200;
                        break;

                    case 3:

                        String sqlIceTea = "INSERT INTO FOOD(Ice_Tea) VALUES('"+quantitytxt.getText()+"')";
                        Statement statement2 = connection1.createStatement();
                        statement2.executeUpdate(sqlIceTea);

                        drink_price = drink_quantity*300.0;
                        break;
                    case 2:

                        String sqlCola = "INSERT INTO FOOD(Cola) VALUES('"+quantitytxt.getText()+"')";
                        Statement statement3 = connection1.createStatement();
                        statement3.executeUpdate(sqlCola);

                        drink_price = drink_quantity*250;
                        break;

                        default:
                            drink_price = 0;
                }

                costofdrinkslbl.setText(String.valueOf(drink_price));
            }

            //-----------------------Subtotal & Tax-----------------------------//
            double cTotal1 = drink_price;

            double cTotal2 = Double.parseDouble(costofmeallbl.getText()) ;



           double tax = (cTotal1 + cTotal2)/100;
           taxlbl.setText(String.valueOf(tax));

           double subtotal = (cTotal1  + cTotal2);
           subtotallbl.setText(String.valueOf(subtotal));

          // ----------------Total---------------------------------------//
              double Total = (subtotal + tax);
              Totallbl.setText(String.valueOf(Total));

        }catch (NumberFormatException ex){

            ex.printStackTrace();

            System.out.println("Check Your Details");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void onExitBtnPress(ActionEvent event){
        System.exit(0);
    }

    public void onResetPress(ActionEvent event){
        chickenburgertxt.setText("");
        chickenfriestxt.setText("");
        cheeseburgertxt.setText("");
        costofdrinkslbl.setText("0");
        costofmeallbl.setText("0");
        quantitytxt.setText("");
        comboBoxjc.setValue("Select One");
        subtotallbl.setText("0");
        taxlbl.setText("0");
        Totallbl.setText("0");
        receipttxt.setText("");
    }

    public void onReceiptPress(ActionEvent event) {


        double qty1 = Double.parseDouble(chickenburgertxt.getText());
        double qty2 = Double.parseDouble(cheeseburgertxt.getText());
        double qty3 = Double.parseDouble(chickenfriestxt.getText());

        receipttxt.appendText("\t\n" +
                "Restaurant Management SYstem:\n" +
                "\n" + "Chicken Burger:\t\t"
                +qty1+ "\nCheese Burger Meal:\t\t" +
                qty2+"\nChicken Fries :\t\t"
                +qty3+"\n\nThanks for dining with us :-)");

        //receipttxt.appendText(String.format("\nRestaurant Management System: \n\nChicken Burger Meal:\t\t%s\n\nCheese Burger Meal:\t\t%s\nChicken Fries Meal:\t\t%s\n\n Thank you and dine with us again", qty1, qty2, qty3));


    }


}
