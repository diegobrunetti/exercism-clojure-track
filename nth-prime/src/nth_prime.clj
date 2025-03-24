(ns nth-prime)

(defn prime? [n]
  (loop [divisor 2]
    (cond (> (* divisor divisor) n) true
          (zero? (rem n divisor)) false
          :else (recur (inc divisor)))))

(defn nth-prime
  "Returns the nth prime number."
  [n]
  (cond
    (= n 1) 2
    :else (nth (filter prime? (iterate (partial + 2) 3)) (- n 2))))