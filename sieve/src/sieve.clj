(ns sieve)

(defn sieve
  "Returns the primes that are less than or equal to num."
  ([num]
   (if (> num 1)
     (sieve [] (range 2 (inc num)))
     []))
  ([acc [n & others]]
   (if (empty? others)
     (conj acc n)
     (recur (conj acc n) (filter #(pos? (rem % n)) others)))))