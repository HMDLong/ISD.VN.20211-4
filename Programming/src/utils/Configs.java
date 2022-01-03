package utils;

public class Configs {
	// static view paths
	public static final String SPLASH_SCREEN_PATH = "/views/fxml/splash.fxml";
	public static final String HOME_SCREEN_PATH = "/views/fxml/home.fxml";
	public static final String RENT_SCREEN_PATH = "/views/fxml/rentbike.fxml";
	public static final String RETURN_SCREEN_PATH = "/views/fxml/returnbike.fxml";
	public static final String PAYMENT_SCREEN_PATH = "/views/fxml/payment.fxml";
	public static final String DOCK_PATH = "/views/fxml/dock.fxml";
	public static final String VIEW_BIKES_PATH = "/views/fxml/bikeview.fxml";
	public static final String DOCK_MENU_PATH = "/views/fxml/dockview.fxml";
	public static final String E_BIKE_PATH = "/views/fxml/ebike.fxml";
	public static final String STD_BIKE_PATH = "/views/fxml/standardbike.fxml";
	public static final String DEPOSIT_PATH = "/views/fxml/deposit_invoice.fxml";
	public static final String INVOICE_PATH = "/views/fxml/payment_invoice.fxml";
	public static final String PAYMENT_PATH = "/views/fxml/payment.fxml";
	
	// api constants
	public static final String GET_BALANCE_URL = "https://ecopark-system-api.herokuapp.com/api/card/balance/118609_group1_2020";
	public static final String GET_VEHICLECODE_URL = "https://ecopark-system-api.herokuapp.com/api/get-vehicle-code/1rjdfasdfas";
	public static final String PROCESS_TRANSACTION_URL = "https://ecopark-system-api.herokuapp.com/api/card/processTransaction";
	public static final String RESET_URL = "https://ecopark-system-api.herokuapp.com/api/card/reset";

	// demo data
	public static final String POST_DATA = "{"
			+ " \"secretKey\": \"BUXj/7/gHHI=\" ,"
			+ " \"transaction\": {"
			+ " \"command\": \"pay\" ,"
			+ " \"cardCode\": \"118609_group1_2020\" ,"
			+ " \"owner\": \"Group 1\" ,"
			+ " \"cvvCode\": \"185\" ,"
			+ " \"dateExpried\": \"1125\" ,"
			+ " \"transactionContent\": \"Pei debt\" ,"
			+ " \"amount\": 50000 "
			+ "}"
		+ "}";
	
}
