(ns all-your-base)

(def binary 2)

(defn- valid? [from-base digits to-base]
  (and
   (>= from-base binary)
   (>= to-base binary)
   (every? #(>= % 0) digits)
   (every? #(< % from-base) digits)))

(defn- to-decimal [from-base digits]
  (reduce #(+ (* from-base %1) %2) 0 digits))

(defn- from-decimal [to-base num]
  (loop [n num
         acc ()]
    (if (< n to-base)
      (cons n acc)
      (recur (quot n to-base) (cons (rem n to-base) acc)))))

(defn convert [from-base digits to-base]
  (when (valid? from-base digits to-base)
    (if (empty? digits)
      ()
      (->> digits
           (to-decimal from-base)
           (from-decimal to-base)))))
