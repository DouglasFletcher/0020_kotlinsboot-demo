@/user/
Feature: Get request with username.

  Background:
    # use post request or via jdbc - for now using:
    # {project.basedir}/kotlinsboot-demo-service/
    # src/resources/data.sql hence this record always
    # exists on startup of the application
    Given the user with the following values exists:
      | id          | 1             |
      | username    | dofletcher    |
      | firstname   | douglas       |
      | lastname    | fletcher      |
      | description | I like kotlin |

  @positive
  Scenario Outline: Get request with username positive response
    When a request with path <path> and parameter <username> is made
    Then the status of the request is <status>
    And the response contains the expected data
    Examples:
      | path | username   | status  |
      | user | dofletcher | SUCCESS |

  @negative
  Scenario Outline: Get request with unknown username negative response
    When a request with path <path> and parameter <username> is made
    Then the status of the request is <status>
    #And the error Message is <message>
    Examples:
      | path | username | status | message                            |
      | user | john     | FAILED | Cannot find user with login: bobby |