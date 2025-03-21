(ns collatz-conjecture)

(defn collatz
  "Returns the number of steps it takes to reach 1 according
  to the rules of the Collatz Conjecture."
  [num]
  (letfn [(count-steps [n, steps]
            (cond
              (= 1 n) steps
              (even? n) (recur (/ n 2) (inc steps))
              :else (recur (inc (* n 3)) (inc steps))))]
    (count-steps num 0)))
