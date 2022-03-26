package services.blog;

import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.blog.Post;

public class BlogPostsService {

    private ObjectMapper mapper = new ObjectMapper();
    private HttpClientService httpClient = new HttpClientService();
    private String baseUrl;

    public BlogPostsService() {
        String environment = System.getenv("ENVIRONMENT");
        baseUrl = "ci".equals(environment)
            ? "http://service-mock:5250"
            : "http://localhost:5250";
    }

    public Post[] getAllPosts() throws Exception {
        HttpResponse<String> response = this.getPosts();
        if (response.statusCode() != 200) {
            throw new Exception("Expecting get posts response code 200 but got " + response.statusCode());
        }
        Post[] posts = this.extractBlogPosts(response);
        return posts;
    }

    public HttpResponse<String> getUserPosts(String userName) throws Exception {
        String url = this.baseUrl + "/posts/" + userName;
        HttpResponse<String> response = httpClient.get(url);
        return response;
    }

    public HttpResponse<String> getPosts() throws Exception {
        String url = this.baseUrl + "/posts";
        HttpResponse<String> response = httpClient.get(url);
        return response;
    }

    public Post[] extractBlogPosts(HttpResponse<String> response) throws Exception {
        Post[] posts = mapper.readValue(response.body(), Post[].class);
        return posts;
    }

}
