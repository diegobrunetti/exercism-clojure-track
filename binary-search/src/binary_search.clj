(ns binary-search)

(defn search-for
  "Returns the index of num in coll, or -1 if num is not found."
  [num coll]
  (loop [start 0
         end (dec (count coll))]
    (let [index (quot (+ start end) 2)
          mid (get coll index)]
      (cond
        (> start end) -1
        (= mid num) index
        (> mid num) (recur 0 (dec index))
        (< mid num) (recur (inc index) end)))))
