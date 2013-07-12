(def n 20)
(def a [1, 10, 49, 3, 8, 13, 7, 23, 60, -500, 42, 599, 45, -23, 1, 10, 49, 3 , 8,13])
(def k 444)

(defn part-sum? [index sum]
  (cond
    (= index n) (= sum k)
    (part-sum? (inc index) sum) true
    (part-sum? (inc index) (+ sum (get a index))) true 
    true false))

(print (part-sum? 0 0))
