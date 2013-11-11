package com.epam.preproduction.helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.epam.preproduction.entities.Microwave;
import com.epam.preproduction.pages.CataloguePage;

public class ItemPageHelper {

	private static CataloguePage cataloguePage;

	public static void setCataloguePage(CataloguePage cataloguePage) {
		ItemPageHelper.cataloguePage = cataloguePage;
	}

	public static Microwave grabAllCharacteristics() {
		Microwave microwave = new Microwave();
		Map<String, String> itemMap = new HashMap<String, String>();

		List<WebElement> listOfCharacteristics = cataloguePage
				.getCompareBlock().getCharacteristicRow();
		for (WebElement element : listOfCharacteristics) {
			String charateristicName = cataloguePage.getCompareBlock()
					.getCharacteristicType().getText();
			String charateristicValue = cataloguePage.getCompareBlock()
					.getCharacteristicValue().getText();
			itemMap.put(charateristicName, charateristicValue);
		}
		microwave.setCharacteristics(itemMap);
		return microwave;
	}

}
