(ns binary-search-tree)

(defrecord Node [data left right])

(defn value [node]
  (:data node))

(defn singleton [value]
  (->Node value nil nil))

(defn left [node]
  (:left node))

(defn right [node]
  (:right node))

(defn insert [value node]
  (if (nil? node)
    (singleton value)
    (if (> value (:data node))
      (->Node (:data node) (:left node) (insert value (:right node)))
      (->Node (:data node) (insert value (:left node)) (:right node)))))

(defn to-list [tree]
  (when tree
    (concat (to-list (left tree)) [(value tree)] (to-list (right tree)))))

(defn from-list [list]
  (reduce #(insert %2 %1) nil list))
