Feature: login new account and add address

  Scenario Outline: user can add his address
    Given User entered his unique email address and password
    When User Goes To Sign In
    When User enter new address data <alias> <address> <city> <zip> <phone>
    When Verify page data <alias> <address> <city> <zip> <phone>
    Then User saves address settings
    Examples:
      | alias   | address   | city         | zip                 | phone      |
      | "Janek" | "Kolska"  | "Babiak"     | "62-610"            |"123456789" |


