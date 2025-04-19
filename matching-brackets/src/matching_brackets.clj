(ns matching-brackets
  (:require [clojure.string :as str]))

(def pairs {\{ \}, \[ \], \( \)})

(defmulti parse-symbol (fn [s _] (if (contains? (set (keys pairs)) s)
                                   :opening
                                   :closing)))

(defmethod parse-symbol :opening [s stack] (conj stack s))

(defmethod parse-symbol :closing [s stack]
  (if (= (pairs (peek stack)) s)
    (pop stack)
    (conj stack :syntax-error)))

(defn valid?
  "Returns true if the given string has properly matched brackets; otherwise, returns false."
  [s]
  (loop [stack []
         input (vec (str/replace s #"[^\[\](){}]" ""))]
    (if (empty? input)
      (empty? stack)
      (recur (parse-symbol (first input) stack) (rest input)))))