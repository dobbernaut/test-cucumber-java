Feature: User blog posts
  Get blog posts by a specific user

  Scenario: Get blog posts by a specific user
    Given A blog service user
    When I get blog posts made by the user
    Then I should get a list of blogs posts of the user

  Scenario: An existing user has not made any posts
    Given A blog service user
    And The user have not made any blog posts
    When I get blog posts made by the user
    Then I should get a list of blogs posts of the user
    And The list should be empty

  Scenario: A non-existing user
    Given A blog service user
    And The user does not exist
    When I get blog posts made by the user
    Then I should get a user not found response
