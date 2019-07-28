# CodeCeption-Automation-Code
This is a repo containing the automation code for some scenarioes at qartCamp website

# Short Description of the repo
This repo containing a utomation code scenarioes for CodeCeption . It has 5 Junit test methods The structure of the code as it contains a packag "CodeCeptionPackage" which contains 3 classes
1- BaseTests : containing Setup and TearDown methods with annotations @Before and @After respectively . At Setup method , I initialized a chrome driver , with implicit wait of 10 secs and maximization at each opened sesion . At TearDown method , I quit the driver after finishing the test steps for each method
2- Utilities : Containing some helpful methods can be called while test execution . I have added a mthid for file upload using Robot hava class to be called per file uploading actions
3- CodeCeptionTests : It is the core class containing the functional tests . it contains methods and each of these methods annotated with @Test annotation
  •	A_Successful_Login() : which performs the successful login scenario with valid creds demo/demo and takes screenshot be the end
  •	B_Failed_Login() : which performs the failed login scenario with invalid creds demo/demo123 and takes screenshot be the end
  •	C_Update_Status() : which performs the adding new post scenario by login first then adding a media image jpg from file system then submits it and takes screenshot be the end
  •	D_CreateAlbum_UploadMedia() : which performs the test of adding album with 5 media jpg images , liking / unliking an image and verifying from the link https://qa.rtcamp.net/members/demo/media/likes/ and taking screenshot by the end
  •	E_Change_Cover_Image() : which performs the test of changing cover image by login first . Go to avatar image at the header > Profile > Change Cover Image and changes it from file system and takes scrrenshot by the end

# How to setup the repo
1- Install Ecipse IDE
2- Install Java at the system [JDK / JRE]
3- Add JAVA_HOME path at system variables pointing to Bin directory . Verify be opening terminal and send java --version
4- There is a folder at the root of the repo named "Test Artfacts" contains the chrome driver , 6 images and a profile picture. An image used for update status at test method C_Update_Status() . Another 5 images used for creating an album at test method D_CreateAlbum_UploadMedia() and finally another profile picture used at method E_Change_Cover_Image() .
5- Import the project at Eclipse IDE by File > Import ... > General > Exsiting Project into Workspace > Next > Browse for project dir > Next and Finish
6- There is a folder at "Test Artifacts" folder named as "Selenium Library" . You need to import all the jars at this folder before
execution as Right click on the project > Build Path > Configure Build Path > Add External Jars > Browse for the Jars
* client-combined-3.141.59.jar
* client-combined-3.141.59-sources.jar
* commons-io-2.6.jar
* hamcrest-core-1.3.jar
* junit-4.11.jar
* All the Jars at libs folder
then click Apply and Close

# How to run the project locally
1- Open the class file CodeCeptionTests.java from Src > CodeCeptionTests.java
2- Right Click on the code and select Run as > Junit Test
3- The project will run and give you a report on the left hand side be the end

