@Login
  Feature:

    Scenario:Successfully login
      Given  user navigate landing page
      When   enter valid credentials and click login
      Then   verify welcome message