package com.valetch.training.mobile.rating.ui;

import com.valtech.training.mobileranking.MobileRankingService;
import com.valtech.training.mobileranking.MobileRankingServiceImpl;

public class RatingHelper {
	
	private MobileRankingService mobileRankingService = new MobileRankingServiceImpl();
	public int getRanking(String mobile) {
		return mobileRankingService.rankMobile(mobile);
	}

}
