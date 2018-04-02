package com.niit.shoppingcartfrontend;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Product;
import com.niit.util.FileUtil;

@Controller
public class ProductController {
	// we need to call ProductDAO methods
	// get,save,update,delete,list

	// private static final Product Id = null;

	// 1.inject the ProductDAO and Product
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryDAO categoryDAO;

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public SupplierDAO getSupplierDAO() {
		return supplierDAO;
	}

	public void setSupplierDAO(SupplierDAO supplierDAO) {
		this.supplierDAO = supplierDAO;
	}

	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private Product product;

	@Autowired
	HttpSession httpSession;
	private String imageDirectory;

	@GetMapping("/product/get")
	public ModelAndView getProduct(@RequestParam String id) {
		product = productDAO.get(id);
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("selectedproduct", product);
		mv.addObject("isUserSelectedProduct", true);
		String rootPath = null;
		mv.addObject("selectedProductImage", rootPath + File.separator + imageDirectory + File.separator + id + ".PNG");
		return mv;

	}

	/*
	 * //http://localhost:8080/shoppingcart/product/get/cate_001
	 * //@GetMapping("/Product/get/{ID}")
	 * 
	 * @RequestMapping(name="/product/get/{ID}",method=RequestMethod.GET) public
	 * ModelAndView getProduct(@RequestParam("id") String id) { //based on id,fetch
	 * the details from productDAO product = productDAO.get(id);
	 * 
	 * //navigate to home page ModelAndView mv=new ModelAndView("home");
	 * mv.addObject("product",product); return mv;
	 * 
	 * 
	 * 
	 * }
	 * 
	 */ @PostMapping("/product/save/")

	// public ModelAndView saveProduct(@RequestParam("Id") String Id,
	// @RequestParam("Id") String name,@RequestParam("Id") String description,)

	public ModelAndView saveProduct(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("price") String price,
			@RequestParam("categoryId") String categoryId, @RequestParam("supplierId") String supplierId,@RequestParam("file") MultipartFile file) {
		// navigate to home page
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");

		product.setId(id);
		product.setName(name);
		product.setDescription(description);
		price = price.replace(",", "");
		product.setPrice(Integer.parseInt(price));
		//product.setCategoryId(categoryDAO.get(categoryId));
		//product.setSupplierId(supplierDAO.get(supplierId));
		product.setCategoryId(categoryId);
		product.setSupplierId(supplierId);

		// save into db
		if (productDAO.save(product)) {
			// add success message
			mv.addObject("productSuccessMessage", "The product created successfully");
			//call upload image method
			if(FileUtil.fileCopyNIO(file,id +".PNG"))
			{
				mv.addObject("uploadMessage","product image successfully updated");
				
			}
			else
			{
				mv.addObject("uploadMessage","could not upload image");
			}
			// fetch all the categories again

		}

		else {
			// add failure message
			mv.addObject("productErrorMessage", "could not create the product.Please contract the admin");
		}
		return mv;
	}

	@PutMapping("/product/update/")

	// public ModelAndView saveProduct(@RequestParam("Id") String Id,
	// @RequestParam("Id") String name,@RequestParam("Id") String description,)

	public ModelAndView updateProduct(@ModelAttribute Product product) {
		// navigate to home page
		ModelAndView mv = new ModelAndView("home");

		// call update method of productDAO
		if (productDAO.update(product) == true) {
			// add success message
			mv.addObject("successMessage", "The product update successfully");

		}

		else {
			// add failure message
			mv.addObject("errorMessage", "could not update the product.");
		}
		return mv;

	}

	@GetMapping("/product/delete")

	// public ModelAndView saveProduct(@RequestParam("id") String Id,
	// @RequestParam("Id") String name,@RequestParam("Id") String description,)

	public ModelAndView deleteProduct(@RequestParam String id) {
		// navigate to home page
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");

		// we supposed to fetch the latest categories
		// and add to httpSession
		// based on id,fetch the deatials from productDAO

		if (productDAO.delete(id) == true) {
			// add success message
			mv.addObject("successMessage", "The product delete successfully");

		}

		else {
			// add failuare messsage
			mv.addObject("errorMessage", "could not delete the product.");
		}
		return mv;

	}

	@GetMapping("/product/edit")
	public ModelAndView editProduct(@RequestParam String id)

	{
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		// based on product id fetch product details
		product = productDAO.get(id);
		mv.addObject("selectedProduct", product);
		httpSession.setAttribute("selectedProduct", product);
		return mv;

	}

	@GetMapping("/products")

	public ModelAndView getAllProducts() {
		ModelAndView mv = new ModelAndView("home");
		java.util.List<Product> products = productDAO.list();
		mv.addObject("products", products);
		return mv;

	}

}
