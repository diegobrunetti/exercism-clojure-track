(ns largest-series-product)

(defn- fail [message]
  (throw (IllegalArgumentException. message)))

(defn- validate [span input]
  (cond
    (some? (re-find #"\D" input)) (fail "digits input must only contain digits")
    (> span (count input)) (fail "span must not exceed string length")
    (neg? span) (fail "span must not be negative")
    :else input))

(defn- get-digits [input] (map #(Character/digit % 10) input))
(defn- get-series [span, input] (partition span 1 [0] input))
(defn- get-product [series] (map (partial apply *) series))
(defn- get-largest [products] (apply max products))

(defn largest-product [span input]
  (->> (validate span input)
       (get-digits)
       (get-series span)
       (get-product)
       (get-largest)))
 
