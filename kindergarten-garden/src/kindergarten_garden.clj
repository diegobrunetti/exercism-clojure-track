(ns kindergarten-garden
  (:require [clojure.string :as str]))

(def plant-names {\G :grass
                  \C :clover
                  \R :radishes
                  \V :violets})

(def children [:alice :bob :charlie :david :eve :fred :ginny :harriet :ileana :joseph :kincaid :larry])

(defn garden [plants]
  (let [parts (str/split plants #"\n")
        row-1 (partition 2 2 (map #(plant-names %) (first parts)))
        row-2 (partition 2 2 (map #(plant-names %) (last parts)))]
    (zipmap children (map concat row-1 row-2))))
