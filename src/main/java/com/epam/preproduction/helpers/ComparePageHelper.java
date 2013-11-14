package com.epam.preproduction.helpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.epam.preproduction.entities.Microwave;
import com.epam.preproduction.pages.CataloguePage;

public class ComparePageHelper {

	private static CataloguePage cataloguePage;

	public static void setCataloguePage(CataloguePage cataloguePage) {
		ComparePageHelper.cataloguePage = cataloguePage;
	}

	public List<Microwave> grabAllParams() {
		List<Microwave> microwaves = new ArrayList<Microwave>();
		Microwave microwave1 = new Microwave();
		Microwave microwave2 = new Microwave();
		microwaves.add(microwave1);
		microwaves.add(microwave2);

		List<WebElement> comparePageCharacteristics = cataloguePage
				.getCompareBlock().getTableClassCompare();
		for (WebElement element : comparePageCharacteristics) {
			String characteristicName = cataloguePage.getCompareBlock()
					.getTdCompare1().getText();
			String firstItemValues = cataloguePage.getCompareBlock()
					.getTdCompare2().getText();
			String secondItemValues = cataloguePage.getCompareBlock()
					.getTdCompare3().getText();
			microwave1.getCharacteristics().put(characteristicName,
					firstItemValues);
			microwave2.getCharacteristics().put(characteristicName,
					secondItemValues);
		}
		return microwaves;
	}

//	public static Set<String> grabAllParamNames() {
//		Set<String> characteristicsNames = new HashSet<String>();
//
//		//List<WebElement> comparePageCharacteristics = comparePage.getDriver().findElements(By.xpath(cataloguePage.getCompareBlock().TABLE_CLASS_COMPARE));
//		List<WebElement> comparePageCharacteristics = cataloguePage.getCompareBlock().getTableClassCompare();
//		for (WebElement element : comparePageCharacteristics) {
//			String characteristicName = cataloguePage.getCompareBlock().getTdCompare1().getText();
//			characteristicsNames.add(characteristicName);
//		}
//		comparePageCharacteristics = cataloguePage.getCompareBlock().getTableClassDifferent();
//		for (WebElement element : comparePageCharacteristics) {
//			String characteristicName = cataloguePage.getCompareBlock().getTdCompare1().getText();
//			characteristicsNames.add(characteristicName);
//		}
//		return characteristicsNames;
//	}
}
