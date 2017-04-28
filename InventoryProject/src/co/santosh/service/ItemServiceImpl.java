package co.santosh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.santosh.dao.ItemDAO;
import co.santosh.model.Item;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDAO itemDAO;
	

	@Override
	public int addItem(Item item) {
		return itemDAO.addItem(item);
	}

	@Override
	public void updateItem(Item item) {
		itemDAO.updateItem(item);
	}

	@Override
	public List<Item> listItem() {
		return itemDAO.listItem();
	}

	@Override
	public List<Item> listProductItem(int productId) {
		return itemDAO.listProductItem(productId);
	}

	@Override
	public Item getItemById(int id) {
		return itemDAO.getItemById(id);
	}

	@Override
	public void removeItem(int id) {
		itemDAO.removeItem(id);
	}

}
