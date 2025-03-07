(ns anagram
  (:require [clojure.string :as str]))

(defn is-anagram? [word prospect]
  (let [w (str/upper-case word)
        p (str/upper-case prospect)]
    (and
     (not= w p)
     (= (sort w) (sort p)))))

(defn anagrams-for [word prospect-list]
  (filter (partial is-anagram? word) prospect-list))
