package controller.search;

import java.util.ArrayList;

import common.exception.InvalidSearchKeyException;
import common.exception.NoResultException;
import controller.BaseController;
import entity.dock.Dock;

public abstract class SearchDockController extends BaseController {
	/**
	 * This method search for docks that matched given keyword.
	 *
	 * @param key the given search keyword
	 * @return ArrayList<Dock> list of result dock
	 * @throws NoResultException throws if there is no matching dock
	 * @throws InvalidSearchKeyException throws if the given keyword is invalid
	 */
  public abstract ArrayList<Dock> searchDock(String key) throws NoResultException, InvalidSearchKeyException;
  
  /**
   * This method validates search key inputed from user.
   *
   * @param key the search key that user entered
   * @throws InvalidSearchKeyException throws if the given search key is invalid(empty/full whitespace) 
   */
  public void validateSearchKey(String key) throws InvalidSearchKeyException {
	  if(key.isBlank()) {
		  throw new InvalidSearchKeyException("Empty search key");
	  }
  }
}