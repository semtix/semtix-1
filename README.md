
INTRODUCTION
=========

This software is a free (GNU Affero 3.0 licensed) open source software meant to help German Semesterticket Offices and 
therefore contains many terms and explanations only aimed at a german-speaking audience.

During the last decade the Semesterticketbüro of the Humboldt University Berlin pursued planning and development of this software to 
 * Remove dependency on proprietary software
 * Be able to use the client on any operating system that supports Java 7
 * Adapt the software to fit the requirement in the best possible way
 * Publish the software for the benefit of everyone else

While it may remain unclear who started the idea of this software, from 2011 to 2014 Jürgen Schmelze designed large parts
of its interface. Starting from 2014, Michael Mertins finished up missing functionalities and is working on this software
until 2016. 

FU Berlin clone: https://git.astafu.de/astafu/semtixdb
HU Berlin uses fork maintained by Schuergi

If you are related to a University AStA and/or Semesterticketbüro and want to adapt this software to your needs, please contact the
author who is reachable at MichaelMertins@gmail.com for consultation, initial help and support or just as a courtesy.

We are very interested in spreading and supporting this software and hope, many other offices will now be able to develop their
own application software based on this as well.

---



RUNNING SEMTIX CLIENT
======================
On each client:
- Install _openjdk-7-(jre|jdk)_ and _libreoffice_ and _apache maven_
- Setup and configure printer, so `/usr/bin/soffice -p` works for printing out .odt files
- Set `logo=0` in _sofficerc_, e.g. /etc/libreoffice/sofficerc, /usr/lib/libreoffice/program/sofficerc
- Copy **semtixconf.properties, log4j.properties and hibernate.cfg.xml to /etc/semtixdb/** and adjust them to your environment
- Create `/var/log/semtixdb/` and make accessible for users that run semtix
- Copy templates folder to the place specified in semtixconf.properties
- Execute `mvn clean install` where the _pom.xml_ file is located whenever you want to build from source with JDK7 and Apache Maven

---

### FIRST STEPS ON CLIENT
- Datenbank `->` Neues Semester Anlegen and create a new Semester
- Datenbank `->` Aktuelles Semester and select the Semester as Global Semester
- Go to Admin section and initialize all relevant settings. That also entails clicking on "Speichern" at the path settings in case a field is missing from your `semtixconf.properties`
- Fill other data that is frequently used (e.g. Textbausteine)
- Put your libreoffice letter template files in the templates folder

--- 

### ON SERVER:
The server is only required to run the actual SQL database:
- create postgresql db (we use driver 9.1-901-1.jdbc4 from within hibernate 4.3.8)
  and make sure the db is accessible by clients (usually port 5432)
- install `postgresql-contrib` and execute `CREATE EXTENSION unaccent;` on semtix db
- Don't forget to configure `/etc/semtixdb/hibernate.cfg.xml` accordingly
- Performance tuning: http://www.postgresql.org/docs/9.1/static/sql-createindex.html

---

### HINTS/FAQ:
- check the tests in order to understand the determination process of how much each student will get paid
- other jdbc databases but PostgreSQL should also work but have not been tested
- Other places to look for templates are: `ExternalSettings.java` and `semtixconf.properties` 
- While printing letters or other documents you may run into problems as the engine expects several freemarker placeholders to be present. A complete list of placeholders is, at the moment, only available by looking at the Java-code. We use freemarker code like this in our odt-templates:     
      ``
      ${vorname} ${nachname}[#if co??]${"\n"}c/o ${co}[/#if]
      [#if zusatz??]${"\n"}${zusatz}[/#if] 
      ``  

- configure git to use odt2txt when pushing new Odt-Templates in order to avoid binary blobs  
- In your .git/config :    
	``
	[diff "odt"]
        	binary = true
	        textconv = odt2txt
	``
- In your .gitattributes :   
	`*.odt diff=odt`
