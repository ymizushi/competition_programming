#!/usr/bin/env clj
;(defn fib-slow [n]
;  (cond
;    (= n 0) 1
;    (= n 1) 1
;    true (bigint (+ (fib-slow (bigint (- n 2))) (fib-slow (bigint (- n 1)))))))
;(println (time (fib-slow 40)))

(defn fib [n]
  (defn fibl [n n-2 n-1]
    (cond
      (= n 0) n-1
      (> n 0) (fibl (bigint (- n 1)) n-1 (bigint (+ n-2 n-1)))))
  (fibl n 0 1))
(println (time (fib 1000)))

(defn fib [x]
  (loop [n x n-2 0 n-1 1]
    (cond
      (= n 0) n-1
      (> n 0) (recur (bigint (- n 1)) n-1 (bigint (+ n-2 n-1))))))
(println (time (fib 1000)))
