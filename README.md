# Backend részről

## Amiket backendben használtam:
1. Spring Boot
2. Hibernate ORM keretrendszer
3. MySQL adatbázis 
4. Gradle build eszköz

Gradle projektépítő eszközt használtam függőségkezelésre.
MySQL connectorom verziója 5.1.24
Külön vannak szedve a controllerek, a service-k, a repository-k és a modellek(ahogy az elvárt egy spring boot applikáció esetén)
Az első futtatáskor feltölti kezdeti adatokkal az adatbázist(Role-ok, árfolyamok, országok, városok), ha még egyszer elindítjuk, akkor nem menti le újra az értékeket.
