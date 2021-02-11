package com.rakuten.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.domain.Product;


@Service
public class ProductServiceImpl implements ProductService{
	
	ProductDAO dao; // = new ProductDAOInMemImpl();
	
	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public int createNewProduct(Product toBeCreated) {
		
		if(toBeCreated.getPrice()*toBeCreated.getQoh() >= 10000) {
			Product created = dao.save(toBeCreated);
			return created.getId()
;		}
		else {
			throw new IllegalArgumentException("product not worth 10k");
		}
	}

	@Override
	public void removeExisting(int id) {
		Product existing = dao.findById(id);
		
		if (existing == null) {
			throw new IllegalArgumentException("product now found");
		}
		
		if(existing.getPrice() * existing.getQoh() >= 100000) {
			throw new IllegalArgumentException("cant delete, product worhtmoreth than 100k");
		}
		
		dao.deleteById(id);
	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}

	

}
