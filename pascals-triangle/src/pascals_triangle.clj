(ns pascals-triangle)

(defn factorial [n]
  (reduce *' (range 1 (inc n))))

(defn- value-at [n k]
  (/ (factorial n) (*' (factorial k) (factorial (- n k)))))

(defn- row [n]
  (map (partial value-at n) (range 0 (inc n))))

(def triangle (map row (range)))
