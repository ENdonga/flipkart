# flipkart
Installing testNG

In Eclipse, on top menu bar, Under Help Menu, Click on "Install new Software" in help window
Enter the URL (http://beust.com/eclipse/) at Work with field and click on "Add" button.
Once you click on "Add", it will display the screen, enter the Name as "TestNG".
After clicking on "OK", it will scan and display the software available with the URL which you have mentioned.
Now select the checkbox at TestNG and Click on "Next" button.
It will check for the requirement and dependencies before starting the installation.
Once the above step is done, it will ask you to review the installation details. If your are ready or Ok to install TestNG, click on "Next" to continue.
Accept the Terms of the license agreement and Click on "Finish" button.
Go to Windows Menu bar, and Mouse Over on "Show View" and Click on "Other"
Expand Java folder and see if the TestNg is available

Update the project:

Import project to your computer
Once project is imported, double click to open pom.xml to view dependencies
Right click the project folder and select maven from the options
Select update project from the window

Execute test classes

In the project structure, locate tests folder
Click to expand it and see the test classes
Double click on a class name to open it
In the class body, right click and select run as TestNG test option
Observe the output for the test class execution

Login test:

Open application
Login modal window opened
Verify username and password fields and type
Click login button to login
Modal window closed
Verify login successful

Home page test:

Open application
Login modal window opened
CLose login modal window
Hover over electronics menu and click mobile sub menu
Verify mobbile page is displayed successfully

Search page test:

Open application
Login modal window opened
CLose login modal window
Locate search box and type in moto to access the search results - Modified due to UI changes
In search results page, verify 4gb ram check box, motorola checkbox is displayed
Click on the check boxes 4gb ram and motorola check box to filter results displayed
Verify unchecking brand moto check box
Verify search results displays phones

View details page test:

Open application
Login modal window opened
CLose login modal window
Locate search box and type in moto to access the search results - Modified due to UI changes
In search results page, click the title of first entry returneed
In the view details verify add to cart button is present
Click add to cart button and verify quantity
Verify basket page

Test Report

Execute test class by double clicking > Run as TestNG test
Upon completion of running, right click project folder and select refresh
Locate test-output folder
Click to expand and select index.html
Right click to open with system editor/browser etc
View the report for the test run