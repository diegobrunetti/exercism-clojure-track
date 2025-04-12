(ns square-root)

(defn square-root
  "Calculates a number's square root"
  [n]
  (loop [x n]
    (if (= (* x x) n)
      x
      (recur (dec x)))))