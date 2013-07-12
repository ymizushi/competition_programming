(defstruct num-map :sum-flg :searched)

(def sample [(struct num-map false false) (struct num-map false false) (struct num-map false false)])

(defn sum-flg-list [num-map-list]
  (let [head (pop num-map-list) booby (last head)]
    (cond
      (:searched booby)
        (conj head (struct num-map true false))
      (not (:searched booby))
        (conj head )
    )))
