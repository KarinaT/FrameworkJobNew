package com.epam.preproduction.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.preproduction.components.FiltersBlock;
import com.epam.preproduction.components.MainBlock;
import com.epam.preproduction.components.NavigationLine;
import com.epam.preproduction.components.SortingLine;
import com.epam.preproduction.configuration.DataProviderLayer;
import com.epam.preproduction.helpers.SortingTestHelper;
import com.epam.preproduction.pages.CataloguePage;

public class SortingTest extends TestBase {

	/**
	 * 1. Написать тест, проверяющий функциональность работы сортировки (по цене
	 * и названию) для раздела «Холодильники» (сортировка справа вверху).
	 * Навигация в категорию должна быть выполнена со стартовой страницы.
	 **/

	CataloguePage cataloguePage;
	SortingTestHelper helper;
	SortingLine sortingLine;
	FiltersBlock filtersBlock;
	NavigationLine navigationLine;

	@BeforeMethod
	public void configuration() {
		cataloguePage = new CataloguePage(driver);
		helper = new SortingTestHelper();
		SortingTestHelper.setCataloguePage(cataloguePage);
	}

	@Test(dataProvider = "readFromExcel", dataProviderClass = DataProviderLayer.class)
	public void testSortingByPrice(String productType) throws Exception {

		goToMainPage();
		cataloguePage.selectProductType(productType);
		helper.verifySortingItemsByPrices();

	}

	@Test(dataProvider = "readFromExcel", dataProviderClass = DataProviderLayer.class)
	public void testSortingByName(String productType) throws Exception {
		goToMainPage();
		cataloguePage.selectProductType(productType);
		helper.verifySortingItemsByNames();

	}

}
