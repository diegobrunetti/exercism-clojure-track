(ns pascals-triangle)

(defn- factorial [n]
  (if (<= n 1)
    1
    (*' n (factorial (dec n)))))

(defn- value-at [n k]
  (/ (factorial n) (*' (factorial k) (factorial (- n k)))))

(defn- row [n]
  (map (partial value-at n) (range 0 (inc n))))

(def triangle (map row (range)))
