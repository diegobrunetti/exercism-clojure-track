(ns grade-school)

(defn grade [school grade]
  (school grade []))

(defn add [school name grade]
  (update school grade #(conj (or % []) name)))

(defn sorted [school]
  (->> school
       (map (fn [[grade names]] [grade (sort names)]))
       (into (sorted-map))))
