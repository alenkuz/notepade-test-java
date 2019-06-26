Feature: Search with Google
  With Google I can search information in the Internet

  Scenario: I search articles about Selenium in the Internet

    Given Google search is opened in my browser
    When I enter search term "Selenium"
    Then Search results contains links for "Selenium" related resources
