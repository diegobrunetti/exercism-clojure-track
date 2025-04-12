(ns phone-number
  (:require [clojure.string :as str]))

(defn- cleanup [s]
  (-> s (str/replace #"\D" "") (str/replace #"^[1]" "")))

(defn number [input]
  (or (re-matches #"[2-9]{1}[0-9]{2}[2-9]{1}[0-9]{6}" (cleanup input))
      "0000000000"))