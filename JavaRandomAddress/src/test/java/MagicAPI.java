import java.util.Map;

public class MagicAPI {
    
	
	// This method will convert input data to xml format
    public static String covertToXML(Map<String, String> map, String root) {
        StringBuilder sb = new StringBuilder("<");
        sb.append(root);
        sb.append(">");
        for (Map.Entry<String, String> e : map.entrySet()) {
            sb.append("<");
            sb.append(e.getKey());
            sb.append(">");

            sb.append(e.getValue());
            sb.append("</");
            sb.append(e.getKey());
            sb.append(">");
        }

        sb.append("</");
        sb.append(root);
        sb.append(">");

        return sb.toString();
    }
}