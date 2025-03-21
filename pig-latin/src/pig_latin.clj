(ns pig-latin
  (:require [clojure.string :as str]))

(defn vowels [word]
  (let [first-letter (str (first word))]
    (str word (when (str/includes? "aeiou" first-letter) "ay"))))

(defn xr-or-yt [word]
  (str word (when (or
                   (str/starts-with? word "xr")
                   (str/starts-with? word "yt")) "ay")))

(defn consonants [word]
  (let [pattern #"^(?!xr|yt)(y)*[^aeiouAEIOUyY\W\d_]*(qu*)*"
        consonants (first (filter not-empty (re-find pattern word)))
        preffix (last (str/split word pattern))
        suffix (when consonants "ay")]
    (str preffix consonants suffix)))

(defn translate
  "Translates phrase from English to Pig Latin"
  [phrase]
  (->> (str/split phrase #" ")
       (map vowels)
       (map xr-or-yt)
       (map consonants)
       (str/join " ")))
