(ns largest-series-product)

(defn validate [span input]
  (cond
    (some? (re-find #"([A-Za-z])" input)) "digits input must only contain digits"
    (> span (count input)) "span must be smaller than string length"
    (neg? span) "span must not be negative"
    :else nil))

(defn get-digits [input]
  (->> (char-array input)
       (map str)
       (map Integer/parseInt)))

(defn get-series [span, input] (partition span 1 [0] input))
(defn get-product [series] (map (fn [[& s]] (apply * s)) series))
(defn get-largest [products] (reduce max products))

(defn largest-product [span input]
  (let [error (validate span input)]
    (when (some? error)
      (throw (IllegalArgumentException. error)))

    (->> (get-digits input)
         (get-series span)
         (get-product)
         (get-largest))))
 
