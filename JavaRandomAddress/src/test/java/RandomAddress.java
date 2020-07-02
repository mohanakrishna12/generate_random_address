import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class RandomAddress extends MagicAPI{
	
	
	
	@Test(description = "Generating a random address and saving it in XML format")
	public void testRandomAddressGenerator() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		Faker usFaker = new Faker(Locale.US);
		map.put("buildingNumber", usFaker.address().buildingNumber());
		map.put("streetAddress", usFaker.address().streetAddress(true));
		map.put("city", usFaker.address().city());
		map.put( "state", usFaker.address().state());
		map.put("countryCode", usFaker.address().countryCode());
		map.put("zipCode", usFaker.address().zipCode());

        String xml = covertToXML(map,"root");
        System.out.println("Result of converted map to xml:");
        System.out.println(xml);
        PrintWriter writer = null;
		try {
			writer = new PrintWriter("valid_address.xml", "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        writer.println(xml);
        writer.close();
	}

}
