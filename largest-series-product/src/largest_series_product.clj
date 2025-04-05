(ns largest-series-product)

(defn validate [span input]
  (cond
    (some? (re-find #"\D" input)) "digits input must only contain digits"
    (> span (count input)) "span must not exceed string length"
    (neg? span) "span must not be negative"))

(defn get-digits [input]
  (map #(Character/digit % 10) input))

(defn get-series [span, input] (partition span 1 [0] input))
(defn get-product [series] (map (partial apply *) series))
(defn get-largest [products] (apply max products))

(defn largest-product [span input]
  (let [error (validate span input)]
    (when (some? error)
      (throw (IllegalArgumentException. error)))

    (->> (get-digits input)
         (get-series span)
         (get-product)
         (get-largest))))
 
