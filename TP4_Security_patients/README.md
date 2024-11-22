# TP4 - Spring Security: Gestion des Patients

## Description

Ce projet consiste en une application Spring Boot sécurisée qui permet de gérer des patients. Elle inclut des fonctionnalités comme l'ajout, la modification, la suppression, et la recherche de patients avec pagination, tout en assurant un contrôle d'accès basé sur des rôles (`ADMIN` et `USER`) grâce à **Spring Security**.

---

## Fonctionnalités

- **Authentification et autorisation :**
    - Les utilisateurs peuvent se connecter avec des rôles `USER` ou `ADMIN`.
    - Les actions sensibles (ajout, modification, suppression) sont accessibles uniquement aux `ADMIN`.
    - Les utilisateurs avec le rôle `USER` peuvent consulter la liste des patients.

- **Gestion des patients :**
    - Lister et rechercher les patients.
    - Ajouter, modifier, et supprimer des patients (admin uniquement).
    - Pagination pour naviguer entre les pages de la liste des patients.

- **Sécurité :**
    - Accès protégé avec Spring Security.
    - Gestion des mots de passe sécurisée via **BCrypt**.
    - Pages personnalisées pour les accès non autorisés.

---

## Structure du projet

### Packages principaux :
- `entities` : Contient l'entité **Patient**.
- `repositories` : Fournit les interfaces pour interagir avec la base de données (via Spring Data JPA).
- `web` : Implémente les contrôleurs pour gérer les requêtes HTTP.
- `security` : Configure l'authentification et l'autorisation avec Spring Security.

### Entité principale :
```java
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min=4,max=40)
    private String name;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private boolean isSick;
    @DecimalMin("100")
    private int score;
}
```

L’entité Patient représente un patient avec les attributs suivants :
- id : Identifiant unique généré automatiquement.
- name : Nom du patient (validé pour avoir entre 4 et 40 caractères).
- birthDate : Date de naissance.
- isSick : Booléen indiquant si le patient est malade.
- score : Un score minimum de 100.

### Sécurité :

- Configuration dans la classe SecurityConfig :
- Utilisation d’utilisateurs en mémoire (in-memory users) avec les rôles USER et ADMIN.
- Protection des URL selon les rôles :
  - `/user/**` : Accessible aux USER et ADMIN.
  - `/admin/**` : Accessible uniquement aux ADMIN.

### Exemple :
```java
httpSecurity.authorizeHttpRequests().requestMatchers("/user/**").hasRole("USER");
httpSecurity.authorizeHttpRequests().requestMatchers("/admin/**").hasRole("ADMIN");
```

## Installation et Exécution

### Prérequis

- Java 17 ou supérieur.
- Maven 3 ou supérieur.
- Un IDE comme IntelliJ IDEA ou Eclipse.

### Étapes

1. **Clonez le projet :**
```bash
git clone https://github.com/votre-repo/tp4-spring-security.git
```
2. **Importez le projet dans votre IDE.**
3. **Assurez-vous que toutes les dépendances Maven sont téléchargées.**
4. **Lancez l’application avec la classe principale :**
```bash
mvn spring-boot:run
```

### Utilisateurs par défaut

Deux utilisateurs sont définis dans la configuration SecurityConfig :
- Utilisateur standard :
  - Nom d’utilisateur : user
  - Mot de passe : user
  - Rôles : USER
- Administrateur :
  - Nom d’utilisateur : admin
  - Mot de passe : admin
  - Rôles : USER, ADMIN

### Endpoints principaux

| Endpoint            | Description                                 | Rôle requis |
|---------------------|---------------------------------------------|-------------|
| /user/index         | Affiche la liste des patients.              | USER        |
| /admin/formPatients | Formulaire pour ajouter un nouveau patient. | ADMIN       |
| /admin/editPatient  | Formulaire pour modifier un patient existant. | ADMIN       |
| /admin/delete       | Supprime un patient.                        | ADMIN       |
| /login              | Page de connexion.                          | Public      |
| /notAuthorized      | Page affichée pour un accès interdit.       | Public      |

## Exemple de flux utilisateur

1. **Connexion :**
  - Accédez à l’URL /login.
  - Connectez-vous avec un utilisateur user ou admin.
2. **Pour un USER :**
  - Vous pouvez consulter la liste des patients via /user/index.
  - La recherche et la pagination sont disponibles.
3. **Pour un ADMIN :**
  - Vous avez accès à toutes les fonctionnalités :
    - Ajouter un patient via /admin/formPatients.
    - Modifier un patient via /admin/editPatient.
    - Supprimer un patient via /admin/delete.

## Bibliothèques utilisées

- Spring Boot : Framework principal.
- Spring Security : Gestion de l’authentification et de l’autorisation.
- Spring Data JPA : Interaction avec la base de données.
- Thymeleaf : Moteur de templates pour les vues HTML.
- Bootstrap (via WebJars) : Style et mise en page des vues.

## Auteur

- Nom : Mohamed Lakssir
- Université : Mundiapolis - 2ACI Info
