(ns leap)

(defn divisible-by? [n year] (zero? (mod year n)))

(defn leap-year?
  "Determine if a year is a leap year"
  [year]
  (cond-> false
    (divisible-by? 4 year) (or true)
    (divisible-by? 100 year) (and false)
    (divisible-by? 400 year) (or true)))
