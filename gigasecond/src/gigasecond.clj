(ns gigasecond
  (:import (java.time LocalDateTime)))

(def gigasecond 1000000000)

(defn from [year month day]
  (let [from-date (LocalDateTime/of year month day 0 0 0)
        future-date (.plusSeconds from-date gigasecond)]
    [(.getYear future-date)
     (.getMonthValue future-date)
     (.getDayOfMonth future-date)]))

