(require '[clojure.set])

(def n 5)
(def s '(1 2 4 6 8))
(def t '(3 5 7 9 10))

(def set-all (set '(1 2 3 4 5 6 7 8 9)))
(def list-subset (list (set '(1 2)) (set '(2 3 4)) (set '(4 5 6)) (set '(6 7 8)) (set '(8 9))))

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

(println (search list-subset set-all 0))

;(println (clojure.set/subset? (nth list-subset 0) set-all))
;(println (nth list-subset 0) )
;(println (clojure.set/difference set-all (nth list-subset 0)))

;区間スケジューリング問題
;n個の仕事があります。各仕事は時間siにはじまり、時間tiに終わります。あなたは各仕事について、参加するか参加しないかを選ばなければなりません。仕事に参加するならば、その仕事のはじめから終わりまで参加しなければなりません。また、参加する仕事の時間帯が重なってはなりません(開始の瞬間・終了の時間だけが重なるのも許されません)
;
;制約
;
;1 ≦ N ≦ 100000
;1 ≦ Si < ti ≦ 109
;
;
;入力
;n = 5, s = {1, 2, 4, 6, 8}, t =  {3, 5, 7, 9, 10}
;出力
;3
;(仕事1, 3, 5を選択)
;
;計算チャレンジ
;
;不手際でt = sの仕事と0から開始している仕事があるので
;
;0 ≦ Si ≦ ti ≦ 109
;
;という条件でおねがしいます。
;
;入力
;n = 100, s = {19, 34, 5, 39, 6, 17, 43, 13, 33, 6, 25, 10, 3, 32, 30, 25, 23, 20, 38, 31, 39, 10, 34, 47, 49, 37, 19, 28, 20, 17, 22, 20, 40, 0, 20, 6, 49, 46, 0, 23, 41, 13, 0, 14, 49, 41, 36, 46, 3, 28, 27, 29, 22, 37, 47, 16, 31, 14, 30, 27, 35, 49, 0, 44, 40, 49, 41, 1, 6, 39, 37, 4, 39, 10, 31, 3, 37, 18, 47, 13, 47, 33, 4, 0, 34, 36, 42, 17, 1, 38, 30, 35, 8, 5, 1, 4, 7, 17, 26, 35}, t = {34, 67, 39, 62, 32, 49, 50, 13, 43, 23, 25, 16, 48, 51, 37, 68, 46, 42, 51, 49, 76, 14, 79, 48, 87, 73, 54, 34, 65, 23, 44, 51, 49, 3, 41, 7, 86, 72, 25, 30, 63, 13, 39, 27, 88, 89, 57, 46, 31, 58, 61, 75, 34, 85, 93, 49, 54, 61, 56, 72, 54, 51, 6, 46, 50, 59, 73, 33, 31, 86, 61, 37, 81, 16, 64, 39, 85, 42, 57, 40, 62, 69, 28, 30, 38, 57, 66, 47, 36, 38, 35, 45, 30, 46, 45, 37, 16, 26, 42, 43}
;
