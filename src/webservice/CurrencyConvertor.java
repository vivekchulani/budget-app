package webservice;


import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import NET.webserviceX.www.Currency;
import NET.webserviceX.www.CurrencyConvertorLocator;
import NET.webserviceX.www.CurrencyConvertorSoap;

@SuppressWarnings("serial")
public class CurrencyConvertor extends Currency{
	
	
	
	public CurrencyConvertor(String value) {
		super(value);
		// TODO Auto-generated constructor stub
	}


	public double getConversion(String fromCur, String toCur) throws ServiceException, RemoteException {
	
	CurrencyConvertorLocator locator = new CurrencyConvertorLocator();
	
	CurrencyConvertorSoap cc = locator.getCurrencyConvertorSoap();
	

	Double conversion = cc.conversionRate(new CurrencyConvertor(fromCur),
			new CurrencyConvertor(toCur));
	
	System.out.println(conversion);
	
		return conversion;
	
	}

}
