(ns bank-account)

(defn open-account []
  (atom {:balance 0}))

(defn close-account [account]
  (reset! account nil))

(defn get-balance [account]
  (:balance @account))

(defn update-balance [account amount]
  (swap! account update :balance + amount))