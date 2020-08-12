package com.sss.im.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sss.im.models.InventoryDisposal;
import com.sss.im.models.InventoryDisposalItem;
import com.sss.im.models.InventoryPurchase;
import com.sss.im.models.InventoryPurchaseItem;
import com.sss.im.models.InventoryTransaction;
import com.sss.im.models.InventoryTransactionItem;
import com.sss.im.models.StoreGeneralInventory;
import com.sss.im.models.Zone;
import com.sss.im.models.ZoneGeneralInventory;
import com.sss.im.models.compositekeys.ZoneInventoryID;
import com.sss.im.repo.InventoryDisposalRepo;
import com.sss.im.repo.InventoryPurchaseRepo;
import com.sss.im.repo.InventoryTransactionRepo;
import com.sss.im.repo.StoreGeneralInventoryRepo;
import com.sss.im.repo.ZoneGeneralInventoryRepo;
import com.sss.im.repo.ZonesRepo;

@Service
public class GeneralInventoryDAO {

	@Autowired
	StoreGeneralInventoryRepo storeRepo;
	@Autowired
	ZoneGeneralInventoryRepo zoneInvRepo;
	@Autowired
	ZonesRepo zonesRepo;
	
	@Autowired
	InventoryPurchaseRepo purchaseRepo;
	@Autowired
	InventoryDisposalRepo disposalRepo;
	@Autowired
	InventoryTransactionRepo transactionRepo;
	
	
	// Listings
	
	public List<StoreGeneralInventory> getAllStoreInventory() {
		List<StoreGeneralInventory> recs = new ArrayList<>();
		storeRepo.findAll().forEach(rec->recs.add(rec));
		return recs;
	}
	
	public List<ZoneGeneralInventory> getAllZoneInventory() {
		List<ZoneGeneralInventory> recs = new ArrayList<>();
		zoneInvRepo.findAll().forEach(rec->recs.add(rec));
		return recs;
	}
	
	public List<Zone> getAllInventoryZones() {
		List<Zone> recs = new ArrayList<>();
		zonesRepo.findAll().forEach(rec->recs.add(rec));
		return recs;
	}
	
	public List<InventoryPurchase> getAllInventoryPurchases() {
		List<InventoryPurchase> recs = new ArrayList<>();
		purchaseRepo.findAll().forEach(rec->recs.add(rec));
		return recs;
	}
	
	public List<InventoryDisposal> getAllInventoryDisposal() {
		List<InventoryDisposal> recs = new ArrayList<>();
		disposalRepo.findAll().forEach(rec->recs.add(rec));
		return recs;
	}
	
	public List<InventoryTransaction> getAllInventoryTransaction() {
		List<InventoryTransaction> recs = new ArrayList<>();
		transactionRepo.findAll().forEach(rec->recs.add(rec));
		return recs;
	}
	
	// creations
	
	public Zone addInventoryZones(Zone zone) {
		Zone z = zonesRepo.save(zone);
		return z;
	}
	
	public InventoryPurchase addInventoryPurchase(InventoryPurchase inventoryPurchase) {
		//save purchase
		InventoryPurchase result =  purchaseRepo.save(inventoryPurchase);
		
		//update inventory
		List<InventoryPurchaseItem> items = inventoryPurchase.getItems();
		for(InventoryPurchaseItem item : items) {
			
			Optional<StoreGeneralInventory> temp = storeRepo.findById(item.getItemName());
			if(temp.isPresent()) {
				//update
				StoreGeneralInventory rec = temp.get();
				rec.setCount(rec.getCount() + item.getCount());
				storeRepo.save(rec);
				
			}else {
				//create new
				StoreGeneralInventory rec = new StoreGeneralInventory();
				rec.setItemName(item.getItemName());
				rec.setCount(item.getCount());
				rec.setDescription(item.getDetails());
				Date d = new Date();
				rec.setCreated(d);
				rec.setUpdated(d);
				rec.setCreatedBy("");
				rec.setUpdatedBy("");
				storeRepo.save(rec);
			}
			
		}
		return result;
		
	}
	
	public InventoryDisposal addInventoryDisposal(InventoryDisposal inventoryDisposal) {
		//save purchase
		InventoryDisposal result = disposalRepo.save(inventoryDisposal);
		
		//update inventory
		List<InventoryDisposalItem> items = inventoryDisposal.getItems();
		for(InventoryDisposalItem item : items) {
			
			Optional<StoreGeneralInventory> temp = storeRepo.findById(item.getItemName());
			if(temp.isPresent()) {
				//update
				StoreGeneralInventory rec = temp.get();
				rec.setCount(rec.getCount() - item.getCount());
				storeRepo.save(rec);
				
			}else {
				//create new
				// item doesnot exist TODO throw exception
			}
			
		}
		return result;
		
	}
	
	public InventoryTransaction addInventoryTransaction(InventoryTransaction inventoryTransaction) {
		//save purchase
		InventoryTransaction result = transactionRepo.save(inventoryTransaction);
		
		//update inventory
		List<InventoryTransactionItem> items = inventoryTransaction.getItems();
		for(InventoryTransactionItem item : items) {
			
			Optional<StoreGeneralInventory> temp = storeRepo.findById(item.getItemName());
			if(temp.isPresent()) {
				//update
				StoreGeneralInventory storeRec = temp.get();
				if(inventoryTransaction.getTransactionType().equalsIgnoreCase("outbound")) {
					storeRec.setCount(storeRec.getCount() - item.getCount());
				}else if(inventoryTransaction.getTransactionType().equalsIgnoreCase("inbound")) {
					storeRec.setCount(storeRec.getCount() + item.getCount());
				}
				
				if(inventoryTransaction.getAssignedType().equalsIgnoreCase("zone")) {
					
					Optional<ZoneGeneralInventory> tempz = zoneInvRepo.findById(new ZoneInventoryID(item.getItemName(),inventoryTransaction.getZoneName() ));
					if(tempz.isPresent()) {
						//update
						ZoneGeneralInventory recz = tempz.get();
						if(inventoryTransaction.getTransactionType().equalsIgnoreCase("inbound")) {
							recz.setCount(recz.getCount() - item.getCount());
						}else if(inventoryTransaction.getTransactionType().equalsIgnoreCase("outbound")) {
							recz.setCount(recz.getCount() + item.getCount());
						}
						zoneInvRepo.save(recz);
						
					}else {
						
						//create new
						if(inventoryTransaction.getTransactionType().equalsIgnoreCase("outbound")) {
							ZoneGeneralInventory recz = new ZoneGeneralInventory();
							recz.setItemName(item.getItemName());
							recz.setZoneName(inventoryTransaction.getZoneName());
							
							recz.setCount(item.getCount());
							recz.setCreated(new Date());
							zoneInvRepo.save(recz);
						}
						//TODO Exception
					}
				}else {
					//personal assignments ?
				}
				
				storeRepo.save(storeRec);
				
			}else {
				//create new
				//TODO Exception
			}
			
		}
		return result;
		
	}
	
}
