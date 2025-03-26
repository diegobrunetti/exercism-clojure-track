(ns isogram
  (:require [clojure.string :as str]))

(defn isogram?
  "Returns true if the given string is an isogram; otherwise, returns false"
  [s]
  (let [word (str/lower-case (str/replace s #"[^\p{Alpha}]"  ""))]
    (= (count (distinct word)) (count word))))
