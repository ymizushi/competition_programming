(use 'clojure.test)


(defn fizz-buzz [i]
  (cond
    (= (rem i 15) 0) "Fizz Buzz"
    (= (rem i  3) 0) "Fizz"
    (= (rem i  5) 0) "Buzz"))

(deftest test-add []
  (testing "fizz-buzz"
    (is (= (fizz-buzz 3) "Fizz"))
    (is (= (fizz-buzz 5) "Buzz"))
    (is (= (fizz-buzz 7) nil))
    (is (= (fizz-buzz 15) "Fizz Buzz"))
    )) 
(run-tests)
