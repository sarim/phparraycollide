# Introduction 
PHP internally uses hashtables to store arrays. If we create a hashtable with 100% collisions (i.e. all keys will have the same hash). Then php need to recreate the hash for every element of the array.
Read more on the orginal article of nikic.
http://nikic.github.com/2011/12/28/Supercolliding-a-PHP-array.html

I created a simple app to generate colliding array and upload (HTTP POST) it to a php site.

# Generating Colliding array data.

The provided data.txt is 2 ^ 17. if you use it then skip to **Running**

Compile 

	javac generatedata.java
	
Generate the data as follows,

	java generatedata 17 > data.txt

Here 17 means it will generate 2 ^ 17 terms.

# Running

compile colid.java 

	javac colid.java 
	
run it
	
	java colid data.txt http://localhost/example.php 5

Here data.txt is the generated data, then the link. And 5 is the concurrent number of threads.

NB: Use it at your own risk only to load test your **own** server, Any unauthorized or evil use is not the authors intention and hence, unethical.