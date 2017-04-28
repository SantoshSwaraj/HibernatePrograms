package co.santosh.dao;

import java.util.List;

import co.santosh.model.Product;

public interface ProductDAO {
	
	public int addProduct(Product product);

	public void updateProduct(Product product);

	public List<Product> listProduct();

	public Product getProductById(int id);

	public void removeProduct(int id);

}
