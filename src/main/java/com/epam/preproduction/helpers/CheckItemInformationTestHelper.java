package com.epam.preproduction.helpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.epam.preproduction.pages.CataloguePage;
import com.epam.preproduction.pages.ItemPage;
import com.epam.preproduction.pages.PricePage;

public class CheckItemInformationTestHelper {
	private static CataloguePage cataloguePage;
	private static PricePage pricePage;
	private static ItemPage itemPage;

	public static ItemPage getItemPage() {
		return itemPage;
	}

	public static void setItemPage(ItemPage itemPage) {
		CheckItemInformationTestHelper.itemPage = itemPage;
	}

	public static CataloguePage getCataloguePage() {
		return cataloguePage;
	}

	public static void setCataloguePage(CataloguePage cataloguePage) {
		CheckItemInformationTestHelper.cataloguePage = cataloguePage;
	}

	public static PricePage getPricePage() {
		return pricePage;
	}

	public static void setPricePage(PricePage pricePage) {
		CheckItemInformationTestHelper.pricePage = pricePage;
	}

	public static void setPages(CataloguePage cataloguePage,
			PricePage pricePage, ItemPage itemPage) {
		CheckItemInformationTestHelper.cataloguePage = cataloguePage;
		CheckItemInformationTestHelper.pricePage = pricePage;
		CheckItemInformationTestHelper.itemPage = itemPage;

	}

	// public List<String> gerUrls() {
	// List<String> catalogueUrls = new ArrayList<String>();
	// // List<String> namesList = new ArrayList<String>();
	// for (int i = 0; i < 5; i++) {
	// List<WebElement> names = cataloguePage.getCompareBlock()
	// .getItemsToCompare();
	// String hrefs = names.get(i).getAttribute("href");
	// // String itemName = names.get(i).getText();
	// // System.out.println(itemName);
	// System.out.println(names);
	// catalogueUrls.add(hrefs);
	// // namesList.add(itemName);
	// }
	// System.out.println(catalogueUrls);
	// return catalogueUrls;
	//
	// }
	//
	// public List<String> getItemUrls() {
	// List<String> urlList = new ArrayList<String>();
	// for (int i = 0; i < 5; i++) {
	// cataloguePage.getCompareBlock().getProductToCompare().click();
	// urlList.add((i), itemPage.getCurrentLinks());
	// cataloguePage.goBack();
	// cataloguePage.refreshLocators();
	//
	// }
	// System.out.println(urlList);
	// return urlList;
	//
	// }
	//
	// public Set<String> goToPricePage() {
	// Set<String> pricePageLinks = new HashSet<String>();
	// cataloguePage.getCompareBlock().getPricePageLink().click();
	// List<String> namesList = new ArrayList<String>();
	// for (int i = 0; i < 5; i++) {
	// List<WebElement> names =
	// cataloguePage.getDriver().findElements(By.xpath("//div[@class='item']["
	// +(i+1) + "]/div/a"));
	// for (WebElement webElement : names) {
	// String itemNames = webElement.getText();
	// namesList.add(itemNames);
	// }
	// }
	// // for (int i = 0; i < 5; i++) {
	// // List<WebElement> names =
	// // cataloguePage.getCompareBlock().getItemsToCompare();
	// // String itemName = names.get(i+1).getText();
	// // namesList.add(itemName);
	// // System.out.println(namesList);
	// // }
	//
	// for (int j = 0; j < namesList.size(); j++) {
	// cataloguePage.getCompareBlock().getEditField()
	// .sendKeys(namesList.get(j));
	// cataloguePage.getCompareBlock().getSearchField().click();
	//
	// List<WebElement> linkToDescription = cataloguePage
	// .getCompareBlock().getTdPricePage();
	//
	// for (WebElement webElement : linkToDescription) {
	// String hrefs = webElement.getAttribute("href");
	// pricePageLinks.add(hrefs);
	//
	// }
	// cataloguePage.getCompareBlock().getEditField().clear();
	//
	// }
	// return pricePageLinks;
	// }
	//
	// public void verifyItemLinksAreEqual() {
	//
	// List<String> catalogueUrls = gerUrls();
	// // List<String> urlList = getItemUrls();
	// Set<String> pricePageLinks = goToPricePage();
	// System.out.println(goToPricePage());
	// System.out.println(catalogueUrls);
	// // System.out.println(urlList);
	// System.out.println(pricePageLinks);
	// // Assert.assertEquals(catalogueUrls, urlList);
	// Assert.assertEquals(catalogueUrls, pricePageLinks,
	// "Some links are shown in search results by mistake! ");
	// }
	public void verifyItemLinksAreEqual() {
		List<String> data = new ArrayList<String>();
		List<String> pricesLinks = new ArrayList<String>();
		List<String> namesList = new ArrayList<String>();
		List<String> catalogueLinks = new ArrayList<String>(); 
		List<String> pricePageLinks = new ArrayList<String>();
		gerUrls(data, pricesLinks);
		goToPricePage(namesList);
		Assert.assertEquals(catalogueLinks, pricePageLinks, "Some links are shown in search results by mistake! ");
		System.out.println();
	}

	public void gerUrls(List<String> catalogueLinks, List<String> pricePageLinks) {

		List<String> urlList = new ArrayList<String>();
		List<String> namesList = new ArrayList<String>();

		for (int i = 1; i < 6; i++) {
			List<WebElement> names = cataloguePage.getDriver().findElements(
					By.xpath("//div[@class='item'][" + i + "]/div/a"));
			// getting catalogue links
			for (WebElement webElement : names) {
				String hrefs = webElement.getAttribute("href");
				String itemNames = webElement.getText();
				namesList.add(itemNames);
				catalogueLinks.add(hrefs);
			}
			// visiting every item page
			cataloguePage
					.getDriver()
					.findElement(
							By.xpath("//div[@class='item'][" + i + "]/div/a"))
					.click();
			// PageFactory.initElements(getDriver(), ItemPage.class);
			urlList.add(i - 1, itemPage.getDriver().getCurrentUrl());
			cataloguePage.goBack();
			cataloguePage.refreshLocators();
			// comparing lists of links
//			Assert.assertEquals(catalogueLinks, urlList);


		}

		System.out.println(namesList);
		System.out.println(catalogueLinks);
		System.out.println(urlList);
		System.out.println(goToPricePage(namesList));

	}

	public Set<String> goToPricePage(List<String> namesList) {
		// go to price page
		// List<String> pricePageLinks = new ArrayList<String>();
		Set<String> pricePageLinks = new HashSet<String>();
		//cataloguePage.getDriver().findElement(By.xpath("//div[@class='links-bar']/div[@class='link']/a")).click();
		cataloguePage.getCompareBlock().getPricePageLink().click();
		for (int j = 0; j < namesList.size(); j++) {
			pricePage.getDriver().findElement(By.id("edit-name-1"))
					.sendKeys(namesList.get(j));
			pricePage.getDriver().findElement(By.id("edit-submit-1")).click();

			List<WebElement> linkToDescription = pricePage.getDriver()
					.findElements(By.xpath("//td[@class='n']/a[1]"));

			// getting catalogue links
			for (WebElement webElement : linkToDescription) {
				String hrefs = webElement.getAttribute("href");
				pricePageLinks.add(hrefs);

			}
			pricePage.getDriver().findElement(By.id("edit-name-1")).clear();

		}
		return pricePageLinks;
	}
}
