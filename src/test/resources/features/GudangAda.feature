Feature: Gudang Ada technical test #2

  Scenario: verify phone number is valid
    Given User go to Gudang Ada
    When User choose login by "phone number"
    And User input phone number "0812234567899"
    Then User should verify phone number is "0812234567899"
    # assert phone_number = “0812234567899”

  Scenario: verify user, password, & url is corresponding with assert data
    Given User go to Gudang Ada
    When User choose login by "email"
    And User input username "qegada@gmail.com" and password "Qe12345@!"
    Then User should verify some data:
    # assert email = “qegada@gmail.com”
    # assert password = “Qe12345@!”
    # assert URL = “https://seller.gudangada.com/home”
    # get URL {driver.getCurrentUrl();}
      | email            | password  | url                               |
      | qegada@gmail.com | Qe12345@! | https://seller.gudangada.com/home |

  Scenario: verify no banner displayed if user registration status is "VERIFIED"
    Given User go to Gudang Ada
    When User choose login by "email"
    And User input username "qegada@gmail.com" and password "Qe12345@!"
    And User click Masuk button
    # additional step for close the alert
    And User avoid alert
    Then User should verify "no banner" displayed
      | status   |
      | VERIFIED |

  Scenario: verify banner will displayed if user registration status is "PENDING"
    Given User go to Gudang Ada
    When User choose login by "email"
    And User input username "qegada@gmail.com" and password "Qe12345@!"
    And User click Masuk button
    Then User should verify "banner" displayed
      | status  |
      | PENDING |

  Scenario: verify banner will displayed if user registration status is "FAILED"
    Given User go to Gudang Ada
    When User choose login by "email"
    And User input username "qegada@gmail.com" and password "Qe12345@!"
    And User click Masuk button
    Then User should verify "banner" displayed
      | status |
      | FAILED |