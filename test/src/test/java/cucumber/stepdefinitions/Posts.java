package cucumber.stepdefinitions;

import io.cucumber.java8.En;
import models.blog.Post;
import services.blog.BlogPostsService;

import static com.google.common.truth.Truth.assertThat;

public class Posts implements En {
    Post[] posts;

    BlogPostsService blogPost = new BlogPostsService();

    public Posts() {
        Given("A blog post service", () -> {});

        When("I get all the blog posts", () -> {
            posts = blogPost.getAllPosts();
        });

        Then("I should get a list of blog posts with a unique identifier", () -> {
            assertThat(posts.length).isGreaterThan(0);
            for (Post post : posts) {
                assertThat(post.id).isNotNull();
            }
        });
    }
}
