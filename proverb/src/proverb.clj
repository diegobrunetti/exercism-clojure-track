(ns proverb
  (:require [clojure.string :as str]))

(defn recite [words]
  (if (empty? words)
    ""
    (->> words
         (partition 2 1)
         (map (partial apply format "For want of a %s the %s was lost.\n"))
         (str/join)
         (#(str % "And all for the want of a " (first words) ".")))))