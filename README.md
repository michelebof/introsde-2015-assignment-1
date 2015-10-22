INTROSDE  Assignment 01: Reading/Writing objects to and from XML and JSON
===============

--------

The code
-------------
 This assignment is developed with the following technologies:

 - JAVA
 - XML/XSD
 - JSON
 - XPATH
 - JAXB/Jackson

In the /src folder there are the Java classes; the package dao ("data access object", a typical data accessing pattern) contains PeopleStore where are saved the people to do marshalling, unmarshalling and create JSON file.
The second package (model) contains the Person and HealthProfile java classes, and the default package contains the two main classes HealtProfileReader and JAXBMarshalling and a model class for HealtProfileReader.
In the root folder there are People.xml and People.xsd useful for the first part to the Assignment; NEWPeople.xml and NEWPeople.json are the results of the second part of the Assignment and finally ivy.xml and the build.xml.

----------

Task of the code
--------------------
With the **HealthProfile** class can execute four different tasks depending on the arguments included, the first argument that must be included is the method.
The method 'all' prints all the people in the 'people.xml' with details while the methods 'displayHealthProfile' and 'displayProfile', with the argument 'PersonID', print the HealthProfile or all the profile of the person with that id. Finally the method 'displayProfilebyWeight'  accepts a weight and an operator (=, > , <) as arguments and prints people that fulfill that condition.
With the  **JAXBmarshalling** class can marshal into NEWpeople.xml or create the NEWpeople.json with three standard people or you can unmarshal the NEWpeople.xml into the PeopleStore class and print the people's details.

------------

How run the code 
---------------------
The code can be run simply execute in the terminal ```ant execute.evaluation```, with this istruction you can see all the results of all the tasks of this assignment. If you want see only one task you should write:

 - ```ant execute.all``` : for print all the people in the people.xml
 - ```ant execute.HPwithid``` : for print the HealtProfile of the person with PersonID='0005'
 - ```ant execute.peoplewithcond``` : for print all the people with weight > 90
 - ```ant execute.marshaling``` : for print, and save to NEWpeople.xml, three people present into PeopleStore class
 - ```ant execute.unmarshaling``` : for unmarshal the NEWpeople.xml 
 - ```ant execute.JSON``` : for print, and save to NEWpeople.json, three people present into PeopleStore class
