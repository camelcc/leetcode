
DELETE P1
FROM Person AS P1, Person AS P2
WHERE P1.Id > P2.Id AND P1.Email = P2.Email

