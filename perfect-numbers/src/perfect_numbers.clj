(ns perfect-numbers)

(defn- aliquot-sum [num]
  (->> (range 1 (inc (int (/ num 2))))
       (filter #(zero? (rem num %)))
       (reduce +)))

(defn classify
  "Classifies the given number as perfect, abundant, or deficient."
  [num]
  (let [sum (aliquot-sum num)]
    (cond
      (= sum num) :perfect
      (> sum num) :abundant
      (< sum num) :deficient)))
