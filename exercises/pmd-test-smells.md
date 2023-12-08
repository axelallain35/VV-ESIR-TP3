# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

Parmi les règles présentes dans pmd-documentation, nous avons en avons reconnu plusieurs dont nous avons parlé en cours. Par exemple, il ne faut pas oublier d'utiliser les décorateurs @After et @Before dans les méthodes setUp() et tearDown(), c'est ce que vérifient les règles JUnit4TestShouldUseBeforeAnnotation et JUnit4TestShouldUseAfterAnnotation. La règle DetachedTestCase vérifie qu'il n'y a bien qu'un seul cas de test par bloc @Test, afin de bien savoir quel est le bug si le test ne passe pas.
