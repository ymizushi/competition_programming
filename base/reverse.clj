(use 'clojure.test)

(deftest test-add []
  (testing "add"
    (is (= 2 (+ 1 1))))) 

(defn rev-str [input output]
  (if (= input "")
    output
    (let [c (first input)
          r (rest input)]
      (recur rev-str (join c output)))))

(run-tests)
