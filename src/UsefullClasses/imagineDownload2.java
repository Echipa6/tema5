package UsefullClasses;

import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import com.google.gson.Gson;
 
public class imagineDownload2 {
 
	private URL url;
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}
	public imagineDownload2(String artist, String title) throws IOException {
	
		String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
		String query = "youtube "+artist+" "+title;
		String charset = "UTF-8";
 
		URL url = new URL(address + URLEncoder.encode(query, charset));
		Reader reader = new InputStreamReader(url.openStream(), charset);
		GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);
 
//		int total = results.getResponseData().getResults().size();
//		System.out.println("total: "+total);
 

		String url23=results.getResponseData().getResults().get(0).getUrl();
		url23=url23.replaceAll("%3F", "?");
		url23=url23.replaceAll("%3D", "=");
		//System.out.println(url23);
		this.url=new URL(url23);
		
	}
    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
 
 
class GoogleResults{
 
    private ResponseData responseData;
    public ResponseData getResponseData() { return responseData; }
    public void setResponseData(ResponseData responseData) { this.responseData = responseData; }
    public String toString() { return "ResponseData[" + responseData + "]"; }
 
    static class ResponseData {
        private List<Result> results;
        public List<Result> getResults() { return results; }
        public void setResults(List<Result> results) { this.results = results; }
        public String toString() { return "Results[" + results + "]"; }
    }
 
    static class Result {
        private String url;
        private String title;
        public String getUrl() { return url; }
        public String getTitle() { return title; }
        public void setUrl(String url) { this.url = url; }
        public void setTitle(String title) { this.title = title; }
        public String toString() { return "Result[url:" + url +",title:" + title + "]"; }
    }

}

