# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `)]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
    ...
}
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators, check if the test cases written so far satisfy *Base Choice Coverage*. If needed, add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.  
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer

1. Parmi toutes les possibilités d'input, nous avons pu les répartir en partitions pour limiter le nombre de tests. Les partitions sont les suivantes :
   - La String vide,
   - Un symbole ouvrant suivi d'un symbole fermant du même type : "()",
   - Un symbole ouvrant suivi d'un symbole fermant d'un type différent : "{)",
   - Une suite de symboles ouvrants et fermants du même type : "{}()[]"
   - Une suite de symboles ouvrants puis une suite de symboles fermants correspondants : "({[]})"
   - Uniquements des symboles ouvrants/fermants : "((" / "))"
   - Un symbole fermant suivi d'un symbole ouvrant : ")("
   - Des paires alternées : "({)}"
   - Une paire de symbole entourant du texte : "(vérificationvalidation)"
   - Une paire de symbole au milieu d'un texte : "vérificati(onva)lidation"
2. Nous avons ajouté au pom.xml le plugin jacoco pour pouvoir visualiser la couverture de test et nous avons réussi à obtenir une couverture de 100% de nos tests.

3. 

4. Après avoir utilisé PIT, nous obtenons un score de mutation de 93% et l'ensemble de nos mutants ont été tués car nos tests ont bien capturé l'ensemble des mutations.
