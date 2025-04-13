(ns matrix
  (:require [clojure.string :as str]))

(defn parse [s]
  (->> (str/split-lines s)
       (mapv (comp read-string (partial format "[%s]")))))

(defn get-row
  "Returns the i-th row of the matrix s"
  [s i]
  (nth (parse s) (dec i)))

(defn get-column
  "Returns the i-th column of the matrix s"
  [s i]
  (nth (apply mapv vector (parse s)) (dec i)))