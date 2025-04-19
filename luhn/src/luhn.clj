(ns luhn
  (:require [clojure.string :as str]))

(defn- luhn-double [n]
  (if (> n 4) (- (+ n n) 9) (+ n n)))

(defn- zigzag-collect [coll]
  (flatten (partition 1 2 coll)))

(defn valid?
  "Returns true if the given number is valid according
  to the luhn algorithm; otherwise, returns false."
  [s]
  (let [s (reverse (str/replace s #"\s" ""))]
    (and (< 1 (count s))
         (let [parsed      (map #(Character/digit % 10) s)
               transformed (map luhn-double (zigzag-collect (drop 1 parsed)))
               untouched   (zigzag-collect parsed)
               sum         (reduce + (concat transformed untouched))]
           (zero? (rem sum 10))))))
