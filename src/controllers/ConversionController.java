package controllers;

import java.rmi.RemoteException;
import java.util.Map;
import java.util.TreeMap;

import webservice.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ConversionController {

	public static  void setCurrencies(HttpServletRequest request) {
		Map<String, String> currencyMap = new TreeMap<String, String>();
		HttpSession sessionCurrency = request.getSession();

		currencyMap.put("AFA", "AFA-Afghanistan Afghani");
		currencyMap.put("ALL", "ALL-Albanian Lek");
		currencyMap.put("DZD", "DZD-Algerian Dinar");
		currencyMap.put("ARS", "ARS-Argentine Peso");
		currencyMap.put("AWG", "AWG-Aruba Florin");
		currencyMap.put("AUD", "AUD-Australian Dollar");
		currencyMap.put("BSD", "BSD-Bahamian Dollar");
		currencyMap.put("BHD", "BHD-Bahraini Dinar");
		currencyMap.put("BDT", "BDT-Bangladesh Taka");
		currencyMap.put("BBD", "BBD-Barbados Dollar");
		currencyMap.put("BZD", "BZD-Belize Dollar");
		currencyMap.put("BMD", "BMD-Bermuda Dollar");
		currencyMap.put("BTN", "BTN-Bhutan Ngultrum");
		currencyMap.put("BOB", "BOB-Bolivian Boliviano");
		currencyMap.put("BWP", "BWP-Botswana Pula");
		currencyMap.put("BRL", "BRL-Brazilian Real");
		currencyMap.put("GBP", "GBP-British Pound");
		currencyMap.put("BND", "BND-Brunei Dollar");
		currencyMap.put("BIF", "BIF-Burundi Franc");
		currencyMap.put("XOF", "XOF-CFA Franc (BCEAO)");
		currencyMap.put("XAF", "XAF-CFA Franc (BEAC)");
		currencyMap.put("KHR", "KHR-Cambodia Riel");
		currencyMap.put("CAD", "CAD-Canadian Dollar");
		currencyMap.put("CVE", "CVE-Cape Verde Escudo");
		currencyMap.put("KYD", "KYD-Cayman Islands Dollar");
		currencyMap.put("CLP", "CLP-Chilean Peso");
		currencyMap.put("CNY", "CNY-Chinese Yuan");
		currencyMap.put("COP", "COP-Colombian Peso");
		currencyMap.put("KMF", "KMF-Comoros Franc");
		currencyMap.put("CRC", "CRC-Costa Rica Colon");
		currencyMap.put("HRK", "HRK-Croatian Kuna");
		currencyMap.put("CUP", "CUP-Cuban Peso");
		currencyMap.put("CYP", "CYP-Cyprus Pound");
		currencyMap.put("CZK", "CZK-Czech Koruna");
		currencyMap.put("DKK", "DKK-Danish Krone");
		currencyMap.put("DJF", "DJF-Dijibouti Franc");
		currencyMap.put("DOP", "DOP-Dominican Peso");
		currencyMap.put("XCD", "XCD-East Caribbean Dollar");
		currencyMap.put("EGP", "EGP-Egyptian Pound");
		currencyMap.put("SVC", "SVC-El Salvador Colon");
		currencyMap.put("EEK", "EEK-Estonian Kroon");
		currencyMap.put("ETB", "ETB-Ethiopian Birr");
		currencyMap.put("EUR", "EUR-Euro");
		currencyMap.put("FKP", "FKP-Falkland Islands Pound");
		currencyMap.put("GMD", "GMD-Gambian Dalasi");
		currencyMap.put("GHC", "GHC-Ghanian Cedi");
		currencyMap.put("GIP", "GIP-Gibraltar Pound");
		currencyMap.put("XAU", "XAU-Gold Ounces");
		currencyMap.put("GTQ", "GTQ-Guatemala Quetzal");
		currencyMap.put("GNF", "GNF-Guinea Franc");
		currencyMap.put("GYD", "GYD-Guyana Dollar");
		currencyMap.put("HTG", "HTG-Haiti Gourde");
		currencyMap.put("HNL", "HNL-Honduras Lempira");
		currencyMap.put("HKD", "HKD-Hong Kong Dollar");
		currencyMap.put("HUF", "HUF-Hungarian Forint");
		currencyMap.put("ISK", "ISK-Iceland Krona");
		currencyMap.put("INR", "INR-Indian Rupee");
		currencyMap.put("IDR", "IDR-Indonesian Rupiah");
		currencyMap.put("IQD", "IQD-Iraqi Dinar");
		currencyMap.put("ILS", "ILS-Israeli Shekel");
		currencyMap.put("JMD", "JMD-Jamaican Dollar");
		currencyMap.put("JPY", "JPY-Japanese Yen");
		currencyMap.put("JOD", "JOD-Jordanian Dinar");
		currencyMap.put("KZT", "KZT-Kazakhstan Tenge");
		currencyMap.put("KES", "KES-Kenyan Shilling");
		currencyMap.put("KRW", "KRW-Korean Won");
		currencyMap.put("KWD", "KWD-Kuwaiti Dinar");
		currencyMap.put("LAK", "LAK-Lao Kip");
		currencyMap.put("LVL", "LVL-Latvian Lat");
		currencyMap.put("LBP", "LBP-Lebanese Pound");
		currencyMap.put("LSL", "LSL-Lesotho Loti");
		currencyMap.put("LRD", "LRD-Liberian Dollar");
		currencyMap.put("LYD", "LYD-Libyan Dinar");
		currencyMap.put("LTL", "LTL-Lithuanian Lita");
		currencyMap.put("MOP", "MOP-Macau Pataca");
		currencyMap.put("MKD", "MKD-Macedonian Denar");
		currencyMap.put("MGF", "MGF-Malagasy Franc");
		currencyMap.put("MWK", "MWK-Malawi Kwacha");
		currencyMap.put("MYR", "MYR-Malaysian Ringgit");
		currencyMap.put("MVR", "MVR-Maldives Rufiyaa");
		currencyMap.put("MTL", "MTL-Maltese Lira");
		currencyMap.put("MRO", "MRO-Mauritania Ougulya");
		currencyMap.put("MUR", "MUR-Mauritius Rupee");
		currencyMap.put("MXN", "MXN-Mexican Peso");
		currencyMap.put("MDL", "MDL-Moldovan Leu");
		currencyMap.put("MNT", "MNT-Mongolian Tugrik");
		currencyMap.put("MAD", "MAD-Moroccan Dirham");
		currencyMap.put("MZM", "MZM-Mozambique Metical");
		currencyMap.put("MMK", "MMK-Myanmar Kyat");
		currencyMap.put("NAD", "NAD-Namibian Dollar");
		currencyMap.put("NPR", "NPR-Nepalese Rupee");
		currencyMap.put("ANG", "ANG-Neth Antilles Guilder");
		currencyMap.put("NZD", "NZD-New Zealand Dollar");
		currencyMap.put("NIO", "NIO-Nicaragua Cordoba");
		currencyMap.put("NGN", "NGN-Nigerian Naira");
		currencyMap.put("KPW", "KPW-North Korean Won");
		currencyMap.put("NOK", "NOK-Norwegian Krone");
		currencyMap.put("OMR", "OMR-Omani Rial");
		currencyMap.put("XPF", "XPF-Pacific Franc");
		currencyMap.put("PKR", "PKR-Pakistani Rupee");
		currencyMap.put("XPD", "XPD-Palladium Ounces");
		currencyMap.put("PAB", "PAB-Panama Balboa");
		currencyMap.put("PGK", "PGK-Papua New Guinea Kina");
		currencyMap.put("PYG", "PYG-Paraguayan Guarani");
		currencyMap.put("PEN", "PEN-Peruvian Nuevo Sol");
		currencyMap.put("PHP", "PHP-Philippine Peso");
		currencyMap.put("XPT", "XPT-Platinum Ounces");
		currencyMap.put("PLN", "PLN-Polish Zloty");
		currencyMap.put("QAR", "QAR-Qatar Rial");
		currencyMap.put("ROL", "ROL-Romanian Leu");
		currencyMap.put("RUB", "RUB-Russian Rouble");
		currencyMap.put("WST", "WST-Samoa Tala");
		currencyMap.put("STD", "STD-Sao Tome Dobra");
		currencyMap.put("SAR", "SAR-Saudi Arabian Riyal");
		currencyMap.put("SCR", "SCR-Seychelles Rupee");
		currencyMap.put("SLL", "SLL-Sierra Leone Leone");
		currencyMap.put("XAG", "XAG-Silver Ounces");
		currencyMap.put("SGD", "SGD-Singapore Dollar");
		currencyMap.put("SKK", "SKK-Slovak Koruna");
		currencyMap.put("SIT", "SIT-Slovenian Tolar");
		currencyMap.put("SBD", "SBD-Solomon Islands Dollar");
		currencyMap.put("SOS", "SOS-Somali Shilling");
		currencyMap.put("ZAR", "ZAR-South African Rand");
		currencyMap.put("LKR", "LKR-Sri Lanka Rupee");
		currencyMap.put("SHP", "SHP-St Helena Pound");
		currencyMap.put("SDD", "SDD-Sudanese Dinar");
		currencyMap.put("SRG", "SRG-Surinam Guilder");
		currencyMap.put("SZL", "SZL-Swaziland Lilageni");
		currencyMap.put("SEK", "SEK-Swedish Krona");
		currencyMap.put("CHF", "CHF-Swiss Franc");
		currencyMap.put("SYP", "SYP-Syrian Pound");
		currencyMap.put("TRY", "TRY-Turkey Lira");
		currencyMap.put("TWD", "TWD-Taiwan Dollar");
		currencyMap.put("TZS", "TZS-Tanzanian Shilling");
		currencyMap.put("THB", "THB-Thai Baht");
		currencyMap.put("TOP", "TOP-Tonga Pa'anga");
		currencyMap.put("TTD", "TTD-Trinidad&amp;Tobago Dollar");
		currencyMap.put("TND", "TND-Tunisian Dinar");
		currencyMap.put("TRL", "TRL-Turkish Lira");
		currencyMap.put("USD", "USD-U.S. Dollar");
		currencyMap.put("AED", "AED-UAE Dirham");
		currencyMap.put("UGX", "UGX-Ugandan Shilling");
		currencyMap.put("UAH", "UAH-Ukraine Hryvnia");
		currencyMap.put("UYU", "UYU-Uruguayan New Peso");
		currencyMap.put("VUV", "VUV-Vanuatu Vatu");
		currencyMap.put("VEB", "VEB-Venezuelan Bolivar");
		currencyMap.put("VND", "VND-Vietnam Dong");
		currencyMap.put("YER", "YER-Yemen Riyal");
		currencyMap.put("YUM", "YUM-Yugoslav Dinar");
		currencyMap.put("ZMK", "ZMK-Zambian Kwacha");
		currencyMap.put("ZWD", "ZWD-Zimbabwe Dollar");
		
		sessionCurrency.setAttribute("mapCurrency", currencyMap);
		
	}
	
	@RequestMapping(value = "/CurrencySubmit" , method=RequestMethod.POST)
	public String getCurrencies(HttpServletRequest request){
		
		String fromCurrency = request.getParameter("fromCurrency");
		String toCurrency = request.getParameter("toCurrency");
		
		CurrencyConvertor cc = new CurrencyConvertor("fromCurrency");
		Double conversionValue = 0.0;
		HttpSession sessionOut = request.getSession();
		try {
			conversionValue = cc.getConversion(fromCurrency, toCurrency);
			System.out.println(conversionValue);

			sessionOut.setAttribute("conversionValue", conversionValue);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sessionOut.setAttribute("set", "1 "+fromCurrency+" = "+conversionValue+" " + toCurrency+"");
		String pageName = (String) sessionOut.getAttribute("pageName");
			
		
		return pageName;
	}
	
}
