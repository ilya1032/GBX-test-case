# Acroplia test case

This project describes test case for Acroplia

Tasks:
-
1. Automate UI test case:
    
    a. Login to https://demo.acroplia.com/login \
    b. Go to 'My Desk' tab \
    c. Create new node and from this node create a new Textpad in Library
    
2. Automate E2E test case:

    a. Login to existing account and get access token from header\
    b. Create Note (Textpad in case of API usage) with given name\
    c. Get list of all textpads and make sure that Note was created
    
Preconditions
-
Gradle 4.4+ \
Java 8+

Setup and run
-
Just clone this repo and run 

`gradlew clean build` -- for *unix-based OS\
and \
`gradlew.bat clean build` -- for Windows

Test results can be found after build in `build/reports/tests/test`