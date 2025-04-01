(ns sum-of-multiples)

(defn- find-multiples [level base-value]
  (range base-value level base-value))

(defn sum-of-multiples
  "Calculate the sum of multiples"
  [magic-items level]
  (->> magic-items
       (mapcat (partial find-multiples level))
       (set)
       (reduce +)))
