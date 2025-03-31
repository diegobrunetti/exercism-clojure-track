(ns run-length-encoding)

(defn run-length-encode
  "Encodes a string with run-length encoding."
  [plain-text]
  (->> plain-text
       (partition-by identity)
       (mapcat (juxt count first))
       (remove #{1})
       (apply str)))

(defn reconstruct [[_ count letter]]
  (apply str (repeat (parse-long (or count "1")) letter)))

(defn run-length-decode
  "Decodes a run-length-encoded string."
  [cipher-text]
  (->> cipher-text
       (re-seq #"(\d+)?(\D)")
       (mapcat reconstruct)
       (apply str)))
