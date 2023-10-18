# SKILLO AUTOMATION QA FINAL PROJECT

Java Maven Test Automation Framework, build using Selenium WebDriver, TestNG, Page Object Model Design Pattern and Page Factory.

The tests check the functionality of the ISkillo Training Web Application: http://training.skillo-bg.com:4200/

If a test failure occurs, a screenshot gets saved in a 'screenshots' folder inside the 'resources' folder in the project structure.

To run the tests use the 'mvn clean test' command.

# Home Page Tests

[Verify that a non-logged in user cannot like a post](https://drive.google.com/file/d/1v9KBOa608J8L9cNntoGlnFEeevI-KF1y/view?usp=sharing)

[Verify that a non-logged in user cannot dislike a post](https://drive.google.com/file/d/1LOcqXT6e15BhWWCEVj8KQxRWm8WwQ6-d/view?usp=sharing)

# New Post Tests

[Verify that a logged in user cannot create a new post with caption length over 100 characters](https://drive.google.com/file/d/1xyt8h2na9bqFh8q3Kq1NmPQyylnBxTPc/view)

[Verify that a logged in user cannot create a new post with a picture over the maximum file size limit (10 MB)](https://drive.google.com/file/d/1Gd-WuoWVZUCOQ7a2zihI9FsYsHe64ruT/view?usp=sharing)

# Profile Tests

[Verify that a logged in user can like a post](https://drive.google.com/file/d/1DyubW_AXmIC35CwfbwdSCyGMcniOxGgc/view?usp=sharing)

[Verify that a logged in user can dislike a post](https://drive.google.com/file/d/1D6LMWI6M5eHHTvsKArrR86enRYqt-vW7/view?usp=sharing)

[Verify that a logged in user can write a comment](https://drive.google.com/file/d/1b-aJtuJlN-Unv0wHh_fbalW3-aD8AQZ5/view?usp=sharing)

[Verify that a logged in user can delete his/hers posts](https://drive.google.com/file/d/1S5vNAoeYhUq6BdP7tr8mQbYNDxsDNMeF/view?usp=sharing)

# Register Tests

[Verify that a user can register with valid credentials](https://drive.google.com/file/d/14Ko4uqbczRE7iPoRDgjS6fdpUiUDfhYi/view?usp=sharing)

[Verify that a user cannot register with Password below the minimum allowed length](https://drive.google.com/file/d/1iV3hem2X5k_dtBgpedMyYsF0xX_4HQhM/view?usp=sharing)

[Verify that a user cannot register with Username below the minimum allowed length](https://drive.google.com/file/d/1S5b1ksry2AQDZYy_DCTKoh6hS4kNQ5J0/view?usp=drive_link)

[Verify that a user cannot register with Passwords which are matching but are over the maximum allowed length](https://drive.google.com/file/d/1xdhdiGb1gsvOoPB8dRZdG0aWgZUmeX4x/view?usp=sharing)

[Verify that a user cannot register with Username which is over the maximum allowed length](https://drive.google.com/file/d/1C0nn3qzrrpPjiYBHeCR052DbkeR9SyDd/view?usp=sharing)

[Verify that a user cannot register with an already taken Username](https://drive.google.com/file/d/1J9mLcnD56Ji3JTWVi6hIhXScWEA2C5DH/view?usp=sharing)

[Verify that a user cannot register with Passwords which don't match](https://drive.google.com/file/d/143sJGbMlBg5JTGukIckB93BCySkyWjh7/view?usp=sharing)

[Verify that a user cannot register with an already taken Email](https://drive.google.com/file/d/1oCsd_WJIXKCBg2vzHBImuceq71y4VkV4/view?usp=sharing)

[Verify that a user cannot register when all the fields are left empty](https://drive.google.com/file/d/1fba7Y4CRH_eCNh9s9iGZ9ZZKYQurrUJ4/view?usp=sharing)

[Verify that a user cannot register with invalid emails](https://drive.google.com/file/d/1HjhOLUfAOfwCeZoLR1nYfYtE0eaNASCZ/view?usp=sharing)
