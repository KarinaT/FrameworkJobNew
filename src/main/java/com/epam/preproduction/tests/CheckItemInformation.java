package com.epam.preproduction.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.preproduction.configuration.DataProviderLayer;
import com.epam.preproduction.helpers.CheckItemInformationTestHelper;
import com.epam.preproduction.pages.CataloguePage;
import com.epam.preproduction.pages.ItemPage;
import com.epam.preproduction.pages.PricePage;

public class CheckItemInformation extends TestBase {

	CataloguePage cataloguePage;
	PricePage pricePage;
	ItemPage itemPage;
	CheckItemInformationTestHelper helper;

	@BeforeMethod
	public void configuration() {
		cataloguePage = new CataloguePage(driver);
		pricePage = new PricePage(driver);
		itemPage = new ItemPage(driver);
		helper = new CheckItemInformationTestHelper();
		CheckItemInformationTestHelper.setPages(cataloguePage, pricePage, itemPage);
	}

	@Test(dataProvider = "readFromExcel", dataProviderClass = DataProviderLayer.class)
	public void testItemInformation(String productType) throws Exception {

		goToMainPage();
		cataloguePage.selectProductType(productType);
		//pricePage.verifyItemLinksAreEqual();
		helper.verifyItemLinksAreEqual();
	}

}
