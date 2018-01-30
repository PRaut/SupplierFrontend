package com.supp.SupplierFrontEnd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.supp.SupplierBackend.Dao.SupplierDao;
import com.supp.SupplierBackend.DaoImpl.SupplierDaoImpl;
import com.supp.SupplierBackend.model.Supplier;

@Controller
public class PageController {

	private SupplierDao supplierDao;
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("pageTitle", "Supplier Registration Form");
		mv.addObject("Supplier", new Supplier());
		return mv;
	}

	@RequestMapping(value = { "/addSupplier" }, method = RequestMethod.POST)
	public ModelAndView addSupplier(@ModelAttribute("supplier") Supplier supplier, BindingResult result, ModelMap model) {
		System.out.println("In addSupplier() user: "+ supplier.getSupplierName());
		
		ModelAndView mv;
		supplierDao = new SupplierDaoImpl();
		
		if(result.hasErrors()){
			mv = new ModelAndView("error");
			return mv;
		}else{
			supplierDao.insertSupp(supplier);
			mv = new ModelAndView("viewSupplier");
			return mv;
		}
	}
}
