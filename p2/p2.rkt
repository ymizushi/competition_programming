#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

(define (sum-even-fib max-num)
  (define (fibl n n-2 n-1 sum)
    (let ((now-num (+ n-2 n-1)))
      (if (>= now-num max-num)
        sum
        (if (even? now-num)
          (fibl (+ n 1) n-1 now-num (+ sum now-num))
          (fibl (+ n 1) n-1 now-num sum)))))
  (fibl 0 0 1 0))
(sum-even-fib 4000000)

(check-expect (sum-even-fib 4000000) 4613732)
(test)
