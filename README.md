##Test task##
(Address book)
You need to create tests for the Web GUI. There is an application, address
book, to work on AngularJS dreamfactory.com service. A link to the application.

http://ft-alexander-golovko.cl.dreamfactory.com/files/AddressBookForAngularJS/add_angular/index.html#/contacts

You can use the current application or create your account for the test.
Functional testing of web GUI
- Analyze the application functionality and make a complete test plan for the
registration process.
- Create the necessary test cases
- Develop test cases for registration functionality.
Tools of your choice.
Are encouraged to use: java, maven, selenium, docker
Documentation on the application:
https://github.com/dreamfactorysoftware/angular-sdk
Suggestions:
• The project must be published on github.com
• Code must be properly decorated and documented.
• You allow to use any libraries and extensions

---

###Test Cases :
_**Issues**_

    1. Required fields should be marked with * symbol or text label "Required*";
    2. "Error : Validation failed" is not user friendly. Messages should be informative.

      Example :
        User type password less 6 symbols length so validation message should displayed

        Actual : "Error : Validation failed" message had been displayed
        Expected : "Error : The password must be at least 6 characters."

    3. After success registration message about it should be displayed.

**_Preconditions:_**
_(execute before each testcase)_

    1. Open login page;
    ExR : login page loaded

    2. Click register button
    ExR : registration form loaded

**TC 01 : register user with new unique email**

    Steps

    1. Fill all fields with correct data and click Register button;
    ExR : page reloaded and login page is displayed

    2. Login used credentials just created account
    ExR : User has loggedIn to Address Book application.

**TC 02 : register user with existing email**

   _Precondition:_
_User has been registered eg (usr01@gmail.com) and email will be used in testcase._

    Steps

    1. Fill correct data for (First Name (eg "Alan"), Last Name(eg "Smith")
       and password (eg "123456")) fields and type email already created account (eg "ki01@gmail.com")
       and click Register button;
    ExR : Error message "Validation: The email has already been taken." appears to user.

**TC 03 : register user with not valid email**

    Steps

    1. Fill correct data for (First Name (eg "Alan"), Last Name(eg "Smith")
       and password (eg "123456")) fields and type not valid value for email
       and click Register button;
    ExR : "Validation: The email must be a valid email address." message appears to user.

**TC 04 : try register user but do not fill required fields**

    Test data

    1. left all fields empty
    2. email : The email field is required.
    3. password : The password field is required.

**TC 05 : validate password field for at least 6 characters - err message should been appeared**

    Steps

    1. Fill correct data for (First Name (eg "Alan"), Last Name(eg "Smith") and
       email (eg "ki<timestamp>@gmail.com"  where timestamp is unique prefix)
       and password less 6 characters (e.g "123"))

    2. Click Register button;
    ExR : Error message "The password must be at least 6 characters." appears to user.

**TC 06 : register user without optional fields**

    Steps

    1. Fill correct data for email (eg "ki<timestamp>@gmail.com"
       where timestamp is unique prefix) and password 6 characters (e.g "123456"))
       and still blank First Name and Last Name

    2. Click Register button;
    ExR : User has been registered.

---

###Run tests from command line:

1) in terminal open project directory

2) execute

    mvn integration-test serenity:aggregate

3) find html report in /target/site/ then open in browser index.html

###Run tests with Docker:
1) open Docker Terminal

2) goto project directory and execute

    docker build -t addressbook-uitests .

3) after build has completed run test in docker use Firefox browser :

    docker run --rm -i -v "$PWD":/home/remoteuser/serenity-project/ addressbook-uitests /bin/bash -c "Xvfb :99 & export DISPLAY=:99 && mvn clean verify -Dwebdriver.driver=firefox"

