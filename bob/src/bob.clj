(ns bob
  (:require [clojure.string :as str]))

(defn question? [s]
  (str/ends-with? s "?"))

(defn yelling? [s]
  (and (= s (str/upper-case s)) (re-find #"[A-Z]" s)))

(def yelling-a-question? (every-pred yelling? question?))
(def silence? str/blank?)

(defn response-for [s]
  (let [s-trimmed (str/trim s)]
    (cond
      (silence? s-trimmed) "Fine. Be that way!"
      (yelling-a-question? s-trimmed) "Calm down, I know what I'm doing!"
      (question? s-trimmed) "Sure."
      (yelling? s-trimmed) "Whoa, chill out!"
      :else "Whatever.")))
