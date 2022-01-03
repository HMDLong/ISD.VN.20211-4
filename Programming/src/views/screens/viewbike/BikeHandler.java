package views.screens.viewbike;

import java.io.IOException;

import entity.bike.Bike;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import views.screens.FXMLScreenHandler;

public abstract class BikeHandler extends FXMLScreenHandler {
    @FXML
    private Label bikeTypeLabel, bikecodeLabel, depositLabel, bikeName;
    @FXML
    private ImageView bikeImage;
  
	protected Pane content;
	protected Bike bike;
	
	protected BikeHandler() {}
	
	public BikeHandler(String screenPath, Bike bike) throws IOException {
		super(screenPath);
		this.content = (Pane) this.getLoader().load();
		this.bike = bike;
		this.bikeTypeLabel.setText(bike.getBikeType());
		this.bikecodeLabel.setText(bike.getBikeCode());
		this.depositLabel.setText("VND 100.000");
		this.bikeName.setText("Bike " + bike.getId());
	}
	
	public abstract BikeHandler createBikeHandler(Bike bike) throws IOException;
	
	public Pane getContent() {
		return this.content;
	}
}
