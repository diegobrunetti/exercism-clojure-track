(ns strain)

(defn- filter-predicate [pred coll]
  (loop [filtered-items []
         pending-items coll]
    (if-let [current-item (first pending-items)]
      (if (pred current-item)
        (recur (conj filtered-items current-item) (rest pending-items))
        (recur filtered-items (rest pending-items)))
      filtered-items)))

(defn retain
  "Keeps the items in coll for which (pred item) returns true."
  [pred coll]
  (filter-predicate pred coll))

(defn discard
  "Removes the items in coll for which (pred item) returns true."
  [pred coll]
  (filter-predicate #(not (pred %)) coll))
