(ns atbash-cipher
  (:require [clojure.string :as str]))

(def plain "abcdefghijklmnopqrstuvwxyz")
(def cipher (zipmap plain (reverse plain)))

(defn encode
  "Encodes the given text using the Atbash cipher."
  [plaintext]
  (->> (str/replace plaintext #"[\p{Punct}\s]" "")
       (str/lower-case)
       (map #(cipher % %))
       (partition 5 5 "")
       (map (partial apply str))
       (str/join " ")))

(defn decode
  "Decodes the given text using the Atbash cipher."
  [ciphertext]
  (->> (str/replace ciphertext #" " "")
       (map #(cipher % %))
       (apply str)))
