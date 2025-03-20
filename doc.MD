# API Documentation

## 1. Ajouter un produit

### URL
http://localhost/9000/api/produit/add

### Méthode HTTP
`POST`

### Description
Cette méthode permet d'ajouter un nouveau produit dans la base de données.

#### Exemple valide
```json
{
    "nom": "Cigares",
    "prix": 12.99,
    "categorie": {
        "id": 1
    }
}
```

#### Réponse de la requête valide
`201 created`
```json
{
  "id": 11,
  "nom": "Cigares",
  "prix": 12.99,
  "categorie": {
    "id": 1,
    "libelle": "Tabac"
  }
}
```
-----------------------

#### Exemple non valide (prix négatif)
```json
{
    "nom": "Cigarettes",
    "prix": -12.99,
    "categorie": {
        "id": 1
    }
}
```

#### Réponse de la requête (prix négatif)
`400 Bad Request`
```json
{
  "prix": "Le prix doit être supérieur à zéro."
}
```

-----------------------

#### Exemple non valide (nom trop long)
```json
{
    "nom": "Ceci est un nom trop long Ceci est un nom trop long Ceci est un nom trop long Ceci est un nom trop long",
    "prix": 12.99,
    "categorie": {
        "id": 1
    }
}
```

#### Réponse de la requête (nom trop long)
`400 Bad Request`
```json
{
  "nom": "Le nom doit être supérieur à 2 caractères et ne pas excéder 50."
}
```
-----------------------

#### Exemple non valide (nom trop court)
```json
{
    "nom": "C",
    "prix": 12.99,
    "categorie": {
        "id": 1
    }
}
```

#### Réponse de la requête (nom trop court)
`400 Bad Request`
```json
{
  "nom": "Le nom doit être supérieur à 2 caractères et ne pas excéder 50."
}
```
---------------
#### Exemple non valide (le produit existe déjà)
`409 Conflict`

```json
{
  "Erreur": "Le produit Steaks hâchés existe déjà."
}
```

------------------
## 2. Retourner tous les produits

### URL
http://localhost/9000/api/produits

### Méthode HTTP
`GET`

### Description
Cette méthode permet de retourner tous les produits présents en BDD.

#### Réponse de la requête valide
`200 OK`
```json
[
  {
    "id": 11,
    "nom": "Cigares",
    "prix": 12.99,
    "categorie": {
      "id": 1,
      "libelle": "Tabac"
    }
  },
  {
    "id": 12,
    "nom": "Mascara",
    "prix": 9.99,
    "categorie": {
      "id": 2,
      "libelle": "Beauté"
    }
  },
  {
    "id": 13,
    "nom": "Brocolis",
    "prix": 2.99,
    "categorie": {
      "id": 3,
      "libelle": "Alimentaire"
    }
  }
]
```
-----------------
#### Exemple non valide (aucun produit en BDD)

`404 Not Found`
```json
"Aucun produit n'a été trouvé."
```

---------------
## 3. Retourner un produit par son ID

### URL
http://localhost/9000/api/produit/{id}

### Méthode HTTP
`GET`

### Description
Cette méthode permet de retourner un produit présent en BDD depuis son ID.

#### Réponse de la requête valide
`200 OK`
```json
{
  "id": 12,
  "nom": "Mascara",
  "prix": 9.99,
  "categorie": {
    "id": 2,
    "libelle": "Beauté"
  }
}
```

----------
#### Exemple non valide (id inexistant)

`404 Not Found`
```json
{
  "Erreur": "Le produit avec l'id 36 n'existe pas"
}
```
---------------

## 4. Ajouter une catégorie

### URL
http://localhost/9000/api/categorie/add

### Méthode HTTP
`POST`

### Description
Cette méthode permet d'ajouter une nouvelle catégorie dans la base de données.

#### Exemple valide
```json
{
  "libelle": "Sport"
}
```

#### Réponse de la requête valide
`201 created`
```json
{
  "id": 6,
  "libelle": "Sport"
}
```
-----------------------

#### Exemple non valide (la catégorie existe déjà)
`409 Conflict`
        
```json
{
  "Erreur": "La catégorie Sport existe déjà."
}
```

-----------------------

#### Exemple non valide (nom trop long)
```json
{
  "libelle": "Ceci est un nom de catégorie beaucoup trop long Ceci est un nom de catégorie beaucoup trop long "
}

```

#### Réponse de la requête (nom trop long)
`400 Bad Request`
```json
{
"libelle": "Le libellé doit contenir au moins 2 caractères et ne pas excéder 50."
}
```
-----------------------

#### Exemple non valide (nom trop court)
```json
{
  "libelle": "C"
}
```

#### Réponse de la requête (nom trop court)
`400 Bad Request`
```json
{
"libelle": "Le libellé doit contenir au moins 2 caractères et ne pas excéder 50."
}
```
---------------
## 5. Retourner toutes les catégories

### URL
http://localhost/9000/api/categories

### Méthode HTTP
`GET`

### Description
Cette méthode permet de retourner toutes les catégories présentes en BDD.

#### Réponse de la requête valide
`200 OK`
```json
[
  {
    "id": 1,
    "libelle": "Tabac"
  },
  {
    "id": 2,
    "libelle": "Beauté"
  },
  {
    "id": 3,
    "libelle": "Alimentaire"
  },
  {
    "id": 6,
    "libelle": "Sport"
  }
]
```

#### Exemple non valide (aucune catégorie en BDD)

`404 Not Found`
```json
"Aucune catégorie n'a été trouvée."
```

---------------
## 6. Retourner une catégorie par son ID

### URL
http://localhost/9000/api/categorie/{id}

### Méthode HTTP
`GET`

### Description
Cette méthode permet de retourner une catégorie présente en BDD depuis son ID.

#### Réponse de la requête valide
`200 OK`
```json
{
  "id": 3,
  "libelle": "Alimentaire"
}
```

----------
#### Exemple non valide (id inexistant)

`404 Not Found`
```json
{
  "Erreur": "La catégorie avec l'id 32 n'existe pas."
}
```