# Projet IOC - Injection de dépendances avec Spring

## Description

Ce projet illustre l'injection de dépendances (IoC - Inversion of Control) en utilisant le framework **Spring**. Il présente plusieurs méthodes d'injection de dépendances :

1. **Instanciation statique** (Couplage fort)
2. **Instanciation dynamique** (Réflexion)
3. **Injection via fichier de configuration XML** (Spring XML)
4. **Injection via annotations** (Spring avec annotations)

Le projet est organisé en trois couches :
- **Couche DAO** : Responsable de la récupération des données.
- **Couche Métier** : Effectue des opérations basées sur les données récupérées.
- **Couche Présentation** : Exécute les tests pour démontrer le fonctionnement des injections de dépendances.

## Structure du projet

Voici la structure principale du projet :

```bash
├── pom.xml                          # Fichier de configuration Maven
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── dao
│   │   │   │   ├── DaoImpl.java      # Implémentation DAO principale
│   │   │   │   ├── DaoImplV2.java    # Deuxième implémentation DAO (alternative)
│   │   │   │   ├── IDao.java         # Interface DAO
│   │   │   ├── metier
│   │   │   │   ├── IMetier.java      # Interface Métier
│   │   │   │   ├── MetierImpl.java   # Implémentation du Métier
│   │   │   ├── pres
│   │   │   │   ├── Pres1.java        # Présentation avec instanciation statique
│   │   │   │   ├── Pres2.java        # Présentation avec instanciation dynamique
│   │   │   │   ├── Pres3.java        # Présentation avec injection via XML (Spring)
│   │   │   │   ├── Pres4.java        # Présentation avec injection via annotations (Spring)
│   │   └── resources
│   │       ├── spring-config.xml     # Fichier de configuration XML de Spring
├── README.md                         # Documentation du projet


```
## Technologies utilisées

- **Java 17**
- **Spring Framework 6.0.0**
- **Maven** pour la gestion des dépendances et la compilation du projet.

## Instructions pour exécuter le projet

### Prérequis

- Avoir installé **Java 17**.
- Avoir installé **Maven**.

### Étapes d'exécution

1. Clonez le dépôt :

   ```bash
   git clone https://github.com/thejokers69/IOC.git
   cd IOC
   ```

2. Compilez et installez les dépendances avec Maven :

   ```bash
   mvn clean install
   ```

3. Exécutez les différentes classes de présentation pour voir les résultats de l'injection de dépendances :

    - **Présentation avec instanciation statique** :
      ```bash
      mvn exec:java -Dexec.mainClass="pres.Pres1"
      ```

    - **Présentation avec instanciation dynamique** :
      ```bash
      mvn exec:java -Dexec.mainClass="pres.Pres2"
      ```

    - **Présentation avec injection via fichier XML** :
      ```bash
      mvn exec:java -Dexec.mainClass="pres.Pres3"
      ```

    - **Présentation avec injection via annotations** :
      ```bash
      mvn exec:java -Dexec.mainClass="pres.Pres4"
      ```

## Configuration Maven (`pom.xml`)

Le fichier `pom.xml` gère les dépendances nécessaires, telles que **Spring** et **JUnit** pour les tests.

```xml
<dependencies>
    <!-- Spring Core Dependency -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>6.0.0</version>
    </dependency>

    <!-- Spring Context Dependency for IoC -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>6.0.0</version>
    </dependency>

    <!-- SLF4J Logging -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.36</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>1.7.36</version>
    </dependency>
</dependencies>
```

## Auteurs

- **Mohamed Lakssir , 2ACI Info , thejokers69**

