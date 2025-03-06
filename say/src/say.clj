(ns say
  (:require [clojure.string :as str]))

(def scales-in-english (sorted-map
                        1000000000 "billion"
                        1000000 "million"
                        1000 "thousand"
                        100 "hundred"
                        90 "ninety"
                        80 "eighty"
                        70 "seventy"
                        60 "sixty"
                        50 "fifty"
                        40 "forty"
                        30 "thirty"
                        20 "twenty"
                        19 "nineteen"
                        18 "eighteen"
                        17 "seventeen"
                        16 "sixteen"
                        15 "fifteen"
                        14 "fourteen"
                        13 "thirteen"
                        12 "twelve"
                        11 "eleven"
                        10 "ten"
                        9 "nine"
                        8 "eight"
                        7 "seven"
                        6 "six"
                        5 "five"
                        4 "four"
                        3 "three"
                        2 "two"
                        1 "one"))

(def scales (reverse (keys scales-in-english)))


(defn- in-range? [num]
  (and (>= num 0) (<= num 999999999999)))


(defn- break-number
  ([num acc]
   (let [scale (first (filter (fn [x] (>= num x)) scales))
         units (quot num scale)
         remainder (rem num scale)]
     (if (> remainder 0)
       (break-number remainder (conj acc {:units units :scale scale}))
       (conj acc {:units units :scale scale})))))


(defn- translate-units [units scale]
  (when (> scale 90)
    (str " " (or (get scales-in-english units) units))))


(defn- translate-scale [scale]
  (let [separator (if (> scale 9)
                    " "
                    "-")]
    (str separator (get scales-in-english scale))))


(defn- translate
  ([{:keys [units scale]}]
   (if (< units 19)
     (str (translate-units units scale) (translate-scale scale))
     (translate (break-number units []) scale)))
  ([chunks scale]
   (str (str/join (map translate chunks)) (translate-scale scale))))


(defn- to-english [chunks]
  (->> chunks
       (map translate)
       (str/join)
       (str/trim)))


(defn number [num]
  (cond
    (not (in-range? num)) (throw (IllegalArgumentException. "Out of the blessed range."))
    (zero? num) "zero"
    (< num 20) (get scales-in-english num)
    :else (to-english (break-number num []))))
