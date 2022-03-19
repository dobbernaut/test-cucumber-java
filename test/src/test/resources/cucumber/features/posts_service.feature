Feature: Blog posts
  Get blog posts

  Scenario: Get all blog posts
    Given A blog post service
    When I get all the blog posts
    Then I should get a list of blog posts with a unique identifier
