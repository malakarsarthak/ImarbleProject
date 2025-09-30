package com.it.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.entities.Product;
import com.it.repository.ProductRepository;


@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "") //For Frontend
public class ProductController
{
   @Autowired
   private ProductRepository productRepository;
   
   //Get All Products
   @GetMapping
   public List<Product> getAllProducts()
   {
	   return productRepository.findAll();
   }
   
   //Get Product By Id
   @GetMapping("/{id}")
   public Optional<Product> getProductById(@PathVariable Integer id)
   {
	   return productRepository.findById(id);
   }

   //Add Product
   @PostMapping
   public Product addProduct(@RequestBody Product product)
   {
	   return productRepository.save(product);
   }
   
   //Update Product
   @PutMapping("/{id}")
   public Product updateProduct(@PathVariable Integer id,@RequestBody Product product)
   {
	   Optional<Product> prod = productRepository.findById(id);
	   if(prod.isPresent())
	   {
		   Product pr = prod.get();
		   pr.setModelNumber(product.getModelNumber());
		   pr.setUnit(product.getUnit());
		   pr.setDescription(product.getDescription());
		   pr.setPriceperUnit(product.getPriceperUnit());
		   pr.setMinStockLevel(product.getMinStockLevel());
		   

		   if (product.getCategoryId() != null && product.getCategoryId().getCatId() != null) {
			   pr.setCategoryId(product.getCategoryId());
		   }
		   if (product.getSubCategory() != null && product.getSubCategory().getSubCatId() != null) {
			   pr.setSubCategory(product.getSubCategory());
		   }
		   if (product.getBrand() != null && product.getBrand().getBrandId() != null) {
			   pr.setBrand(product.getBrand());
		   }
		   return productRepository.save(pr);
	   }
	   else
	   {
		  return null;
	   }
   } 
   //Delete Product
   @DeleteMapping("/{id}")
   public String deleteProduct(@PathVariable Integer id)
   {
	   productRepository.deleteById(id);
	   return "Product deleted By Id " + id;
   }
}
