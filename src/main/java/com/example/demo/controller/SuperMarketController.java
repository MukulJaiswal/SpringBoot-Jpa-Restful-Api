package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SuperMarketDao;
import com.example.demo.model.SuperMarket;

/**
 * This Controller class contains all the functions for the RestFul API
 * 
 * @author MukulJaiswal
 *
 */
@RestController
public class SuperMarketController {

	@Autowired
	SuperMarketDao superMarketDao;

	/**
	 * This is used to get all items in the SuperMarket Store
	 * 
	 * @return
	 */
	@GetMapping("items")
	public List<SuperMarket> getItems() {
		return superMarketDao.findAll();
	}

	/**
	 * This method returns the items in store by ID
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("item/{id}")
	public SuperMarket getItem(@PathVariable("id") int id) {
		return superMarketDao.findOne(id);
	}

	/**
	 * This method is used to add items in the store
	 * 
	 * @param superMarket
	 * @return
	 */

	@PostMapping("items")
	public SuperMarket addItem(@RequestBody SuperMarket superMarket) {
		return superMarketDao.save(superMarket);
	}
	/**
	 * This method is used to update items in the store.
	 * 
	 * @param superMarket
	 * @return
	 */

	@PutMapping("item")
	public SuperMarket saveOrUpdateItem(@RequestBody SuperMarket superMarket) {
		return superMarketDao.save(superMarket);
	}

	/**
	 * This Method updates the item in the store by ID
	 * 
	 * @param id
	 * @param superMarketDetails
	 * @return
	 */

	@PutMapping("item/{id}")
	public SuperMarket updateItemById(@PathVariable int id, @Valid @RequestBody SuperMarket superMarketDetails) {
		SuperMarket superMarket = superMarketDao.findOne(id);

		superMarket.setName(superMarketDetails.getName());
		superMarket.setQuantity(superMarketDetails.getQuantity());
		superMarket.setDate(superMarketDetails.getDate());
		SuperMarket updatedItem = superMarketDao.save(superMarket);

		return updatedItem;
	}

	/**
	 * This method is used to delete all items in the store.
	 * 
	 * @param superMarket
	 */
	@DeleteMapping("items")
	public void deleteAllItems(SuperMarket superMarket) {
		superMarketDao.deleteAll();
	}
	
	/**
	 * This method deletes an item from the store.
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("items/{id}")
	public String deleteItem(@PathVariable int id) {
		superMarketDao.delete(id);
		return "Deleted";
	}
	 
	/**
	 * This method patch updates the Quantity and Date of supermarket Items.
	 * 
	 * @param partialUpdate
	 * @param id
	 * @return
	 */
	@PatchMapping("item/{id}")
	public SuperMarket patchUpdateItemById(@PathVariable int id, @Valid @RequestBody SuperMarket superMarketDetails) {
		SuperMarket superMarket = superMarketDao.findOne(id);
		superMarket.setQuantity(superMarketDetails.getQuantity());
		superMarket.setDate(superMarketDetails.getDate());
		SuperMarket updatedItem = superMarketDao.save(superMarket);

		return updatedItem;
	}
}
