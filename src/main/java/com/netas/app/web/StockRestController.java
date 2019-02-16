package com.netas.app.web;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.netas.app.model.Role;
import com.netas.app.model.Stock;
import com.netas.app.service.api.RoleService;
import com.netas.app.service.api.StockService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/stockrest")
public class StockRestController {

	@Autowired
	private StockService stockService;
	
	@RequestMapping(method=RequestMethod.GET,value="/stocks")
	public ResponseEntity<List<Stock>> getStocks(){
		
		List<Stock> stocks = stockService.findStocks();
		return ResponseEntity.ok(stocks);
		
	}
	/*
	@RequestMapping(method = RequestMethod.GET, value = "/stock")
	public ResponseEntity<List<Stock>> getStocksByName(@RequestParam("name") String name) {
		List<Stock> stocks = stockService.findByName(name);
		return ResponseEntity.ok(stocks);
	}*/
	@RequestMapping(method = RequestMethod.GET, value = "/stock")
	public ResponseEntity<List<Stock>> getStocksByCode(@RequestParam("code") String code) {
		List<Stock> stocks = stockService.findByCode(code);
		return ResponseEntity.ok(stocks);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/stock/new")
	public ResponseEntity<URI> createRole(@RequestBody Stock stock) {
		try {
			stockService.createStock(stock);
			Long id = stock.getId();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/stock/{id}")
	public ResponseEntity<?> updateRole(@PathVariable("id") Long id, @RequestBody Stock stockRequest) {
		try {
			Stock stock = stockService.findStock(id);
			
			stock.setName(stockRequest.getName());
			stock.setCode(stockRequest.getCode());
			stock.setCreatedDate(stockRequest.getCreatedDate());
			stock.setLastModifiedDate(new Date());
			stock.setPrice(stockRequest.getPrice());
			
			stockService.updateStock(stock);
			return ResponseEntity.ok().build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
