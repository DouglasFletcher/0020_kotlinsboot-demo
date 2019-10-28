Feature: Belly

  @positive
  Scenario: a few cakes
    Given I have 42 cakes in my belly
    When I wait 1 hour
    Then My belly should grumble with loudness 1