(ns series)

(defn- fail [error]
  (throw (IllegalArgumentException. error)))

(defn slices [input series-size]
  (cond
    (empty? input) (fail "series cannot be empty")
    (zero? series-size) (fail "slice length cannot be zero")
    (neg? series-size) (fail "slice length cannot be negative")
    (> series-size (count input)) (fail "slice length cannot be greater than series length")
    :else (map #(apply str %) (partition series-size 1 input))))

