(ns change)

(defn- select-coin [amount coins]
  (let [available (filter #(<= % amount) (sort coins))]
    (if (empty? available)
      (throw (IllegalArgumentException. "can't make target with given coins"))
      (apply max available))))

(defn issue
  "Given an amount to change and a set of coins, it returns the
  fewest coins such that the sum of their values equals the change"
  [amount coins]
  (let [sum (atom 0)
        change-so-far (atom [])]
    (while (and
            (not= amount @sum)
            (> amount @sum))
      (let [coin (select-coin (Math/abs (- amount @sum)) coins)]
        (swap! change-so-far conj coin)
        (reset! sum (+ @sum coin))))
    (sort @change-so-far)))
