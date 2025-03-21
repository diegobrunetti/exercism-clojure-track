(ns pangram
  (:require [clojure.string :as str]))

(defn pangram?
  "Returns true if the given string is a pangram; otherwise, returns false"
  [s]
  (let [distinct-letters (filter Character/isLetter (distinct (str/upper-case s)))]
    (= (count distinct-letters) 26)))
