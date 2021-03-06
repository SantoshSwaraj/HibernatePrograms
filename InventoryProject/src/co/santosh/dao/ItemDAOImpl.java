package co.santosh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.santosh.model.Item;

@Repository
public class ItemDAOImpl implements ItemDAO{
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(readOnly=false)
	public int addItem(Item item) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(item);
		System.out.println("Item Saved Successfully..");
		return item.getId();
	}

	@Override
	@Transactional(readOnly=false)
	public void updateItem(Item item) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(item);
		System.out.println("Item Updated Successfully..");
	}

	@Override
	@Transactional(readOnly=true)
	public List<Item> listItem() {
		Session session  = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Item> itemList = session.createQuery("from Item").list();
		System.out.println("Item List Returned..");
		return itemList;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Item> listProductItem(int productId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Item> listProductItem = (List<Item>) session.createCriteria(List.class).add(Restrictions.eq("productId.id", productId)).list();
		return listProductItem;
	}

	@Override
	@Transactional(readOnly=true)
	public Item getItemById(int id) {
		Session session  = this.sessionFactory.getCurrentSession();
		Item item = (Item)session.get(List.class, id);
		System.out.println("Item Loaded Successfully..");
		return item;
	}

	@Override
	@Transactional(readOnly=false)
	public void removeItem(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Item item = (Item)session.load(Item.class, new Integer(id));
		session.delete(item);
		System.out.println("Item deleted Succesfully..");	
	}

}
