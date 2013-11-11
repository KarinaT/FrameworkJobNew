package com.epam.preproduction.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.preproduction.configuration.DataProviderLayer;
import com.epam.preproduction.helpers.PriceFilterTestHelper;
import com.epam.preproduction.pages.CataloguePage;

/**
 * 3. Проверить функциональность фильтра по цене (мин, макс) для категории
 * "стиральные машины". То есть, убедиться, что этот фильтр работает корректно -
 * показывает все товары, которые должны показаться и не показывает ничего
 * лишнего.
 * **/
public class CheckPriceFilterTest extends TestBase {

	CataloguePage cataloguePage;
	PriceFilterTestHelper helper;

	@BeforeMethod
	public void configurations() {
		cataloguePage = new CataloguePage(driver);
		helper = new PriceFilterTestHelper();
		helper.setCataloguePage(cataloguePage);
	}

	@Test(dataProvider = "readFromExcel", dataProviderClass = DataProviderLayer.class)
	public void testFilterPrice(String categoryName, String productType,
			double minPrice, double maxPrice) throws Exception {

		goToMainPage();
		cataloguePage.selectItemCategory(categoryName);
		cataloguePage.selectProductType(productType);
		helper.verifyPriceFilter(minPrice, maxPrice);
	}

}
