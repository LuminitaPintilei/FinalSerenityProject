package org.fasttrack.pages;

import net.serenitybdd.core.pages.PageObject;

public class BasePage extends PageObject {

    public int getIntPriceFromPrice(String priceNonFormatted){
        return Integer.parseInt(priceNonFormatted
                .replace(",", "")
                .replace("lei", "")
                .replace("FREE", "0")
                .replace("Total", "0")
                .replace(".","").trim());


    }
}
