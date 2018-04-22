## API Service information for "MS3 and ME"
 
This project provide the RESTFull service for the "MS3 and ME" conversion logic for the given number range as input.  

API Endpoint details:
URL: http://<<server_name>>:<<port>>/api/v1.0/number/range?min=<<minimum_number>>&max=<<maximum_number>>  
The above endpoint allows two query url parameters, those are  
	"**min**" -> by this we can give the minimum range number as input  
	"**max**" -> by this we can give the maximum range number as input
	
---
How to Run:  
	Please clone the given below git URL into your local directory.
	
	If you want build the project please run the below maven command, then finally it will create the runnable jar file in the "target" folder under the   
	project directory. 
	>> mvn package
	
	If you want build the project and at the same time deploy the Restfull api as service use the below maven command from the project directory. 
	>> mvn package && java -jar target/rest-services-0.0.1-SNAPSHOT.jar 


	

Text attributes _italic_, 
**bold**, `monospace`.

Horizontal rule:

---

Bullet list:

  * apples
  * oranges
  * pears

Numbered list:

  1. wash
  2. rinse
  3. repeat

A [link](http://example.com).

![Image](Image_icon.png)

> Markdown uses email-style > characters for blockquoting.

Inline <abbr title="Hypertext Markup Language">HTML</abbr> is supported.