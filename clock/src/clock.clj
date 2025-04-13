(ns clock
  (:import [java.time LocalTime]
           [java.time.format DateTimeFormatter]))

(defn clock->string [clock]
  (.format (DateTimeFormatter/ofPattern "HH:mm") clock))

(defn clock [hours minutes]
  (let [seconds (+ (* hours 3600) (* minutes 60))]
    (.plusSeconds (LocalTime/of 0 0) seconds)))

(defn add-time [clock time]
  (.plusMinutes clock time))