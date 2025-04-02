(ns beer-song
  (:require [clojure.string :as str]))

(defmulti verse (fn [num]
                  (cond
                    (> num 1) :plural
                    (= num 1) :singular
                    (= num 0) :zero)))

(defmethod verse :plural [num]
  (str num " bottles of beer on the wall, " num " bottles of beer.\n"
       "Take one down and pass it around, " (dec num) " bottle" (when (> num 2) "s") " of beer on the wall.\n"))

(defmethod verse :singular [_]
  (str "1 bottle of beer on the wall, 1 bottle of beer.\n"
       "Take it down and pass it around, no more bottles of beer on the wall.\n"))

(defmethod verse :zero [_]
  (str "No more bottles of beer on the wall, no more bottles of beer.\n"
       "Go to the store and buy some more, 99 bottles of beer on the wall.\n"))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (sing start 0))
  ([start end]
   (->> (range start (dec end) -1)
        (map verse)
        (str/join "\n"))))
