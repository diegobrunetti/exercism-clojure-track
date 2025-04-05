(ns isbn-verifier
  (:require [clojure.string :as str]))

(defn- sanitize [isbn]
  (->> (str/replace isbn "-" "")
       (re-matches #"^\d{9}[\dX]$")
       (map #(if (= % \X) 10 (Character/digit % 10)))))

(defn- apply-formula [digits]
  (reduce + (map * digits (range 10 0 -1))))

(defn- verify [num]
  (and
   (pos? num)
   (zero? (rem num 11))))

(defn isbn? [isbn]
  (->> isbn
       (sanitize)
       (apply-formula)
       (verify)))
