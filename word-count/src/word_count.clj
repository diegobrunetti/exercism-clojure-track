(ns word-count
  (:require [clojure.string :as str]))

(defn word-count
  "Counts how many times each word occurs in the given string"
  [input]
  (->> (str/split (str/lower-case input) #"[^\w']+")
       (map #(str/replace % #"^'|'$" ""))
       (remove empty?)
       (frequencies)))
