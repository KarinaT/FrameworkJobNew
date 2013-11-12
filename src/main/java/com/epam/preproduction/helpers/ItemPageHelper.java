package com.epam.preproduction.helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.epam.preproduction.entities.Microwave;
import com.epam.preproduction.pages.CataloguePage;
import com.epam.preproduction.pages.ItemPage;

public class ItemPageHelper {

	private static CataloguePage cataloguePage;
	private static ItemPage itemPage;

	public static void setCataloguePage(CataloguePage cataloguePage,
			ItemPage itemPage) {
		ItemPageHelper.cataloguePage = cataloguePage;
		ItemPageHelper.itemPage = itemPage;
	}

//	public static Microwave grabAllCharacteristics() {
//		
//        Microwave microwave = new Microwave();
//        Map<String, String> itemMap = new HashMap<String, String>();
//
////        List<WebElement> listOfCharacteristics = itemPage.getDriver().findElements(By.className("row"));
////        System.out.println(listOfCharacteristics);
//        List<WebElement> listOfCharacteristics =  cataloguePage.getCompareBlock().getCharacteristicRow();
//        for (WebElement element : listOfCharacteristics) {
//                String charateristicName = element.findElement(By.className("pr")).getText();
//                String charateristicValue = element.findElement(By.className("val")).getText();
//                itemMap.put(charateristicName, charateristicValue);
//        }
//        microwave.setCharacteristics(itemMap);
//        return microwave;
//
//}

}
