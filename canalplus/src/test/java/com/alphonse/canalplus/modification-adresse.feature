Feature: the version can be retrieved
  Scenario: Modification de l'adresse d'un abonné résidant en France sans date d'effet
	Given un abonné avec une adresse principale active en France  
    When le conseiller connecté à <canal> modifie l'adresse de l'abonné sans date d'effet
    Then l'adresse de l'abonné modifiée est enregistrée sur l'ensemble des contrats de l'abonné
    And un mouvement de modification d'adresse est créé
    And un mouvement de modification d'adresse est créé
    And Et la nouvelle adresse peut être recherchée