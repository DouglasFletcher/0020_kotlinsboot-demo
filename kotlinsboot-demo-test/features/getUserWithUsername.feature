@/user/
Feature: Get request with username.

  Background:
    # use post request or via jdbc - for now using:
    # {project.basedir}/kotlinsboot-demo-service/
    # src/resources/data.sql hence this record always
    # exists on startup of the application
    Given the user with the following values exists:
      | id          | 1             |
      | login       | dofletcher    |
      | firstname   | douglas       |
      | lastname    | fletcher      |
      | description | I like kotlin |

  Scenario Outline: Get request with username positive response
    When a request with base uri "/user" and parameter <username>
    Then the status of the request is <status>
    And the response is what is expected

    Examples:
      | status |
      | OK     |