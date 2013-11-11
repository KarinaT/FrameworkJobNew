package com.epam.preproduction.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.preproduction.configuration.DataProviderLayer;
import com.epam.preproduction.helpers.FilterParameterTestHelper;
import com.epam.preproduction.pages.CataloguePage;

/*
 * 5. Проверить корректность работы фильтра «регулировка веса» у хлебопечек, а
 * именно: проверить, что, выбрав наличие функции "регулировка веса" в фильтре,
 * результаты показываются правильно (показываются все товары, у которых есть
 * эта функция, и не показывается ничего лишнего)
 */
public class CheckFilterParameters extends TestBase {

	CataloguePage cataloguePage;
	FilterParameterTestHelper helper;

	@BeforeMethod
	public void configuration() {
		cataloguePage = new CataloguePage(driver);
		helper = new FilterParameterTestHelper();
		FilterParameterTestHelper.setCataloguePage(cataloguePage);
	}

	@Test(dataProvider = "readFromExcel", dataProviderClass = DataProviderLayer.class)
	public void testFilterParameter(String productType, String searchParameter)
			throws Exception {

		goToMainPage();
		cataloguePage.selectProductType(productType);
		cataloguePage.clickAtFilterParameter(searchParameter);

	}

	@Test(dataProvider = "readFromExcel", dataProviderClass = DataProviderLayer.class)
	public void testFilterByProducer(String productType) throws Exception {

		goToMainPage();
		cataloguePage.selectProductType(productType);
		helper.verifyManufacturerInNames();
	}

}
