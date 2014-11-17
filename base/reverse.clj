(use 'clojure.test)


(defn rev-str [input output]
  (loop [input output]
    (if (= input "")
      output
      (let [c (first input)
            r (rest input)]
        (recur r (str c output))))))

(deftest test-add []
  (testing "rev-str"
    (is (= (rev-str "hoge" "") "egoh"))))

(run-tests)
