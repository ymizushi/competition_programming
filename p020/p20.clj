#!clj
(use 'clojure.test)

(defn fac [n result]
  (let [n (bigint n)]
    (if (= n 1)
    result
    (fac (- n 1) (* result n)))))

(defn split [s]
  (rest (clojure.string/split s #"")))

(defn parse-int [s]
   (Integer. (re-find  #"\d+" s )))

(defn sum-str-fac [n]
  (let [result (fac n 1)]
    (apply
      +
      (map parse-int (split (str result))))))

(deftest test-fac []
  (testing "fac"
    (is (= 1 (fac 1 1)))
    (is (= 3628800 (fac 10 1)))
    (is (= ["1" "2" "3" "4"] (split "1234")))
    (is (= 1 (parse-int "1") ))
    (is (= [1 2 3 4] (map parse-int ["1" "2" "3" "4"])))
    (is (= 27 (sum-str-fac 10)))
    (is (= 648 (sum-str-fac 100))))) 

(run-tests)
