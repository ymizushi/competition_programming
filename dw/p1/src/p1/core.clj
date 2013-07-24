(ns p1.core)

(defn part-sum? [a k]
  (let [n (count a)]
    (defn part-sum? [index sum]
      (cond
        (= index n) (= sum k)
        (part-sum? (inc index) sum) true
        (part-sum? (inc index) (+ sum (get a index))) true 
        true false))
    (part-sum? 0 0)))
