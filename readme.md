The application returns the list of atms

Steps to Run Application:

1. Build the application
2. Run AtmsServiceApplication as java application

Steps to Test the application:

There are multiple tools available to test the rest api such as Postman, Rest client , soap ui. To test the AtmsServiceApplication we can use either of these. The application does not have any header or body arguments for input so can be tested directly with browser itself .

AtmsServiceApplication exposes following APIs and retun json response:

	A. An API to get list of atms: 
			 http://localhost:8080/atmList/  - the url return list of atms
	B. An API to filter atms by city:
			http://localhost:8080/atmList/{city} -> replace the city for fetching the atms list with city like http://localhost:8080/atmList/Leeuwarden