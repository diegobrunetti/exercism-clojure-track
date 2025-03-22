(ns protein-translation)

(def codon-length 3)
(def invalid-nucleotide "X")

(defn invalid? [protein]
  (seq (filter nil? protein)))

(defn break-rna [rna]
  (map #(apply str %) (partition codon-length codon-length invalid-nucleotide rna)))

(defn to-amino-acid [codon]
  (case codon
    ("AUG") "Methionine"
    ("UUU" "UUC") "Phenylalanine"
    ("UUA" "UUG") "Leucine"
    ("UCU" "UCC" "UCA" "UCG") "Serine"
    ("UAU" "UAC") "Tyrosine"
    ("UGU" "UGC") "Cysteine"
    ("UGG") "Tryptophan"
    ("UAA" "UAG" "UGA") "STOP"
    nil))

(defn translate-rna
  "Translates an RNA string into amino acids."
  [rna]
  (let [protein
        (->> rna
             (break-rna)
             (map to-amino-acid)
             (take-while (partial not= "STOP")))]
    (when (invalid? protein)
      (throw (IllegalArgumentException. "Invalid codon")))
    protein))
