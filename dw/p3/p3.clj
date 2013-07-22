(require '[clojure.set])

(def n 5)
(def s '(1 2 4 6 8))
(def t '(3 5 7 9 10))

(defn zip [a b]
  (for [i (range (count a))]
     (list (nth a i) (nth b i))))

(def set-all (set '(1 2 3 4 5 6 7 8 9)))
(def list-subset (list (set '(1 2)) (set '(2 3 4)) (set '(4 5 6)) (set '(6 7 8)) (set '(8 9))))

(println (zip [1 2 3 4] [2 3 4 5]))

(defn min-numlist [l]
  (first (sort l)))

(defn min-count [list-subset]
  (min-numlist (map #(count %) list-subset)))

(defn search [list-subset set-all count]
  (let [subset-list (filter #(= (count %) (min-count list-subset)) list-subset)]
    (if (not (empty? subset-list))
      (let [subset (nth subset-list 0)]
        (if (clojure.set/subset? subset set-all)
          (search (clojure.set/difference set-all (rest subset-list)) (inc count))
          count)
        count))))
;
;(def set-p (set '(1 2 3 4 5 6 7 8 9)))
;(def set-st (list (set '(1 2)) (set '(2 3 4)) (set '(4 5 6)) (set '(6 7 8)) (set '(8 9))))
;
;(println (search list-subset set-all 0))

;(println (clojure.set/subset? (nth list-subset 0) set-all))
;(println (nth list-subset 0) )
;(println (clojure.set/difference set-all (nth list-subset 0)))
