(defn part-sum? [a k]
  (let [n (count a)]
    (defn part-sum? [index sum]
      (cond
        (= index n) (= sum k)
        (part-sum? (inc index) sum) true
        (part-sum? (inc index) (+ sum (get a index))) true 
        true false))
    (part-sum? 0 0)))
(println (part-sum? [1, 10, 49, 3, 8, 13, 7, 23, 60, -500, 42, 599, 45, -23, 1, 10, 49, 3 , 8,13] 444))
