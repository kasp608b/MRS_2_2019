/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrs_2_2019.gui;

import java.io.IOException;
import mrs_2_2019.be.Movie;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import mrs_2_2019.dal.MovieDAO;

/**
 *
 * @author pgn
 */
public class FXMLDocumentController implements Initializable
{
    
    private ListView<Movie> lstView;
    @FXML
    private TextField txtMovieTitle;
    @FXML
    private TextField txtMovieYear;
    @FXML
    private TextField txtSelectedMovieTitle;
    @FXML
    private TextField txtSelectedMovieYear;
    @FXML
    private TextField txtMovieSearch;
    @FXML
    private ListView<?> lstMovies;
    @FXML
    private TextField txtUserSearch;
    @FXML
    private ListView<?> lstUsers;
    @FXML
    private RadioButton radioRatingMinus5;
    @FXML
    private RadioButton radioRatingMinus3;
    @FXML
    private RadioButton radioRating1;
    @FXML
    private RadioButton radioRating3;
    @FXML
    private RadioButton radioRating5;
    @FXML
    private ListView<?> lstRecommendedMovies;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {
            MovieDAO movieDao = new MovieDAO();
            List<Movie> allMovies = movieDao.getAllMovies();    
            ObservableList<Movie> obsAllMovies =  FXCollections.observableArrayList(allMovies);
            lstView.setItems(obsAllMovies);
        } catch (Exception ex)
        {
            System.out.println("Ooops");
            ex.printStackTrace();
        }
    }    

    @FXML
    private void handleAddMovie(ActionEvent event)
    {
    }

    @FXML
    private void handleUpdateMovie(ActionEvent event)
    {
    }

    @FXML
    private void handleDeleteMovie(ActionEvent event)
    {
    }

    @FXML
    private void handleSearchMovie(KeyEvent event)
    {
    }

    @FXML
    private void handleSearchUser(KeyEvent event)
    {
    }

    @FXML
    private void handleUserRateMovie(ActionEvent event)
    {
    }
    
}
