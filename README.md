Installing testNG

1. In Eclipse, on top menu bar, Under Help Menu, Click on "Install new Software" in help window
2. Enter the URL (http://beust.com/eclipse/) at Work with field and click on "Add" button.
3. Once you click on "Add", it will display the screen, enter the Name as "TestNG".
4. After clicking on "OK", it will scan and display the software available with the URL which you have mentioned.
5. Now select the checkbox at TestNG and Click on "Next" button.
6. It will check for the requirement and dependencies before starting the installation.
7. Once the above step is done, it will ask you to review the installation details. If your are ready or Ok to install TestNG, click on "Next" to continue.
8. Accept the Terms of the license agreement and Click on "Finish" button.
9. Go to Windows Menu bar, and Mouse Over on "Show View" and Click on "Other"
10. Expand Java folder and see if the TestNg is available

Update the project:

1. Import project to your computer
2. Once project is imported, double click to open pom.xml to view dependencies
3. Right click the project folder and select maven from the options
4. Select update project from the window

Execute test classes

1. In the project structure, locate tests folder
2. Click to expand it and see the test classes
3. Double click on a class name to open it
4. In the class body, right click and select run as TestNG test option
5. Observe the output for the test class execution

Login test:

1. Open application
2. Login modal window opened
3. Verify username and password fields and type
4. Click login button to login
5. Modal window closed
6. Verify login successful

Home page test:

1. Open application
2. Login modal window opened
3. CLose login modal window
4. Hover over electronics menu and click mobile sub menu
5. Verify mobbile page is displayed successfully


Search page test:

1. Open application
2. Login modal window opened
3. CLose login modal window
4. Locate search box and type in moto to access the search results - Modified due to UI changes
5. In search results page, verify 4gb ram check box, motorola checkbox is displayed
6. Click on the check boxes 4gb ram and motorola check box to filter results displayed
7. Verify unchecking brand moto check box
8. Verify search results displays phones

View details page test:

1. Open application
2. Login modal window opened
3. CLose login modal window
4. Locate search box and type in moto to access the search results - Modified due to UI changes
5. In search results page, click the title of first entry returneed
6. In the view details verify add to cart button is present
7. Click add to cart button and verify quantity
8. Verify basket page

Test Report
1. Execute test class by double clicking > Run as TestNG test
2. Upon completion of running, right click project folder and select refresh
3. Locate test-output folder
4. Click to expand and select index.html
5. Right click to open with system editor/browser etc
6. View the report for the test run
