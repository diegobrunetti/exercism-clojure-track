(ns sublist)

(defn sublist? [sublist coll]
  (some #(= sublist (take (count sublist) %))
        (partition (count sublist) 1 coll)))

(defn classify
  [first second]
  (cond
    (= first second) :equal
    (sublist? first second) :sublist
    (sublist? second first) :superlist
    :else :unequal))
