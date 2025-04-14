(ns twelve-days
  (:require [clojure.string :as str]))

(def base "On the %s day of Christmas my true love gave to me: ")

(def days {1 "first", 2 "second", 3 "third", 4 "fourth", 5 "fifth", 6 "sixth"
           7 "seventh", 8 "eighth", 9 "ninth", 10 "tenth", 11 "eleventh", 12 "twelfth"})

(def gifts {1 "Partridge in a Pear Tree", 2 "two Turtle Doves"
            3 "three French Hens", 4 "four Calling Birds"
            5 "five Gold Rings", 6 "six Geese-a-Laying"
            7 "seven Swans-a-Swimming", 8 "eight Maids-a-Milking"
            9 "nine Ladies Dancing", 10 "ten Lords-a-Leaping"
            11 "eleven Pipers Piping", 12 "twelve Drummers Drumming"})

(defn gift-list [start-verse]
  (letfn [(build [start-verse]
            (loop [verse start-verse
                   list []]
              (cond
                (= start-verse 1) (conj list (str "a " (gifts 1)))
                (= verse 1) (conj list (str "and a " (gifts 1)))
                :else (recur (dec verse) (conj list (gifts verse))))))]
    (str/join ", " (build start-verse))))

(defn recite
  "Returns the lyrics of the song: 'The Twelve Days of Christmas.'"
  [start-verse end-verse]
  (->> (range start-verse (inc end-verse))
       (map #(str (format base (days %)) (gift-list %) "."))
       (str/join "\n")))