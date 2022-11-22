package com.sdk.service;

import java.util.List;

import com.sdk.domain.Market;

public interface MarketService {
	List<Market> getAllMarket();
	Market findMarketById(Integer id);
	void saveMarket(Market market);
	void updateMarket(Market market);
	void deleteMarket(Integer id);
}
