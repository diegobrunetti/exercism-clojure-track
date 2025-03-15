(ns interest-is-interesting)

(defn interest-rate
  "Returns the interest rate based on the specified balance."
  [balance]
  (condp <= balance
    5000 2.475
    1000 1.621
    0 0.5
    -3.213))

(defn annual-balance-update
  "Returns the annual balance update, taking into account the interest rate."
  [balance]
  (let [b balance
        interest (bigdec (* (interest-rate b) 1/100))]
    (+ b  (* (.abs b) interest))))

(defn amount-to-donate
  "Returns how much money to donate based on the balance and the tax-free percentage."
  [balance tax-free-percentage]
  (let [tax-free-amount (bigdec (* balance (/ tax-free-percentage 100)))]
    (if (pos? tax-free-amount)
      (int (* tax-free-amount 2))
      0)))
