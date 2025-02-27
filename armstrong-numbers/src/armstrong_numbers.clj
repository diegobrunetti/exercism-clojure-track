(ns armstrong-numbers)

(defn- split [n]
  (loop [result '()
         m n]
    (if (< m 10)
      (cons m result)
      (recur (cons (mod m 10) result) (quot m 10)))))

(defn armstrong?
  "Returns true if the given number is an Armstrong number; otherwise, returns false"
  [num]
  (let [digits (split num)
        exponent (count digits)]
    (->> digits
         (map #(.pow (biginteger %) exponent))
         (reduce +)
         (== num))))


;; (ns armstrong-numbers)

;; (defn- split [n]
;;   (loop [result '()
;;          m n]
;;     (if (< m 10)
;;       (cons m result)
;;       (recur (cons (mod m 10) result) (quot m 10)))))

;; (defn armstrong? [num]
;;   (let [digits (split num)
;;         digit-count (count digits)]
;;     (== num (reduce (fn [sum digit] (+ sum (.pow (biginteger digit) digit-count))) 0 digits))))