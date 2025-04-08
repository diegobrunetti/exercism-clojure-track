(ns leap)

(defn divisible-by? [n year] (zero? (mod year n)))

(defn leap-year?
  "Determine if a year is a leap year"
  [year]
  (cond
    (divisible-by? 400 year) true
    (divisible-by? 100 year) false
    (divisible-by? 4 year) true
    :else false))
