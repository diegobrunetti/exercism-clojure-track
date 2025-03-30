(ns rotational-cipher
  (:require [clojure.string :as str]))

(def letters "abcdefghijklmnopqrstuvwxyz")
(def a-z letters)
(def A-Z (str/upper-case letters))

(defn rotate [input rot]
  (let [rotated (merge
                 (zipmap a-z (drop rot (cycle a-z)))
                 (zipmap A-Z (drop rot (cycle A-Z))))]
    (->> input
         (map #(rotated % %))
         (str/join))))
