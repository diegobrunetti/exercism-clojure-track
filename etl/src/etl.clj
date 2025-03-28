(ns etl
  (:require [clojure.string :as str]))

(defn transform
  [source]
  (->> source
       (map (fn [[score letters]] (zipmap (map str/lower-case letters) (repeat score))))
       (into (sorted-map))))
