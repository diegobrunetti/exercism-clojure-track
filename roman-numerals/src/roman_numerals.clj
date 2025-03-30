(ns roman-numerals)

(def roman-numerals (sorted-map-by >
                                   1000 "M"
                                   900 "CM"
                                   500 "D"
                                   400 "CD"
                                   100 "C"
                                   90 "XC"
                                   50 "L"
                                   40 "XL"
                                   10 "X"
                                   9 "IX"
                                   5 "V"
                                   4 "IV"
                                   1 "I"))

(defn find-closest-roman-numeral [number]
  (first (filter (fn [[key _]] (<= key number)) roman-numerals)))

(defn numerals
  "Convert a number to its roman numeral(s)"
  [number]
  (loop [n number
         roman-so-far ""]
    (let [[decimal, roman] (find-closest-roman-numeral n)
          remainder (- n decimal)
          result (str roman-so-far roman)]
      (if (zero? remainder)
        result
        (recur remainder result)))))
