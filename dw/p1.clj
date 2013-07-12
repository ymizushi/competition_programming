(def n 20)
(def a [1, 10, 49, 3, 8, 13, 7, 23, 60, -500, 42, 599, 45, -23, 1, 10, 49, 3 , 8,13])
(def k 444)


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
