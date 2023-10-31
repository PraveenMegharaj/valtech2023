package com.valtech.training.ratingui;

import junit.framework.Assert;
import junit.framework.TestCase;
 
public class RatingHelperTest extends TestCase {
	public void testGetRating() {
		RatingHelper helper=new RatingHelper();
		Assert.assertEquals(0,helper.getRating("9900135729"));
	}
}