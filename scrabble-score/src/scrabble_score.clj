(ns scrabble-score
  (:require [clojure.string :as str]))

(def ^:private letter-values
  (->> [["AEIOULNRST" 1] ["DG" 2] ["BCMP" 3] ["FHVWY" 4] ["K" 5] ["JX" 8] ["QZ" 10]]
       (map (fn [[letters value]] (zipmap letters (repeat value))))
       (into {})))

(defn score-word
  "Calculate a word's scrabble score"
  [word]
  (reduce + (map #(letter-values %) (str/upper-case word))))
