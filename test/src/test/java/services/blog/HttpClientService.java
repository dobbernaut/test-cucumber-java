package services.blog;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientService {

    public HttpResponse<String> get(String url) throws Exception {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (Exception exception) {
            throw new Exception("Failed to send get request to url " + url + "\n" + exception);
        }
    }
}
