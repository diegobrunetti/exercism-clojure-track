(ns prime-factors)

(defn- get-factor [n]
  (some #(when (zero? (rem n %)) %) (range 2 (inc n))))

(defn of
  "Returns the prime factors of the given number."
  [num]
  (loop [n num
         factors []]
    (if (= n 1)
      factors
      (let [f (get-factor n)]
        (recur (quot n f) (conj factors f))))))