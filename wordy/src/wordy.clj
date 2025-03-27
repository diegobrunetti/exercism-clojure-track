(ns wordy
  (:require [clojure.string :as str]))

(def operations {:plus "+"
                 :minus "-"
                 :multiplied "*"
                 :divided "/"})

(defn single? [coll] (= 1 (count coll)))

(defn parse [question]
  (let [question-parts (-> question
                           (str/replace #"What is" "")
                           (str/replace #"[?]" "")
                           (str/split #"\s"))]
    (->> question-parts
         (filter #(not (str/blank? %)))
         (filter #(not= "by" %))
         (vec))))

(def question-pattern #"^What is\s-?\d+(?:\s(?:plus|minus|divided by|multiplied by)\s-?\d+)*\?$")
(def operands-pattern #".*-?\d+\s.*(?:\s-?\d+)?$")
(def operation-pattern #".*(plus|minus|divided by|multiplied by).*")

(defn validation-error? [question]
  (let [valid-question? (re-matches question-pattern question)
        valid-operation? (some? (re-matches operation-pattern question))
        valid-operands? (some? (re-matches operands-pattern question))]
    (when (not valid-question?)
      (if (and valid-operands? (not valid-operation?))
        "unknown operation"
        "syntax error"))))

(defn calculate [ops]
  (loop [[a op b & other-ops] ops]
    (let [operation (str "(" ((keyword op) operations) \space a \space b ")")
          result (eval (read-string operation))]
      (if (some? other-ops)
        (recur (cons (str result) other-ops))
        result))))

(defn evaluate
  "Evaluates a simple math problem"
  [question]
  (let [parts (parse question)
        error (validation-error? question)]

    (when (some? error)
      (throw (IllegalArgumentException. error)))

    (cond
      (empty? parts) (throw (IllegalArgumentException. "syntax error"))
      (single? parts) (read-string (apply str parts))
      :else (calculate parts))))
