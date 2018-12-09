package net.webservicex.www;

public class TestGeoIPService {

	public static void main(String[] args) throws Exception{
		GeoIPServiceLocator locator = new GeoIPServiceLocator();
		GeoIPServiceSoap soap = locator.getGeoIPServiceSoap();
		GeoIP ip = soap.getGeoIP("115.110.157.36");
		System.out.println(ip.getCountryName());
		System.out.println(ip.getCountryCode());
	}
}
