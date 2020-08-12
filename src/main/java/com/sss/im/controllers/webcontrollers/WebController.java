package com.sss.im.controllers.webcontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.AutoPopulatingList;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sss.im.dao.GeneralInventoryDAO;
import com.sss.im.models.InventoryDisposal;
import com.sss.im.models.InventoryDisposalItem;
import com.sss.im.models.InventoryPurchase;
import com.sss.im.models.InventoryPurchaseItem;
import com.sss.im.models.InventoryTransaction;
import com.sss.im.models.InventoryTransactionItem;
import com.sss.im.models.Zone;

@Controller
@RequestMapping("/")
public class WebController {
	
	
	@Autowired
	GeneralInventoryDAO giDAO; 
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getHomePage(){
		return "imhome";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/imhome")
	public String getIMHomePage(){
		return "imhome";
	}
	
	
	///////////////////////////////////////////////////////////////////////
	
	//list inventory
	@GetMapping("/list-inventory")
	public String allInventory(HttpServletRequest request){
		request.setAttribute("storeinv", giDAO.getAllStoreInventory());
		return "list-inventory";
	}
	
	//list inventory
		@GetMapping("/list-zoneinventory")
		public String allZonalInventory(HttpServletRequest request){
			request.setAttribute("zoneinv", giDAO.getAllZoneInventory());
			return "list-zoneinventory";
		}
	
	
	//list zones
	@GetMapping("/list-zones")
	public String allZones(HttpServletRequest request){
		request.setAttribute("zones", giDAO.getAllInventoryZones());
		return "list-zones";
	}
	//add zone
	@GetMapping("/add-zone")
	public String newZone(HttpServletRequest request){
		request.setAttribute("zone", new Zone());
		return "add-zone";
	}
	@PostMapping("/add-zone")
	public String saveZone(@ModelAttribute Zone zone, BindingResult bindingResult, HttpServletRequest request){
		Zone r = giDAO.addInventoryZones(zone);
		System.out.println("WebController.saveZone()"+r);
		request.setAttribute("zones", giDAO.getAllInventoryZones());
		return "list-zones";
	}
	
	
	//list purchases
	@GetMapping("/list-purchase")
	public String allPurchases(HttpServletRequest request){
		request.setAttribute("purchases", giDAO.getAllInventoryPurchases());
		return "list-purchase";
	}
	// add purchase
	@GetMapping("/add-purchase")
	public String newPurchase(HttpServletRequest request){
		InventoryPurchase invP = new InventoryPurchase();
		invP.setItems(new AutoPopulatingList<InventoryPurchaseItem>(InventoryPurchaseItem.class));
		request.setAttribute("purchase", invP);
		return "add-purchase";
	}
	
	@PostMapping("/add-purchase")
	public String savePurchase(@ModelAttribute InventoryPurchase purchase, BindingResult bindingResult, HttpServletRequest request){
		System.out.println("WebController.savePurchase()" + purchase) ;
		System.out.println("WebController.savePurchase()" + purchase.getItems().size()) ;
		System.out.println("WebController.savePurchase()" + purchase.getItems()) ;
		System.out.println("WebController.savePurchase()" + bindingResult) ;
	
		giDAO.addInventoryPurchase(purchase);
		request.setAttribute("storeinv", giDAO.getAllStoreInventory());
		return "list-inventory";
	}
	
	
	//list transactions
	@GetMapping("/list-transaction")
	public String allTransactions(HttpServletRequest request){
		request.setAttribute("transactions", giDAO.getAllInventoryTransaction());
		return "list-transaction";
	}
	// add transaction
	@GetMapping("/add-transaction")
	public String newTransaction(HttpServletRequest request){
		InventoryTransaction i = new InventoryTransaction();
		i.setItems(new AutoPopulatingList<InventoryTransactionItem>(InventoryTransactionItem.class));
		request.setAttribute("transaction", i);
		return "add-transaction";
	}
	
	@PostMapping("/add-transaction")
	public String saveTransaction(@ModelAttribute InventoryTransaction transaction, BindingResult bindingResult, HttpServletRequest request){
		System.out.println("WebController.saveTransaction()" + transaction) ;
		System.out.println("WebController.saveTransaction()" + transaction.getItems().size()) ;
		System.out.println("WebController.saveTransaction()" + transaction.getItems()) ;
		System.out.println("WebController.saveTransaction()" + bindingResult) ;
		
		giDAO.addInventoryTransaction(transaction);
		request.setAttribute("storeinv", giDAO.getAllStoreInventory());
		return "list-inventory";
	}
	
	
	//list disposals
	@GetMapping("/list-disposal")
	public String allDisposals(HttpServletRequest request){
		request.setAttribute("disposals", giDAO.getAllInventoryDisposal());
		return "list-disposal";
	}
	
	// add disposal
	@GetMapping("/add-disposal")
	public String newDisposal(HttpServletRequest request){
		InventoryDisposal i = new InventoryDisposal();
		i.setItems(new AutoPopulatingList<InventoryDisposalItem>(InventoryDisposalItem.class));
		request.setAttribute("disposal", i);
		return "add-disposal";
	}
	
	@PostMapping("/add-disposal")
	public String saveDisposal(@ModelAttribute InventoryDisposal disposal, BindingResult bindingResult, HttpServletRequest request){
		System.out.println("WebController.saveDisposal()" + disposal) ;
		System.out.println("WebController.saveDisposal()" + disposal.getItems().size()) ;
		System.out.println("WebController.saveDisposal()" + disposal.getItems()) ;
		System.out.println("WebController.saveDisposal()" + bindingResult) ;
		
		giDAO.addInventoryDisposal(disposal);
		request.setAttribute("storeinv", giDAO.getAllStoreInventory());
		return "list-inventory";
	}
	
}
