package cucumber.stepdefinitions;

import io.cucumber.java8.En;
import models.blog.Post;
import services.blog.BlogPostsService;

import static com.google.common.truth.Truth.assertThat;

import java.net.http.HttpResponse;

public class UserPosts implements En {
    String userName;
    HttpResponse<String> response;
    Post[] posts;

    BlogPostsService blogPost = new BlogPostsService();

    public UserPosts() {
        Given("A blog service user", () -> {
            userName = "bill";
        });

        And("The user have not made any blog posts", () -> {
            userName = "tom";
        });

        And("The user does not exist", () -> {
            userName = "jack";
        });

        When("I get blog posts made by the user", () -> {
            response = blogPost.getUserPosts(userName);
        });

        Then("I should get a list of blogs posts of the user", () -> {
            assertThat(response.statusCode()).isEqualTo(200);
            posts = blogPost.extractBlogPosts(response);
            assertThat(posts).isNotNull();
        });

        And("The list should be empty", () -> {
            assertThat(posts).isEmpty();
        });

        Then("I should get a user not found response", () -> {
            assertThat(response.statusCode()).isEqualTo(404);
            assertThat(response.body()).contains("Error: No blog posts by " + userName);
        });
    }
}
