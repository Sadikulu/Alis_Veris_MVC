package com.sdk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdk.domain.Market;
import com.sdk.exception.ResourceNotFoundException;
import com.sdk.repository.MarketRepository;

@Component
public class MarketServiceImpl implements MarketService{

	@Autowired
	private MarketRepository marketRepository;
	
	@Override
	public List<Market> getAllMarket() {
		return marketRepository.getAll();
	}

	@Override
	public Market findMarketById(Integer id) {
		return marketRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Market not found with id:"+id));
	}

	@Override
	public void saveMarket(Market market) {
		marketRepository.save(market);	
	}

	@Override
	public void updateMarket(Market market) {
		marketRepository.update(market);	
	}

	@Override
	public void deleteMarket(Integer id) {
		marketRepository.delete(id);
	}
}
