## Placesharing-System LB2
Quarkus Applikation um ein Placesharing-System zu verwalten


## Installieren
1. Projekt in einem Folder öffnen.
2. Instalation von Quarkus & Dev container extension in vs code.
3. Docker starten
4. Projekt im Entwiklercontainer öffnen.


## Projekt starten
1. Projekt mit dem Befehl Quarkus Debug starten.
2. Endpoint übersicht auf http://localhost:8080/swagger
3. Befehl './mvnw quarkus:test' ausführen um Tests zu starten
4. Optional Endpoints via Postman aufrufen


## Datenbank
Datenbank GUI läuft auf dem Port http://localhost:5050, von dort aus ist es möglich alles manuell zu verwalten.


## Datenbankadministration
Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`


## Tests
Tests sind ausführbar mit dem Befehl './mvnw quarkus:test' und brauchen die selbe DB wie Postman.
Tests für create & put funktionieren nicht, delete Tests nur 1x aufgrund der id, anpassen von x bis auf 0 falls mehrfach getestet wird.


## Login
 - URL:     `/users/login`
 - User:    markus
 - PW:      abc123
 - Beispiel: Test login in `test/java/ch/zli/m223/UsersResourceTest.java`


## Abweichung zu Planung
Einige Endpoints nicht erstellt, waren überflüssig
JWT-Token nicht verwendet, zeitlich zu knapp


## Referenz
basierend auf Punch clock projekt

## Repo
`https://github.com/nilsHenzen/m223_project`