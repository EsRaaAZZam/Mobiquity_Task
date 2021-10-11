Feature: Count Questions in Worksheet

  Scenario Outline: Validations for the comments for the post made by a specific user.
    Given Search for the user with username "<User Name>"
    Then search for all posts by this user
    Then For each post, fetch the comments and validate  emails format


    Examples:
      | User Name |
      | Delphine  |


  Scenario Outline: Search for non existing user.
    Given Search for the user with username "<User Name>"
    Then  no user should be returned



    Examples:
      | User Name |
      | Esraa  |


  Scenario Outline: Search for  existing user with no posts.
    Given Search for the posts with with Invalid  "<User ID>"
    Then  no posts should be returned
    Examples:
      | User ID |
      | 800  |


  Scenario Outline: Check if the user search with invalid postId
    Given user search with invalid "<Post ID>"
    Then no comments should be returned

    Examples:
      | Post ID |
      | 98898    |

















