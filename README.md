Exercism Java
=============

[![GPLv3 License](http://img.shields.io/badge/license-GPLv3-blue.svg)](https://www.gnu.org/copyleft/gpl.html)

[![CircleCI](https://circleci.com/gh/quikkoo/exercism-java.svg?style=svg)](https://circleci.com/gh/quikkoo/exercism-java)
[![Codeship Status for quikkoo/exercism-java](https://app.codeship.com/projects/3af75120-6714-0134-c7b6-62ec90e592b2/status?branch=master)](https://app.codeship.com/projects/176099)

Java exercises from [exercism.io](http://exercism.io/)

This is a multi module project for all exercises in java language,
it makes easier to manage some of the common features and tasks between all exercises,
but each one can still be built individually.

### Check code

```sh
mvn verify
```

or

```sh
gradle check
```

### Run tests

```sh
mvn test
```

or

```sh
gradle test jacocoTestReport
```

### Build package

```sh
mvn package
```

or

```sh
gradle build
```


Exercises details
-----------------

Eventually, some of these exercises are not exactly what you fetch using 
`exercism fetch`, and there are different reasons for that:

- Some languages have different tests compared to others, 
  so i modify the test suite by adding or removing test cases
- The project is structured using some standard tools, 
  specifically for each technology
- The code is written aiming to apply some common patterns
  used by the target language community

Despite these differences, all test suites are essentially the same, it keeps 
the same logic and consistency (in most cases, i hope).

Feel free to clone this repository and use it to learn or improve your 
development skills, and i also encourage you to create an account on 
[exercism.io](http://exercism.io/)
and share your own solutions and doubts about these exercises and others.

You can also follow the discussion on the exercism track 
[exercism.io/quikkoo](http://exercism.io/quikkoo), 
to suggest me some improvements or to ask questions.
