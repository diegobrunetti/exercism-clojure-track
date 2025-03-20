(ns acronym
  (:require [clojure.string :as str]))

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (->> (str/split phrase #"[^A-Za-z']")
       (map first)
       (apply str)
       (str/upper-case)))
