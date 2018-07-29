import java.util.List;
import java.util.ArrayList;
class EncodeDecodeTinyURL {
	// Encodes a URL to a shortened URL.
	private List<String> urls = new ArrayList<String>();

    public String encode(String longUrl) {
    	// just add the url to the String List and return the index
        urls.add(longUrl);
        return "http://tinyurl.com/" + String.valueOf(urls.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
    	String[] sp = shortUrl.split("/");
        int index = Integer.parseInt(sp[sp.length - 1]);
        if (index >= 0 && index < urls.size()) {
        	return urls.get(index);
        }
        return "";
    }

    public static void main(String[] args) {

    }
}