(ns darts)

(def outer 10)
(def middle 5)
(def inner 1)

(defn landed? [radius x y]
  (let [eucledian-distance (Math/sqrt (+ (Math/pow x 2)
                                         (Math/pow y 2)))]
    (<= eucledian-distance radius)))

(defn score
  "Calculates the score of a dart throw"
  [x y]
  (cond
    (landed? inner x y) 10
    (landed? middle x y) 5
    (landed? outer x y) 1
    :else 0))
