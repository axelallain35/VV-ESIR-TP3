# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { ... }

    public static boolean isValidDate(int day, int month, int year) { ... }

    public static boolean isLeapYear(int year) { ... }

    public Date nextDate() { ... }

    public Date previousDate { ... }

    public int compareTo(Date other) { ... }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer

1.IsValidDate
|   | IsValidDate          | IsNotValidDate |
| :---------------: |:---------------:| :-----:|
| Jour  |   jour > 1 et jour < 31       |  jour < 1 ou jour > 31 |
| Mois | mois > 1 et mois < 12              |   mois < 1 ou mois > 12  |
| Date invalide pour une année bissextile  | 29 Février : année bissextile         |    29 Février : année non bissextile |  
  
IsLeapYear
|   | IsLeapYear          | IsNotLeapYear |
| :---------------: |:---------------:| :-----:|
| Années bissextiles ou non bissextiles  |   Année bissextile       |  Année non bissextile |  
  
  NextDate
|   | GoodNextDate          | WrongNextDate |
| :---------------: |:---------------:| :-----:|
| Changement d'année quand avance d'une journée le 31 Décembre  |   return : 1 Janvier de l'année suivante       |  return : date non valide |
| Changement de mois  |   return : 1er du Mois suivant       |  return : date non valide |  
  
  PreviousDate
|   | GoodPreviousDate          | WrongPreviousDate |
| :---------------: |:---------------:| :-----:|
| Changement d'année quand recule d'une journée le 1er Janvier  |   return : 31 Décembre de l'année d'avant       |  return : date non valide |
| Changement de mois  |   return : 31 du Mois précédent       |  return : date non valide |  
  
  CompareTo  
|  | Entier positif | Entier Négatif | Zéro   |
| :---------------: |:---------------:| :-----:| :-----:|
| Comparaison de dates dans le même mois  |    10/01/2022 et 15/01/2022      | 15/01/2022 et 10/01/2022  | 10/01/2022 et 10/01/2022 |
| Comparaison de dates dans la même année  |    15/01/2022 et 10/04/2022      | 10/04/2022 et 15/01/2022  | Impossible |
| Comparaison de dates dans des années différentes  |   20/04/2022 et 15/01/2023       |  15/01/2023 et 20/04/2022 | Impossible
  
  
2. Nous obtenons une courverture de test de 80%. Pour augmenter notre couverture de test, nous avons ajouté des tests pour les NullPointerException dans le cas où la date est null. Nous nous sommes rendu compte que nous n'avions pas testé le cas de changement de jour lors d'une année bissextile, nous avons donc rajouté les cas de test correspondants. Maintenant, notre couverture de test est de 100%.

3. Nous n'avons pas de cas où nous avons plus de 2 opérateurs booléens.

4. 


