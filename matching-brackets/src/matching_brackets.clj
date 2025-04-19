(ns matching-brackets)

(def brackets {\{ \}, \[ \], \( \)})
(def opening? (set (keys brackets)))
(def bracket? (set (flatten (seq brackets))))

(defmulti parse-symbol (fn [s _] (if (opening? s)
                                   :opening
                                   :closing)))

(defmethod parse-symbol :opening [s stack] (conj stack s))

(defmethod parse-symbol :closing [s stack]
  (if (= (brackets (peek stack)) s)
    (pop stack)
    (conj stack :syntax-error)))

(defn valid?
  "Returns true if the given string has properly matched brackets; otherwise, returns false."
  [s]
  (loop [stack []
         input (filter bracket? s)]
    (if (empty? input)
      (empty? stack)
      (recur (parse-symbol (first input) stack) (rest input)))))