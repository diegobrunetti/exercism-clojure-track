(ns difference-of-squares
  (:require [clojure.math :as math]))

(defn square-of-sum
  "Returns the square of the sum of the numbers up to the given number"
  [n]
  (bigint (math/pow (reduce + (range 1 (inc n))) 2)))

(defn sum-of-squares
  "Returns the sum of the squares of the numbers up to the given number"
  [n]
  (bigint (reduce + (map #(math/pow % 2) (range 1 (inc n))))))

(defn difference
  "Returns the difference between the square of the sum of numbers up to a given number and the sum of the squares of those numbers"
  [n]
  (- (square-of-sum n) (sum-of-squares n)))
