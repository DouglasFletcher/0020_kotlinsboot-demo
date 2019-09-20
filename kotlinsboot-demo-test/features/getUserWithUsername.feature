@/user/
Feature: Get request with username.

  Background:
    Given the user with the following values exists:
      | login       | dofletcher    |
      | firstname   | douglas       |
      | lastname    | fletcher      |
      | description | I like kotlin |

  Scenario Outline: Get request with username returns a user
    When a request with base uri "/user" and parameter <username>
    Then the status of the request is <status>
    And the data matches what is in the database

    Examples:
      | status | id | username   |
      | OK     | 1  | dofletcher |