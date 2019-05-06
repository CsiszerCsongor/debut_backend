# Backend részről

Gradle projektépítő eszközt használtam függőségkezelésre.
MySQL connectorom verziója 5.1.24
Külön vannak szedve a controllerek, a service-k, a repository-k és a modellek(ahogy az elvárt egy spring boot applikációó esetén)

Ahhoz, hogy a weboldal működjön, miután lefuttattuk a backend-et és létrehozta az adattáblákat az adatbázisban, a következő adatbázis parancsokat kell futtatni az adatbázisban:
1. INSERT INTO roles(name) VALUES('ROLE_USER');
2. INSERT INTO roles(name) VALUES('ROLE_ADMIN');
3. INSERT INTO \`countries\`(\`is_deleted\`, \`name\`) VALUES (0, 'Romania'), (0, 'Hungary'), (0, 'Brazil'), (0, 'Belgium'), (0, 'Bolivia')
4. INSERT INTO \`cities\`(\`is_deleted\`, \`name\`, \`country_id\`) VALUES (0, 'Budapest', 2), (0, 'Debrecen', 2), (0, 'Pécs', 2),
(0, 'Miercurea-Ciuc', 1), (0, 'Cluj-Napoca',1), (0,'Brasov',1), (0, 'Rio de Janeiro', 3), (0, 'Salvador da Bahia', 3), (0, 'Recife', 3),
(0,'Gent',4), (0,'Brugge', 4),(0,'Leuwen', 4),(0,'La Paz', 5), (0,'El Alto', 5), (0,'Tarija', 5)
5. INSERT INTO \`currencies\`(\`is_deleted\`, \`name\`) VALUES (0, 'EURO'), (0, 'RON'), (0, 'HUF'), (0, 'BOB'), (0, 'BRL')
