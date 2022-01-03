package controller;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Map;

import common.exception.InvalidCardException;
import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;
import subsystem.InterbankInterface;
import subsystem.InterbankSubsystem;


/**
 * This {@code PaymentController} class control the flow of the payment process
 * in our Ecobike Software.
 * 
 */
public class PaymentController extends BaseController {

	/**
	 * Represent the card used for payment
	 */
	private CreditCard card;

	/**
	 * Represent the Interbank subsystem
	 */
	private InterbankInterface interbank;

	/**
	 * Validate the input date which should be in the format "mm/yy", and then
	 * return a {@link java.lang.String String} representing the date in the
	 * required format "mmyy" .
	 * 
	 * @param date - the {@link java.lang.String String} represents the input date
	 * @return {@link java.lang.String String} - date representation of the required
	 *         format
	 * @throws InvalidCardException - if the string does not represent a valid date
	 *                              in the expected format
	 */
	private String getExpirationDate(String date) throws InvalidCardException {
		String[] strs = date.split("/");
		if (strs.length != 2) {
			throw new InvalidCardException();
		}

		String expirationDate = null;
		int month = -1;
		int year = -1;

		try {
			month = Integer.parseInt(strs[0]);
			year = Integer.parseInt(strs[1]);
			if (month < 1 || month > 12 || year < Calendar.getInstance().get(Calendar.YEAR) % 100 || year > 100) {
				throw new InvalidCardException();
			}
			expirationDate = strs[0] + strs[1];

		} catch (Exception ex) {
			throw new InvalidCardException();
		}

		return expirationDate;
	}
	/**
	 * Validate the input cvv which should be in the format number
	 * @param cvv - the {@link java.lang.String String} represents the input date
	 * @return {@link java.lang.integer int} - date representation of the required
	 *         format
	 * @throws InvalidCardException - if the string does not represent a valid cvv
	 *                              in the expected format
	 */
	private int getCvv(String cvv) throws InvalidCardException {
		int sCode;
		try {
	      sCode = Integer.parseInt(cvv);
		} catch (NumberFormatException ex) {
			throw new InvalidCardException();
		}
		return sCode;
	}
	
	

	/**
	 * Pay order, and then return the result with a message.
	 * 
	 * @param amount         - the amount to pay
	 * @param contents       - the transaction contents
	 * @param cardNumber     - the card number
	 * @param cardHolderName - the card holder name
	 * @param expirationDate - the expiration date in the format "mm/yy"
	 * @param securityCode   - the cvv/cvc code of the credit card
	 * @return {@link java.util.Map Map} represent the payment result with a
	 *         message.
	 */
	public Map<String, String> requestToRefund(String content ,int amount, String cardNumber, String cardHolderName,
			String expirationDate, String securityCode) {
		Map<String, String> result = new Hashtable<String, String>();
		result.put("RESULT", "PAYMENT FAILED!");
		try {
			this.card = new CreditCard(cardNumber, cardHolderName, getCvv(securityCode),
					getExpirationDate(expirationDate));

			this.interbank = new InterbankSubsystem();
			PaymentTransaction transaction = interbank.refund(card, amount, content);

			result.put("RESULT", "PAYMENT SUCCESSFUL!");
			result.put("MESSAGE", "succesffully !");
		} catch (PaymentException | UnrecognizedException ex) {
			result.put("MESSAGE", ex.getMessage());
		}
		return result;
	}
	
	/**
	 * 
	 * @param content
	 * @param amount
	 * @param cardNumber
	 * @param cardHolderName
	 * @param expirationDate
	 * @param securityCode
	 * @return
	 */
	public Map<String, String> requestToPay(String content ,int amount, String cardNumber, String cardHolderName,
			String expirationDate, String securityCode) {
		Map<String, String> result = new Hashtable<String, String>();
		result.put("RESULT", "PAYMENT FAILED!");
		try {
			this.card = new CreditCard(cardNumber, cardHolderName, getCvv(securityCode),
					getExpirationDate(expirationDate));
	
			this.interbank = new InterbankSubsystem();
			PaymentTransaction transaction = interbank.payOrder(card, amount, content);
			result.put("RESULT", "PAYMENT SUCCESSFUL!");
			result.put("MESSAGE", "You have succesffully paid the order!");
		} catch (PaymentException | UnrecognizedException ex) {
			result.put("MESSAGE", ex.getMessage());
		}
		return result;
   }

}
