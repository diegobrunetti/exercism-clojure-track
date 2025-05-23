# Lucian's Luscious Lasagna

Welcome to Lucian's Luscious Lasagna on Exercism's Clojure Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

In Clojure, binding a value to a name is referred to as a _var_. Top-level (global) vars are similar to constants in other languages.

Top-level vars are defined using `def`:

```clojure
(def fingers 10)

fingers
;;=> 10
```

You can use `defn` to define a function taking zero or more arguments. This is a function that would add 2 numbers together:

```clojure
(defn add [x y]
  (+ x y))
```

This function takes 2 arguments which are placed in the vector `[x y]`, followed by the *body* of the function which can contain any number of expressions. The return value is always the result of evaluating the last expression in the body, `(+ x y)`. This expression is a list representing a function call. The first items of the list is the `+` function which is evaluated using the following items `x` and `y` as arguments.

The `add` function defined above is called the same way:

```clojure
(add 2 3)
;;=> 5
```

Functions and values in Clojure can only be used _after_ they have been defined, i.e. forms are always evaluated in the order they appear.

In Clojure, whitespace has no significance other than formatting.

Clojure functions and vars are organized in namespaces. A namespace groups related functionality and is defined using the `ns` macro:

```clojure
(ns calculator)

(def pi 3.14)

(defn add [x y]
  (+ x y))
```

Clojure supports two types of comments. Single line comments are preceded by `;` and the `comment` form is used to prevent evaluation of everything between `(comment` and `)`.

## Instructions

In this exercise you're going to write some code to help you cook a brilliant lasagna from your favorite cooking book.

You have four tasks, all related to the time spent cooking the lasagna.

## 1. Define the expected oven time in minutes

Define the `expected-time` var to check how many minutes the lasagna should be in the oven. According to the cooking book, the expected oven time in minutes is 40:

```clojure
expected-time
;;=> 40
```

## 2. Calculate the remaining oven time in minutes

Define the `remaining-time` function that takes the actual minutes the lasagna has been in the oven as an argument and returns how many minutes the lasagna still has to remain in the oven, based on the expected time oven time in minutes from the previous task.

```clojure
(remaining-time 30)
;;=> 10
```

## 3. Calculate the preparation time in minutes

Define the `prep-time` function that takes the number of layers you added to the lasagna as an argument and returns how many minutes you spent preparing the lasagna, assuming each layer takes you 2 minutes to prepare.

```clojure
(prep-time 2)
;;=> 4
```

## 4. Calculate the total working time in minutes

Define the `total-time` function that takes two arguments: the first argument is the number of layers you added to the lasagna, and the second argument is the number of minutes the lasagna has been in the oven. The function should return how many minutes in total you've worked on cooking the lasagna, which is the sum of the preparation time in minutes, and the time in minutes the lasagna has spent in the oven at the moment.

```clojure
(total-time 3 20)
;;=> 26
```

## Source

### Created by

- @bobbicodes