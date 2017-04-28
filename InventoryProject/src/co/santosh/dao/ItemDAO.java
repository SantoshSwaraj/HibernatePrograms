package co.santosh.dao;

import java.util.List;

import co.santosh.model.Item;

public interface ItemDAO {
	
	public int addItem(Item item);

	public void updateItem(Item item);

	public List<Item> listItem();

	public List<Item> listProductItem(int productId);
	
	public Item getItemById(int id);

	public void removeItem(int id);


}
